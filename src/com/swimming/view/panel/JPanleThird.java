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

	 
//	 ��ʵ�����ģʽ
	 private JPanleThird(){
		 my = new MyTableModel();
		 table = new JTable(my);
	 }
		 
	 public static JPanel getInstance() {
		
		 if(jPanel==null){
			 
			 jPanelThird = new JPanleThird();
			 jPanel = new JPanel();
		 }
		 

//			�����������ݼ���  ����������󡣡���
			my.addTableModelListener(jPanelThird);
			table = new JTable(my);
			
//			���ñ�Ŀ�
			table.getColumnModel().getColumn(2).setPreferredWidth(130);
			table.getColumnModel().getColumn(1).setPreferredWidth(150);
			table.getColumnModel().getColumn(0).setPreferredWidth(150);
			table.getColumnModel().getColumn(3).setPreferredWidth(80);
			
		    JScrollPane sp=new JScrollPane(table);
		    sp.setPreferredSize(new Dimension(1200, 800));
			
			jPanel.add(sp);
			
		return jPanel;
		
	}
	

	
//	 ��ʱ����Ҫ��׽�¼���ֱ��ɨ��table�Ϳ���
	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub

		
			
		/*
		 * ÿ��ѧԱ�ĵ��ο���
		 * �ֶ�����
		 * �����������������0
		 * �����©������1
		 * �����ݴ��뿼�ڱ�\
		 * ע��Ŀǰֻ��ʵ�ֵ��յĿ��ڣ����ղ��ܴ�������Ŀ���
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
			    	JOptionPane.showMessageDialog(null,"ֻ������0��1", "�������Ϸ�", JOptionPane.INFORMATION_MESSAGE);	
			    	my.setValueAt("", row, column);
			    	System.out.println("tttt");
			    }
			  				
				}
	    
	}

	public class MyTableModel extends AbstractTableModel{

	

		
		
		String[] columnNames =
			{ "����","һ������","©��","ʣ��","1","2","3","4","5",
					"6","7","8","9","10","11","12","13","14","15","16","17",
					"18","19","20","21","22","23","24","25","26","27","28","29",
					"30","31"};
		Object[][] data; 
		
	    public MyTableModel() {
			// TODO Auto-generated constructor stub
	    	
//	    	�����ݿ��ȡ����ѧ��
	    	StudentDao studentDao = new StudentDaoImpl();
			List<Student> listAll ;
	    	listAll=studentDao.allStudent();
	    	int number = listAll.size();
	    	
//	    	�����ݿ��ȡѧ��ʣ�����
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
	    	 * ����attendance
	    	 * ���������շ��뿼�ڵ�Jtable
	    	 * 1���жϽ�������ѡ�е��·ݺ����
	    	 * 2����attendance���ж�ȡѡ���º�������п�����Ϣ���������ݱ��еĿ������ڣ�
	    	 * 3�����õ������ݷ������
	    	 * 4��ע�������ʾ�������ڵĻ���0��©�򿨵Ļ���1��Ĭ��û�п����ǿ�
	    	 * 11/4
	    	 * jamesLee��Ŀǰֻ�ǵ�ǰ�·ݵĲ���BUGBUGBUG!!!!!!!!��
	    	 */
//	    	�����ݿ�Attendance���ȡ��������
	    	AttendanceDao attendanceDao = new AttendanceDaoImpl();
	    	List<Attendance> list = new LinkedList<Attendance>();
	    	list = attendanceDao.Attendance();
	    	int number2 = list.size();
	    	
	    	//����·����п�����Ϣ������,һ��һ������Jtable
	    	for (int i = 0; i < number2; i++) {
				
	    		String name = list.get(i).getStu_name();
				String date = list.get(i).getAttendance_date();
				
				List<String> list_date= new ArrayList<>();
				list_date.add(date.substring(0, 4));
				list_date.add(date.substring(5, 7));
				list_date.add(date.substring(8, 10));
				
				String month = list_date.get(1);
				int day = Integer.parseInt(list_date.get(2));
				
				//��������Jtable,�жϴ�ʱ���е�ѧ���Ƿ��п�����Ϣ,number ����ѧԱ
				for (int k = 0; k < number; k++) {
					
					if(data[k][0].equals(name)){
						data[k][day+3]=list.get(i).getForget();
						
					}
				}
				
			}
	    	
		}
		
	 // ����Ϊ�̳���AbstractTableModle�ķ����������Զ���
	 		/**
	 		 * �õ�����
	 		 */
	 		@Override
	 		public String getColumnName(int column)
	 		{
	 			return columnNames[column];
	 		}
	 		
	 		/**
	 		 * ��д�������õ��������
	 		 */
	 		@Override
	 		public int getColumnCount()
	 		{
	 			return columnNames.length;
	 		}

	 		/**
	 		 * �õ��������
	 		 */
	 		@Override
	 		public int getRowCount()
	 		{
	 			return data.length;
	 		}

	 		/**
	 		 * �õ���������Ӧ����
	 		 */
	 		@Override
	 		public Object getValueAt(int rowIndex, int columnIndex)
	 		{
	 			return data[rowIndex][columnIndex];
	 		}

	 		/**
	 		 * �õ�ָ���е���������
	 		 */
	 		@Override
	 		public Class<?> getColumnClass(int columnIndex)
	 		{
	 			return data[0][columnIndex].getClass();
	 		}

	 		/**
	 		 * ָ���������ݵ�Ԫ�Ƿ�ɱ༭.��������"����","ѧ��"���ɱ༭
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
	 		 * ������ݵ�ԪΪ�ɱ༭���򽫱༭���ֵ�滻ԭ����ֵ
	 		 */
	 		@Override
	 		public void setValueAt(Object aValue, int rowIndex, int columnIndex)
	 		{
	 			data[rowIndex][columnIndex] = aValue;
	 			/*֪ͨ���������ݵ�Ԫ�����Ѿ��ı�*/
	 			fireTableCellUpdated(rowIndex, columnIndex);
	 		}

		
	}

	
}
