package main.com.wswenyue.db.dao.impl;

import main.com.wswenyue.db.dao.AccountDao;
import main.com.wswenyue.db.domain.Account;
import main.com.wswenyue.db.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao {
	
	public void updateAstatusAndStartTime(Account account) throws SQLException{
		QueryRunner qr = new QueryRunner();
		String sql = "update account set astatus=?,startTime=? where uid=?";
		Object params[] = {account.getAstatus(),account.getStartTime(),account.getUid()};
		qr.update(JdbcUtils.getConnection(),sql, params);
		
	}

	@Override
	public void updateAstatus(Account account) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "update account set astatus=? where uid=?";
		Object params[] = {account.getAstatus(),account.getUid()};
		qr.update(JdbcUtils.getConnection(),sql, params);
	}

	@Override
	public void updateAstatus(Integer uid, Integer astatus) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "update account set astatus=? where uid=?";
		Object params[] = {astatus,uid};
		qr.update(JdbcUtils.getConnection(),sql, params);
	}

	@Override
	public void updateStartTime(Account account) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "update account set startTime=? where uid=?";
		Object params[] = {account.getStartTime(),account.getUid()};
		qr.update(JdbcUtils.getConnection(),sql, params);

	}

	@Override
	public void updateStartTime(Integer uid,String startTime) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "update account set startTime=? where uid=?";
		Object params[] = {startTime,uid};
		qr.update(JdbcUtils.getConnection(),sql, params);
	}

	@Override
	public void updateAll(Account account) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "update account set uid=?,aname=?astatus=?,startTime=? where aid=?";
		Object params[] = {account.getUid(),account.getAname(),account.getAstatus(),account.getStartTime(),account.getAid()};
		qr.update(JdbcUtils.getConnection(),sql, params);
	}

	@Override
	public void add(Account account) throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "insert into account(uid,aname) values(?,?)";
		Object params[] = {account.getUid(),account.getAname()};
		qr.update(sql, params);
	}

	@Override
	public Account find(Integer uid) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "select * from account where uid=?";
		return (Account) qr.query(JdbcUtils.getConnection(),sql, uid, new BeanHandler(Account.class));
	}
}
