package main.com.wswenyue.db.service;


import main.com.wswenyue.db.dao.impl.PriceDaoImpl;
import main.com.wswenyue.db.domain.Price;

import java.sql.SQLException;

/**
 * 添加、修改、删除单价
 * Created by wswenyue on 2015/6/6.
 */
public class PriceService {
    static PriceDaoImpl priceDao = new PriceDaoImpl();

    /**
     * 查找是否存在此单价
     * @param pname
     * @return 找到返回true，找不到或执行出错返回false
     * */
    public static boolean FindPrice(String pname){
        try {
            if(priceDao.find(pname) != null){
               return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取单价名所对应的单价
     * @param pname
     * @return 找到返回price，找不到或执行出错返回NULL
     * */
    public static Integer GetPrice(String pname){
        Integer price = null;
        if(FindPrice(pname)){
            try {
                price = priceDao.find(pname).getUnitprice();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return price;
    }
    /**
     * 添加单价
     * @param price
     * @return 成功返回true，失败返回false
     * */
    public static boolean AddPrice(Price price){
        if(!FindPrice(price.getPname())){
            try {
                priceDao.add(price);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 修改单价
     * @param price
     * @return 成功返回true，失败返回false
     * */
    public static boolean ModifyPrice(Price price){
        if(FindPrice(price.getPname())){
            try {
                priceDao.update(price);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 删除指定名称的单价
     * @param price
     * @return 成功返回true，失败返回false
     * */
    public static boolean DeletePrice(Price price){
        if(FindPrice(price.getPname())){
            try {
                priceDao.delete(price.getPname());
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
