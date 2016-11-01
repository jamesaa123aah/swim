package com_swimming_main_function;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException ;


import javax.swing.OverlayLayout;

public class ConnectionTest {

	Connection connection;
	
	public Connection getConnection(){
		
		try {
//			Class.forName("G://web/WAMP/wamp/bin/mysql/mysql.15.6.17/data/web");
//			Class.forName("jdbc:mysql://localhost:3306/foodies");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("数据库驱动加载完成");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		try {
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swimming", "root","");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}
	
	
}
