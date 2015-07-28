package main.com.wswenyue.db.service;


import main.com.wswenyue.db.dao.impl.SHTDaoImpl;
import main.com.wswenyue.db.domain.SHT;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by wswenyue on 2015/7/2.
 */
public class SHTManage {
    static SHTDaoImpl shtDao = new SHTDaoImpl();
    public static final Integer DataNum = 10;
    public static SHT GetRecentSHT(){
        SHT sht = null;
        try {
             sht = shtDao.findRecent();
            if (sht == null) {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sht;
    }

    public static String GetDatas(Integer num){
        StringBuffer sb = new StringBuffer();
        try {
            List<SHT> list = shtDao.GitDatas(num);
            for (int i = num-1; i >=0 ; i--) {
                String[] strs = list.get(i).getTime().split(" ");
                if(i==0){
                    sb.append("'").append(strs[1]).append("'#");
                }else {
                    sb.append("'").append(strs[1]).append("',");
                }
            }
            for (int i = num-1; i >=0 ; i--) {
                if(i==0){
                    sb.append(list.get(i).getT()).append("#");
                }else {
                    sb.append(list.get(i).getT()).append(",");
                }
            }
            for (int i = num-1; i >=0 ; i--) {
                if(i==0){
                    sb.append(list.get(i).getH());
                }else {
                    sb.append(list.get(i).getH()).append(",");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
