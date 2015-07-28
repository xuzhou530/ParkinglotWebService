package main.com.wswenyue.db.dao;


import main.com.wswenyue.db.domain.Price;

import java.sql.SQLException;

/**
 * Created by wswenyue on 2015/6/6.
 */
public interface PriceDao {
    void add(Price price) throws SQLException;

    void update(Price price) throws SQLException;

    void delete(String pname) throws SQLException;

    Price find(String pname) throws SQLException;
}
