package com.swimming.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.swimming.dao.DetailOfAccountDao;
import com.swimming.model.Course;
import com.swimming.model.DetailsOfAccount;
import com.swimming.util.JDBCUtil;

public class DetailOfAccountDaoImpl implements DetailOfAccountDao {

	@Override
	public void DetailsAccount(DetailsOfAccount d) {
		// TODO Auto-generated method stub
		StringBuffer strSQL = new StringBuffer();
		strSQL.append("insert into account_detail(stu_name,remain_money,details,account_operation_date,remain_times) values (?,?,?,?,?)");
		
		
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement stmt=null;
		int count = 0;
		int index = 1;
		
		try {
			stmt=conn.prepareStatement(strSQL.toString());
			stmt.setString(1, d.getstu_name());
			stmt.setInt(2, d.getMoney());
			stmt.setString(3, d.getDetails());
			Date date=new Date();
			 String nowTime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			 stmt.setString(4, nowTime1);
			 stmt.setInt(5, d.getTimes());
			 count=stmt.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List DetailsAccountInfoAll() {
		StringBuffer strSQL=new StringBuffer();
		strSQL.append("select stu_name,remain_money,details,account_operation_date from account_detail");
		Connection conn =JDBCUtil.getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<DetailsOfAccount> list=null;
		
		try {
			stmt=conn.prepareStatement(strSQL.toString());
			rs=stmt.executeQuery();
			DetailsOfAccount d=null;
			list=new ArrayList<DetailsOfAccount>();
			
			while(rs.next()){
				d=new DetailsOfAccount();
				d.setstu_name(rs.getString(1));
				d.setMoney(Integer.parseInt(rs.getString(2)));
				d.setDetails(rs.getString(3));
				d.setAccount_operation_date(rs.getString(4));
				
				list.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List DetailsAccountInfoOfOne(String stu_name) {
		StringBuffer strSQL=new StringBuffer();
		strSQL.append("select stu_name,remain_money,details,account_operation_date from account_detail where stu_name=?");
		Connection conn =JDBCUtil.getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<DetailsOfAccount> list=null;
		
		try {
			stmt=conn.prepareStatement(strSQL.toString());
			stmt.setString(1, stu_name);
			rs=stmt.executeQuery();
			DetailsOfAccount d=null;
			list=new ArrayList<DetailsOfAccount>();
			
			while(rs.next()){
				d=new DetailsOfAccount();
				d.setstu_name(rs.getString(1));
				d.setMoney(Integer.parseInt(rs.getString(2)));
				d.setDetails(rs.getString(3));
				d.setAccount_operation_date(rs.getString(4));
				
				list.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	
	
}
