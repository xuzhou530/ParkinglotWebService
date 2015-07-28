package main.com.wswenyue.db.service;


import main.com.wswenyue.db.dao.impl.CardDaoimpl;
import main.com.wswenyue.db.domain.Card;
import main.com.wswenyue.db.domain.User;

import java.sql.SQLException;

/**
 * /**
 * 判断该卡是否存在
 * 获取该卡状态：0/1 0：表示出来，1表示进入 0为默认
 * 获取进来时间或开始时间
 * <p>
 * Created by wswenyue on 2015/6/6.
 */
public class BasicCardService {
    static CardDaoimpl cardDao = new CardDaoimpl();

    /**
     * 判断该卡是否存在
     *
     * @param card
     */
    public static boolean FindCard(Card card) {
        try {
            if (cardDao.find(card.getUid()) != null) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 判断该卡是否存在
     *
     * @param uid
     */
    public static boolean FindCard(Integer uid) {
        if (uid != null) {
            try {
                if (cardDao.find(uid) != null) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 获取该卡刷卡数
     *
     * @param card
     * @return 查询失败返回 NULL
     */
    public static Integer GetCardCount(Card card) {
        Integer status = null;
        if (FindCard(card)) {
            try {
                status = cardDao.find(card.getUid()).getCcount();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return status;
    }

    /**
     * 获取该卡刷卡数
     *
     * @param uid
     * @return 查询失败返回 NULL
     */
    public static Integer GetCardCount(Integer uid) {
        Integer status = null;
        if (FindCard(uid)) {
            try {
                status = cardDao.find(uid).getCcount();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return status;
    }


    /**
     * 获取进来时间或开始时间
     *
     * @param user
     * @return 查询失败返回：空字符串
     */
    public static String GetCardStartTime(User user) {
        String startTime = "";
        Integer uid = BasicUserService.GetUid(user);
        if (uid!=null && FindCard(uid)) {
            try {
                startTime = cardDao.find(uid).getStartTime();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return startTime;
    }

    /**
     * 获取进来时间或开始时间
     *
     * @param uid
     * @return 查询失败返回：空字符串
     */
    public static String GetCardStartTime(Integer uid) {
        String startTime = "";
        if (FindCard(uid)) {
            try {
                startTime = cardDao.find(uid).getStartTime();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return startTime;
    }

    /**
     * 设置刷卡次数，每正确执行一次，对应账户card ccount加1
     *
     * @param uid
     * @return 错误返回：false
     */
    public static boolean SetCardCount(Integer uid) {
        if (FindCard(uid)) {
            try {
                Integer count = GetCardCount(uid);
                if (count != null) {
                    cardDao.updateCcount(uid, count + 1);
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 设置刷卡次数，每正确执行一次，对应账户card ccount加1
     *
     * @param user
     * @return 错误返回：false
     */
    public static boolean SetCardCount(User user) {
        Integer uid = BasicUserService.GetUid(user);
        if (uid != null && FindCard(uid)) {
            try {
                Integer count = GetCardCount(uid);
                if (count != null) {
                    cardDao.updateCcount(uid, count + 1);
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 由user对象获取Card对象
     */
    public static Card GetCard(User user) {
        if (BasicUserService.FindUser(user)) {
            Integer uid = BasicUserService.GetUid(user);
            if (uid != null) {
                try {
                    return cardDao.find(uid);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }



    /**
     * 设置开始时间为空
     *
     * @param uid
     * @return 失败返回：false
     */
    public static boolean SetCardStartTime(Integer uid) {
        if (FindCard(uid)) {
            String startTime = "";
            try {
                cardDao.updateStartTime(uid, startTime);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


}
