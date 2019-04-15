package com.example.smart.util;

import java.util.List;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.junit.Test;

public class MQUtil {
	private static String namesrvAddr = FtpUtils.getProperties("redis.properties", "namesrvAddr");
	public static void sendToMQ(String topic, String tag, String key, String message) {
		 DefaultMQProducer producer = new DefaultMQProducer("ServerProducer");

	        producer.setNamesrvAddr(namesrvAddr);
	        try {
	            producer.start();
	            Message msg = new Message(topic, tag, key, message.getBytes("UTF-8"));
	            SendResult result = producer.send(msg);
	            System.out.println("id:" + result.getMsgId() + " result:" + result.getSendStatus());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally{
	            producer.shutdown();
	        }
	}
	public  void receiveFromMQSendSubject() {
		 DefaultMQPushConsumer consumer =
	                new DefaultMQPushConsumer("PushConsumer");
	        consumer.setNamesrvAddr("192.168.10.214:9876");
	        try {
	            //订阅PushTopic下Tag为push的消息，““”"*"代表所有tag
	            consumer.subscribe("sendSubject", "110");
	            consumer.setMessageModel(MessageModel.BROADCASTING);
	            //程序第一次启动从消息队列头取数据
	            /**
	             * consumer的消费策略
	             * CONSUME_FROM_LAST_OFFSET默认策略，从该队列最尾开始消费，即跳过历史消息
	             * CONSUME_FROM_FIRST_OFFSET从队列最开始开始消费，即历史消息（还储存在broker的）全部消费一遍
	             * CONSUME_FROM_TIMESTAMP从某个时间点开始消费，和setConsumeTimestamp()配合使用，默认半个小时以前
	             */
	            consumer.setConsumeFromWhere(
	                    ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
	            //设置一个Listener，主要进行消息的逻辑处理
	            consumer.registerMessageListener(new MessageListenerConcurrently() {
	                     public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext Context) {
	                     Message msg = list.get(0);
	                     System.out.println(msg.toString());
	                     String topic = msg.getTopic();
	                     System.out.println("topic = " + topic);
	                     byte[] body = msg.getBody();
	                     System.out.println("body:  " + new String(body));
	                     String keys = msg.getKeys();
	                     System.out.println("keys = " + keys);
	                     String tags = msg.getTags();
	                     System.out.println("tags = " + tags);
	                     System.out.println("-----------------------------------------------");
	                     //返回消费状态，CONSUME_SUCCESS消费成功，RECONSUME_LATER消费失败，需要稍后重新消费
	                     return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
	                    }
	                }
	            );
	            //调用start()方法启动consumer
	            consumer.start();
	        } catch (Exception e) {
	            e.printStackTrace();
        }
	}
	public  void receiveFromMQEndAnswering() {
		DefaultMQPushConsumer consumer =
				new DefaultMQPushConsumer("PushConsumer");
		consumer.setNamesrvAddr("192.168.10.214:9876");
		try {
			consumer.subscribe("endAnswering", "110");
			consumer.setMessageModel(MessageModel.BROADCASTING);
			consumer.setConsumeFromWhere(
					ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
			consumer.registerMessageListener(new MessageListenerConcurrently() {
				public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext Context) {
					Message msg = list.get(0);
					System.out.println(msg.toString());
					String topic = msg.getTopic();
					System.out.println("topic = " + topic);
					byte[] body = msg.getBody();
					System.out.println("body:  " + new String(body));
					String keys = msg.getKeys();
					System.out.println("keys = " + keys);
					String tags = msg.getTags();
					System.out.println("tags = " + tags);
					System.out.println("-----------------------------------------------");
					return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
				}
			}
					);
			consumer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
