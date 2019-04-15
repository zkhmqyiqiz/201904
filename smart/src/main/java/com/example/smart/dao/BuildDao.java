package com.example.smart.dao;

import java.util.Date;
import java.util.List;

import com.example.smart.entity.*;
import org.apache.ibatis.annotations.Select;


public interface BuildDao {
	/**
	 * 查询楼栋信息表中所有的楼栋信息
	 * */
	public List<Build> selectBuildByTung();
	
	/**
	 * 根据楼栋名称删除数据
	 * @param tung 楼
	 * */
	public int deleteBuildByTung(String tung);
	
	/**
	 * 插入楼栋信息
	 * @param --楼栋编号
	 * @param tung 楼栋
	 * @param floor 楼层
	 * @param campus 校区
	 * */
	public int insertBuild(Integer buildnumber, String tung, String floor, String campus);
	
	/**
	 * 查询添加的对象是否存在
	 * @param tung 楼栋
	 * @param floor 楼层
	 * @param campus 校区
	 * */
	public Build selectExsit(String tung, String floor, String campus);
	@Select("select * from build where tung =#{0} and floor=#{1}")
	public Build selectBuildNumber(String tung, String floor);
	/**
	 * 查询一栋楼的所有教室
	 * @param tung
	 * @return
	 */
	@Select("select tung,floor,campus,classroomtype,classroomname,classroomid,tjoinnumber from classroom natural join build where tung = #{0} and floor = #{1} limit #{2},#{3}")
	public List<BuildAndClassroom> selectAllBuildAndClassroom(String tung, String floor, Integer limit, Integer count);//XXX 教室类型
	/**
	 * 根据楼栋和楼层查询当前楼栋下当前楼层中的教室总数*/
	@Select("select count(0) from classroom natural join build where tung = #{0} and floor = #{1}")
	public Integer selectAllBuildAndClassroomCount(String tung, String floor);//XXX 教室类型
	/**
	 * 查询条数
	 * @param tung
	 * @return
	 */
	@Select("select count(0) from classroom natural join build where tung = #{0}")
	public Integer selectBuildAndClassroomCount(String tung);
	/**
	 * 按栋查询楼栋
	 * @param tung
	 * @return
	 */
	@Select("SELECT buildnumber,tung,floor,campus FROM build where tung = #{0}")
	public List<Build> selectBuildFromTung(String tung);
	/**
	 * 查询所有楼栋信息
	 * @return
	 */
	public List<Build> selectAllBuild();
	public List<BuildAndClassroom> selectClassroomByTung(String tung, String capmus);
	/**
	 * 根据教室id查询教室布局表
	 * @param --tung
	 * @param --capmus
	 * @return
	 */
	public ClassroomLayout selectClassroomLayout(String classroomid);
	/**
	 * 插入或更新教室布局表
	 * @param classroomLayout
	 * @return
	 */
	public int insertClassroomLayout(ClassroomLayout classroomLayout);
	/**
	 * 根据楼栋编号查询户型图
	 * @param buildnumber
	 * @return
	 */
	public Build selectImage(int buildnumber);
	/**
	 * 根据楼栋编号查询教室列表
	 * @param buildnumber
	 * @return
	 */
	public List<Classroom> selectClassroomByBuildnumber(int buildnumber);
	
	/**
	 * 查询所有楼栋的信息，将查询结果中buildnumber+tung+floor+campus拼接起来，将buildnumber作为classroom的属性值*/
	public List<Build> selectAllBuildByClassroom();
	
	/**
	 * 按栋查询当前楼栋中所有的教室并分页
	 * @param tung
	 * @param begin 分页起始位置
	 * @param end 分页结束位置
	 * @return
	 */
	@Select("SELECT classroomid,classroomid as c,floor,classroomname,classroomtype,state,(select sum(`time`) from classroomusetime where classroomid = c) as sumtime FROM build natural join classroom where tung = #{0} limit #{1},#{2}")
	public List<BuildAndClassroom> selectBulidClassroomByTung(String tung, Integer begin, Integer end);
	
	@Select("SELECT classroomid,classroomid as c,floor,classroomname,classroomtype,state,(select sum(`time`) from classroomusetime where classroomid = c and `date` between #{3} and #{4}) as sumtime FROM build natural join classroom where tung = #{0} limit #{1},#{2}")
	public List<BuildAndClassroom> selectBulidClassroomByTungAndTime(String tung, Integer begin, Integer end, Date timestart, Date timeend);
	
	/**
	 * 按栋,楼层查询当前楼栋中所有的设备的相关信息：设备名称、设备品牌、设备型号、设备编号、设备使用年限、购买时间、楼栋、楼层、教室名称、设备状态、教室ID
	 * @param tung
	 * @param floor 
	 * @return
	 */
//	@Select("SELECT teg,brand,model,devicenumber,servicelife,purchasetime,tung,FLOOR,classroomname,STATUS,classroomid FROM build NATURAL JOIN classroom NATURAL JOIN device WHERE tung = #{0} AND FLOOR = #{1}")
	@Select("SELECT devicename,devicetype,teg,brand,model,devicenumber,servicelife,purchasetime,tung,FLOOR,classroomname,STATUS,a.classroomid  FROM (SELECT * FROM build NATURAL JOIN classroom WHERE tung = #{0} AND FLOOR = #{1}) AS a LEFT JOIN device AS b ON a.classroomid=b.classroomid WHERE a.tung = #{0} AND a.FLOOR = #{1}")
	public List<BuildClassroomDevice> selectDeviceByTungAndFloor(String tung, String floor);
	
	
	
	/**
	 * 更新教室配置json
	 */
	public int updateClassroomLayout(ClassroomLayout classroomLayout);

}
