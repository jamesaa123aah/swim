package com.swimming.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.swimming.dao.PaymentDao;
import com.swimming.model.Payment;
import com.swimming.model.Student;
import com.swimming.util.JDBCUtil;

public class PaymentDaoImpl implements PaymentDao {

	@Override
	public void ChangeMoneyandTime(Payment p) {
		// TODO Auto-generated method stub
		StringBuffer strSQL=new StringBuffer();
		strSQL.append("update account_info set money=?,times=? where stu_name=?");
		
		Connection conn=JDBCUtil.getConnection();
		
		PreparedStatement stmt=null;
		int count = 0;
		int index = 1;
		
		try {
			stmt=conn.prepareStatement(strSQL.toString());
			
			stmt.setInt(1, p.getMoney());
			stmt.setInt(2, p.getTimes());
			stmt.setString(3, p.getName());
			
			count=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List MoneyandTime(String stu_name) {
		StringBuffer strSQL=new StringBuffer();
		strSQL.append("select money,times from account_info where stu_name=?");
		Connection conn =JDBCUtil.getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Payment> list=null;
		
		try {
			stmt=conn.prepareStatement(strSQL.toString());
			stmt.setString(1, stu_name);
			rs=stmt.executeQuery();
			Payment p=null;
			list=new ArrayList<Payment>();
			
			while(rs.next()){
				p=new Payment();
				p.setMoney(Integer.parseInt(rs.getString(1)));
				p.setTimes(Integer.parseInt(rs.getString(2)));
				
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
}
