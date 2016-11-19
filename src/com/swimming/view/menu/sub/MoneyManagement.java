package com.swimming.view.menu.sub;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.xml.soap.Detail;

import com.swimming.dao.DetailOfAccountDao;
import com.swimming.dao.PaymentDao;
import com.swimming.dao.Impl.DetailOfAccountDaoImpl;
import com.swimming.dao.Impl.PaymentDaoImpl;
import com.swimming.model.DetailsOfAccount;
import com.swimming.model.Payment;
import com.swimming.view.panel.JPanelSecond;
import com.swimming.view.panel.JPanleThird;

public class MoneyManagement extends JDialog{

	JLabel jLabel_name = new JLabel("������");
	JLabel jLabel_money1 = new JLabel("���(RMB):");
	JLabel jLabel_money1_show = new JLabel("   ");
	JLabel jLabel_times1 = new JLabel("����:");
	JLabel jLabel_time1_show = new JLabel("  ");
	
	JLabel jLabel_money = new JLabel("���(RMB):");
	JLabel jLabel_times = new JLabel("����:");
	
//	combobox����
	String arry_times[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17"
			,"18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37",
			"38","39","40","41","42","43","44","45","46","47","48","49","50"};
	
	
	
	JTextField jTextField_money = new JTextField(10);
	JComboBox jComboBox_times = new JComboBox<>(arry_times);
	JTextField jTextField_name = new JTextField();
	
	JButton jButton_search = new JButton("�鿴");
	JButton jButton_confirm = new JButton("ȷ�Ͻɷ�");
	
	public MoneyManagement() {
		// TODO Auto-generated constructor stub
		
//		������������
		jLabel_name.setSize(40, 30);
		jLabel_name.setLocation(5, 5);
		add(jLabel_name);
//		jComboBox_name.setSize(100, 20);
//		jComboBox_name.setLocation(45, 10);
//		add(jComboBox_name);
		
		jTextField_name.setSize(100, 20);
		jTextField_name.setLocation(45, 10);
		/*
		 * 11/17
		 * ѡ��ѧԱ
		 * ���нɷ�
		 */
		if(JPanleThird.table.getSelectedRow()>=0)
		jTextField_name.setText((String) JPanleThird.my.getValueAt(JPanleThird.table.getSelectedRow(), 0));
		
		add(jTextField_name);
		
		
		jButton_search.setSize(90, 25);
		jButton_search.setLocation(180, 5);
		add(jButton_search);
	
	
		
		
//      �鿴��ǰ�����
		jLabel_money1.setSize(80,30);
		jLabel_money1.setLocation(5, 50);
		add(jLabel_money1);
		jLabel_money1_show.setSize(100, 20);
		jLabel_money1_show.setLocation(70, 55);
		add(jLabel_money1_show);
		
//		�鿴��ǰ�Ĵ���
		jLabel_times1.setSize(70,30);
		jLabel_times1.setLocation(180, 50);
		add(jLabel_times1);
		jLabel_time1_show.setSize(100, 20);
		jLabel_time1_show.setLocation(215, 55);
		add(jLabel_time1_show);
		
//		�ɷѶ���(RMB)
		jLabel_money.setSize(75, 30);
		jLabel_money.setLocation(5, 95);
		add(jLabel_money);
		jTextField_money.setSize(60, 20);
		jTextField_money.setLocation(80, 100);
		add(jTextField_money);
		
//		��Ӧ�����ۺ϶��ٴ�
		jLabel_times.setSize(40, 30);
		jLabel_times.setLocation(180, 95);
		add(jLabel_times);
		jComboBox_times.setSize(100, 20);
		jComboBox_times.setLocation(220, 100);
		add(jComboBox_times);
		
//		ȷ�ϽɷѰ�ť
		jButton_confirm.setSize(100, 30);
		jButton_confirm.setLocation(150, 180);
		
		add(jButton_confirm);
		

		/*
		 * �س���
		 * ������¼
		 * 11/16
		 */
		this.getRootPane().setDefaultButton(jButton_search);
		
		
		jButton_search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("hah");
				
				List<Payment> list = new LinkedList<>();
				
				PaymentDao paymentDao = new PaymentDaoImpl();
				
				Payment payment = new Payment();
				payment.setName(jTextField_name.getText());
				
				
				list = paymentDao.MoneyandTime(payment.getName());
				
				jLabel_money1_show.setText(String.valueOf(list.get(0).getMoney()));
				jLabel_time1_show.setText(String.valueOf(list.get(0).getTimes()));
				
				
			}
		});
		
		jButton_confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Payment payment = new Payment();
				
//				���ӳ�ֵ��Ǯ
				payment.setMoney(Integer.parseInt(jTextField_money.getText())+Integer.parseInt(jLabel_money1_show.getText()));
				payment.setTimes(Integer.parseInt((String)jComboBox_times.getSelectedItem())+Integer.parseInt(jLabel_time1_show.getText()));
				payment.setName(jTextField_name.getText());
//				����account_info
				PaymentDao paymentDao = new PaymentDaoImpl();				
				paymentDao.ChangeMoneyandTime(payment);
				
//				����account_detail
				DetailsOfAccount detailsOfAccount = new DetailsOfAccount();
				
				detailsOfAccount.setstu_name(jTextField_name.getText());
				detailsOfAccount.setMoney(Integer.parseInt(jTextField_money.getText())+Integer.parseInt(jLabel_money1_show.getText()));
				detailsOfAccount.setTimes(Integer.parseInt((String)jComboBox_times.getSelectedItem())+Integer.parseInt(jLabel_time1_show.getText()));
				detailsOfAccount.setDetails("+"+jTextField_money.getText());
				
				
				DetailOfAccountDao detailOfAccountDao = new DetailOfAccountDaoImpl();
				
				detailOfAccountDao.DetailsAccount(detailsOfAccount);
				JOptionPane.showMessageDialog(null,"�ɷѳɹ�", "�ɹ�", JOptionPane.INFORMATION_MESSAGE);	
				
				JPanleThird.queryClass(JPanelSecond.select_classname);
				dispose();
				
			}
			
		});
		
		setDefaultCloseOperation(2);
		setTitle("�ɷ�");		
        //setLayout(new FlowLayout(1,5,30));// ���ò�����ʽ����
		setLayout(null);
	    setModal(true);
		setSize(400,300);		
		setLocationRelativeTo(null);// ���ھ���

	}
}
