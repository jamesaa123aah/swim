package com.swimming.view.menu.sub;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.swimming.dao.CoachDao;
import com.swimming.dao.StudentDao;
import com.swimming.dao.Impl.CoachDaoImpl;
import com.swimming.dao.Impl.StudentDaoImpl;

public class StudentManagementDelete extends JDialog {

//	��������
	JLabel jLabel_name = new JLabel("������");
	String[] array_name = {"����","����","��������"};
	//JComboBox jComboBox_name = new JComboBox<>(array_name);
	JTextField jTextField_name = new JTextField(10);
//	ѧ��
	JLabel jLabel_id = new JLabel("ѧ�ţ�");
	String[] array_id = {"000005","100032","400086"};
	JComboBox jComboBox_id = new JComboBox<>(array_id);
	
	
//	��ť
	JButton jButton_confirm = new JButton("ȷ��ɾ��");
	
	public StudentManagementDelete() {
		// TODO Auto-generated constructor stub
		
//		����
		jLabel_name.setSize(40, 25);
		jLabel_name.setLocation(25, 5);
		add(jLabel_name);
//		jComboBox_name.setSize(100, 25);
//		jComboBox_name.setLocation(80, 10);
		jTextField_name.setSize(100, 25);
		jTextField_name.setLocation(80, 10);
		add(jTextField_name);
//		jComboBox_name.setEditable(true);
		
		
//		ѧ��
		jLabel_id.setSize(40,30);
		jLabel_id.setLocation(25, 50);
		//add(jLabel_id);
		jComboBox_id.setSize(100, 25);
		jComboBox_id.setLocation(80,50);
		//add(jComboBox_id);
		
//		��ť
		jButton_confirm.setSize(100,30);
		jButton_confirm.setLocation(80, 110);
		add(jButton_confirm);
		
		jButton_confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentDao studentDao = new StudentDaoImpl();
				
				System.out.println("1111111");
//				ѧ����ʱ��ʹ��
				studentDao.deleteStu(jTextField_name.getText());
				System.out.println("222222");
				
				dispose();
			}
		});
		
		
//		���ô���
		setSize(250, 220);
		setTitle("ѧԱɾ��");
		setResizable(false);
		setModal(true);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);// ���ھ���
		setLayout(null);
	}
}
