package com.swimming.view.menu.sub;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.swimming.dao.StudentDao;
import com.swimming.dao.Impl.StudentDaoImpl;
import com.swimming.model.Student;

public class StudentManagementIncrease extends JDialog{

	
	
	
	/*
	 * ����ѧԱ����
	 * �ؼ��ĳ�ʼ��
	 */
	JLabel jLabel_adJust = new JLabel("     ");
	JLabel jLabel_adJust2 = new JLabel("                 ");
	
	JLabel jLabel_name = new JLabel("������");
	JTextField jTextField_name = new JTextField(8);
	
		
	JLabel jLabel_sex = new JLabel("�Ա�");
	JComboBox jComboBox_sex = new JComboBox();
	
		
	JLabel jLabel_birth_date = new JLabel("��������: ");	
	String array_date[] = {"1995-08-05"};
	JComboBox jComboBox_birth_date = new JComboBox<>(array_date);
	
		
	JLabel jLabel_school = new JLabel("ѧУ��");
	JTextField jTextField_school = new JTextField(10);
	
	
	JLabel jLabel_phone = new JLabel("�绰��");
	JTextField jTextField_phone = new JTextField(8);
	
	
	JLabel jLabel_class = new JLabel("�༶��");
	String array_class[] = {"������","�������","�߼���"};
	JComboBox jComboBox_class = new JComboBox<>(array_class);
	JTextField jTextField_class = new JTextField("������༶����");
	
	JPanel jPanel_remark = new JPanel();
	JLabel jLabel_remark = new JLabel("��ע��");
	JTextArea jTextArea_remark =new JTextArea("", 13, 20);
	
	JButton jButton_confirm = new JButton("ȷ������");
	
	
	
	public StudentManagementIncrease() {
		// TODO Auto-generated constructor stub
		
//		�������������
		add(jLabel_name);
		add(jTextField_name);	
		add(jLabel_adJust2);
	
		
		
		
//		�����Ա�ѡ���
		add(jLabel_sex);
		add(jComboBox_sex);
		jComboBox_sex.addItem("��");
		jComboBox_sex.addItem("Ů");
		
//		���ӳ������¿�
		add(jLabel_adJust);
		add(jLabel_birth_date);
		add(jComboBox_birth_date);
		
//		����ѧУ�����
		add(jLabel_school);
		add(jTextField_school);
		
//		���ӵ绰�����
		add(jLabel_phone);
		add(jTextField_phone);
		
//		���Ӱ༶ѡ���
		add(jLabel_class);
		//add(jComboBox_class);
		add(jTextField_class);
		
//		���ӱ�ע��
		jPanel_remark.add(jLabel_remark);
		jPanel_remark.add(new JScrollPane(jTextArea_remark));		
		add(jPanel_remark);
		
		add(new JLabel("                                   "));
		add(jButton_confirm);
		
	
		
//		ȷ�ϰ�ť��Ӧ
  jButton_confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

//				���Ը��ݴ˷�����ȡһ��list(���ӵ�ѧԱ��Ϣ)
				List list_stu = getStudentInfo();
				
				Student stu=new Student();
				stu.setClass_name(jTextField_class.getText());
				stu.setStu_name(jTextField_name.getText());
				stu.setStu_sex((String) jComboBox_sex.getSelectedItem());
				stu.setStu_school(jTextField_school.getText());
				stu.setStu_phone(jTextField_phone.getText());
				stu.setStu_birthDate((String) jComboBox_birth_date.getSelectedItem());
				stu.setStu_remark(jTextArea_remark.getText());
				
				
				StudentDao studentDao=new StudentDaoImpl();
				studentDao.addStu(stu);
				
				dispose();
			}
		});
		
		
		
		//setResizable(false);
		setDefaultCloseOperation(2);
		setResizable(false);
		setTitle("����ѧԱ");		
        setLayout(new FlowLayout(0,10,20));// ���ò�����ʽ����
	    setModal(true);
		setSize(370,500);		
		setLocationRelativeTo(null);// ���ھ���
	}
	
	/*
	 * �������ѧԱ���ݽ��з�װ
	 * ����һ��list
	 * ����̨
	 */
private List getStudentInfo() {
		
		
	List<String> list_stu = new LinkedList<String>();

	System.out.println("����ѧԱ");
				
				
				
				//list_stu.add();
				list_stu.add(jTextField_name.getText());
				list_stu.add((String)jComboBox_sex.getSelectedItem());
				list_stu.add(jTextField_school.getText());
				list_stu.add(jTextField_phone.getText());
				list_stu.add((String) jComboBox_birth_date.getSelectedItem());
				list_stu.add(jTextArea_remark.getText());
				
				
//				����Ĳ���
//				Iterator iterator = list_stu.iterator();
//				while (iterator.hasNext()) {
//					System.out.println(iterator.next());
//				}
					
				
		
		
		return list_stu;
	}
}
