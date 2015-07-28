package main.com.wswenyue.db.dao.impl;

import main.com.wswenyue.db.dao.PriceDao;
import main.com.wswenyue.db.domain.Price;
import main.com.wswenyue.db.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by wswenyue on 2015/6/6.
 */
public class PriceDaoImpl implements PriceDao {
    @Override
    public void add(Price price) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "insert into price(pname,unitprice) values(?,?)";
        Object params[] = {price.getPname(),price.getUnitprice()};
        qr.update(sql, params);
    }

    @Override
    public void update(Price price) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "update price set  unitprice=? where pname=?";
        Object params[] = {price.getUnitprice(),price.getPname()};
        qr.update(JdbcUtils.getConnection(),sql, params);

    }

    @Override
    public void delete(String pname) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "delete from price where pname=?";
        qr.update(JdbcUtils.getConnection(),sql, pname);
    }

    @Override
    public Price find(String pname) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from price where pname=?";
        return (Price) qr.query(JdbcUtils.getConnection(),sql, pname, new BeanHandler(Price.class));
    }
}
