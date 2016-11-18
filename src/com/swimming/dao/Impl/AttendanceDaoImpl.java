package com.swimming.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
			//Date date = new Date();
			//String nowTime1 = new SimpleDateFormat("yyyy-MM-dd").format(date);
			stmt.setString(2, a.getAttendance_date());
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

	
	public List nameSortList() {
		List<Attendance>list1=Attendance();
		int m=0;
		String[] names=new String[list1.size()];
 		for (Attendance attendance : list1) {
			names[m]=attendance.getStu_name();
			m=m+1;
		}
 		Comparator<Object> cmp2 = Collator.getInstance(java.util.Locale.CHINA);  
		Arrays.sort(names,cmp2);
//		for (String string : names) {
//			System.out.println(string.toString());
//		}
		//一个新的list，里面是排序好的list
		List<Attendance> namelist=new ArrayList<Attendance>();
		for (int j = 0; j < list1.size(); j++) {
			for (Attendance a1 : list1) {
				if (names[j].equals(a1.getStu_name())&&!namelist.contains(a1)) {
					namelist.add(a1);
				}
			}
		}
 		
		return namelist;
	}

	@Override
	public List DateSortList() {
		List<Attendance> list1=Attendance();
		int i=0;
		String[] dates=new String [list1.size()];
		for (Attendance attendance : list1) {
			dates[i]=attendance.getAttendance_date();
			i=i+1;
		}
		Comparator<Object> cmp1 = Collator.getInstance(java.util.Locale.CHINA).reversed();
		
		Arrays.sort(dates,cmp1);
		for (String string : dates) {
			System.out.println(string.toString());
		}
		List<Attendance> datelist=new ArrayList<Attendance>();
		for (int j = 0; j < list1.size(); j++) {
			for (Attendance a1 : list1) {
				if (dates[j].equals(a1.getAttendance_date())&&!datelist.contains(a1)) {
					datelist.add(a1);
					
				}
			}
		}
		
		return datelist;
	}
}
