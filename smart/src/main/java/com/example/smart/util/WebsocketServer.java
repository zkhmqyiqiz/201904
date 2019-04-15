package com.example.smart.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 * @ServerEndpoint 可以把当前类变成websocket服务类
 */
@ServerEndpoint("/websocket/{username}")
public class WebsocketServer {
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static ConcurrentHashMap<String, WebsocketServer> webSocketSet = new ConcurrentHashMap<String, WebsocketServer>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session WebSocketsession;
    //当前发消息的人员编号
    private String username = "";


    /**
     * 连接建立成功调用的方法
     *
     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     * config 整个终端的配置
     */
    @OnOpen
    public void onOpen(@PathParam(value = "username") String param, Session WebSocketsession, EndpointConfig config) {
        System.out.println(param);
        username = param;//接收到发送消息的人员账号号
        this.WebSocketsession = WebSocketsession;
        webSocketSet.put(param, this);//加入map中 this 类的实例
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
    }


    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        if (!username.equals("")) {
            webSocketSet.remove(username);  //从set中删除
            subOnlineCount();           //在线数减1
            System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
        }
    }



private static  String result;
/**
 * 获取静态存储结果（set方法中的  ）的变量
 * @return
 */

/*public static  String getResult() {
		return result;
	}


	public void setResult(String result) {
		System.out.println(result);
		this.result = result;
	}*/

	/**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
		@OnMessage
    public void onMessage(String message, Session session) {
    	System.out.println(message);
       setResult(message);
       
       
    }


    public static String getResult() {
		return result;
	}


	public static void setResult(String result) {
		WebsocketServer.result = result;
	}


	/**
     * 给指定的人发送消息
     * @param message（没用）
     */
   
    public void sendToUser(String msg) {
    	String toUsername = msg.split(";")[0];
    	System.out.println(toUsername+"2");
    	String rtspUrl = msg.split(";")[1];
        String now = getNowTime();
        try {
            if (webSocketSet.get(toUsername) != null) {
                webSocketSet.get(toUsername).sendMessage("是否同意用户ip电话请求;客户端rtst地址："+rtspUrl+";"+now);
            } else {
               System.out.println("当前用户不在线");
            }
        } catch (IOException e) {
        	
            e.printStackTrace();
        }
    }


    
    /**
     * 给所有人发消息
     * @param message
     */
    public void sendAll(String message) {
    	String now = getNowTime();
        //遍历HashMap
        for (String key : webSocketSet.keySet()) {
            try {
                //判断接收用户是否是当前发消息的用户
                if (!username.equals(key)) {
                    webSocketSet.get(key).sendMessage("是否同意用户" + username+"ip电话请求:"+now);
                    System.out.println("key = " + key);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




    /**
     * 获取当前时间
     *
     * @return
     */
    private String getNowTime() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        return time;
    }
    /**
     * 发生错误时调用
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }


    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     *
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
    	System.out.println(message);
       this.WebSocketsession.getBasicRemote().sendText(message);
        //this.session.getAsyncRemote().sendText(message);
    }
    
    public static String sendMessageToIp(String message,String ip) throws IOException {
    	System.out.println(webSocketSet);
    	for(String key : webSocketSet.keySet()) {
    		System.out.println(key+"----"+webSocketSet.get(key));
    		if(key.equals(ip)) {
    			webSocketSet.get(key).sendMessage(message);
    			return ip;
    		}
    	}
    	return null;
    }


    public static synchronized int getOnlineCount() {
        return onlineCount;
    }


    public static synchronized void addOnlineCount() {
        WebsocketServer.onlineCount++;
    }


    public static synchronized void subOnlineCount() {
        WebsocketServer.onlineCount--;
    }




}