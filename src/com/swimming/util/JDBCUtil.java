package com.swimming.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JDBCUtil {
	
	private static final String URL="jdbc:mysql://localhost:3306/swimming";
	private static final String USER="root";
	private static final String PASSWORD="";
	private static java.sql.Connection cn=null;
	
	//静态块执行最早的
		static{
			try {
				// 加载驱动程序
				Class.forName("com.mysql.jdbc.Driver");
				
				// 获取数据库的连接
				 cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/swimming?user=root&password="
				 		+ ""+"&useUnicode=true&characterEncoding=utf-8");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static java.sql.Connection getConnection(){
			return cn;
		}
	
	public static void closeParam(ResultSet rs,Statement stt,PreparedStatement stmt,Connection conn){
		
		try {
			if(rs!=null)
				rs.close();
			if(stt!=null)
				stt.close();
			if(stmt!=null)
				stmt.close();
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	

}
