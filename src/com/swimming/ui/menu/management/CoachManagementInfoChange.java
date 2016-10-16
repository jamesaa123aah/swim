package com.swimming.ui.menu.management;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CoachManagementInfoChange extends JDialog{

	JLabel jLabel_name = new JLabel("姓名：");
	JComboBox jComboBox_name = new JComboBox<>();
	
	JLabel jLabel_id = new JLabel("教练号：");
	JComboBox jComboBox_id = new JComboBox<>();
	
	JLabel jLabel_name1 = new JLabel("姓名：");
	JTextField jTextField_name = new JTextField("张三");
	
	JLabel jLabel_sex1 = new JLabel("性别：");
	String array_sex[] = {"男","女"};
	JComboBox jComboBox_sex2 = new JComboBox<>(array_sex);
	
	JLabel jLabel_birhdate1 = new JLabel("出生年月：");
	JComboBox jComboBox_birthdate = new JComboBox<>();
	
	JLabel jLabel_phone1 = new JLabel("电话：");
	JTextField jTextField_phone2 = new JTextField("13456789648");
	
	
	JLabel jLabel_remark1 = new JLabel("备注：");
	JTextArea jTextArea_remark2 = new JTextArea(60, 75);
	
	JButton jButton = new JButton("确认修改") ;
	public CoachManagementInfoChange() {
		// TODO Auto-generated constructor stub
		
  
		setLayout(new GridBagLayout());
		Container container = getContentPane();
		
		GridBagConstraints gridBagConstraints_0 = new GridBagConstraints();	
		gridBagConstraints_0.gridy = 0;
		gridBagConstraints_0.gridx=0;
		gridBagConstraints_0.insets = new Insets(0, 0, 0, 0);
		gridBagConstraints_0.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_name,gridBagConstraints_0);
		
		GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.gridy = 0;
		gridBagConstraints_1.gridx = 1;
		gridBagConstraints_1.insets = new Insets(0, 0, 0, 0);
		gridBagConstraints_1.weightx = 30;
		gridBagConstraints_1.fill = GridBagConstraints.HORIZONTAL;
		container.add(jComboBox_name,gridBagConstraints_1);
		
		GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.gridy=0;
		gridBagConstraints_2.gridx=2;
		gridBagConstraints_2.insets = new Insets(0, 60, 0, 0);
		gridBagConstraints_2.fill=GridBagConstraints.HORIZONTAL;
		container.add(jLabel_id,gridBagConstraints_2);
		
		
		GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		gridBagConstraints_3.gridy=0;
		gridBagConstraints_3.gridx=3;
		gridBagConstraints_3.insets = new Insets(0, 0, 0, 0);
		gridBagConstraints_3.weightx=30;
		gridBagConstraints_3.fill = GridBagConstraints.HORIZONTAL; 
		container.add(jComboBox_id,gridBagConstraints_3);
		
		GridBagConstraints gridBagConstraints_33 = new GridBagConstraints();
		gridBagConstraints_33.gridy=1;
		gridBagConstraints_33.gridx=0;
		gridBagConstraints_33.insets = new Insets(60, 0, 0, 0);
		gridBagConstraints_33.fill = GridBagConstraints.HORIZONTAL; 
		container.add(jLabel_name1,gridBagConstraints_33);
		
		GridBagConstraints gridBagConstraints_333 = new GridBagConstraints();
		gridBagConstraints_333.gridy=1;
		gridBagConstraints_333.gridx=1;
		gridBagConstraints_333.insets = new Insets(60, 0, 0, 0);
		gridBagConstraints_333.fill = GridBagConstraints.HORIZONTAL; 
		container.add(jTextField_name,gridBagConstraints_333);
		
		GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
		gridBagConstraints_4.gridy=1;
		gridBagConstraints_4.gridx=2;
		gridBagConstraints_4.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_4.insets = new Insets(60, 60, 0, 0);
		container.add(jLabel_sex1, gridBagConstraints_4);
		
		GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
		gridBagConstraints_5.gridy=1;
		gridBagConstraints_5.gridx=3;
		gridBagConstraints_5.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_5.insets = new Insets(60, 0, 0, 0);
		container.add(jComboBox_sex2, gridBagConstraints_5);
		
		GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.gridy=2;
		gridBagConstraints_6.gridx=0;
		gridBagConstraints_6.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints_6.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_birhdate1, gridBagConstraints_6);
		
		GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();
		gridBagConstraints_7.gridy=2;
		gridBagConstraints_7.gridx=1;
		gridBagConstraints_7.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_7.insets = new Insets(10, 0, 0, 0);
		container.add(jComboBox_birthdate, gridBagConstraints_7);
		
		GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();
		gridBagConstraints_8.gridy=2;
		gridBagConstraints_8.gridx=2;
		gridBagConstraints_8.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_8.insets = new Insets(30, 60, 0, 0);
		container.add(jLabel_phone1, gridBagConstraints_8);
		
		GridBagConstraints gridBagConstraints_9 = new GridBagConstraints();
		gridBagConstraints_9.gridy=2;
		gridBagConstraints_9.gridx=3;
		gridBagConstraints_9.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_9.insets = new Insets(30, 0, 0, 0);
		container.add(jTextField_phone2, gridBagConstraints_9);
		
		GridBagConstraints gridBagConstraints_18 = new GridBagConstraints();
		gridBagConstraints_18.gridy=5;
		gridBagConstraints_18.gridx=0;
		gridBagConstraints_18.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_18.insets = new Insets(30, 0, 0, 0);
		container.add(jLabel_remark1, gridBagConstraints_18);
		
		GridBagConstraints gridBagConstraints_19 = new GridBagConstraints();
		gridBagConstraints_19.gridy=5;
		gridBagConstraints_19.gridx=1;
		gridBagConstraints_19.ipady=150;
		gridBagConstraints_19.ipadx=150;
		gridBagConstraints_19.fill = GridBagConstraints.BOTH;
		gridBagConstraints_19.insets = new Insets(30, 0, 0, 0);
		container.add(jTextArea_remark2, gridBagConstraints_19);
		
		GridBagConstraints gridBagConstraints_20 = new GridBagConstraints();
		gridBagConstraints_20.gridy=6;
		gridBagConstraints_20.gridx=3;
		gridBagConstraints_19.weighty=30;
		gridBagConstraints_20.fill = GridBagConstraints.HORIZONTAL;
		container.add(jButton,gridBagConstraints_20);
		
//		设置窗口
		setSize(500, 450);
		setTitle("教练员信息修改");
		//setResizable(false);
		setModal(true);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);// 窗口居中
	}
}
