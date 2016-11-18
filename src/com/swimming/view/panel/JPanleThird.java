package com.swimming.view.panel;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.swimming.dao.AttendanceDao;
import com.swimming.dao.DetailOfAccountDao;
import com.swimming.dao.PaymentDao;
import com.swimming.dao.StudentDao;
import com.swimming.dao.Impl.AttendanceDaoImpl;
import com.swimming.dao.Impl.DetailOfAccountDaoImpl;
import com.swimming.dao.Impl.PaymentDaoImpl;
import com.swimming.dao.Impl.StudentDaoImpl;
import com.swimming.model.Attendance;
import com.swimming.model.DetailsOfAccount;
import com.swimming.model.Payment;
import com.swimming.model.Student;

public class JPanleThird  implements TableModelListener{

//	 my is abstract tablemodel
	 public  static  MyTableModel my =null; 
	 public static JTable table =null;
	 private static JPanleThird jPanelThird = null;
	 public static JPanel jPanel = null;

	// public static String[] columnNames;
	// public static Object[][] data;
//	 单实例设计模式
	 private JPanleThird(){
		 my = new MyTableModel();
		 table = new JTable(my);
	
	 }
		 
	 public static JPanel getInstance() {
		
		 if(jPanel==null){
			 
			 jPanelThird = new JPanleThird();
			 jPanel = new JPanel();
		 }
		 

//			把列名和数据加入  监听这个对象。。。
			my.addTableModelListener(jPanelThird);
			table = new JTable(my);
			
//			设置表的宽
			table.getColumnModel().getColumn(2).setPreferredWidth(130);
			table.getColumnModel().getColumn(1).setPreferredWidth(150);
			table.getColumnModel().getColumn(0).setPreferredWidth(150);
			table.getColumnModel().getColumn(3).setPreferredWidth(80);
			
		    JScrollPane sp=new JScrollPane(table);
		    sp.setPreferredSize(new Dimension(1200, 560));
			
			jPanel.add(sp);
			
		return jPanel;
		
	}
	

	
//	 暂时不需要捕捉事件，直接扫描table就可以
	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub

	
		
			
		/*
		 * 每个学员的单次考勤
		 * 手动输入
		 * 如果是正常考勤输入0
		 * 如果是漏打卡输入1
		 * 将数据存入考勤表\
		 
		 * 
		 * 2、注意还要扣费
		 * 3、还要写入明细表里
		 */
		
		AttendanceDao attendanceDao = new AttendanceDaoImpl();
		Attendance attendance = new Attendance();
		
		
		
		
		int row = e.getFirstRow();
	    int column = e.getColumn();
		/*
		 * 判断是否清楚漏打卡
		 * 11/8
		 */
		int n;
		if(column!=3){
			String name =(String) my.getValueAt(row,0);
			List<Attendance> list_clear=attendanceDao.forgetAttendance();
            int size = list_clear.size();
            for (int i = 0; i <size; i++) {
				
            	if (list_clear.get(i).getStu_name().equals(name)) {
            		n=JOptionPane.showConfirmDialog(null, "是否移除漏打卡","清除",JOptionPane.YES_NO_OPTION);
            		if(n==0){
            			attendanceDao.setForgetToAttendance(list_clear.get(i).getAttendance_number());
            		}
            		
				}
			}

			
			
		
			
		}
	
	  	
	    /*
	     * 第一次余额不足不能一键考勤
	     */
	   
	    
	    if(column!=2&&column!=3&&my.getValueAt(row, 3).equals(0)&&(my.getValueAt(row, 3).equals(0))){
	    	
	    	JOptionPane.showMessageDialog(null,"余额不足(不能一健考勤)，请修改学员钱", "警告", JOptionPane.INFORMATION_MESSAGE);	
	    	
	    	if(column>3){
	    	//my.setValueAt(-1, row, 3);
	    	//my.setValueAt("", row, column);
	    	
	    	/*
	    	 * 没有钱了也考勤
	    	 * 但是费用和次数没办法扣掉
	    	 * 需要手动修改学员信息
	    	 * 11/18
	    	 */
	    	
	    	
//	    	获取用户输入的值
	    	String tem =my.getValueAt(row, column).toString();
	   
/*
 * 正常考勤
 * 加入考勤表
 */
	    if(column>3&&tem.equals("0")){
	    	System.out.println("0000");	 
	    	attendance.setStu_name((String) my.getValueAt(row, 0));
	    	attendance.setForget(0);
	    	String year = JpanelFirst.year;
	    	String month =JpanelFirst.month;
	        String day = String.valueOf(column-3);
	        if(day.length()==1){day = "0"+day;}
	        String attendance_date = year+"-"+month+"-"+day;
	    	attendance.setAttendance_date(attendance_date);
	    	attendanceDao.stuAttend(attendance);
	    	
//	    	/*
//	    	 * 扣费
//	    	 * 扣减次数
//	    	 */
//	    	PaymentDao paymentDao = new PaymentDaoImpl();		
//	    	List<Payment> list=paymentDao.MoneyandTime((String) my.getValueAt(row, 0));
//	    	int money_time = list.get(0).getMoney()/list.get(0).getTimes();
//	    	
//	    	Payment payment = new Payment();
//	    	payment.setName((String) my.getValueAt(row, 0));
//	    	payment.setMoney(list.get(0).getMoney()-money_time);
//	    	payment.setTimes(list.get(0).getTimes()-1);
//	    	paymentDao.ChangeMoneyandTime(payment);
	    	
	    	/*
	    	 * 表格中
	    	 * 界面的次数
	    	 * 相应减一
	    	 */
	    	my.setValueAt(Integer.parseInt(String.valueOf(my.getValueAt(row, 3)))-1, row, 3);
	   
	    	/*
	    	 * 导入明细表
	    	 * 2016/11/8
	    	 */
	  
//			DetailsOfAccount detailsOfAccount = new DetailsOfAccount();
//			DetailOfAccountDao detailOfAccountDao = new DetailOfAccountDaoImpl();
//			detailsOfAccount.setstu_name((String) my.getValueAt(row, 0));
//			detailsOfAccount.setDetails("正常考勤");
//			detailsOfAccount.setMoney((int) my.getValueAt(row, 3));
//			
//			detailOfAccountDao.DetailsAccount(detailsOfAccount);
	    }else if (column>3&&tem.equals("1")) {
	    	/*
	    	 * 楼打卡考勤
	    	 * 加入attendace表
	    	 */
	    	//System.out.println("111");	 
	    	attendance.setStu_name((String) my.getValueAt(row, 0));
	    	attendance.setForget(1);
	    	String year = JpanelFirst.year;
	    	String month =JpanelFirst.month;
	        String day = String.valueOf(column-3);
	        if(day.length()==1){day = "0"+day;}
	        String attendance_date = year+"-"+month+"-"+day;
	    	attendance.setAttendance_date(attendance_date);
	    	attendanceDao.stuAttend(attendance);
	    	
	    	
//	    	/*
//	    	 * 扣费
//	    	 * 扣减次数
//	    	 */
//	    	PaymentDao paymentDao = new PaymentDaoImpl();		
//	    	List<Payment> list=paymentDao.MoneyandTime((String) my.getValueAt(row, 0));
//	    	int money_time = list.get(0).getMoney()/list.get(0).getTimes();
//	    	
//	    	Payment payment = new Payment();
//	    	payment.setName((String) my.getValueAt(row, 0));
//	    	payment.setMoney(list.get(0).getMoney()-money_time);
//	    	payment.setTimes(list.get(0).getTimes()-1);
//	    	paymentDao.ChangeMoneyandTime(payment);
//	    	my.setValueAt(Integer.parseInt(String.valueOf(my.getValueAt(row, 3)))-1, row, 3);
		    
	    	/*
	    	 * 导入明细表
	    	 * 2016/11/8
	    	 */
	  
//			DetailsOfAccount detailsOfAccount = new DetailsOfAccount();
//			DetailOfAccountDao detailOfAccountDao = new DetailOfAccountDaoImpl();
//			detailsOfAccount.setstu_name((String) my.getValueAt(row, 0));
//			detailsOfAccount.setDetails("漏打卡");
//			detailsOfAccount.setMoney((int) my.getValueAt(row, 3));
//			
//			detailOfAccountDao.DetailsAccount(detailsOfAccount);
			
	    
	    } else {
			
			    if(column>3&&!tem.equals("")){
			    	JOptionPane.showMessageDialog(null,"只能输入0和1", "操作不合法", JOptionPane.INFORMATION_MESSAGE);	
			    	my.setValueAt("", row, column);
			    	System.out.println("tttt");
			    }
			  				
				}
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	/*
	    	 * 在没有钱的情况下
	    	 * 考勤
	    	 */
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	}
	    	
	    }else{
	   
//	    	获取用户输入的值
	    	String tem =my.getValueAt(row, column).toString();
	   
/*
 * 正常考勤
 * 加入考勤表
 */
	    if(column>3&&tem.equals("0")){
	    	System.out.println("0000");	 
	    	attendance.setStu_name((String) my.getValueAt(row, 0));
	    	attendance.setForget(0);
	    	String year = JpanelFirst.year;
	    	String month =JpanelFirst.month;
	        String day = String.valueOf(column-3);
	        if(day.length()==1){day = "0"+day;}
	        String attendance_date = year+"-"+month+"-"+day;
	    	attendance.setAttendance_date(attendance_date);
	    	attendanceDao.stuAttend(attendance);
	    	
	    	/*
	    	 * 扣费
	    	 * 扣减次数
	    	 */
	    	PaymentDao paymentDao = new PaymentDaoImpl();		
	    	List<Payment> list=paymentDao.MoneyandTime((String) my.getValueAt(row, 0));
	    	int money_time = list.get(0).getMoney()/list.get(0).getTimes();
	    	
	    	Payment payment = new Payment();
	    	payment.setName((String) my.getValueAt(row, 0));
	    	payment.setMoney(list.get(0).getMoney()-money_time);
	    	payment.setTimes(list.get(0).getTimes()-1);
	    	paymentDao.ChangeMoneyandTime(payment);
	    	
	    	/*
	    	 * 表格中
	    	 * 界面的次数
	    	 * 相应减一
	    	 */
	    	my.setValueAt(Integer.parseInt(String.valueOf(my.getValueAt(row, 3)))-1, row, 3);
	   
	    	/*
	    	 * 导入明细表
	    	 * 2016/11/8
	    	 */
	  
//			DetailsOfAccount detailsOfAccount = new DetailsOfAccount();
//			DetailOfAccountDao detailOfAccountDao = new DetailOfAccountDaoImpl();
//			detailsOfAccount.setstu_name((String) my.getValueAt(row, 0));
//			detailsOfAccount.setDetails("正常考勤");
//			detailsOfAccount.setMoney((int) my.getValueAt(row, 3));
//			
//			detailOfAccountDao.DetailsAccount(detailsOfAccount);
	    }else if (column>3&&tem.equals("1")) {
	    	/*
	    	 * 楼打卡考勤
	    	 * 加入attendace表
	    	 */
	    	//System.out.println("111");	 
	    	attendance.setStu_name((String) my.getValueAt(row, 0));
	    	attendance.setForget(1);
	    	String year = JpanelFirst.year;
	    	String month =JpanelFirst.month;
	        String day = String.valueOf(column-3);
	        if(day.length()==1){day = "0"+day;}
	        String attendance_date = year+"-"+month+"-"+day;
	    	attendance.setAttendance_date(attendance_date);
	    	attendanceDao.stuAttend(attendance);
	    	
	    	
	    	/*
	    	 * 扣费
	    	 * 扣减次数
	    	 */
	    	PaymentDao paymentDao = new PaymentDaoImpl();		
	    	List<Payment> list=paymentDao.MoneyandTime((String) my.getValueAt(row, 0));
	    	int money_time = list.get(0).getMoney()/list.get(0).getTimes();
	    	
	    	Payment payment = new Payment();
	    	payment.setName((String) my.getValueAt(row, 0));
	    	payment.setMoney(list.get(0).getMoney()-money_time);
	    	payment.setTimes(list.get(0).getTimes()-1);
	    	paymentDao.ChangeMoneyandTime(payment);
	    	my.setValueAt(Integer.parseInt(String.valueOf(my.getValueAt(row, 3)))-1, row, 3);
		    
	    	/*
	    	 * 导入明细表
	    	 * 2016/11/8
	    	 */
	  
//			DetailsOfAccount detailsOfAccount = new DetailsOfAccount();
//			DetailOfAccountDao detailOfAccountDao = new DetailOfAccountDaoImpl();
//			detailsOfAccount.setstu_name((String) my.getValueAt(row, 0));
//			detailsOfAccount.setDetails("漏打卡");
//			detailsOfAccount.setMoney((int) my.getValueAt(row, 3));
//			
//			detailOfAccountDao.DetailsAccount(detailsOfAccount);
			
	    
	    } else {
			
			    if(column>3&&!tem.equals("")){
			    	JOptionPane.showMessageDialog(null,"只能输入0和1", "操作不合法", JOptionPane.ERROR_MESSAGE);	
			    	my.setValueAt("", row, column);
			    	System.out.println("tttt");
			    }
			  				
				}
	    }
	}

	public static class MyTableModel extends AbstractTableModel{

	
	
		
		
		 static String[] columnNames =
			{ "姓名","一健考勤","漏打卡","剩余","1","2","3","4","5",
					"6","7","8","9","10","11","12","13","14","15","16","17",
					"18","19","20","21","22","23","24","25","26","27","28","29",
					"30","31"};
		 static Object[][] data=null; 
		
	    public MyTableModel() {
			// TODO Auto-generated constructor stub
	    	
//	    	从数据库获取所有学生
	    	StudentDao studentDao = new StudentDaoImpl();
			List<Student> listAll ;
	    	listAll=studentDao.nameList();
	    	int number = listAll.size();
	    	
//	    	从数据库读取学生剩余次数
	    	PaymentDao paymentDao = new PaymentDaoImpl();
	    	List<Payment> listPayments;
  	
	    	 data = new Object[number][35];
	    	System.out.println(data.length);
	    	for (int i = 0; i < number; i++) {
				
	    		for (int j = 0; j < 35; j++) {
					
	    			switch (j) {
					case 0:
						data[i][j] = listAll.get(i).getStu_name();
						break;
					case 1:
						data[i][j] = new Boolean(false);
						break;
					case 2:
						data[i][j] = new Boolean(false);
						break;
					case 3:
						String tem_name = listAll.get(i).getStu_name();
						listPayments=paymentDao.MoneyandTime(tem_name);
						data[i][j] = listPayments.get(0).getTimes();						
						break;  
					default:
						data[i][j]="";
						break;
					}
				}
			}
	    
	    	
	    	

	    	
	    	/*
	    	 * 解析attendance
	    	 * 按照年月日放入考勤的Jtable
	    	 * 1、判断界面现在选中的月份和年份
	    	 * 2、从attendance表中读取选中月和年的所有考勤信息（解析数据表中的考勤日期）
	    	 * 3、将得到的数据放入表中
	    	 * 4、注意界面显示正常考勤的话是0，漏打卡的话是1，默认没有考勤是空
	    	 * 11/4
	    	 * jamesLee（目前只是当前月份的测试BUGBUGBUG!!!!!!!!）
	    	 */
//	    	从数据库Attendance表获取考勤数据
	    	AttendanceDao attendanceDao = new AttendanceDaoImpl();
	    	List<Attendance> list = new LinkedList<Attendance>();
	    	list = attendanceDao.Attendance();
	    	int number2 = list.size();
	    	
	    	//这个月份所有考勤信息的条数,一条一条放入Jtable
	    	for (int i = 0; i < number2; i++) {
				
	    		String name = list.get(i).getStu_name();
				String date = list.get(i).getAttendance_date();
				
				List<String> list_date= new ArrayList<>();
				list_date.add(date.substring(0, 4));
				list_date.add(date.substring(5, 7));
				list_date.add(date.substring(8, 10));
				
				String month = list_date.get(1);
				int day = Integer.parseInt(list_date.get(2));
				
				//检索整个Jtable,判断此时表中的学生是否有考勤信息,number 所有学员
				for (int k = 0; k < number; k++) {
					
					if(data[k][0].equals(name)){
						data[k][day+3]=list.get(i).getForget();
						
					}
				}
				
			}
	    	
		}
		
	 // 以下为继承自AbstractTableModle的方法，可以自定义
	 		/**
	 		 * 得到列名
	 		 */
	 		@Override
	 		public String getColumnName(int column)
	 		{
	 			return columnNames[column];
	 		}
	 		
	 		/**
	 		 * 重写方法，得到表格列数
	 		 */
	 		@Override
	 		public int getColumnCount()
	 		{
	 			return columnNames.length;
	 		}

	 		/**
	 		 * 得到表格行数
	 		 */
	 		@Override
	 		public int getRowCount()
	 		{
	 			return data.length;
	 		}

	 		/**
	 		 * 得到数据所对应对象
	 		 */
	 		@Override
	 		public Object getValueAt(int rowIndex, int columnIndex)
	 		{
	 			return data[rowIndex][columnIndex];
	 		}

	 		/**
	 		 * 得到指定列的数据类型
	 		 */
	 		@Override
	 		public Class<?> getColumnClass(int columnIndex)
	 		{
	 			return data[0][columnIndex].getClass();
	 		}

	 		/**
	 		 * 指定设置数据单元是否可编辑.这里设置"姓名","学号"不可编辑
	 		 */
	 		@Override
	 		public boolean isCellEditable(int rowIndex, int columnIndex)
	 		{
	 			if (columnIndex== 0)
	 				return false;
	 			else if(columnIndex == 3)
					return false;
	 			else if(my.getValueAt(rowIndex, 3).equals(0)){
	 				//return false;
	 			   return true;
	 			}
	 			else
	 				return true;
	 		}
	 		
	 		/**
	 		 * 如果数据单元为可编辑，则将编辑后的值替换原来的值
	 		 */
	 		@Override
	 		public void setValueAt(Object aValue, int rowIndex, int columnIndex)
	 		{
	 			data[rowIndex][columnIndex] = aValue;
	 			/*通知监听器数据单元数据已经改变*/
	 			fireTableCellUpdated(rowIndex, columnIndex);
	 		}

	 		/*
	 		 * remove 
	 		 * 
	 		 */
	 
		
	}

	
	
}
