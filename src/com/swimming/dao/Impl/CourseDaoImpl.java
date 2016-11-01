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

import com.swimming.dao.CourseDao;
import com.swimming.model.Coach;
import com.swimming.model.Course;
import com.swimming.util.JDBCUtil;

public class CourseDaoImpl implements CourseDao {

	@Override
	public void addClass(Course c) {
		StringBuffer strSQL=new StringBuffer();
		strSQL.append("insert into  class(class_name,class_tab,class_operation_time,coach_name) values(?,1,?,?)");
		
		Connection conn=JDBCUtil.getConnection();
		
		PreparedStatement stmt=null;
		int count = 0;
		int index = 1;
		
		try {
			stmt=conn.prepareStatement(strSQL.toString());
//			stmt.setInt(1, 1004);
			stmt.setString(1, c.getClass_name());
			
			Date date=new Date();
			String nowTime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			stmt.setString(2, nowTime1);
			stmt.setString(3, c.getCoach_name());
			
	        
	       
	       
	        
			count=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println("异常：已有班级名");
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteClass(String course_name) {
		StringBuffer strSQL = new StringBuffer();
		strSQL.append("update class set class_tab=0 where class_name=?");// 通配符
		
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement stmt=null;
		int index=1;
		int count=0;
		try {
			stmt=conn.prepareStatement(strSQL.toString());
			if (course_name != null && !"".equals(course_name))
				stmt.setString(index++, course_name);
			
			
			count=stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List allClass() {
		StringBuffer strSQL=new StringBuffer();
		strSQL.append("select class_name,coach_name from class where class_tab=1");
		Connection conn =JDBCUtil.getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Course> list=null;
		
		try {
			stmt=conn.prepareStatement(strSQL.toString());
			rs=stmt.executeQuery();
			Course c=null;
			list=new ArrayList<Course>();
			
			while(rs.next()){
				c=new Course();
				c.setClass_name(rs.getString(1));
				c.setCoach_name(rs.getString(2));
				
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void updateClass(Course c,String course_name) {
		StringBuffer strSQL=new StringBuffer();
		strSQL.append("update class set coach_name=?,class_name=?,class_operation_time=? where class_name=? ");
		
		Connection conn = JDBCUtil.getConnection();

		PreparedStatement stmt = null;
		int count = 0;
		int index = 1;
		
		
		try {
			stmt=conn.prepareStatement(strSQL.toString());
			
			
			
			Date date =new Date();
			stmt.setString(index++, c.getCoach_name());
			stmt.setString(index++, c.getClass_name());
	        String nowTime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			
			stmt.setString(index++, nowTime1);
			stmt.setString(index++, course_name);
			
			count=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(count>0)
			System.out.println("修改班级成功");
		
	}

	@Override
	public List queryoneClass(String course_name) {
		// TODO Auto-generated method stub
		StringBuffer strSQL=new StringBuffer();
		strSQL.append("select class_name,coach_name from class where class_name=?");
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Course> list=null;
		try {
			stmt=conn.prepareStatement(strSQL.toString());
			stmt.setString(1, course_name);
			rs=stmt.executeQuery();
			Course c=null;
			list=new ArrayList<Course>();
			
			while(rs.next()){
				c=new Course();
				c.setClass_name(rs.getString(1));
				c.setCoach_name(rs.getString(2));
				
				list.add(c);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
