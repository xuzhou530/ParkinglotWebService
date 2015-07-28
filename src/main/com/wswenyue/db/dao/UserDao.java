package main.com.wswenyue.db.dao;


import main.com.wswenyue.db.domain.User;

import java.sql.SQLException;
import java.util.List;


public interface UserDao {

	/** 更新用户表*/
	void updateAll(User user) throws SQLException;

	/** 对用户的金额进行处理*/
	void updateBalance(String phone, int money) throws SQLException;

	/** 对用户的登录状态进行更改*/
	void updateUserflag(String phone, int flag) throws SQLException;

	/** 修改密码*/
	void updatePasswd(String phone, String NewPasswd) throws SQLException;

	/** 添加用户*/
	void add(User user) throws SQLException;


	/** 通过uid查找用户 */
	User find(Integer uid) throws SQLException;
	/** 查找所有用户 */
	List<User> find() throws SQLException;
	/** 查找所有在线用户 */
	List<User> findOnline() throws SQLException;
   /** 通过手机号查找用户*/
	User find(String phone) throws SQLException;
	/** 通过手机号查找用户*/
	User findUserByName(String name) throws SQLException;

	/** 通过手机号和Email确定用户*/
	User find(String phone, String email) throws SQLException;

	/** 通过手机号和Email确定用户*/
	User findUserByNameAndPasswd(String name, String passwd) throws SQLException;

}