package com.swimming.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.swimming.dao.CoachDao;
import com.swimming.model.Coach;
import com.swimming.model.Student;
import com.swimming.util.JDBCUtil;

public class CoachDaoImpl implements CoachDao {

	@Override
	public void addCoach(Coach c) {
		// TODO Auto-generated method stub
		StringBuffer strSQL=new StringBuffer();
		strSQL.append("insert into coach(coach_name,coach_sex,coach_phone,coach_birth_date,coach_remark,coach_tab,coach_operation_date) values(?,?,?,?,?,1,?)");
		
		Connection conn=JDBCUtil.getConnection();
		
		PreparedStatement stmt=null;
		int count = 0;
		int index = 1;
		
		try {
			stmt=conn.prepareStatement(strSQL.toString());
			stmt.setString(1, c.getCoach_name());
			stmt.setString(2, c.getCoach_sex());
			stmt.setString(3, c.getCoach_phone());
			Date date =new Date();
	        String nowTime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	        
	        stmt.setString(4, c.getCoach_birth_date());
	        stmt.setString(5, c.getCoach_remark());
	        
	      
	        stmt.setString(6, nowTime1);
	        
			count=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List allCoach() {
		// TODO Auto-generated method stub
		StringBuffer strSQL=new StringBuffer();
		strSQL.append("select coach_name,coach_number from coach where coach_tab=1");
		Connection conn =JDBCUtil.getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Coach> list=null;
		
		try {
			stmt=conn.prepareStatement(strSQL.toString());
			rs=stmt.executeQuery();
			Coach c=null;
			list=new ArrayList<Coach>();
			
			while(rs.next()){
				c=new Coach();
				c.setCoach_name(rs.getString(1));
				c.setCoach_number(Integer.parseInt(rs.getString(2)));
				
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void deleteCoach(String coach_name) {
		StringBuffer strSQL = new StringBuffer();
		//strSQL.append("update coach set coach_tab=0 where coach_name=? and coach_number=?");// 通配符
		strSQL.append("update coach set coach_tab=0 where coach_name=?");// 通配符
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement stmt=null;
		int index=1;
		int count=0;
		try {
			stmt=conn.prepareStatement(strSQL.toString());
			if (coach_name != null && !"".equals(coach_name))
				stmt.setString(index++, coach_name);
//			if (coach_number != 0 && !"".equals(coach_number))
//				stmt.setInt(index++, coach_number);
			System.out.println("2222");
			count=stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateCoach(Coach c,String oldname) {
		// TODO Auto-generated method stub
		StringBuffer strSQL=new StringBuffer();
		strSQL.append("update coach set coach_name=?,coach_sex=?,coach_phone=?,coach_birth_date=?,coach_remark=?,coach_operation_date=? where coach_name=? ");
		
		Connection conn = JDBCUtil.getConnection();

		PreparedStatement stmt = null;
		int count = 0;
		int index = 1;
		
		
		try {
			stmt=conn.prepareStatement(strSQL.toString());
			
			
			
			Date date =new Date();
			stmt.setString(index++, c.getCoach_name());
			stmt.setString(index++, c.getCoach_sex());
			stmt.setString(index++, c.getCoach_phone());
			stmt.setString(index++, c.getCoach_birth_date());
			stmt.setString(index++, c.getCoach_remark());
	        String nowTime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			
			stmt.setString(index++, nowTime1);
			
			stmt.setString(index++, oldname);
			
			count=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(count>0)
			System.out.println("修改成功");
		
	}

	@Override
	public List queryoneCoach(String coach_name) {
		StringBuffer strSQL=new StringBuffer();
		strSQL.append("select coach_name,coach_sex,coach_birth_date,coach_phone,coach_remark from coach where coach_tab=1 and coach_name=?");
		Connection conn =JDBCUtil.getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Coach> list=null;
		
		try {
			stmt=conn.prepareStatement(strSQL.toString());
			stmt.setString(1, coach_name);
			rs=stmt.executeQuery();
			Coach c=null;
			list=new ArrayList<Coach>();
			
			while(rs.next()){
				c=new Coach();
				c.setCoach_name(rs.getString(1));
				c.setCoach_sex(rs.getString(2));
				c.setCoach_birth_date(rs.getString(3));
				c.setCoach_phone(rs.getString(4));
				c.setCoach_remark(rs.getString(5));
				
				
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
}
