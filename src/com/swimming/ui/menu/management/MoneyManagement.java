package com.swimming.ui.menu.management;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MoneyManagement extends JDialog{

	JLabel jLabel_name = new JLabel("姓名：");
	JLabel jLabel_id = new JLabel("学号：");
	JLabel jLabel_class = new JLabel("班级：");
	JLabel jLabel_money = new JLabel("金额(RMB):");
	JLabel jLabel_times = new JLabel("次数：");
	
//	combobox内容
	String arry_name[]={"王麻子","张三哈哈","李四"};
	String arry_id[]={"000001","000345"};
	String arry_class[]={"王飞教练班","张一山教练班","赵四海教练班"};
	String arry_times[]={"1","2","3","4","5"};
	
	
	JComboBox jComboBox_name = new JComboBox<>(arry_name);
	JComboBox jComboBox_id = new JComboBox<>(arry_id);
	JComboBox jComboBox_class = new JComboBox<>(arry_class);
	JTextField jTextField_money = new JTextField(10);
	JComboBox jComboBox_times = new JComboBox<>(arry_times);
	
	
	JButton jButton_confirm = new JButton("确认缴费");
	
	public MoneyManagement() {
		// TODO Auto-generated constructor stub
		
//		增加姓名输入
		jLabel_name.setSize(40, 30);
		jLabel_name.setLocation(5, 5);
		add(jLabel_name);
		jComboBox_name.setSize(100, 20);
		jComboBox_name.setLocation(45, 10);
		add(jComboBox_name);
	
		
		
//		增加学号植入
		jLabel_id.setSize(40,30);
		jLabel_id.setLocation(180, 5);
		add(jLabel_id);
		jComboBox_id.setSize(100, 20);
		jComboBox_id.setLocation(220, 10);
		add(jComboBox_id);
		
//		增加班级输入
		jLabel_class.setSize(40, 30);
		jLabel_class.setLocation(5, 50);
		add(jLabel_class);
		jComboBox_class.setSize(100, 20);
		jComboBox_class.setLocation(45, 50);
		add(jComboBox_class);
		
//		缴费多少(RMB)
		jLabel_money.setSize(75, 30);
		jLabel_money.setLocation(5, 95);
		add(jLabel_money);
		jTextField_money.setSize(60, 20);
		jTextField_money.setLocation(80, 100);
		add(jTextField_money);
		
//		相应费用折合多少次
		jLabel_times.setSize(40, 30);
		jLabel_times.setLocation(180, 95);
		add(jLabel_times);
		jComboBox_times.setSize(100, 20);
		jComboBox_times.setLocation(220, 100);
		add(jComboBox_times);
		
//		确认缴费按钮
		jButton_confirm.setSize(100, 30);
		jButton_confirm.setLocation(150, 180);
		add(jButton_confirm);
		
		setDefaultCloseOperation(2);
		setTitle("缴费");		
        //setLayout(new FlowLayout(1,5,30));// 设置布局流式布局
		setLayout(null);
	    setModal(true);
		setSize(400,300);		
		setLocationRelativeTo(null);// 窗口居中

	}
}
