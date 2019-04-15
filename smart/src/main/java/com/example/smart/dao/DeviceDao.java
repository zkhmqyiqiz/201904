package com.example.smart.dao;

import java.util.Date;
import java.util.List;

import com.example.smart.entity.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;



public interface DeviceDao {
	public List<Device> selectAllDevice(int page, int count);
	
	public int setDevice(DeviceDeviceprpNote device);
	public int setDeviceNew(String propvalue, String deviceid, int propid);
	public int setDeviceForNull(DeviceDeviceprpNote device);
	public int setDeviceForNullNew(String propvalue, String deviceid, int propid);
	public int selectPropById(String deviceid);
	public int selectPropByIdNew(String deviceid, int propid);
	public int insertDevice(DeviceDeviceprpNote device);
	public int insertProp(DeviceDeviceprpNote device);
	public Device selectDeviceById(String deviceid);
	public List<Device> selectDeviceByClass(String classroomid);
	public Deviceerror selectErrorByDevice(String deviceid);
	/**
	 * 根据公司名查询 设备所有信息（加了教室名）
	 * @param page 从那条开始显示的
	 * @param count  条数
	 * @return
	 */
	public List<DeviceNote> selectAllDeviceNote(int page, int count);
	/**
	 * 根据教室名，设备名模糊查询 。
	 * @param classroomname 教室名		
	 * @param devicename 设备名
	 * @param page 从那条数据显示
	 * @param count 显示的条数
	 * @return
	 */
	public  List<DeviceNote> selectDeviceNoteByLike(@Param("classroomname") String classroomname, @Param("devicename") String devicename, int page, int count);
	/**
	 * 查询总条数
	 * @param classroomname 教室名
	 * @param devicename 设备名
	 * @return
	 */
	public int selectDeviceAll(@Param("classroomname") String classroomname, @Param("devicename") String devicename);
	
	/**
	 * 根据设备id查询故障设备信息
	 * @param deviceid
	 * @return
	 */
	public Deviceerror selectDeviceerrorById(String deviceid);
	
	/**
	 * 连接device，deviceprop，propvalue三张表查询数据 
	 * @return
	 */
	public List<DeviceDeviceprpNote> selectAllSensor(String ip);

	
	/**
	 * 连接device，deviceprop，propvalue三张表查询数据 ,devicetype<=5
	 * @return
	 */
	public List<DeviceDeviceprpNote> selectAllDeviceById(String classroomid);

	/**
	 * 连接device，deviceprop，propvalue三张表查询数据 ,devicetype>5
	 * @return
	 */
	public List<DeviceDeviceprpNote> selectAllDeviceById2(String classroomid);
	
	
	/**
	 * 连接device，deviceprop，propvalue三张表查询数据 ,根据id查询，值为list集合。
	 * @return
	 */
	public List<DeviceDeviceprpNote> selectAllDeviceById3(String deviceid);
	
	public List<DeviceDeviceprpNote> selectAllDeviceByClassname(String classroomname);
	
	public int updateDeviceStatus(String deviceid);
	
	public int deleteDeviceById(String deviceid);
	public int deleteDeviceById1(String id);
	
	public int deletePropById(String deviceid);
	public int deletePropById1(String ip, String listDeviceid);
	
	public int updateStatusBy11(Integer status, String deviceid);
	
	public List<Device> selectPropById1(String ip);
	
	public int updateDevice(String devicename, int devicetype, Date date, String teg, String deviceid);
	
	public List<LatestErrorDevices> selectLatestErrorDevice(int page, int count);
	public List<DeviceMessage> selectAllDeviceMessage(int page, int count);
	public int insertDeviceNew(String deviceid, String devicename, String brand, String model, String devicenumber, String classroomid, String devicebarcode, String personliable, Integer servicelife);
	
	public int deleteDevice(String deviceid);
	
	public int updateDeviceNew(String deviceid, String devicename, String brand, String model, String devicenumber, String classroomid, String devicebarcode, String personliable, Integer servicelife);
	
	/**
	 * 设备记录查询
	 * 查询所有的设备的相关信息：设备名称、设备品牌、设备型号、设备编号、设备条形码、设备使用年限、购买时间、楼栋、楼层、教室名称、设备状态、教室ID、责任人
	 * @param teg 设备名称
	 * @param brand 设备品牌 
	 * @param tung 楼栋
	 * @param floor 楼层
	 * @param classroomname 教室名称
	 * @param purchasetime 购买时间
	 * @param personliable 责任人
	 * @param begin 开始
	 * @param end 结束
	 * @return
	 */
	public List<BuildClassroomDevice> selectDevicelike(@Param("teg") String teg, @Param("brand") String brand, @Param("tung") String tung, @Param("floor") String floor, @Param("classroomname") String classroomname, @Param("purchasetime") Date purchasetime, @Param("personliable") String personliable, Integer begin, Integer end);
	
	/**
	 * 设计记录查询
	 * 查询所有的设备总数
	 * @param teg 设备名称
	 * @param brand 设备品牌 
	 * @param tung 楼栋
	 * @param floor 楼层
	 * @param classroomname 教室名称
	 * @param purchasetime 购买时间
	 * @param personliable 责任人
	 * @return
	 */
	public Integer selectDevicelikeCount(@Param("teg") String teg, @Param("brand") String brand, @Param("tung") String tung, @Param("floor") String floor, @Param("classroomname") String classroomname, @Param("purchasetime") Date purchasetime, @Param("personliable") String personliable);

	/**
	 * 设备借还查询
	 * 查询所有的设备的借还相关信息：设备名称、借还状态、借用人、出借时间、归还时间、责任人
	 * @param teg 设备名称
	 * @param ifborrow 是否借出（设备借还状态） 
	 * @param borrowtime 借出时间
	 * @param returntime 归还时间
	 * @param borrowman 借用人
	 * @param personliable 责任人
	 * @param begin 开始
	 * @param end 结束
	 * @return
	 */
	public List<BorrowdeviceDevice> selectDeviceBrrowingdevice(@Param("teg") String teg, @Param("ifborrow") Integer ifborrow, @Param("borrowtime") Date borrowtime, @Param("returntime") Date returntime, @Param("borrowman") String borrowman, @Param("personliable") String personliable, Integer begin, Integer end);
	
	/**
	 * 设备借还查询
	 * 查询满足条件的所有的设备总数
	 * @param teg 设备名称
	 * @param ifborrow 是否借出（设备借还状态） 
	 * @param borrowtime 借出时间
	 * @param returntime 归还时间
	 * @param borrowman 借用人
	 * @param personliable 责任人
	 * @return
	 */
	public Integer selectDeviceBrrowingdeviceCount(@Param("teg") String teg, @Param("ifborrow") Integer ifborrow, @Param("borrowtime") Date borrowtime, @Param("returntime") Date returntime, @Param("borrowman") String borrowman, @Param("personliable") String personliable);
	
	/**
	 * 设备借还
	 * 功能描述：向设备记录表中插入设备借出记录
	 * @param deviceid 设备ID
	 * @param ifborrow 设备状态（此时默认为1,1表示借出）
	 * @param --borrowtime 借出时间（为数据库的当前时间，该参数通过SQL中的函数直接添加，不通过java参数传递）
	 * @param borrowman 借用人
	 * @param userid 借用人ID
	 * @return
	 */
	@Insert("insert into borrowingdevice(deviceid,ifborrow,borrowtime,borrowman,userid) values(#{0},#{1},now(),#{2},#{3})")
	public Integer insertBorrowingDevice(String deviceid, Integer ifborrow, String borrowman, String userid);

	/**
	 * 设备借还
	 * 功能：更改设备的归还时间和设备的状态
	 * @param deviceid 设备ID
	 * @param --returntime 借出时间（为数据库的当前时间，该参数通过SQL中的函数直接添加，不通过java参数传递）
	 * @param ifborrow 设备状态（此时默认为2,2表示已归还，也就是未借出）
	 * @return
	 */
	@Update("update borrowingdevice set ifborrow=#{2},returntime=now() where deviceid =#{0} and borrowtime =#{1}")
	public Integer updateBrrowingdevice(String deviceid, Date borrowtime, Integer ifborrow);

	
	/**
	 * 设备维修查询
	  * 查询所有的设备的维修相关信息：设备名称、设备ID、楼栋、楼层、教室名称、设备维修状态、故障时间、报修人、责任人
	 * @param teg 设备名称
	 * @param tung 楼栋
	 * @param floor 楼层
	 * @param classroomname 教室名称
	 * @param --repair维修状态
	 * @param errortime 故障时间（报修时间）
	 * @param repairman 报修人
	 * @param personliable 责任人
	 * @param begin 开始
	 * @param end 结束
	 * @return
	 */
	public List<DeviceDeviceerror> selectDeviceDeviceerror(@Param("teg") String teg, @Param("tung") String tung, @Param("floor") String floor, @Param("classroomname") String classroomname, @Param("repair") Integer repair, @Param("errortime") Date errortime, @Param("repairman") String repairman, @Param("personliable") String personliable, Integer begin, Integer end);
	
	/**
	 * 设备维修查询
	 *  查询满足条件的维修设备的总数
	 * @param teg 设备名称
	 * @param tung 楼栋
	 * @param floor 楼层
	 * @param classroomname 教室名称
	 * @param --repair维修状态
	 * @param errortime 故障时间（报修时间）
	 * @param repairman 报修人
	 * @param personliable 责任人
	 * @return
	 */
	public Integer selectDeviceDeviceerrorCount(@Param("teg") String teg, @Param("tung") String tung, @Param("floor") String floor, @Param("classroomname") String classroomname, @Param("repair") Integer repair, @Param("errortime") Date errortime, @Param("repairman") String repairman, @Param("personliable") String personliable);

	
	/**
	 * 设备维修
	 *  更改设备维修的开始时间、维修状态、完成维修时间、维修方式、报废方式、配件备注
	 * @param deviceid 设备ID
	 * @param --repair维修状态
	 * @param errortime 故障时间（报修时间）
	 * @param startrepair 开始维修时间
	 * @param repairtime 完成维修时间
	 * @param repairtype 维修方式
	 * @param scrapproposal 报废建议
	 * @param equipmentteg 维修备注
	 * @return
	 */
	public Integer updateDeviceState(@Param("deviceid") String deviceid, @Param("repair") Integer repair, @Param("errortime") String errortime, @Param("startrepair") String startrepair, @Param("repairtime") String repairtime, @Param("repairtype") Integer repairtype, @Param("scrapproposal") String scrapproposal, @Param("equipmentteg") String equipmentteg, @Param("state") int state);
	
	/**
	 * 设备借还
	 *  根据设备条形码查询借还设备的相关信息
	 * @param para  表示设备条形码的list集合
	 * @return
	 */
	public List<BorrowdeviceDevice> selectdevicebarcode(List<String> para);
	
	/**
	 * 设备维修
	 *  根据设备条形码查询维修设备的相关信息
	 * @param para  表示设备条形码的list集合
	 * @return
	 */
	public List<DeviceDeviceerror> selecterrordevicebarcode(List<String> para);
	
	/**
	 * 设备维修查询
	  * 查询所有的设备的维修相关信息：设备名称、设备ID、楼栋、楼层、教室名称、设备维修状态、故障时间、报修人、责任人
	 * @param teg 设备名称
	 * @param classroomname 教室名称
	 * @param --errortime 故障时间（报修时间）
	 * @param repairtime 完成维修的时间
	 * @param personliable 责任人
	 * @param repairtype 维修类型
	 * @param begin 开始
	 * @param end 结束
	 * @return
	 */
	public List<DeviceDeviceerror> selecteByRepairtype(@Param("teg") String teg, @Param("classroomname") String classroomname, @Param("purchasetime") String purchasetime, @Param("repairtime") String repairtime, @Param("personliable") Integer personliable, @Param("repairtype") int repairtype, Integer begin, Integer end);

	public Integer selecteByRepairtypeCount(@Param("teg") String teg, @Param("classroomname") String classroomname, @Param("purchasetime") String purchasetime, @Param("repairtime") String repairtime, @Param("personliable") Integer personliable, @Param("repairtype") int repairtype);
}
