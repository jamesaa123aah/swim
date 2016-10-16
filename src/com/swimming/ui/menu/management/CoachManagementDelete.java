package com.swimming.ui.menu.management;

import java.awt.Container;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class CoachManagementDelete extends JDialog {

	
//	姓名区域
	JLabel jLabel_name = new JLabel("姓名：");
	String[] array_name = {"张三教练","李四教练","王麻子教练"};
	JComboBox jComboBox_name = new JComboBox<>(array_name);
	
//	教练员号
	JLabel jLabel_id = new JLabel("教练号：");
	String[] array_id = {"0005","0032","0086"};
	JComboBox jComboBox_id = new JComboBox<>(array_id);
	
	
//	按钮
	JButton jButton_confirm = new JButton("确认删除");
	public CoachManagementDelete() {
		// TODO Auto-generated constructor stub
		

		
		Container container = getContentPane();
		
//		姓名
		jLabel_name.setSize(90, 25);
		jLabel_name.setLocation(25, 10);
		container.add(jLabel_name);
		jComboBox_name.setSize(100, 25);
		jComboBox_name.setLocation(80, 10);
		container.add(jComboBox_name);
		jComboBox_name.setEditable(true);
		
		
//		教练员号
		jLabel_id.setSize(100,30);
		jLabel_id.setLocation(25, 50);
		container.add(jLabel_id);
		jComboBox_id.setSize(100, 25);
		jComboBox_id.setLocation(80,50);
		container.add(jComboBox_id);
		
//		按钮
		jButton_confirm.setSize(100,30);
		jButton_confirm.setLocation(80, 110);
		container.add(jButton_confirm);
		
//		设置窗口
		setSize(250, 220);
		setTitle("教练员删除");
		//setResizable(false);
		setLayout(null);
		setModal(true);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);// 窗口居中
	}
}
