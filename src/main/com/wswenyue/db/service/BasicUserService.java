package main.com.wswenyue.db.service;


import main.com.wswenyue.db.dao.impl.UserDaoImpl;
import main.com.wswenyue.db.domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * 查找用户是否存在:FindUser()
 * 查询余额:InquireBalance()
 * 返回用户登录状态：UserStatus()
 * 查看用户账户余额是否大于零：CheckBalance()
 * 查看用户是否已登录：CheckAlreadyLogin()
 *通过手机号得到uid：FindUser()
 * Created by wswenyue on 2015/6/6.
 */
public class BasicUserService {
    static UserDaoImpl userDao = new UserDaoImpl();
    /**
     * 查找用户是否存在
     * @param user
     * @return 用户存在返回true，不存在返回false
     * */
    public static boolean FindUser(User user){
        try {
            if(userDao.find(user.getPhone()) != null){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * 查找用户是否存在
     * @param uname
     * @param phone
     * @return 用户存在返回true，不存在返回false
     * */
    public static boolean FindUser(String uname,String phone){
        try {
            User user = userDao.find(phone);
            if( user!= null && user.getUname().equals(uname)){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 通过手机号得到uid
     * @param phone
     * @return 用户存在返回uid，不存在返回null
     * */
    public static Integer FindUser(String phone){
        try {
            User user = userDao.find(phone);
            if(user != null){
                return user.getUid();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过手机号得到user
     * @param phone
     * @return 用户存在返回uid，不存在返回null
     * */
    public static User GetUser(String phone){
        try {
            User user = userDao.find(phone);
            if(user != null){
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 得到users
     * @return 用户存在返回uid，不存在返回null
     * */
    public static List<User> GetUsers(){
        try {
            List<User> users = userDao.find();
            if(users.size()!=0){
               return users;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 得到在线用户users
     * @return 用户存在返回uid，不存在返回null
     * */
    public static List<User> GetOnlineUsers(){
        try {
            List<User> users = userDao.findOnline();
            if(users.size()!=0){
               return users;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 通过用户名得到user
     * @param uname
     * @return 用户存在返回uid，不存在返回null
     * */
    public static User GetUserByName(String uname){
        try {
            User user = userDao.findUserByName(uname);
            if(user != null){
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 通过用户名和密码得到user
     * @param uname
     * @param passwd
     * @return 用户存在返回uid，不存在返回null
     * */
    public static User GetUserByNameAndPasswd(String uname,String passwd){
        try {
            User user = userDao.findUserByNameAndPasswd(uname,passwd);
            if(user != null){
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过User得到uid
     * @param u
     * @return 用户存在返回uid，不存在返回null
     * */
    public static Integer GetUid(User u){
        try {
            User user = userDao.find(u.getPhone());
            if(user != null){
                return user.getUid();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过UName得到uid
     * @param uname
     * @return 用户存在返回uid，不存在返回null
     * */
    public static Integer GetUidByUname(String uname){
        try {
            User user = userDao.findUserByName(uname);
            if(user != null){
                return user.getUid();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**查询余额
     * */
    public static Integer InquireBalance(User user){
        Integer balance = null;
        if(FindUser(user)){
            try {
                balance = userDao.find(user.getPhone()).getBalance();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return balance;
    }

    /**
     * 查看用户账户余额是否大于零
     * @param user
     * @return 余额大于零返回true，小于零返回false
     * */
    public static boolean CheckBalance(User user){
        Integer money = InquireBalance(user);
        if( money != null && money > 0){
            return true;
        }
        return false;
    }


    /**
     * 返回用户登录状态
     * @param user
     * @return 查询到状态返回状态值：0、1、2
     * @return 查询出错返回NUll
     * */
    public static Integer UserStatus(User user){
        Integer userStatus = null;
        if(FindUser(user)){
            try {
                userStatus = userDao.find(user.getPhone()).getUserflag();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userStatus;
    }



    /**
     * 查看用户是否已登录
     * @param user
     * @return 已登录返回true，否则返回false
     * */
    public static boolean CheckAlreadyLogin(User user){
        Integer status = UserStatus(user);
        if( status != null && status == 1 ){
            return true;
        }
        return false;
    }

    /**
     * 更新余额
     * */
    public static boolean UpdateBalance(String phone, int balance){
        try {
            userDao.updateBalance(phone,balance);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * 充值
     * */
    public static boolean Prepaid(String phone, int money){
        try {
            User user = GetUser(phone);
            if(user!=null){
                userDao.updateBalance(phone,user.getBalance()+money);
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
