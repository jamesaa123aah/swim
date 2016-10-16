package com.swimming.ui.menu.management;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StudentManagementIncrease extends JDialog{

	/*
	 * 新增学员界面
	 * 控件的初始化
	 */
	JLabel jLabel_adJust = new JLabel("     ");
	JLabel jLabel_adJust2 = new JLabel("                 ");
	
	JLabel jLabel_name = new JLabel("姓名：");
	JTextField jTextField_name = new JTextField(8);
	
		
	JLabel jLabel_sex = new JLabel("性别：");
	JComboBox jComboBox_sex = new JComboBox();
	
		
	JLabel jLabel_birth_date = new JLabel("出生日期: ");
	String array_date[] = {"1995-08-05"};
	JComboBox jComboBox_birth_date = new JComboBox<>(array_date);
	
		
	JLabel jLabel_school = new JLabel("学校：");
	JTextField jTextField_school = new JTextField(10);
	
	
	JLabel jLabel_phone = new JLabel("电话：");
	JTextField jTextField_phone = new JTextField(8);
	
	
	JLabel jLabel_class = new JLabel("班级：");
	String array_class[] = {"恐龙班","初级班班","高级班"};
	JComboBox jComboBox_class = new JComboBox<>(array_class);
	
	
	JPanel jPanel_remark = new JPanel();
	JLabel jLabel_remark = new JLabel("备注：");
	JTextArea jTextArea_remark =new JTextArea("", 13, 20);
	
	JButton jButton_confirm = new JButton("确认增加");
	
	
	
	public StudentManagementIncrease() {
		// TODO Auto-generated constructor stub
		
//		增加姓名输入框
		add(jLabel_name);
		add(jTextField_name);	
		add(jLabel_adJust2);
	
		
		
		
//		增加性别选择框
		add(jLabel_sex);
		add(jComboBox_sex);
		jComboBox_sex.addItem("男");
		jComboBox_sex.addItem("女");
		
//		增加出生年月框
		add(jLabel_adJust);
		add(jLabel_birth_date);
		add(jComboBox_birth_date);
		
//		增加学校输入框
		add(jLabel_school);
		add(jTextField_school);
		
//		增加电话输入框
		add(jLabel_phone);
		add(jTextField_phone);
		
//		增加班级选择框
		add(jLabel_class);
		add(jComboBox_class);
		
//		增加备注框
		jPanel_remark.add(jLabel_remark);
		jPanel_remark.add(new JScrollPane(jTextArea_remark));		
		add(jPanel_remark);
		
		add(new JLabel("                                   "));
		add(jButton_confirm);
		
	
		
		
		//setResizable(false);
		setDefaultCloseOperation(2);
		setResizable(false);
		setTitle("新增学员");		
        setLayout(new FlowLayout(0,10,20));// 设置布局流式布局
	    setModal(true);
		setSize(370,500);		
		setLocationRelativeTo(null);// 窗口居中
	}
}
