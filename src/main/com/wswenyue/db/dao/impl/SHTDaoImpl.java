package main.com.wswenyue.db.dao.impl;


import main.com.wswenyue.db.dao.SHTDao;
import main.com.wswenyue.db.domain.SHT;
import main.com.wswenyue.db.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by wswenyue on 2015/6/30.
 */
public class SHTDaoImpl implements SHTDao {

    @Override
    public SHT findRecent() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from sht where eid=(select max(eid) from sht)";
        return (SHT) qr.query(sql,new BeanHandler(SHT.class));
    }

    @Override
    public List<SHT> GitDatas(Integer num) throws SQLException {
        if(num == null){
            num = 1;
        }
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from sht order by eid desc limit ?";
        return (List<SHT>)qr.query(sql,num,new BeanListHandler(SHT.class));
    }

}
