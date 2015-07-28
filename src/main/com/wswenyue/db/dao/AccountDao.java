package main.com.wswenyue.db.dao;


import main.com.wswenyue.db.domain.Account;

import java.sql.SQLException;


public interface AccountDao {

	/**更新进出状态和进入时间*/
	void updateAstatusAndStartTime(Account account) throws SQLException;
	/**更新进出状态*/
	void updateAstatus(Account account) throws SQLException;
	/**更新进出状态*/
	void updateAstatus(Integer uid, Integer astatus) throws SQLException;
	/**更新进入时间*/
	void updateStartTime(Account account) throws SQLException;
	/**更新进入时间*/
	void updateStartTime(Integer uid, String startTime) throws SQLException;
	/**更新全部*/
	void updateAll(Account account) throws SQLException;

	/** 添加账户*/
	void add(Account account) throws SQLException;

	/** 查找账户*/
	Account find(Integer uid) throws SQLException;
}