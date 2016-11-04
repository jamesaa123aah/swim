package com.swimming.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.swimming.dao.AttendanceDao;
import com.swimming.util.JDBCUtil;
import com.swimming.model.Attendance;

public class AttendanceDaoImpl implements AttendanceDao {

	@Override
	public void stuAttend(Attendance a) {
		// TODO Auto-generated method stub
		StringBuffer strSQL=new StringBuffer();
		strSQL.append("insert into attendance(stu_name,attendance_date,forget) values(?,?,?)");
		Connection conn=JDBCUtil.getConnection();
		
		PreparedStatement stmt=null;
		int count = 0;
		int index = 1;
		
		try {
			stmt=conn.prepareStatement(strSQL.toString());
			stmt.setString(1, a.getStu_name());
			Date date = new Date();
			String nowTime1 = new SimpleDateFormat("yyyy-MM-dd").format(date);
			stmt.setString(2, nowTime1);
			stmt.setInt(3, a.getForget());
			count=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List Attendance() {
		StringBuffer strSQL=new StringBuffer();
		strSQL.append("select attendance_number,stu_name,attendance_date,forget from attendance");
		Connection conn =JDBCUtil.getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Attendance> list=null;
		
		try {
			stmt=conn.prepareStatement(strSQL.toString());
			rs=stmt.executeQuery();
			Attendance a=null;
			list=new ArrayList<Attendance>();
			while(rs.next()){
				a=new Attendance();
				a.setAttendance_number(rs.getInt(1));
				a.setStu_name(rs.getString(2));
				a.setAttendance_date(rs.getString(3));
				a.setForget(rs.getInt(4));
				list.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

	@Override
	public void setForgetToAttendance(int attendance_number) {
		StringBuffer strSQL=new StringBuffer();
		strSQL.append("update attendance set forget=0 where attendance_number=?");
		Connection conn =JDBCUtil.getConnection();
		PreparedStatement stmt=null;
		
		int count=0;
		try {
			stmt=conn.prepareStatement(strSQL.toString());
			stmt.setInt(1, attendance_number);
			
			count=stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List forgetAttendance() {
		StringBuffer strSQL=new StringBuffer();
		strSQL.append("select attendance_number,stu_name,attendance_date from attendance where forget=1");
		Connection conn =JDBCUtil.getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Attendance> list=null;
		
		try {
			stmt=conn.prepareStatement(strSQL.toString());
			rs=stmt.executeQuery();
			Attendance a=null;
			list=new ArrayList<Attendance>();
			while(rs.next()){
				a=new Attendance();
				a.setAttendance_number(Integer.parseInt(rs.getString(1)));
				a.setStu_name(rs.getString(2));
				a.setAttendance_date(rs.getString(3));
				
				list.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
