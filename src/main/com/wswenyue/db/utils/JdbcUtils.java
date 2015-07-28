package main.com.wswenyue.db.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtils {
	private static ComboPooledDataSource ds = null;
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal();
	
	static{
		ds = new ComboPooledDataSource("parkingLot");
	}
	
	public static Connection getConnection() throws SQLException{
		
		Connection conn = threadLocal.get();
		if(conn==null){
			conn = getDataSource().getConnection();
			threadLocal.set(conn);
		}
		return conn;
	}
	
	public static DataSource getDataSource(){
		return ds;
	}
	
	
	public static void startTransaction(){
		try{
			Connection conn =  threadLocal.get();
			if(conn==null){
				conn = getConnection();
				threadLocal.set(conn);  //把conn绑定到当前线程上
			}
			conn.setAutoCommit(false);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void rollback(){
		
		try{
			Connection conn =  threadLocal.get();
			if(conn!=null){
				conn.rollback();
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void commit(){
		
		try{
			Connection conn =  threadLocal.get();
			if(conn!=null){
				conn.commit();
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void release(){
		try{
			Connection conn =  threadLocal.get();
			if(conn!=null){
				conn.close();
				threadLocal.remove(); //解除当前线程上绑定conn
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
}
