package com.swimming.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.swimming.model.Attendance;
import com.swimming.model.Student;

import javax.swing.JOptionPane;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.swimming.dao.StudentDao;
import com.swimming.model.Student;
import com.swimming.util.JDBCUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void addStu(Student stu) {
		// TODO Auto-generated method stub
		StringBuffer strSQL=new StringBuffer();
		StringBuffer strSQL2=new StringBuffer();
		//strSQL.append("insert into student(stu_name,stu_sex,stu_school,stu_phone,stu_birthDate,stu_remark,stu_tab,stu_operation_date,class_number) values(?,?,?,?,?,?,1,?,?)");
		strSQL.append("insert into student(stu_name,stu_sex,stu_school,stu_phone,stu_birth_date,stu_remark,stu_tab,stu_operation_date,class_name) values(?,?,?,?,?,?,1,?,?)");
		strSQL2.append("insert into account_info(stu_name,money,times) values(?,0,0)");
		
		Connection conn=JDBCUtil.getConnection();
		
		PreparedStatement stmt,stmt2=null;
		int count = 0;
		int index = 1;
		
		
		try {
			stmt=conn.prepareStatement(strSQL.toString());
			stmt2=conn.prepareStatement(strSQL2.toString());
			
			stmt.setString(1, stu.getStu_name());
			stmt.setString(2, stu.getStu_sex());
			stmt.setString(3, stu.getStu_school());
			stmt.setString(4, stu.getStu_phone());
			
			stmt2.setString(1, stu.getStu_name());
			
	        stmt.setString(5, stu.getStu_birthDate());
	        stmt.setString(6, stu.getStu_remark());
	        Date date=new Date();
	        String nowTime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	        
	        stmt.setString(7, nowTime1);
	        //stmt.setInt(8, stu.getClass_number());
	        stmt.setString(8, stu.getClass_name());
	        
			count=stmt.executeUpdate();
			stmt2.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
			
		
		
	}

	@Override
	public void deleteStu(String stu_name) {
		// TODO Auto-generated method stub
		StringBuffer strSQL = new StringBuffer();
		//strSQL.append("update coach set coach_tab=0 where coach_name=? and coach_number=?");// 通配符
		strSQL.append("update student set stu_tab=0 where stu_name=?");// 通配符
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement stmt=null;
		
		int index=1;
		int count=0;
		try {
			stmt=conn.prepareStatement(strSQL.toString());
			if (stu_name != null && !"".equals(stu_name))
				stmt.setString(index++, stu_name);
//			if (coach_number != 0 && !"".equals(coach_number))
//				stmt.setInt(index++, coach_number);
			System.out.println("2222");
			count=stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
			
		}
		
	}

	@Override
	public List getLookStu(String stuName) {
		// TODO Auto-generated method stub
	
	    
		List<Student> list = new LinkedList<>();
		
		//String sql = "select * from student where stu_name = '"+stuName+"'"+"and stu_tab=1";
		StringBuffer strSQL=new StringBuffer();
		strSQL.append("select stu_name,stu_sex,stu_birth_date,stu_school,class_name,stu_phone,stu_remark from student where stu_name=?");
		Connection conn=JDBCUtil.getConnection();
		
		
		PreparedStatement stmt=null;
		
		int count = 0;
		int index = 1;
		
		Student student = null;
		
		try {
			stmt=conn.prepareStatement(strSQL.toString());
			stmt.setString(1, stuName);
		
			 ResultSet rs = stmt.executeQuery();// executeQuery会返回结果的集合，否则返回空值
		
	         
			 
	         
	         
	         while (rs.next()) {
////	        	 用于输出测试输出名字
//                 System.out.println(rs.getString(3));
//                 
//                 System.out.println(rs.getString(8));
//                 
////                 将一行数据全部加入list
//                 for (int i = 1; i < 11; i++) {
//                	 list.add(rs.getString(i));
//				}
	        	 student = new Student();
	        	 student.setStu_name(rs.getString(1));
	        	 student.setStu_sex(rs.getString(2));
	        	 student.setStu_birthDate(rs.getString(3));
	        	 student.setStu_school(rs.getString(4));
	        	 student.setClass_name(rs.getString(5));
	        	 student.setStu_phone(rs.getString(6));
	        	 student.setStu_remark(rs.getString(7));
                 
	        	 list.add(student);
             }
	         
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "alert1", "222", JOptionPane.ERROR_MESSAGE); 
		}
		
		return list;
	}


	@Override
	public void changeStu(Student student,String oldname) {
		// TODO Auto-generated method stub
		
		StringBuffer strSQL=new StringBuffer();
		strSQL.append("update student set stu_name=?,stu_sex=?,stu_phone=?,stu_birth_date=?,stu_remark=?,stu_operation_date=?,stu_school=?,class_name=? where stu_name=? ");
		
		Connection conn = JDBCUtil.getConnection();

		PreparedStatement stmt = null;
		int count = 0;
		int index = 1;
		
		
		try {
			stmt=conn.prepareStatement(strSQL.toString());
			
			
			
			Date date =new Date();
			stmt.setString(index++, student.getStu_name());
			stmt.setString(index++, student.getStu_sex());
			stmt.setString(index++, student.getStu_phone());
			stmt.setString(index++, student.getStu_birthDate());
			stmt.setString(index++, student.getStu_remark());
			
	        String nowTime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			
			stmt.setString(index++, nowTime1);
			stmt.setString(index++, student.getStu_school());
			stmt.setString(index++, student.getClass_name());
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
	public List allStudent() {
		// TODO Auto-generated method stub
		StringBuffer strSQL=new StringBuffer();
		strSQL.append("select stu_name from student where stu_tab=1");
		Connection conn =JDBCUtil.getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Student> list=null;
		
		try {
			stmt=conn.prepareStatement(strSQL.toString());
			rs=stmt.executeQuery();
			Student stu=null;
			list=new ArrayList<Student>();
			
			while(rs.next()){
				stu=new Student();
				stu.setStu_name(rs.getString(1));
				//stu.setStu_number(Integer.parseInt(rs.getString(2)));
				
				list.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	
	}

	
	public List mistStudent(String strName) {
		// TODO Auto-generated method stub
		List<Student> all_list=allStudent();
		List<Student> mistlist=new ArrayList<Student>();
		
		int i=0;
		//names负责把list中的名字取出来
		String[] names=new String[all_list.size()];
		for (Student student2 : all_list) {	
			if(student2.getStu_name().matches(".*"+strName+".*")){
				names[i]=student2.getStu_name().toString();
				i=i+1;
			}
			
		}
		for (int j = 0; j < i; j++) {
			for (Student student2 : all_list) {
				if (names[j].equals(student2.getStu_name())) {
					mistlist.add(student2);
				}
			}
		}
		return mistlist;
	}

	@Override
	public List nameList() {
		List<Student>list1=allStudent();
		int m=0;
		String[] names=new String[list1.size()];
 		for (Student student : list1) {
			names[m]=student.getStu_name();
			m=m+1;
		}
 		Comparator<Object> cmp2 = Collator.getInstance(java.util.Locale.CHINA);  
		Arrays.sort(names,cmp2);
//		for (String string : names) {
//			System.out.println(string.toString());
//		}
		//一个新的list，里面是排序好的list
		List<Student> namelist=new ArrayList<Student>();
		for (int j = 0; j < list1.size(); j++) {
			for (Student a1 : list1) {
				if (names[j].equals(a1.getStu_name())&&!namelist.contains(a1)) {
					namelist.add(a1);
				}
			}
		}
 		
		return namelist;
	}

	@Override
	public List StudentList(String coursename) {
		// TODO Auto-generated method stub
		StringBuffer strSQL=new StringBuffer();
		strSQL.append("select stu_name from student where stu_tab=1 and class_name=?");
		
		//查看所有学生
		StringBuffer strSQL2=new StringBuffer();
		strSQL2.append("select stu_name from student where stu_tab=1");
		
		Connection conn =JDBCUtil.getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Student> list=null;
		
		try {
			
			if (coursename.equals("全部学员")) {
				stmt=conn.prepareStatement(strSQL2.toString());
			
				rs=stmt.executeQuery();
			}else if (!coursename.equals("全部学员")) 
			{
			stmt=conn.prepareStatement(strSQL.toString());
			stmt.setString(1, coursename);
			rs=stmt.executeQuery();
			}
//			stmt=conn.prepareStatement(strSQL.toString());
//			stmt.setString(1, coursename);
//			rs=stmt.executeQuery();
			Student stu=null;
			list=new ArrayList<Student>();
			
			while(rs.next()){
				stu=new Student();
				stu.setStu_name(rs.getString(1));
				//stu.setStu_number(Integer.parseInt(rs.getString(2)));
				
				list.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List coursenameList(String class_name) {
		// TODO Auto-generated method stub
		List<Student>list1=StudentList(class_name);
		int m=0;
		String[] names=new String[list1.size()];
 		for (Student student : list1) {
			names[m]=student.getStu_name();
			m=m+1;
		}
 		Comparator<Object> cmp2 = Collator.getInstance(java.util.Locale.CHINA);  
		Arrays.sort(names,cmp2);
//		for (String string : names) {
//			System.out.println(string.toString());
//		}
		//一个新的list，里面是排序好的list
		List<Student> namelist=new ArrayList<Student>();
		for (int j = 0; j < list1.size(); j++) {
			for (Student a1 : list1) {
				if (names[j].equals(a1.getStu_name())&&!namelist.contains(a1)) {
					namelist.add(a1);
				}
			}
		}
 		
		return namelist;
	}
}
