package main.com.wswenyue.db.dao.impl;


import main.com.wswenyue.db.dao.CardDao;
import main.com.wswenyue.db.domain.Card;
import main.com.wswenyue.db.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by wswenyue on 2015/6/6.
 */
public class CardDaoimpl implements CardDao {
    @Override
    public void updateCcount(Card card) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "update card set  ccount=? where uid=?";
        Object params[] = {card.getCcount(),card.getUid()};
        qr.update(JdbcUtils.getConnection(),sql, params);
    }

    @Override
    public void updateCcount(Integer uid,Integer ccount) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "update card set  ccount=? where uid=?";
        Object params[] = {ccount,uid};
        qr.update(JdbcUtils.getConnection(),sql, params);
    }

    @Override
    public void updateStartTime(Card card) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "update card set  startTime=? where uid=?";
        Object params[] = {card.getStartTime(),card.getUid()};
        qr.update(JdbcUtils.getConnection(),sql, params);
    }

    @Override
    public void updateStartTime(Integer uid, String startTime) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "update card set  startTime=? where uid=?";
        Object params[] = {startTime,uid};
        qr.update(JdbcUtils.getConnection(),sql, params);
    }


    @Override
    public void add(Card card) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "insert into card(uid,cname) values(?,?)";
        Object params[] = {card.getUid(),card.getCname()};
        qr.update(sql, params);
    }

    @Override
    public Card find(Integer uid) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from card where uid=?";
        return (Card) qr.query(JdbcUtils.getConnection(),sql, uid, new BeanHandler(Card.class));
    }

}
