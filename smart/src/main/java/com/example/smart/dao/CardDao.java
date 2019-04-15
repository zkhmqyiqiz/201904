package com.example.smart.dao;

import java.util.List;

import com.example.smart.entity.AllCardByUser;
import com.example.smart.entity.Card;
import com.example.smart.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;



public interface CardDao {
	
	public int selectCardCount();
	
	public List<Card> selectAllCard(int page, int count);
	
	public User selectUserByCard(Long cardid);
	
	public List<Card> selectCardByUser(String userid);
	//查询分页所有的用户的信息
	public List<AllCardByUser> selectCardToUser(Integer page, Integer count);
	//查询卡的总数
	public Integer selectCardToUserCount();
	
	//查询当前卡号是大端还是小端，1表示大端，2表示小端
	@Select("select radixs from radix")
	public Integer selectCardRadix();
	
	//根据卡号配置提交的卡号类型（大端，小端），更新数据表radix
	@Update("update radix set radixs = #{0} where id = 1")
	public Integer updateCardRadix(Integer radix);
	
	/**
	 * 根据userid,username模糊查询用户以及对应的卡号信息*/
	public List<AllCardByUser> selectCardToUserlike(@Param("userid") String userid, @Param("username") String username, @Param("page") Integer page, @Param("count") Integer count);
	
	/**
	 * 根据userid,username模糊查询用户以及对应的卡号信息的数据总数*/
	public Integer selectCardToUserlikeCount(@Param("userid") String userid, @Param("username") String username);
	
	/**
	 * 根据list批量更新多用户对应的卡号*/
	public Integer updateCard(List<Card> list);
	
	
	@Update("UPDATE card SET cardid=(cardid >> 24 | ((cardid >> 8)&0xff00) | ((cardid << 8)&0xff0000) | ((cardid << 24)&0xff000000))")
	public Integer updateAllCard();
}
