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
import javax.swing.table.TableCellRenderer;

import com.swimming.dao.AttendanceDao;
import com.swimming.dao.PaymentDao;
import com.swimming.dao.StudentDao;
import com.swimming.dao.Impl.AttendanceDaoImpl;
import com.swimming.dao.Impl.PaymentDaoImpl;
import com.swimming.dao.Impl.StudentDaoImpl;
import com.swimming.model.Attendance;
import com.swimming.model.Payment;
import com.swimming.model.Student;

public class JPanleThird  implements TableModelListener{


//	 my is abstract tablemodel
	 static public MyTableModel my =null; 
	 static JTable table =null;
	 private static JPanleThird jPanelThird = null;
	 private static JPanel jPanel = null;

	 
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
		    sp.setPreferredSize(new Dimension(1200, 800));
			
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
		 * 注意目前只有实现单日的考勤，单日不能打其他天的考勤
		 * (BUGBUGBUG!!!!!!!!!!!!!!!!)
		 */
		
		AttendanceDao attendanceDao = new AttendanceDaoImpl();
		Attendance attendance = new Attendance();
		
		int row = e.getFirstRow();
	    int column = e.getColumn();
	  	   
	   String tem =my.getValueAt(row, column).toString();
	   
	    if(column>3&&tem.equals("0")){
	    	System.out.println("0000");	 
	    	attendance.setStu_name((String) my.getValueAt(row, 0));
	    	attendance.setForget(0);
	    	attendanceDao.stuAttend(attendance);
	    	
	    }else if (column>3&&tem.equals("1")) {
	    	System.out.println("111");	 
	    	attendance.setStu_name((String) my.getValueAt(row, 0));
	    	attendance.setForget(1);
	    	attendanceDao.stuAttend(attendance);
		} else {
			
			    if(column>3&&!tem.equals("")){
			    	JOptionPane.showMessageDialog(null,"只能输入0和1", "操作不合法", JOptionPane.INFORMATION_MESSAGE);	
			    	my.setValueAt("", row, column);
			    	System.out.println("tttt");
			    }
			  				
				}
	    
	}

	public class MyTableModel extends AbstractTableModel{

	

		
		
		String[] columnNames =
			{ "姓名","一健考勤","漏打卡","剩余","1","2","3","4","5",
					"6","7","8","9","10","11","12","13","14","15","16","17",
					"18","19","20","21","22","23","24","25","26","27","28","29",
					"30","31"};
		Object[][] data; 
		
	    public MyTableModel() {
			// TODO Auto-generated constructor stub
	    	
//	    	从数据库获取所有学生
	    	StudentDao studentDao = new StudentDaoImpl();
			List<Student> listAll ;
	    	listAll=studentDao.allStudent();
	    	int number = listAll.size();
	    	
//	    	从数据库读取学生剩余次数
	    	PaymentDao paymentDao = new PaymentDaoImpl();
	    	List<Payment> listPayments;
  	
	    	
	    	data= new Object[number][35];
	    	
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

		
	}

	
}
