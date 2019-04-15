package com.example.smart.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

import net.common.util.FtpUtils;
import net.smartschool.dao.DeviceDao;
import net.smartschool.entity.BorrowdeviceDevice;
import net.smartschool.entity.BuildClassroomDevice;
import net.smartschool.entity.Device;
import net.smartschool.entity.DeviceDeviceerror;
import net.smartschool.entity.DeviceDeviceprpNote;
import net.smartschool.entity.DeviceMessage;
import net.smartschool.entity.DeviceNote;
import net.smartschool.entity.Deviceerror;
import net.smartschool.entity.LatestErrorDevices;
import net.smartschool.impl.DeviceDaoImpl;

class PropKey {
    String devId;
    //true表示男，false表示女
    int provid;
    
    public PropKey(String id,int proid)
    {
    	this.devId = id;
    	this.provid = proid;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((devId == null) ? 0 : devId.hashCode());
		result = prime * result + provid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropKey other = (PropKey) obj;
		if (devId == null) {
			if (other.devId != null)
				return false;
		} else if (!devId.equals(other.devId))
			return false;
		if (provid != other.provid)
			return false;
		return true;
	}
   
}


public class DeviceService {
	class ayscThread extends Thread
	{
		public boolean b_stop = false;
		
		public void run()
		{
			while(!b_stop)
			{
				Hashtable<PropKey,DeviceDeviceprpNote> mapDeviceProeTmp = new Hashtable<PropKey,DeviceDeviceprpNote>();
				synchronized (mapDeviceProe){
					Iterator<Entry<PropKey, DeviceDeviceprpNote>> iter = mapDeviceProe.entrySet().iterator();
					while (iter.hasNext()) {
						Entry<PropKey,DeviceDeviceprpNote> entry = (Entry<PropKey,DeviceDeviceprpNote>) iter.next();
						Object key = entry.getKey();
						DeviceDeviceprpNote val = (DeviceDeviceprpNote)entry.getValue();
						mapDeviceProeTmp.put((PropKey)key, val);
					}
					mapDeviceProe.clear();
				}
				
				if(mapDeviceProeTmp.size() <= 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					continue;
				}
				
				Iterator<Entry<PropKey, DeviceDeviceprpNote>> iter = mapDeviceProeTmp.entrySet().iterator();
				while (iter.hasNext()) {
					Entry<PropKey,DeviceDeviceprpNote> entry = (Entry<PropKey,DeviceDeviceprpNote>) iter.next();
					//Object key = entry.getKey();
					DeviceDeviceprpNote val = (DeviceDeviceprpNote)entry.getValue();
					dao.setDeviceNew(val.getPropvalue(), val.getDeviceid(), val.getPropid());	//更新
				}
				mapDeviceProeTmp.clear();
			}
		}
	}

	//<DeviceDeviceprpNote> queDeviceProe = new LinkedList<DeviceDeviceprpNote>();
	Hashtable<PropKey,DeviceDeviceprpNote> mapDeviceProe=new Hashtable<PropKey,DeviceDeviceprpNote>();                
   
	
	ayscThread syncThread = new ayscThread();
	DeviceDao dao = new DeviceDaoImpl();
	public DeviceService() {
		this.syncThread.start();
	}

	private static final Logger logger = LogManager.getLogger();
	public String selectDeviceById(String deviceid) {
		JSONObject res = new JSONObject();
		try {
			Device t = null; 
			t = dao.selectDeviceById(deviceid);
			if (!(t == null)) {
				res.put("state", 0);
				res.put("msg", "查询设备成功！");
				res.put("data", t);
			} else {
				res.put("state", 100);
				res.put("msg", "查询设备失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		return res.toString();
	}
	
	public String selectAllDevice(int page, int count) {
		JSONObject res = new JSONObject();
		try {
			List<Device> t = null; 
			t = dao.selectAllDevice((page - 1) * count, count);
			if (!(t == null)) {
				res.put("state", 0);
				res.put("msg", "查询设备成功！");
				res.put("data", t);
			} else {
				res.put("state", 100);
				res.put("msg", "查询设备失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		return res.toString();
	}
	
	public String selectDeviceByClass(String classroomid) {
		JSONObject res = new JSONObject();
		try {
			List<Device> t = null; 
			t = dao.selectDeviceByClass(classroomid);
			if (!(t == null)) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", t);
			} else {
				res.put("state", 100);
				res.put("msg", "查询配置失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		return res.toString();
	}
	
	public String selectErrorByDevice(String deviceid) {
		JSONObject res = new JSONObject();
		try {
			Deviceerror t = null; 
			t = dao.selectErrorByDevice(deviceid);
			if (!(t == null)) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", t);
			} else {
				res.put("state", 100);
				res.put("msg", "查询配置失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		return res.toString();
	}
	
	
	/**
	 * 根据公司名查询 设备所有信息（加了教室名）
	 * @param page 页数
	 * @param count  条数
	 * @return
	 */
	public String selectAllDeviceNote(int page, int count) {
		JSONObject res = new JSONObject();
		try {
			String classroomname = null;
			String devicename = null;
			int numbers = 0;
			List<DeviceNote> t = null; 
			t = dao.selectAllDeviceNote((page - 1) * count, count);
			numbers = dao.selectDeviceAll(classroomname, devicename);
			if (t != null) {
				t.sort((d1, d2) -> d1.getTeg().compareTo(d2.getTeg()));
				res.put("state", 0);
				res.put("msg", "查询设备信息成功！");
				res.put("data", t);
				res.put("numbers", numbers);
			} else {
				res.put("state", 100);
				res.put("msg", "查询设备信息失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		return res.toString();
		
	}
	/**
	 * 根据教室名，设备名模糊查询
	 * @param classroomname
	 * @param devicename
	 * @param page
	 * @param count
	 * @return
	 */
	public String selectDeviceNoteByLike(String classroomname, String devicename, int page, int count) {
		JSONObject res = new JSONObject();
		try {
			List<DeviceNote> t = null; 
			int numbers = 0;
			t = dao.selectDeviceNoteByLike(classroomname, devicename, (page - 1) * count, count);
			//查询总条数
			numbers = dao.selectDeviceAll(classroomname, devicename);
			if (!(t == null)) {
				res.put("state", 0);
				res.put("msg", "查询设备信息成功！");
				res.put("data", t);
				res.put("numbers", numbers);
			} else {
				res.put("state", 100);
				res.put("msg", "查询设备信息失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		return res.toString();
	}
	
	public String selectDeviceerrorById(String deviceid) {
		JSONObject res =new  JSONObject();
		try {
			Deviceerror deviceerror=null;
			deviceerror=dao.selectDeviceerrorById(deviceid);
			if(!(deviceerror==null)) {
				res.put("state", 0);
				res.put("msg", "查询故障设备信息成功！");
				res.put("data", deviceerror);
			} else {
				res.put("state", 100);
				res.put("msg", "查询故障设备信息失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		return res.toString();
	}
	
	/**
	 * 连接device，deviceprop，propvalue，classroom，electricdevice五张表查询数据 
	 * @return
	 */
	public String selectAllSensor(String ip,Integer isdevice) {
		JSONObject res = new JSONObject();
		//ip = "192.168.10.160";
		try {
			List<DeviceDeviceprpNote> t = null; 
			t=dao.selectAllSensor(ip);
			List<DeviceDeviceprpNote> devices = new ArrayList<>();
			if(isdevice==null) {
				for(DeviceDeviceprpNote list : t) {
					Integer propid = list.getPropid();
					Integer devicetype = Integer.parseInt(FtpUtils.getProperties("device.properties",list.getDevicename()) == null ? "-1" : FtpUtils.getProperties("device.properties", list.getDevicename()));
					//devicetype>5||devicetype<15
					if((devicetype > 5 || devicetype < 15) && (propid != 11)) {
						devices.add(list);
					}
				}
			} else {
				List<DeviceDeviceprpNote> listtemp = new ArrayList<>();
				for(DeviceDeviceprpNote list : t) {
					Integer devicetype = Integer.parseInt(FtpUtils.getProperties("device.properties", list.getDevicename()) == null ? "-1" : FtpUtils.getProperties("device.properties", list.getDevicename()));
					Integer propid = list.getPropid();
					
					if((devicetype <= 5 || devicetype >= 15) && (propid == 26 || propid == 54 || propid == 31)) {
						devices.add(list);
						listtemp.add(list);
					} else if ((devicetype <= 5 || devicetype >= 15) && (propid == 11)) {
							boolean flag = false;
							for(DeviceDeviceprpNote d : listtemp) {
								if(d.getDeviceid().equals(list.getDeviceid())) {
									flag = true;
								}
							}
							if(!flag) {
								devices.add(list);
							}
					
					}
				}
			}
			//devices.sort((DeviceDeviceprpNote d1,DeviceDeviceprpNote d2)->d1.getPropname().compareTo(d2.getPropname()));
			devices.sort((DeviceDeviceprpNote d1,DeviceDeviceprpNote d2) -> d1.getDeviceid().compareTo(d2.getDeviceid()));
			if (devices.size() > 0) {
				res.put("state", 0);
				res.put("msg", "查询设备信息成功！");
				res.put("data", devices);
			} else {
				res.put("state", 100);
				res.put("msg", "查询设备信息失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		return res.toString();
	}

	/**
	 * 连接device，deviceprop，propvalue三张表查询数据 ,devicetype<=5
	 * @return
	 */
	public String selectAllDeviceById(String classroomid) {
		JSONObject res = new JSONObject();
		try {
			List<DeviceDeviceprpNote> t = null; 
			t = dao.selectAllDeviceById(classroomid);
			List<DeviceDeviceprpNote> devices = new ArrayList<DeviceDeviceprpNote>();
			for(DeviceDeviceprpNote list : t) {
				Integer devicetype = Integer.parseInt(FtpUtils.getProperties("device.properties", list.getDevicename()) == null ? "6" : FtpUtils.getProperties("device.properties", list.getDevicename()));
				if(devicetype <= 5 || devicetype >= 15) {
					devices.add(list);
				}
			}
			if (!(t == null)) {
				res.put("state", 0);
				res.put("msg", "查询设备信息成功！");
				res.put("data", devices);
			} else {
				res.put("state", 100);
				res.put("msg", "查询设备信息失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	public String selectAllSensorById(String classroomid) {
		JSONObject res = new JSONObject();
		try {
			List<DeviceDeviceprpNote> t = null; 
			t = dao.selectAllDeviceById(classroomid);
			List<DeviceDeviceprpNote> devices = new ArrayList<DeviceDeviceprpNote>();
			for(DeviceDeviceprpNote list : t) {
				Integer devicetype = Integer.parseInt(FtpUtils.getProperties("device.properties", list.getDevicename()) == null ? "0" : FtpUtils.getProperties("device.properties", list.getDevicename()));
				if(devicetype > 5 && devicetype < 15) {
					devices.add(list);
				}
			}
			if (!(t == null)) {
				res.put("state", 0);
				res.put("msg", "查询设备信息成功！");
				res.put("data", devices);
			} else {
				res.put("state", 100);
				res.put("msg", "查询设备信息失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}

	/**
	 * 连接device，deviceprop，propvalue三张表查询数据 devicetype>5
	 * @return 以 Propname为键  Propvalue为值的 map 集合
	 */
	public String selectAllDeviceById2(String classroomid) {
		System.out.println(classroomid + "==========================");
		JSONObject res = new JSONObject();
		try {
			List<DeviceDeviceprpNote> t = null; 
			t = dao.selectAllDeviceById2(classroomid);
			if (!(t == null)) {
				res.put("state", 0);
				res.put("msg", "查询设备信息成功！");
				res.put("data", t);
			} else {
				res.put("state", 100);
				res.put("msg", "查询设备信息失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	/**
	 * 连接device，deviceprop，propvalue三张表查询数据 ,根据id查询，值为list集合。
	 * @return
	 */
	public String selectAllDeviceById3(String deviceid) {
		JSONObject res = new JSONObject();
		try {
			List<DeviceDeviceprpNote> t = null; 
			t = dao.selectAllDeviceById3(deviceid);
			if (!(t == null)) {
				res.put("state", 0);
				res.put("msg", "查询设备信息成功！");
				res.put("datas", t);
			} else {
				res.put("state", 100);
				res.put("msg", "查询设备信息失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();	
	}
	
	public int setDeviceProp(DeviceDeviceprpNote prop) {
		int count = 0;
		int propcnt = dao.selectPropById(prop.getDeviceid());//查询总数据
		if (propcnt == 0) {
			count = dao.setDeviceForNull(prop);//插入数据
		} else if (propcnt > 1 || prop.getPropid() == 11) {
			count = dao.setDevice(prop);//更新
		} else {
			count = dao.setDeviceForNull(prop);
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回："+count);
		return count;
	}
	
	public int setDevicePropNew(DeviceDeviceprpNote prop) {
		//String propvalue = prop.getPropvalue();
		String deviceid = prop.getDeviceid();
		int propid = prop.getPropid();
		int count = 0;
		
		
		//logger.info("setDevicePropNew thread id = " + Thread.currentThread().getId());
		//System.out.println("setDevicePropNew thread id = " + Thread.currentThread().getId());
		/*
		if(propid == 11)
		{
			synchronized (mapDeviceProe) {
				int propcnt = dao.selectPropByIdNew(deviceid, propid);//查询总数据
				if (propcnt==0) {
					count = dao.setDeviceForNullNew(propvalue, deviceid, propid);//插入数据
				}else {
					count = dao.setDeviceNew(propvalue, deviceid, propid);//更新
				}
			}
		}
		else {*/
			synchronized (mapDeviceProe) 
			{
				//queDeviceProe.add(prop);
				mapDeviceProe.put(new PropKey(deviceid,propid), prop);
				/*
				int propcnt = dao.selectPropByIdNew(deviceid, propid);//查询总数据
				if (propcnt==0) {
					count = dao.setDeviceForNullNew(propvalue, deviceid, propid);//插入数据
				}else {
					count = dao.setDeviceNew(propvalue, deviceid, propid);//更新
				}
				*/
			}
		//}
		//logger.info("从"+this.getClass().getName()+"收到请求返回："+count);
		System.out.println("从" + this.getClass().getName() + "  setDevicePropNew 返回：" + count);
		return count;
	}
	
	public String selectLatestErrorDevice(int page, int count) {
		JSONObject res = new JSONObject();
		List<LatestErrorDevices> t = null;
		
		try {
			t = dao.selectLatestErrorDevice((page - 1) * count, count);
			if (t != null) {
				t.stream().forEach(one ->{
					one.setLocation(one.getTung()+one.getFloor()+one.getClassroomname());
				});
				res.put("state", 0);
				res.put("msg", "查询最新设备故障信息成功");
				res.put("data", t);
			} else {
				res.put("state", 100);
				res.put("msg", "查询最新设备故障信息失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	public String selectAllDeviceMessage(int page, int count) {
		JSONObject res = new JSONObject();
		List<DeviceMessage> t = null;
		try {
			t = dao.selectAllDeviceMessage((page - 1) * count, count);
			
			if (t != null) {
				res.put("state", 0);
				res.put("msg", "查询所有设备信息成功");
				res.put("data", t);
			} else {
				res.put("state", 100);
				res.put("msg", "查询所有设备信息失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	public String insertDevice(String deviceid, String devicename, String brand, String model,String devicenumber,String classroomid,String devicebarcode,String personliable,Integer servicelife) {
		JSONObject res = new JSONObject();
		Integer t = null;
		Device count = null;
		try {
			count = dao.selectDeviceById(deviceid);
			if (count != null) {
				res.put("state", 300);
				res.put("msg", "设备id重复！");
			}else {
				t = dao.insertDeviceNew(deviceid, devicename, brand, model,devicenumber,classroomid,devicebarcode,personliable,servicelife);
				if (t == 1) {
					res.put("state", 0);
					res.put("msg", "添加设备信息成功");
				} else {
					res.put("state", 100);
					res.put("msg", "添加设备信息失败");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	public String deleteDevice(String deviceid) {
		JSONObject res = new JSONObject();
		Integer t = null;
		try {
			t = dao.deleteDevice(deviceid);
			if (t == 1) {
				res.put("state", 0);
				res.put("msg", "删除设备信息成功");
			} else {
				res.put("state", 100);
				res.put("msg", "删除设备信息失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	public String updateDevice(String deviceid, String devicename, String brand, String model,String devicenumber,String classroomid,String devicebarcode,String personliable,Integer servicelife) {
		JSONObject res = new JSONObject();
		Integer t = null;
		try {
			t = dao.updateDeviceNew(deviceid, devicename, brand, model,devicenumber,classroomid,devicebarcode,personliable,servicelife);
			if (t == 1) {
				res.put("state", 0);
				res.put("msg", "更新设备信息成功");
			} else {
				res.put("state", 100);
				res.put("msg", "更新设备信息失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	public String selectDevicelike(String teg, String brand, String tung, String floor,
			String classroomname, Date purchasetime, String personliable,Integer page,Integer count) {
		JSONObject res =  new JSONObject();
		try {
			int  total = dao.selectDevicelikeCount(teg, brand, tung, floor, classroomname, purchasetime, personliable);
			Integer begin  = 0 ;//设置分页的起始位置
			Integer end  = 0 ;//设施分页的结束位置
			if(count==null||page==null||count <= 0||page < 0) {
				res.put("state", 100);
				res.put("msg", "count或者page的参数不符合要求");
				return res.toString();
				
			}
			if( page > 0) {
				begin = (page-1)*count;
				end = count;
				if(begin > total) {
					res.put("state", 100);
					res.put("msg", "起始页位置超过数据总量");
					res.toString();
				}
			}else {
				begin = page;
				end = count;
			}
			List<BuildClassroomDevice> list =  dao.selectDevicelike(teg, brand, tung, floor, classroomname, purchasetime, personliable, begin, end);
			if (list.size() > 0) {
				res.put("state", 0);
				res.put("msg", "查询所有设备成功！");
				res.put("data", list);
				res.put("count", total);
			} else {
				res.put("state", 100);
				res.put("msg", "查询所有失败！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
		
	}
	
	public String selectDeviceBrrowingdevice(String teg, Integer ifborrow, Date borrowtime,
			Date returntime, String borrowman, String personliable, Integer page, Integer count) {
		JSONObject res =  new JSONObject();
		try {
			int  total = dao.selectDeviceBrrowingdeviceCount(teg, ifborrow, borrowtime, returntime, borrowman, personliable);
			Integer begin  = 0 ;//设置分页的起始位置
			Integer end  = 0 ;//设施分页的结束位置
			if(count==null||page==null||count <= 0||page < 0) {
				res.put("state", 100);
				res.put("msg", "count或者page的参数不符合要求");
				return res.toString();
			}
			if( page > 0) {
				begin = (page-1)*count;
				end = count;
				if(begin > total) {
					res.put("state", 100);
					res.put("msg", "起始页位置超过数据总量");
					res.toString();
				}
			}else {
				begin = page;
				end = count;
			}
			List<BorrowdeviceDevice> list =  dao.selectDeviceBrrowingdevice(teg, ifborrow, borrowtime, returntime, borrowman, personliable, begin, end);
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					if(list.get(i).getIfborrow() == null) {
						list.get(i).setIfborrow(2);
					}
				}
				res.put("state", 0);
				res.put("msg", "查询所有设备成功！");
				res.put("data", list);
				res.put("count", total);
			} else {
				res.put("state", 100);
				res.put("msg", "暂无数据");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	
	public String updateBrrowingdevice(String deviceid, Date borrowtime, String borrowman, String userid,int state) {
		JSONObject res =  new JSONObject();
		try {
			if(state ==0) {
				Integer ifborrow = 1;
				dao.insertBorrowingDevice(deviceid, ifborrow, borrowman, userid);
			}else {
				Integer ifborrow = 2;
				dao.updateBrrowingdevice(deviceid, borrowtime, ifborrow);
			}
			res.put("state", 0);
			res.put("msg", "更新或插入设备借还记录成功！");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	public String selectDeviceDeviceerror(String teg, String tung, String floor, String classroomname,
			Integer repair, Date errortime, String repairman, String personliable, Integer page, Integer count) {
		JSONObject res =  new JSONObject();
		try {
			int  total = dao.selectDeviceDeviceerrorCount(teg, tung, floor, classroomname, repair, errortime, repairman, personliable);
			Integer begin  = 0 ;//设置分页的起始位置
			Integer end  = 0 ;//设施分页的结束位置
			if(count==null||page==null||count <= 0||page < 0) {
				res.put("state", 100);
				res.put("msg", "count或者page的参数不符合要求");
				return res.toString();
				
			}
			if( page > 0) {
				begin = (page-1)*count;
				end = page*count;
				if(begin > total) {
					res.put("state", 100);
					res.put("msg", "起始页位置超过数据总量");
					res.toString();
				}
			}else {
				begin = page;
				end = count;
			}
			List<DeviceDeviceerror> list =  dao.selectDeviceDeviceerror(teg, tung, floor, classroomname, repair, errortime, repairman, personliable, begin, end);
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					
				}
				res.put("state", 0);
				res.put("msg", "查询所有设备成功！");
				res.put("data", list);
				res.put("count", total);
			} else {
				res.put("state", 100);
				res.put("msg", "暂无数据");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	/*public String updateDeviceState(String deviceid, Integer repair, String errortime,Integer state,String scrapproposal,String equipmentteg) {
		JSONObject res =  new JSONObject();
		Integer repairtype = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String startrepair = null;
			String repairtime = null;
			if(state == 1) {
				repair = 1;
				Date date = new Date();
				startrepair = sdf.format(date);
			}else if(state == 2) {
				repairtype = 2;
			}else if(state == 3) {
				repairtype = 1;
			}else if(state == 4) {
				repairtype = 3;
			}else if(state == 5) {
				repair = 2;
				Date date = new Date();
				repairtime = sdf.format(date);
			}
			dao.updateDeviceState(deviceid, repair, errortime, startrepair, repairtime, repairtype, scrapproposal, equipmentteg);
			res.put("state", 0);
			res.put("msg", "更新或插入设备维修记录成功！");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}*/
	
	public String updateDeviceState(String deviceid, Integer repair, String errortime,Integer state,String scrapproposal,String equipmentteg) {
		JSONObject res =  new JSONObject();
		Integer repairtype = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String startrepair = null;
			String repairtime = null;
			if(state == 1) {
				repair = 1;
				Date date = new Date();
				startrepair = sdf.format(date);
				
			}else if(state == 2) {
				repairtype = 2;
			}else if(state == 3) {
				repairtype = 1;
			}else if(state == 4) {
				repairtype = 3;
			}else if(state == 5) {
				repair = 2;
				Date date = new Date();
				repairtime = sdf.format(date);
			}
			dao.updateDeviceState(deviceid, repair, errortime, startrepair, repairtime, repairtype, scrapproposal, equipmentteg,state);
			res.put("state", 0);
			res.put("msg", "更新或插入设备维修记录成功！");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	public String selectdevicebarcode(String devicebarcode) {
		JSONObject res =  new JSONObject();
		List<BorrowdeviceDevice> result = null;
		String[] split = devicebarcode.split("<br>");
		Set<String> set = new HashSet<>();
		List<String> para = new ArrayList<>();
		for (String string : split) {
			 set.add(string); 
		}
		for (String string : set) {
			para.add(string); 
		}
		try {
			result = dao.selectdevicebarcode(para);
			if (result != null && result.size() != 0) {
				res.put("data", result);
				res.put("state", 0);
				res.put("msg", "查询设备信息成功！");
			} else {
				res.put("state", 100);
				res.put("msg", "暂无数据");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	public String selecterrordevicebarcode(String devicebarcode) {
		JSONObject res =  new JSONObject();
		List<DeviceDeviceerror> result = null;
		String[] split = devicebarcode.split("<br>");
		Set<String> set = new HashSet<>();
		List<String> para = new ArrayList<>();
		for (String string : split) {
			 set.add(string); 
		}
		for (String string : set) {
			para.add(string); 
		}
		try {
			result = dao.selecterrordevicebarcode(para);
			if (result != null && result.size() != 0) {
				res.put("data", result);
				res.put("state", 0);
				res.put("msg", "查询设备信息成功！");
			} else {
				res.put("state", 100);
				res.put("msg", "暂无数据");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	public String selecteByRepairtype(String teg, String classroomname, String purchasetime,
			String repairtime, Integer personliable, int repairtype, Integer page, Integer count) {
		JSONObject res =  new JSONObject();
		try {
			int  total = dao.selecteByRepairtypeCount(teg, classroomname, purchasetime, repairtime, personliable, repairtype);
			Integer begin  = 0 ;//设置分页的起始位置
			Integer end  = 0 ;//设施分页的结束位置
			if(count==null||page==null||count <= 0||page < 0) {
				res.put("state", 100);
				res.put("msg", "count或者page的参数不符合要求");
				return res.toString();
				
			}
			if( page > 0) {
				begin = (page-1)*count;
				end = page*count;
				if(begin > total) {
					res.put("state", 100);
					res.put("msg", "起始页位置超过数据总量");
					res.toString();
				}
			}else {
				begin = page;
				end = count;
			}
			List<DeviceDeviceerror> list =  dao.selecteByRepairtype(teg, classroomname, purchasetime, repairtime, personliable, repairtype, begin, end);
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					
				}
				res.put("state", 0);
				res.put("msg", "查询所有设备成功！");
				res.put("data", list);
				res.put("count", total);
			} else {
				res.put("state", 100);
				res.put("msg", "暂无数据");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
}
