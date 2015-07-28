package main.com.wswenyue.db.dao;


import main.com.wswenyue.db.domain.Card;

import java.sql.SQLException;


public interface CardDao {

	/**更新进出状态*/
	void updateCcount(Card card) throws SQLException;
	/**更新进出状态*/
	void updateCcount(Integer uid, Integer ccount) throws SQLException;

	/**更新进入时间*/
	void updateStartTime(Card card) throws SQLException;

	/**更新进入时间*/
	void updateStartTime(Integer uid, String startTime) throws SQLException;

	/** 添加账户*/
	void add(Card card) throws SQLException;

	/** 查找账户*/
	Card find(Integer uid) throws SQLException;

}