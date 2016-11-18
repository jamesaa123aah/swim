package com.swimming.view.menu;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import com.*;
import com.swimming.dao.AttendanceDao;
import com.swimming.dao.DetailOfAccountDao;
import com.swimming.dao.PaymentDao;
import com.swimming.dao.Impl.AttendanceDaoImpl;
import com.swimming.dao.Impl.DetailOfAccountDaoImpl;
import com.swimming.dao.Impl.PaymentDaoImpl;
import com.swimming.model.Attendance;
import com.swimming.model.DetailsOfAccount;
import com.swimming.model.Payment;
import com.swimming.model.Student;
import com.swimming.view.panel.JPanleThird;
import com.swimming.view.panel.JpanelFirst;

public class OneKeyAttendance extends JDialog  implements TableModelListener{

	JButton jButton1 = new JButton("查看");
	JButton jButton = new JButton("确认一健考勤");
	static MyTableModelOnekey myTableModelOnekey = null;
	JTable table = null;
	
	public OneKeyAttendance() {
		// TODO Auto-generated constructor stub
		myTableModelOnekey = new MyTableModelOnekey();
		myTableModelOnekey.addTableModelListener(this);
		table = new JTable(myTableModelOnekey);
		
		
		
		
		Container container = getContentPane();
		
		container.add(jButton1);
		container.add(jButton);
		container.add(getJpanelThird2());
		
//		查看按钮响应事件
		jButton1.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int m  = 0;
				for (int i = 0; i <JPanleThird.my.getRowCount(); i++) {
					
//					判断考勤
					if((Boolean)JPanleThird.my.getValueAt(i, 1)==true){
						myTableModelOnekey.setValueAt(JPanleThird.my.getValueAt(i, 0), m, 0);
						
//						判断是否漏打卡
				    if((Boolean)JPanleThird.my.getValueAt(i, 2)==true){
							myTableModelOnekey.setValueAt("漏", m, 2);
						}
						
				    m++;
					}
							
					 
				}
				
				
				
				
			}
		});
		
//		确认一健考勤按钮响应,将数据加入attendance
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				for (int i = 0; i < JPanleThird.my.getRowCount(); i++) {
					JPanleThird.my.setValueAt(false, i, 1);
					JPanleThird.my.setValueAt(false, i, 2);
				}
				
			
                 Attendance attendance ;
                 AttendanceDao attendanceDao;
                 
                 
                 for (int i = 0; i < myTableModelOnekey.getRowCount(); i++) {
                	 
                	
                	 
//                	 判断是否从一键考勤表里移除数据了
                	 if((boolean)myTableModelOnekey.getValueAt(i, 1)==false){
                   	 
                		 attendance = new Attendance();
                    	 attendanceDao= new AttendanceDaoImpl();
                		
                    	 attendance.setStu_name((String) myTableModelOnekey.getValueAt(i, 0));              	 
//                    	 set漏打卡
                    	 if (myTableModelOnekey.getValueAt(i, 2)=="漏") {
                    		 attendance.setForget(1);
                    		 Date date = new Date();
                 			String nowTime1 = new SimpleDateFormat("yyyy-MM-dd").format(date);
                    		 attendance.setAttendance_date(nowTime1);
                    		 
                    		DetailsOfAccount detailsOfAccount = new DetailsOfAccount();
                  			DetailOfAccountDao detailOfAccountDao = new DetailOfAccountDaoImpl();
                  			detailsOfAccount.setstu_name((String) myTableModelOnekey.getValueAt(i, 0));
                  			detailsOfAccount.setDetails("漏打卡");
                  			
                  			int rownumber=JPanleThird.my.getRowCount();
                  			int times=0;
                  			for(int j=0;j<rownumber;j++){
                  				
                  				if(JPanleThird.my.getValueAt(j, 0)==myTableModelOnekey.getValueAt(i, 0)){	            
                  					times=(int) JPanleThird.my.getValueAt(j,3);
                  					detailsOfAccount.setMoney(times-1);
                  					
                  					/*
                  					 * 11/18不要求考勤导入明细
                  					 */
                  					//detailOfAccountDao.DetailsAccount(detailsOfAccount);
                  					
                  					
                  					PaymentDao paymentDao = new PaymentDaoImpl();		
                  			    	List<Payment> list=paymentDao.MoneyandTime((String)myTableModelOnekey.getValueAt(i, 0));
                  			    	int money_time = list.get(0).getMoney()/list.get(0).getTimes();
                  			    	
                  			    	Payment payment = new Payment();
                  			    	payment.setName((String)myTableModelOnekey.getValueAt(i, 0));
                  			    	payment.setMoney(list.get(0).getMoney()-money_time);
                  			    	payment.setTimes(list.get(0).getTimes()-1);
                  			    	paymentDao.ChangeMoneyandTime(payment);
                  			    	
                  			    	
                  			    	JPanleThird.my.setValueAt(Integer.parseInt(String.valueOf(JPanleThird.my.getValueAt(j, 3)))-1, j, 3);
                  				}
                  				
                  			}
                  			
    					}else {
    						attendance.setForget(0);
    						Date date = new Date();
                  			String nowTime1 = new SimpleDateFormat("yyyy-MM-dd").format(date);
                     		attendance.setAttendance_date(nowTime1);
                     		 
                     		DetailsOfAccount detailsOfAccount = new DetailsOfAccount();
                   			DetailOfAccountDao detailOfAccountDao = new DetailOfAccountDaoImpl();
                   			detailsOfAccount.setstu_name((String) myTableModelOnekey.getValueAt(i, 0));
                   			detailsOfAccount.setDetails("正常考勤");
                   			
                   			int rownumber=JPanleThird.my.getRowCount();
                   			int times=0;
                   			for(int j=0;j<rownumber;j++){
                   				
                   				if(JPanleThird.my.getValueAt(j, 0)==myTableModelOnekey.getValueAt(i, 0)){	            
                   					times=(int) JPanleThird.my.getValueAt(j,3);
                   					detailsOfAccount.setMoney(times-1);
                   					
                   					//detailOfAccountDao.DetailsAccount(detailsOfAccount);
                   					
                   					
                   					PaymentDao paymentDao = new PaymentDaoImpl();		
                   			    	List<Payment> list=paymentDao.MoneyandTime((String)myTableModelOnekey.getValueAt(i, 0));
                   			    	int money_time = list.get(0).getMoney()/list.get(0).getTimes();
                   			    	
                   			    	Payment payment = new Payment();
                   			    	payment.setName((String)myTableModelOnekey.getValueAt(i, 0));
                   			    	payment.setMoney(list.get(0).getMoney()-money_time);
                   			    	payment.setTimes(list.get(0).getTimes()-1);
                   			    	paymentDao.ChangeMoneyandTime(payment);
                   			    	
                   			    	
                   			    	JPanleThird.my.setValueAt(Integer.parseInt(String.valueOf(JPanleThird.my.getValueAt(j, 3)))-1, j, 3);
                   				}
                   				
                   			}
    					}
                    	     	 
                    	 
                    	
                    	 attendanceDao.stuAttend(attendance);
                		 
                	 }
                                 
                 
                 }
             	 JOptionPane.showMessageDialog(null,"一健考勤成功", "成功", JOptionPane.INFORMATION_MESSAGE);	
                 dispose();		
			}
						
		});
		
		
		setDefaultCloseOperation(2);
		setTitle("一健考勤");		
        setLayout(new FlowLayout(2,10,20));// 设置布局流式布局
	    setModal(true);
		setSize(540,350);		
		setLocationRelativeTo(null);// 窗口居中
	}
	
	
	
	

//	返回面板
	public JPanel getJpanelThird2() {
	
		
		
		table = new JTable(myTableModelOnekey);
		

		
	    JScrollPane sp=new JScrollPane(table);
	    sp.setPreferredSize(new Dimension(499, 249));
		JPanel jPanel = new JPanel();
		jPanel.add(sp);	
		
		return jPanel;
		
	}







public class MyTableModelOnekey extends AbstractTableModel{

	
	String[] columnNames ={ "姓名","移除","漏打卡"};
	Object[][] data;
	
      public MyTableModelOnekey() {
		// TODO Auto-generated constructor stub
    	  
//    	  动态控制一健考勤表的size
    	  int size = 0; 
    	  for (int i = 0; i <JPanleThird.my.getRowCount();i++) {
    		  if((Boolean)JPanleThird.my.getValueAt(i, 1)==true){
    			  size++;
    		  }
		}
    	 
    	
    	  
    	  
//    	  对选中的同学的checkbox加入一健考勤表
    	  data = new Object[size][3];
    	    	  
    	  for (int i = 0; i < size; i++) {
			
    		  for (int j = 0; j < 3; j++) {
				
    			  switch (j) {
				case 1:
				    Boolean boolean1 = new Boolean(false);
					data[i][j] = boolean1;
                    break;
				default:
					data[i][j]=" ";
					break;
				}
			}
		}
    	  

	}
	
  	/**
		 * 得到列名
		 */
		@Override
		public String getColumnName(int column)
		{
			return columnNames[column];
		}
      
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
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
		
/*删除指定数据
 * jamesLee
 * 11/4
 */
//	public void removeData(int rowNumber) {
//		
//		myTableModelOnekey.removeTableModelListener(table);
//		
//	}
	
	
}







@Override
public void tableChanged(TableModelEvent e) {
	// TODO Auto-generated method stub
	int i;
	for (i = 0; i < myTableModelOnekey.getRowCount(); i++) {
		if((boolean) myTableModelOnekey.getValueAt(i, 1)==true){
			//myTableModelOnekey.remover  //删除行
			//myTableModelOnekey.removeData(i);
		}
	}
	
	
	
}
	
	
}
