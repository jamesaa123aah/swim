import java.sql.*;

public class Login {

	public int login_yanzheng() {
		
		ConnectionTest connectionTest = new ConnectionTest();
		connectionTest.getConnection();
		
		try {
			Statement sql = connectionTest.connection.createStatement();
			ResultSet resultSet = sql.executeQuery("select * from student");
			
			String id = resultSet.getString("stuid");
			System.out.println(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return 0;
	}
	
	public static void main(String[] args) {
		
		
	}
}
