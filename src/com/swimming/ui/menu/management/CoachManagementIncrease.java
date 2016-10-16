package com.swimming.ui.menu.management;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CoachManagementIncrease extends JDialog {

	JLabel jLabel_name = new JLabel("姓名：");
	JTextField jTextField_name = new JTextField(8);
	
	JLabel jLabel_sex = new JLabel("性别：");
	String array_sex[] = {"男","女"};
	JComboBox jComboBox_sex = new JComboBox(array_sex);
	
	JLabel jLabel_birth_date = new JLabel("出生日期: ");
	String array_date[] = {"1995-08-05"};
	JComboBox jComboBox_birth_date = new JComboBox<>(array_date);
	
	JLabel jLabel_phone = new JLabel("电话：");
	JTextField jTextField_phone = new JTextField(8);
		
	JLabel jLabel_remark = new JLabel("备注：");
	JTextArea jTextArea_remark = new JTextArea();
	
	JButton jButton_confirm = new JButton("确认增加");
	
	
	
	public CoachManagementIncrease() {
		// TODO Auto-generated constructor stub
		
		
//		增加姓名输入区域
		jLabel_name.setSize(40, 30);
		jLabel_name.setLocation(5, 5);
		add(jLabel_name);
		jTextField_name.setSize(100, 25);
		jTextField_name.setLocation(60, 10);
		add(jTextField_name);
		
//		增加性别选择区域
		jLabel_sex.setSize(40, 25);
		jLabel_sex.setLocation(220, 5);
		add(jLabel_sex);
		jComboBox_sex.setSize(40, 30);
		jComboBox_sex.setLocation(260, 5);
		add(jComboBox_sex);
		
//		增加出生年月
		jLabel_birth_date.setSize(60, 25);
		jLabel_birth_date.setLocation(5, 60);
		add(jLabel_birth_date);
		jComboBox_birth_date.setSize(100, 30);
		jComboBox_birth_date.setLocation(65, 60);
		add(jComboBox_birth_date);
		
//		增加电话输入
		jLabel_phone.setSize(40, 25);
		jLabel_phone.setLocation(220,60);
		add(jLabel_phone);
		jTextField_phone.setSize(100, 25);
		jTextField_phone.setLocation(260, 60);
		add(jTextField_phone);
		
		
//		备注
		jLabel_remark.setSize(40,200);
		jLabel_remark.setLocation(5, 100);
		add(jLabel_remark);
		jTextArea_remark.setSize(300, 200);
		jTextArea_remark.setLocation(45,100);
		jTextArea_remark.setLineWrap(true);
		JScrollPane js=new JScrollPane(jTextArea_remark);
		js.setSize(300, 200);
		js.setLocation(45,100);
		add(js);
		
//		确认按钮
		jButton_confirm.setSize(90,30);
		jButton_confirm.setLocation(160, 320);
		add(jButton_confirm);
		
		
		
		
//		对话框设置
		setResizable(false);
		setDefaultCloseOperation(2);
		setTitle("新增教练员");		
        setLayout(null);// 设置布局
	    setModal(true);
		setSize(400,400);		
		setLocationRelativeTo(null);// 窗口居中
	}
}
