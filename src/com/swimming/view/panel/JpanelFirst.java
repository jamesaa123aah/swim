package com.swimming.view.panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.swimming.dao.StudentDao;
import com.swimming.dao.Impl.StudentDaoImpl;
import com.swimming.model.Student;
import com.swimming.view.NowTime;
import com.swimming.view.menu.DrainPunch;
import com.swimming.view.menu.OneKeyAttendance;
import com.swimming.view.menu.Statistics;
import com.swimming.view.menu.sub.MoneyManagement;

public class JpanelFirst {
    
	private  JpanelFirst() {
		// TODO Auto-generated constructor stub		
		
	}
	
	private static JpanelFirst jpanelFirst = null;
	
	//static JPanel jPanel = new JPanel(new FlowLayout(0, 10, 5));
	private static JPanel jPanel = null;
	
	
	
//	����ģ�����ҵ������б�
	//static JComboBox jComboBox1 = new JComboBox();
	static JTextField jMistName=new JTextField(8);
	
//	����ģ�����Ұ�ť
	static JButton jButton_Name_finding = new JButton("��������");	
    
//	��ݺ��·ݡ�ѡ��һ�����ڵ�label
	static JLabel jLabel1 = new JLabel("���:");
	static JLabel jLabel2 = new JLabel("�·�:");
	static JLabel jLabel_choose = new JLabel("ѡ��༶��");

//	��ݺ��·�������
	static JComboBox jComboBox2 = new JComboBox(get_year());
	static JComboBox jComboBox3 = new JComboBox(get_month());
	static JComboBox jComboBox_onekey = new JComboBox();

//  ��ǰʱ���Label	 
	static JLabel jLabel_date_title = new JLabel("����ʱ��:");
	static JLabel jLabel_date_year = new JLabel(""+"��");
	static JLabel jLabel_date_month = new JLabel(""+"��");
	static NowTime nowTime = new NowTime();
	static JTextField jTextField_now_time =  nowTime.get_time();
	 

		
//		��ť
	static JButton jButton_onekey = new JButton("һ������");
	static JButton jButton_forget = new JButton("©��");
	static JButton jButton_statistic = new JButton("ͳ��");
	static  JButton jButton_money = new JButton("�ɷ�");
	//static  JButton jButton_add_onekey = new JButton("����һ������");
	static  JButton jButton_choose = new JButton("ѡ��");
		   
		
//	 ����ѡ��
	static   JLabel jLabel4 = new JLabel("����ʽ��");
	static	JRadioButton jRadioButton1 = new JRadioButton("��ƴ������");
	static	JRadioButton jRadioButton2 = new JRadioButton("���������");
	static	ButtonGroup buttonGroup = new ButtonGroup();
		
     
	 /*
	  * ѡ��
	  * �鿴�� year month
	  * Ĭ�ϵ�ǰ��ݺ��·�
	  */
	  
	static Calendar a=Calendar.getInstance();
	
	
	public static String year;
	public static String month;
	 
	/*
	 * ���ص�ǰ����
	 */
	public static void getaa() {
		
		List<String> list = null;
		  System.out.println(a.get(Calendar.YEAR));//�õ���
		  System.out.println(a.get(Calendar.MONTH)+1);//�����·��Ǵ�0��ʼ�����Լ�1
		  System.out.println(a.get(Calendar.DATE));
		  
		  
		 year =String.valueOf(a.get(Calendar.YEAR));
		 month=String.valueOf(a.get(Calendar.MONTH)+1);
		 
	}
	
	
	/*
	 * ���ص�һ�����
	 */
public static JPanel getJPanel() {
	// TODO Auto-generated constructor stub
		
	if(jPanel==null){
		jPanel = new JPanel();
		getaa();
	}
	
	
//	ģ�������м��������ڲ���
//	jComboBox1.addItem("����");
//	jComboBox1.addItem("����");
//	jComboBox1.addItem("������");
	
	
//    ѡ��һ�����ڼ���İ༶
	jComboBox_onekey.addItem("������");
	jComboBox_onekey.addItem("���ϰ�");
	
//	����м��������������·�������
	
	jPanel.add(jLabel1);
	jPanel.add(jComboBox2);
	jPanel.add(jLabel2);
	jPanel.add(jComboBox3);	
	jPanel.add(jButton_choose);
	jPanel.add(new JLabel("            "));
	
	
//	����м���ģ�����ҵ�������
	jPanel.add(jMistName);

//	����м���ģ�����Ұ�ť
	jPanel.add(jButton_Name_finding);
	jPanel.add(new JLabel("                  "));
	
	
	
//	���������������ʽ
	jPanel.add(new JLabel("             "));
	jPanel.add(new JLabel("             "));
	buttonGroup.add(jRadioButton1);
	buttonGroup.add(jRadioButton2);
	jPanel.add(jLabel4);
	
	jPanel.add(jRadioButton1);
	jPanel.add(jRadioButton2);
    jRadioButton1.setSelected(true);
	
    jRadioButton2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			//JPanleThird.my.fireTableDataChanged();
			//JPanleThird.data[][];
			System.out.println("1211");
			
			
		}
	});
	
	//	����һ����ѯ��©�򿨰�ť
	jPanel.add(new JLabel("             "));
//	jPanel.add(jButton1);
//	jPanel.add(jButton2);
//	jPanel.add(jButton3);


//	������м���һ�����ڵİ༶ѡ��
	jPanel.add(new JLabel("             "));
	jPanel.add(new JLabel("             "));
	jPanel.add(new JLabel("             "));
	jPanel.add(jButton_money);
	jPanel.add(jButton_onekey);
	jPanel.add(jButton_statistic);
	
	jPanel.add(new JLabel("             "));
	jPanel.add(jLabel_date_title);
	jPanel.add(jLabel_date_year);
	jPanel.add(jLabel_date_month);

	/*
	 * Ĭ�ϵ�ǰʱ��
	 */
	jLabel_date_year.setText(year+"��");
	jLabel_date_month.setText(month+"��");
	/*
	 * ���ÿ������ڵ�����
	 */
	jLabel_date_title.setFont(new   java.awt.Font("Dialog",   1,   26));	
	jLabel_date_title.setForeground(Color.red);
	jLabel_date_year.setFont(new   java.awt.Font("Dialog",   1,   26));	
	jLabel_date_year.setForeground(Color.red);
	jLabel_date_month.setFont(new   java.awt.Font("Dialog",   1,   26));	
	jLabel_date_month.setForeground(Color.red);
	
//����м��뵱ǰʱ��
//	jPanel.add(new JLabel("                 "));
//	jPanel.add(jLabel3);
//	jPanel.add(jTextField_now_time);
	
//	�ɷѰ�ť
	jButton_money.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			MoneyManagement moneyManagement = new MoneyManagement();
			moneyManagement.setModal(true);
			moneyManagement.setVisible(true);
		}
	});

//	�����·ݵ�ѡ��
	jButton_choose.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			year = String.valueOf(jComboBox2.getSelectedItem()).substring(0, 4);
			month=String.valueOf(jComboBox3.getSelectedItem());
			if (month.length()==1) {
				month = "0"+month;
			}
			System.out.println(month.length());
				
			/*
			 * �����û�ѡ���ʱ��
			 */
			jLabel_date_year.setText(year+"��");
			jLabel_date_month.setText(month+"��");
			
			JPanleThird.queryClass(JPanelSecond.select_classname);
		}
		
		
	});
	
	jButton_onekey.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			OneKeyAttendance oneKeyAttendance = new OneKeyAttendance();
			oneKeyAttendance.setVisible(true);
			
		}
	});
	
	jButton_forget.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			DrainPunch drainPunch = new DrainPunch();
			drainPunch.setVisible(true);
		}
	});
	
	jButton_statistic.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Statistics statistics = new Statistics();
			statistics.setVisible(true);
		}
	});
	
	jButton_Name_finding.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String strName=jMistName.getText();
			StudentDao studentdao=new StudentDaoImpl();
			List<Student> list=studentdao.mistStudent(strName);
			List<Integer> numlist=new LinkedList<Integer>(); 
			String targetName;
			int rownumber=JPanleThird.my.getRowCount();
			for(int i=0;i<rownumber;i++){
				targetName=(String) JPanleThird.my.getValueAt(i, 0);
				for(int j=0;j<list.size();j++){
					if(targetName.equals(list.get(j).getStu_name())){
						numlist.add(i);
					}
				}
			}
			JPanleThird.table.setRowSelectionInterval(numlist.get(0), numlist.get(0));
			for(int i=1;i<numlist.size();i++){
				JPanleThird.table.addRowSelectionInterval(numlist.get(i), numlist.get(i));
			}
			
			//JPanleThird.table.addRowSelectionInterval(2, 3);
			//JPanleThird.table.addRowSelectionInterval(10, 10);
			
		}
	});
	
	return jPanel;
}


/*
 *   �����������·ݵĴ���
 *   ����һ����ݺ��·�����
 *   ���ظ��ϱߵ�combox
 */

private static String[] get_year() {
	// TODO Auto-generated method stub
	String[] arry = new String[201];
    for (int i = 2015; i < 2201; i++) {
        arry[i-2015] = i+"��";
    }
    return arry;
}

private static String[] get_month() {
	// TODO Auto-generated method stub
	String[] arry = new String[12];
    for (int i = 1; i < 13; i++) {
        arry[i-1] = String.valueOf(i);
    }
    return arry;
}

public String year() {
	
	String year = (String) jComboBox2.getSelectedItem();
	return year;
	
}

public String month() {
	
	String month = (String) jComboBox3.getSelectedItem();
	return month;
	
}
}
