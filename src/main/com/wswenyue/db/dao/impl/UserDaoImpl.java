package main.com.wswenyue.db.dao.impl;

import main.com.wswenyue.db.dao.UserDao;
import main.com.wswenyue.db.domain.User;
import main.com.wswenyue.db.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by wswenyue on 2015/6/6.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void updateAll(User user) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "update user set uname=?, password=?, email=?, phone=?, balance=?, userflag=? where uid=?";
        Object params[] = {user.getUname(),user.getPassword(),user.getEmail(),user.getPhone(),user.getBalance(),user.getUserflag(),user.getUid()};
        qr.update(JdbcUtils.getConnection(),sql, params);
    }

    @Override
    public void updateBalance(String phone, int money) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "update user set balance=? where phone=?";
        Object params[] = {money,phone};
        qr.update(JdbcUtils.getConnection(),sql, params);
    }

    @Override
    public void updateUserflag(String phone, int flag) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "update user set userflag=? where phone=?";
        Object params[] = {flag,phone};
        qr.update(JdbcUtils.getConnection(),sql, params);
    }

    @Override
    public void updatePasswd(String phone, String NewPasswd) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "update user set password=? where phone=?";
        Object params[] = {NewPasswd,phone};
        qr.update(JdbcUtils.getConnection(),sql, params);
    }


    @Override
    public void add(User user) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "insert into user(uname,password,email,phone) values(?,?,?,?)";
        Object params[] = {user.getUname(),user.getPassword(),user.getEmail(),user.getPhone()};
        qr.update(sql, params);
    }

    @Override
    public User find(Integer uid) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from user where uid=?";
        return (User) qr.query(JdbcUtils.getConnection(),sql, uid, new BeanHandler(User.class));
    }

    @Override
    public List<User> find() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from user";
        return (List<User>) qr.query(JdbcUtils.getConnection(),sql, new BeanListHandler(User.class));
    }

    @Override
    public List<User> findOnline() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from user where userflag=1";
        return (List<User>) qr.query(JdbcUtils.getConnection(),sql, new BeanListHandler(User.class));
    }

    @Override
    public User find(String phone) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from user where phone=?";
        return (User) qr.query(JdbcUtils.getConnection(),sql, phone, new BeanHandler(User.class));
    }

    @Override
    public User findUserByName(String name) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from user where uname=?";
        return (User) qr.query(JdbcUtils.getConnection(),sql, name, new BeanHandler(User.class));
    }

    @Override
    public User find(String phone, String email) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from user where phone=? add email=?";
        Object params[] = {phone,email};
        return (User) qr.query(JdbcUtils.getConnection(),sql, params, new BeanHandler(User.class));
    }

    @Override
    public User findUserByNameAndPasswd(String name, String passwd) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from user where uname=? add password=?";
        Object params[] = {name,passwd};
        return (User) qr.query(JdbcUtils.getConnection(),sql, params, new BeanHandler(User.class));
    }
}
