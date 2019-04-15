package com.example.smart.dao;

import java.util.Date;
import java.util.List;

import com.example.smart.entity.User;
import org.apache.ibatis.annotations.Param;


public interface UserDao {
	//userid查询
	public User selectUserById(String userid, @Param("pass") String pass);
	//根据手机号和密码查询
	public User selectUserByPhoneNumber(String phoneNumber, @Param("pass") String pass);
	
	//根据userid和pass查询
	public User selectUserByIdAndPass(String userid, @Param("pass") String pass);
	
	public List<User> selectAllUser(int page, int count);
	
	public int addUser(User user);
	
	public int updateUser(User user);
	
	public int deleteUser(String userid);
	
	public int updateUserPhoto(byte[] photo, String userid);
	
	public int saveCurrentsid(String sessionid, String userid);
	
	public String getCurrentsid(String userid);
	
	/**
	 * 获取管理员online=1 时的第一条数据
	 * @return
	 */
	public User startIPCall();
	
	/**
	 * 向ipcall表中插入一条数据
	 * @param userid 用户名
	 * @param start 开始时间
	 * @param end 结束时间
	 * @param ip ip地址。
	 * @return
	 */
	public int setIPCallStatus(String userid, Date start, Date end, String ip, Integer status);
	
	public int updateIPCallstatus(Date endcall, Integer status, String edeviceip);
	//online改为1，上线
	public int updateOnlineTo1(String userid, String ip, String pass, Integer pcport);
	//online改为0，下线
	public int updateOnlineTo0(String userid, String pass);
	//oncall改为1，开始通话
	public int updateOncallTo1(String userid);
	//oncall改为0，结束通话
	public int updateOncallTo0(String userid);

	//挂断电话，修改结束时间
	public int endIPCall(Date date, String edeviceip);

	public int selectAllUserCount();
	
	public User selectauditByUserid(String userid);
}
