package com.swimming.view.mian_login_register;
import java.sql.*;

import com.mysql.jdbc.RowDataCursor;

import com_swimming_main_function.ConnectionTest;

public class Login {

	public int login_yanzheng() {
		
		ConnectionTest connectionTest = new ConnectionTest();
		Connection connection=connectionTest.getConnection();
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		try {
			statement = connection.prepareStatement("select * from student");
			resultSet=statement.executeQuery();
			String id=null;
			
			if(resultSet.next())
			id= resultSet.getString(1);
			
			
			System.out.println(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return 0;
	}
}
