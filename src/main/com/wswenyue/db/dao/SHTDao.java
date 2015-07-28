package main.com.wswenyue.db.dao;


import main.com.wswenyue.db.domain.SHT;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by wswenyue on 2015/6/30.
 */
public interface SHTDao {
    SHT findRecent() throws SQLException;
    List<SHT> GitDatas(Integer num) throws SQLException;
}
