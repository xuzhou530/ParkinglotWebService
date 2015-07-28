package main.com.wswenyue.db.dao.impl;


import main.com.wswenyue.db.dao.PlaceDao;
import main.com.wswenyue.db.domain.Place;
import main.com.wswenyue.db.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by wswenyue on 2015/7/1.
 */
public class PlaceDaoImpl implements PlaceDao {
    //得到相应等级可用停车位
    @Override
    public List<Place> getAvailablePlaceByGrade(String grade) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from place where grade=? and isUsing='NO' ";
        return (List<Place>) qr.query(JdbcUtils.getConnection(),sql,grade,new BeanListHandler(Place.class));
    }

    @Override
    public String findAvailablePlac() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select count(*) from place where isUsing='NO'";
        Object[] temp = (Object[]) qr.query(JdbcUtils.getConnection(),sql,new ArrayHandler());
        return  temp[0].toString();
    }

    @Override
    public void updateStatus(Place place) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "update place p set p.isUsing=?, p.uname=? where p.id=?";
        Object params[] = {place.getIsUsing(),place.getUname(),place.getId()};
        qr.update(JdbcUtils.getConnection(),sql,params);
    }

    @Override
    public void updateStatus(String placeNum, String isUsing) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "update place set isUsing=? where placeNum=?";
        Object params[] = {isUsing,placeNum};
        qr.update(JdbcUtils.getConnection(),sql,params);
    }

    @Override
    public Integer getUsedCount(String placeNum) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select usedCount from place where placeNum=?";
        return (Integer) qr.query(JdbcUtils.getConnection(), sql, placeNum, new ScalarHandler(1));
    }

    @Override
    public void updateUsedCount(Place place) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "update place set usedCount=? where id=?";
        Object params[] = {place.getUsedCount(),place.getId()};
        qr.update(JdbcUtils.getConnection(),sql,params);
    }

    @Override
    public void updateUsedCount(String placeNum,String usedCount) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "update place set usedCount=? where placeNum=?";
        Object params[] = {usedCount,placeNum};
        qr.update(JdbcUtils.getConnection(),sql,params);
    }

    @Override
    public Place findPlaceByUname(String uname) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from place where uname=?";
        return (Place) qr.query(JdbcUtils.getConnection(), uname, sql, new BeanHandler(Place.class));
    }
}
