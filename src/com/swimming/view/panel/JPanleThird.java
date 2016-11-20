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
import javax.swing.text.html.HTML.Tag;

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

	public static Boolean tag=false;
	/*
	 * ��ѯ���Ӧ�༶��ѧ��
	 */
	public static void queryClass(String Classname){
		tag=true;
//		���ݿ��ж�ȡѧ������
		 StudentDao studentdao=new StudentDaoImpl();
		 List<Student> slist=studentdao.coursenameList(Classname);
		 
//	    	�����ݿ��ȡѧ��ʣ�����
	    	PaymentDao paymentDao = new PaymentDaoImpl();
	    	List<Payment> listPayments;
	    	

		 int rownumber=defaultTableModel.getRowCount();
		 for(int k=rownumber;k>=0;k--){
			 if(k==0)
				 break;
			 else
				 defaultTableModel.removeRow(k-1);
		 }
		 
		 for(int i=0;i<slist.size();i++){
			 
			 Object[] data = new Object[35];
			 data[0]=slist.get(i).getStu_name();
			 for(int j = 0;j<35;j++){
				 data[j]=" ";
			 }
			 defaultTableModel.addRow(data);
		 }
		 
		 for (int i = 0; i < slist.size(); i++) {
				
	    		for (int j = 0; j < 35; j++) {
					
	    			switch (j) {
					case 0:
						defaultTableModel.setValueAt(slist.get(i).getStu_name(), i, j);
						break;
					case 1:
						defaultTableModel.setValueAt(false, i, j);
						break;
					case 2:
						defaultTableModel.setValueAt(false,i, j);
						break;
					case 3:
						String tem_name = slist.get(i).getStu_name();
						listPayments=paymentDao.MoneyandTime(tem_name);
						/*
						 * ����0
						 * �ᴥ��Ƿ���¼�
						 * 
						 */
//						if (listPayments.get(0).getTimes()==0) {
//							defaultTableModel.setValueAt(-1, i, j);
//						}else {
						System.out.println("hhhhhh");
							defaultTableModel.setValueAt(listPayments.get(0).getTimes(), i, j);
//						}
						
						//data[i][j] = listPayments.get(0).getTimes();						
						break;  
					default:
						defaultTableModel.setValueAt("",i, j);
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
	    	 * 11/19
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
				
				/*
				 * ���ڽ���
				 */
				List<String> list_date= new ArrayList<>();
				list_date.add(date.substring(0, 4));
				list_date.add(date.substring(5, 7));
				list_date.add(date.substring(8, 10));
				
				String year = list_date.get(0);
				String month = list_date.get(1);
				if (month.length()==1) {
					month="0"+month;
				}
				int day = Integer.parseInt(list_date.get(2));
				
				/*
				 * �ж��Ƿ���ѡ�е���
				 */
				if(year.equals(JpanelFirst.year)){
				/*
				 * �ж��Ƿ���
				 * ѡ�еĿ����·�
				 */
				if (month.equals(JpanelFirst.month)) {
					//��������Jtable,�жϴ�ʱ���е�ѧ���Ƿ��п�����Ϣ,number ����ѧԱ
					for (int k = 0; k < slist.size(); k++) {
						
						if(defaultTableModel.getValueAt(k, 0).equals(name)){
							//data[k][day+3]=list.get(i).getForget();
//							����set ,����tag = true;
							
							defaultTableModel.setValueAt(list.get(i).getForget(), k, day+3);
						
						
						}
					}
				}
				}
		
				
			}
	
//	    	�����������
	tag=false;
	}
	
//	 my is abstract tablemodel
	 public  static  MyTableModel my =null; 
	 public static JTable table =null;
	 private static JPanleThird jPanelThird = null;
	 public static JPanel jPanel = null;
	 public static DefaultTableModel defaultTableModel=null;
	 
	// public static String[] columnNames;
	// public static Object[][] data;
//	 ��ʵ�����ģʽ
	 private JPanleThird(){
		 my = new MyTableModel();
		 table = new JTable(my);
		 defaultTableModel =(DefaultTableModel) table.getModel();
		 
		 String[] columnNames =
				{ "����","һ������","©��","ʣ��","1","2","3","4","5",
				"6","7","8","9","10","11","12","13","14","15","16","17",
				"18","19","20","21","22","23","24","25","26","27","28","29",
				"30","31"};
		 
		 for(int i =0;i<columnNames.length;i++){
	    		defaultTableModel.addColumn(columnNames[i]);
	    }
		 
		 
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
		    sp.setPreferredSize(new Dimension(1200, 560));
			
			jPanel.add(sp);
			
		return jPanel;
		
	}
	

	
//	 ��ʱ����Ҫ��׽�¼���ֱ��ɨ��table�Ϳ���
	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub

		if(tag==false){
		
			
		/*
		 * ÿ��ѧԱ�ĵ��ο���
		 * �ֶ�����
		 * �����������������0
		 * �����©������1
		 * �����ݴ��뿼�ڱ�\
		 
		 * 
		 * 2��ע�⻹Ҫ�۷�
		 * 3����Ҫд����ϸ����
		 */
		
		AttendanceDao attendanceDao = new AttendanceDaoImpl();
		Attendance attendance = new Attendance();
		
		
		
		
		int row = e.getFirstRow();
	    int column = e.getColumn();
	
	    
	    if(row>=0 && column>=0){
		int n;
		
		/*
		 * �ж��Ƿ����©��
		 * 11/8
		 */
		if(column!=3){
			String name =(String) my.getValueAt(row,0);
			List<Attendance> list_clear=attendanceDao.forgetAttendance();
            int size = list_clear.size();
            for (int i = 0; i <size; i++) {
				
            	if (list_clear.get(i).getStu_name().equals(name)) {
            		n=JOptionPane.showConfirmDialog(null, "�Ƿ��Ƴ�©��","���",JOptionPane.YES_NO_OPTION);
            		if(n==0){
            			attendanceDao.setForgetToAttendance(list_clear.get(i).getAttendance_number());
            		}
            		
				}
			}

			
			
		
			
		}
	
	  	
	   
	   
		if(column==1 && my.getValueAt(row, 3).equals(0)){
			/*
			 *  ��һ�����㲻��һ������
			 *  ֻ����ͨ����
			 */
			if(my.getValueAt(row, 1).equals(true)){
				JOptionPane.showMessageDialog(null,"���㣬����һ������,��ȡ����", "����", JOptionPane.INFORMATION_MESSAGE);	

			}
			
		}else if(column!=1&&column!=2&&column!=3&&my.getValueAt(row, 3).equals(0)){
	    	/*
	    	 * �ڶ����Ժ�����
	    	 * ������������
	    	 */
	    	JOptionPane.showMessageDialog(null,"���㣬������޸�ѧԱ��Ϣ��", "����", JOptionPane.INFORMATION_MESSAGE);	
	    	
	    	if(column>3){
	    	//my.setValueAt(-1, row, 3);
	    	//my.setValueAt("", row, column);
	    	
	    	/*
	    	 * û��Ǯ��Ҳ����
	    	 * ���Ƿ��úʹ���û�취�۵�
	    	 * ��Ҫ�ֶ��޸�ѧԱ��Ϣ
	    	 * 11/18
	    	 */
	    	
	    	
//	    	��ȡ�û������ֵ
	    	String tem =my.getValueAt(row, column).toString();
	   
/*
 * ��������
 * ���뿼�ڱ�
 */
	    if(column>3&&tem.equals("0")){
	    //	System.out.println("0000");	 
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
//	    	 * �۷�
//	    	 * �ۼ�����
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
	    	 * �����
	    	 * ����Ĵ���
	    	 * ��Ӧ��һ
	    	 */
	    	my.setValueAt(Integer.parseInt(String.valueOf(my.getValueAt(row, 3)))-1, row, 3);
	   
	    	/*
	    	 * ������ϸ��
	    	 * 2016/11/8
	    	 */
	  
//			DetailsOfAccount detailsOfAccount = new DetailsOfAccount();
//			DetailOfAccountDao detailOfAccountDao = new DetailOfAccountDaoImpl();
//			detailsOfAccount.setstu_name((String) my.getValueAt(row, 0));
//			detailsOfAccount.setDetails("��������");
//			detailsOfAccount.setMoney((int) my.getValueAt(row, 3));
//			
//			detailOfAccountDao.DetailsAccount(detailsOfAccount);
	    }else if (column>3&&tem.equals("1")) {
	    	/*
	    	 * ¥�򿨿���
	    	 * ����attendace��
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
//	    	 * �۷�
//	    	 * �ۼ�����
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
	    	 * ������ϸ��
	    	 * 2016/11/8
	    	 */
	  
//			DetailsOfAccount detailsOfAccount = new DetailsOfAccount();
//			DetailOfAccountDao detailOfAccountDao = new DetailOfAccountDaoImpl();
//			detailsOfAccount.setstu_name((String) my.getValueAt(row, 0));
//			detailsOfAccount.setDetails("©��");
//			detailsOfAccount.setMoney((int) my.getValueAt(row, 3));
//			
//			detailOfAccountDao.DetailsAccount(detailsOfAccount);
			
	    
	    } else {
			
			    if(column>3&&!tem.equals("")){
			    	JOptionPane.showMessageDialog(null,"ֻ������0��1", "�������Ϸ�", JOptionPane.INFORMATION_MESSAGE);	
			    	my.setValueAt("", row, column);
			    	//System.out.println("tttt");
			    }
			  				
				}
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	/*
	    	 * ��û��Ǯ�������
	    	 * ����
	    	 */
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	}
	    	
	    }else{
	   
//	    	��ȡ�û������ֵ
	    	String tem =my.getValueAt(row, column).toString();
	   
/*
 * ��������
 * ���뿼�ڱ�
 */
	    if(column>3&&tem.equals("0")){
	    	//System.out.println("0000");	 
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
	    	 * �۷�
	    	 * �ۼ�����
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
	    	 * �����
	    	 * ����Ĵ���
	    	 * ��Ӧ��һ
	    	 */
	    	my.setValueAt(Integer.parseInt(String.valueOf(my.getValueAt(row, 3)))-1, row, 3);
	    	//my.setValueAt(String.valueOf(Integer.parseInt(String.valueOf(my.getValueAt(row, 3)))-1), row, 3);
	    	/*
	    	 * ������ϸ��
	    	 * 2016/11/8
	    	 */
	  
//			DetailsOfAccount detailsOfAccount = new DetailsOfAccount();
//			DetailOfAccountDao detailOfAccountDao = new DetailOfAccountDaoImpl();
//			detailsOfAccount.setstu_name((String) my.getValueAt(row, 0));
//			detailsOfAccount.setDetails("��������");
//			detailsOfAccount.setMoney((int) my.getValueAt(row, 3));
//			
//			detailOfAccountDao.DetailsAccount(detailsOfAccount);
	    }else if (column>3&&tem.equals("1")) {
	    	/*
	    	 * ¥�򿨿���
	    	 * ����attendace��
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
	    	 * �۷�
	    	 * �ۼ�����
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
	    	 * ������ϸ��
	    	 * 2016/11/8
	    	 */
	  
//			DetailsOfAccount detailsOfAccount = new DetailsOfAccount();
//			DetailOfAccountDao detailOfAccountDao = new DetailOfAccountDaoImpl();
//			detailsOfAccount.setstu_name((String) my.getValueAt(row, 0));
//			detailsOfAccount.setDetails("©��");
//			detailsOfAccount.setMoney((int) my.getValueAt(row, 3));
//			
//			detailOfAccountDao.DetailsAccount(detailsOfAccount);
			
	    
	    } else {
			
			    if(column>3&&!tem.equals("")){
			    	JOptionPane.showMessageDialog(null,"ֻ������0��1", "�������Ϸ�", JOptionPane.ERROR_MESSAGE);	
			    	my.setValueAt("", row, column);
			    //	System.out.println("tttt");
			    }
			  				
				}
	    }
	    
	}
	}
	}

	public static class MyTableModel extends DefaultTableModel{

	
	
		
		
//		 static String[] columnNames =
//			{ "����","һ������","©��","ʣ��","1","2","3","4","5",
//					"6","7","8","9","10","11","12","13","14","15","16","17",
//					"18","19","20","21","22","23","24","25","26","27","28","29",
//					"30","31"};
//		 static Object[][] data=null; 
//		
//	    public MyTableModel() {
//			// TODO Auto-generated constructor stub
//	    	
////	    	�����ݿ��ȡ����ѧ��
//	    	StudentDao studentDao = new StudentDaoImpl();
//			List<Student> listAll ;
//	    	listAll=studentDao.nameList();
//	    	int number = listAll.size();
//	    	
////	    	�����ݿ��ȡѧ��ʣ�����
//	    	PaymentDao paymentDao = new PaymentDaoImpl();
//	    	List<Payment> listPayments;
//  	
//	    	 data = new Object[number][35];
//	    //	System.out.println(data.length);
//	    	for (int i = 0; i < number; i++) {
//				
//	    		for (int j = 0; j < 35; j++) {
//					
//	    			switch (j) {
//					case 0:
//						data[i][j] = listAll.get(i).getStu_name();
//						break;
//					case 1:
//						data[i][j] = new Boolean(false);
//						break;
//					case 2:
//						data[i][j] = new Boolean(false);
//						break;
//					case 3:
//						String tem_name = listAll.get(i).getStu_name();
//						listPayments=paymentDao.MoneyandTime(tem_name);
//					//	data[i][j] = listPayments.get(0).getTimes();						
//						break;  
//					default:
//						data[i][j]="";
//						break;
//					}
//				}
//			}
//	    
//	    	
//	    	
//
//	    	
//	    	/*
//	    	 * ����attendance
//	    	 * ���������շ��뿼�ڵ�Jtable
//	    	 * 1���жϽ�������ѡ�е��·ݺ����
//	    	 * 2����attendance���ж�ȡѡ���º�������п�����Ϣ���������ݱ��еĿ������ڣ�
//	    	 * 3�����õ������ݷ������
//	    	 * 4��ע�������ʾ�������ڵĻ���0��©�򿨵Ļ���1��Ĭ��û�п����ǿ�
//	    	 * 11/4
//	    	 * jamesLee��Ŀǰֻ�ǵ�ǰ�·ݵĲ���BUGBUGBUG!!!!!!!!��
//	    	 */
////	    	�����ݿ�Attendance���ȡ��������
//	    	AttendanceDao attendanceDao = new AttendanceDaoImpl();
//	    	List<Attendance> list = new LinkedList<Attendance>();
//	    	list = attendanceDao.Attendance();
//	    	int number2 = list.size();
//	    	
//	    	//����·����п�����Ϣ������,һ��һ������Jtable
//	    	for (int i = 0; i < number2; i++) {
//				
//	    		String name = list.get(i).getStu_name();
//				String date = list.get(i).getAttendance_date();
//				
//				/*
//				 * ���ڽ���
//				 */
//				List<String> list_date= new ArrayList<>();
//				list_date.add(date.substring(0, 4));
//				list_date.add(date.substring(5, 7));
//				list_date.add(date.substring(8, 10));
//				
//				String year = list_date.get(0);
//				String month = list_date.get(1);
//				int day = Integer.parseInt(list_date.get(2));
//				
//				//��������Jtable,�жϴ�ʱ���е�ѧ���Ƿ��п�����Ϣ,number ����ѧԱ
//				for (int k = 0; k < number; k++) {
//					
//					if(data[k][0].equals(name)){
//						data[k][day+3]=list.get(i).getForget();
//						
//					}
//				}
//				
//			}
//	    	
//		}
		
	    public Class getColumnClass(int c) {
	        return getValueAt(0, c).getClass();
	}

	 
		
	}

	
	
}
