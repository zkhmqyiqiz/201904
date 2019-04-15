package com.example.smart.service;

import java.net.InetSocketAddress;
import java.util.Base64;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.example.smart.dao.BuildDao;
import com.example.smart.entity.Build;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.mina.core.session.IoSession;

import com.alibaba.fastjson.JSONObject;

import net.common.util.ProtocolUtil;
import net.smartmiddle.constant.Login;
import net.smartmiddle.deprecated.SmartLiveProtoHeader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildService {
	@Autowired
	private BuildDao buildDao;


	private static final Logger logger = LogManager.getLogger();
	public String selectBuildByTung() {
		JSONObject res = new JSONObject();
		try {
			List<Build> buildList = null;
			buildList = buildDao.selectBuildByTung();
			if (!(buildList == null)) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", buildList);
			} else {
				res.put("state", 100);
				res.put("msg", "查询配置失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
		
	}
	public String selectAllBuild() {
		JSONObject res = new JSONObject();
		try {
			List<Build> buildList = null;
			buildList = buildDao.selectAllBuild();
			if (!(buildList == null)) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", buildList);
			} else {
				res.put("state", 100);
				res.put("msg", "查询配置失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
		
	}
	
	public String deleteBuildByTung(String tung) {
		JSONObject res = new JSONObject();
		try {
			int a = 0;
			a = buildDao.deleteBuildByTung(tung);
			if (a>0) {
				res.put("state", 0);
				res.put("msg", "删除配置成功！");
			} else {
				res.put("state", 100);
				res.put("msg", "删除配置失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
		
	}
	
	public String insertBuild(String tung, String floor, String campus) {
		JSONObject res = new JSONObject();
		try {
			Build build = buildDao.selectExsit(tung, floor, campus);
			if(build == null) {
				String temp = tung+floor+campus;
				int buildnumber = Math.abs(ProtocolUtil.crc32(temp.getBytes()));
				int a = 0;
				a = buildDao.insertBuild(buildnumber, tung, floor, campus);
				if (a>0) {
					res.put("state", 0);
					res.put("msg", "添加配置成功！");
				} else {
					res.put("state", 100);
					res.put("msg", "添加配置失败！");
				}
			} else {
				res.put("state", 300);
				res.put("msg", "此楼栋已存在！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
		
	}
	
	public String selectAllBuildAndClassroom(String tung,String floor,Integer page,Integer limit) {
		JSONObject res = new JSONObject();
		try {
			List<BuildAndClassroom> result = buildDao.selectAllBuildAndClassroom(tung, floor, (page-1)*limit, limit);
			if(result != null) {
				res.put("state", 0);
				res.put("count", buildDao.selectBuildAndClassroomCount(tung));
				res.put("msg", "查询配置成功！");
				res.put("data", result);
			} else {
				res.put("state", 100);
				res.put("msg", "查询配置失败！！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
	}
	
	public String selectAllBuildAndClassroomNew(String tung,String floor,Integer page,Integer count) {
		JSONObject res = new JSONObject();
		try {
			List<BuildAndClassroom> result = buildDao.selectAllBuildAndClassroom(tung, floor, (page-1)*count, count);
			if(result != null) {
				res.put("state", 0);
				res.put("count", buildDao.selectAllBuildAndClassroomCount(tung,floor));
				res.put("msg", "查询配置成功！");
				res.put("data", result);
			} else {
				res.put("state", 100);
				res.put("msg", "查询配置失败！！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
	}
	
	public String selectBuildFromTung(String tung) {
		JSONObject res = new JSONObject();
		try {
			List<Build> buildList = null;
			buildList = buildDao.selectBuildFromTung(tung);
			if (!(buildList == null)) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", buildList);
			} else {
				res.put("state", 100);
				res.put("msg", "查询配置失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
		
	}
	public String selectClassroomByTung(String tung, String campus) {
		JSONObject res = new JSONObject();
		try {
			List<BuildAndClassroom> buildList = null;
			buildList = buildDao.selectClassroomByTung(tung, campus);
			if (!(buildList == null)) {
				res.put("state", 0);
				res.put("msg", "查询教室信息成功！");
				res.put("data", buildList);
			} else {
				res.put("state", 100);
				res.put("msg", "查询教室信息失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}

	public String selectClassroomLayout(String classroomid) {
		JSONObject res = new JSONObject();
		try {
			//String layoutJson = null;
			ClassroomLayout classroomLayout = null;
			classroomLayout = buildDao.selectClassroomLayout(classroomid);
			if (!(classroomLayout == null)) {
				res.put("state", 0);
				res.put("msg", "查询教室布局信息成功！");
				res.put("layoutJson", classroomLayout);
			} else {
				res.put("state", 100);
				res.put("msg", "查询教室布局信息失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	public String insertClassroomLayout(ClassroomLayout classroomLayout) {
		JSONObject res = new JSONObject();
		try {
			Integer count = null;
			count = buildDao.insertClassroomLayout(classroomLayout);
			if (count != null) {
				res.put("state", 0);
				res.put("msg", "插入教室布局信息成功！");
			} /*else {
				res.put("state", 100);
				res.put("msg", "插入教室布局信息失败！");
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	public String selectImage(int buildnumber) {
		JSONObject res = new JSONObject();
		try {
			Byte[] array = null;
			Build build = buildDao.selectImage(buildnumber);
			List<Classroom> list = buildDao.selectClassroomByBuildnumber(buildnumber);
			Base64.Encoder encoder = Base64.getEncoder();
			String image = null;
			if ((build != null && list != null)) {
				array = build.getApartment();
				byte[] newarray = new byte[array.length];
				for (int i = 0; i < array.length; i ++) {
					newarray[i] = array[i];
				}
				image = encoder.encodeToString(newarray);
				res.put("buildnumber", buildnumber);
				res.put("state", 0);
				res.put("msg", "查询教室布局信息成功！");
				res.put("image", image);
				res.put("data", list);
			} else {
				res.put("state", 100);
				res.put("msg", "查询教室布局信息失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	public String selectImages(String tung,String floor) {
		BuildDaoImp dao = new  BuildDaoImp();
		Build build  = dao.selectBuildNumber(tung, floor);
		String temp = new  BuildService().selectImage(build.getBuildnumber());
		return temp;
		
	}
	
	/*public String selectImages(String tung,String floor) {
		JSONObject res = new JSONObject();
		try{
			BuildDaoImp dao = new  BuildDaoImp();
			Build build  = dao.selectBuildNumber(tung, floor);
			res.put("state", 0);
			res.put("msg", "查询教室布局信息成功！");
			res.put("image", build.getApartment());
		}catch(Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		return res.toString();
		
	}*/
	
	public String selectAllBuildByClassroom() {
		JSONObject res = new JSONObject();
		try {
			List<Build> list = buildDao.selectAllBuildByClassroom();
			if (list.size() > 0) {
				res.put("state", 0);
				res.put("msg", "查询楼栋信息成功！");
				res.put("data", list);
			} else {
				res.put("state", 100);
				res.put("msg", "查询楼栋信息失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	public String selectBulidClassroomByTung(String tung, Integer page, Integer count ,Date timestart,Date timeend) {
		JSONObject res =  new JSONObject();
		try {
			int  total = buildDao.selectBuildAndClassroomCount(tung);//根据楼栋查询当前楼栋的教室总数
			Integer begin  = 0 ;//设置分页的起始位置
			Integer end  = 0 ;//设施分页的结束位置
			if(count <= 0) {
				res.put("state", 100);
				res.put("msg", "count的参数不符合要求");
				res.toString();
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
			List<BuildAndClassroom> list = new LinkedList<>();
			if(timestart == null) {
				list = buildDao.selectBulidClassroomByTung(tung, begin, end);
			} else {
				list = buildDao.selectBulidClassroomByTungAndTime(tung, begin, end,timestart,timeend);
			}
			if (list.size() > 0) {
				res.put("state", 0);
				res.put("msg", "根据楼栋查询所有教室成功！");
				res.put("data", list);
				res.put("count", total);
			} else {
				res.put("state", 100);
				res.put("msg", "根据楼栋查询所有教室失败！");
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
	
	public String selectDeviceByTungAndFloor(String tung, String floor,Integer page,Integer count) {
		JSONObject res = new JSONObject();
		try {
			List<BuildClassroomDevice> list = buildDao.selectDeviceByTungAndFloor(tung, floor);
			if(list.size() > 0) {
				res.put("state", 0);
				res.put("msg", "根据楼栋、楼层查询所有的设备，查询成功");
				res.put("data", list);
				res.put("page", page);
				res.put("count", count);
			}else {
				res.put("state", 100);
				res.put("msg", "根据楼栋、楼层查询所有的设备，查询失败");
				res.put("data", list);
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
	
	
	
	
	
	public String updateClassroomLayout(ClassroomLayout classroomLayout) {
		JSONObject res = new JSONObject();
		try {
			int result = buildDao.updateClassroomLayout(classroomLayout);
			if (result > 0) {
				res.put("state", 0);
				res.put("msg", "更新数据正常！");
			} else {
				res.put("state", 100);
				res.put("msg", "更新数据失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	public String goDataToPC(String classroomid, String clientIP) {
		JSONObject res = new JSONObject();
		try {
			Set<IoSession> ioset = Login.szUserMap.keySet();
			for (IoSession session : ioset) {
				String ip = ((InetSocketAddress)session.getRemoteAddress()).getAddress().getHostAddress();
				if(clientIP.equals(ip)) {
					byte[] rsp_obj_byte = classroomid.getBytes("GBK");
					int newcrc = ProtocolUtil.crc32(rsp_obj_byte);
					int cookie = ProtocolUtil.crc32(Login.szUserMap.get(session).getBytes());
					SmartLiveProtoHeader rspHead = new SmartLiveProtoHeader(cookie, rsp_obj_byte.length,
							rsp_obj_byte.length, false, newcrc, SmartLiveProtoHeader.localversion, 'W',
							30008, 0);
					byte[] rsp_head_byte = rspHead.tobyte();
					byte[] rsp_byte = new byte[rsp_head_byte.length + rsp_obj_byte.length];
					//System.out.println(rspHead.toString() + rspObj.toString());
					System.arraycopy(rsp_head_byte, 0, rsp_byte, 0, rsp_head_byte.length);
					System.arraycopy(rsp_obj_byte, 0, rsp_byte, rsp_head_byte.length, rsp_obj_byte.length);
					session.write(rsp_byte);
					res.put("state", 0);
					res.put("msg", "发送数据正常！");
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据发送错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}

}
