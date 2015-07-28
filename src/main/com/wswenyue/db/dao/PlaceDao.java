package main.com.wswenyue.db.dao;


import main.com.wswenyue.db.domain.Place;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by wswenyue on 2015/7/1.
 */
public interface PlaceDao {
    //得到相应等级可用停车位
    List<Place> getAvailablePlaceByGrade(String grade) throws SQLException;
    //得到可用停车位的数量
    String findAvailablePlac() throws SQLException;

    //更新停车位状态的标志
    void updateStatus(Place place) throws SQLException;
    void updateStatus(String placeNum, String isUsing) throws SQLException;

    Integer getUsedCount(String placeNum) throws SQLException;

    //更新停车位使用计数
    void updateUsedCount(Place place) throws SQLException;
    void updateUsedCount(String placeNum, String usedCount) throws SQLException;

    //找到车位
    Place findPlaceByUname(String uname) throws SQLException;
}
