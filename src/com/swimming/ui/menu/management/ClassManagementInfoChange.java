package com.swimming.ui.menu.management;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ClassManagementInfoChange extends JDialog {

	JLabel jLabel_className = new JLabel("班级名：");
	JComboBox jComboBox_className = new JComboBox();
	
	JLabel jLabel_classID = new JLabel("班级号：");
	JComboBox jComboBox_classID = new JComboBox();
	
	JLabel jLabel_className2 = new JLabel("班级名：");
	JTextField jTextField_className = new JTextField();
	
	JLabel jLabel_coachName = new JLabel("教练名：");
	JComboBox jComboBox_coachName = new JComboBox();
	
	JLabel jLabel_money = new JLabel("费用(RMB/次):");
	JTextField jTextField_money = new JTextField();
	
	JButton jButton = new JButton("确认新增");
	
	public ClassManagementInfoChange() {
		// TODO Auto-generated constructor stub
		setLayout(new GridBagLayout());		
		Container container = getContentPane();
		
		GridBagConstraints gridBagConstraints_0 = new GridBagConstraints();
		gridBagConstraints_0.gridy=0;
		gridBagConstraints_0.gridx=0;
		gridBagConstraints_0.insets = new Insets(20, 0, 0, 0);
		gridBagConstraints_0.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_className,gridBagConstraints_0);
		
		GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.gridy=0;
		gridBagConstraints_1.gridx=1;
		gridBagConstraints_1.ipadx=100;
		gridBagConstraints_1.insets = new Insets(20, 0, 0, 0);
		gridBagConstraints_1.fill = GridBagConstraints.HORIZONTAL;
		container.add(jComboBox_className,gridBagConstraints_1);
		
		GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.gridy=1;
		gridBagConstraints_2.gridx=0;
		gridBagConstraints_2.insets = new Insets(20, 0, 0, 0);
		gridBagConstraints_2.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_classID,gridBagConstraints_2);
		
		GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		gridBagConstraints_3.gridy=1;
		gridBagConstraints_3.gridx=1;
		gridBagConstraints_3.ipadx=100;
		gridBagConstraints_3.insets = new Insets(20, 0, 0, 0);
		gridBagConstraints_3.fill = GridBagConstraints.HORIZONTAL;
		container.add(jComboBox_classID,gridBagConstraints_3);
		
		GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
		gridBagConstraints_4.gridy=2;
		gridBagConstraints_4.gridx=0;
		gridBagConstraints_4.insets = new Insets(80, 0, 0, 0);
		gridBagConstraints_4.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_className2,gridBagConstraints_4);
		
		GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
		gridBagConstraints_5.gridy=2;
		gridBagConstraints_5.gridx=1;
		gridBagConstraints_5.ipadx=100;
		gridBagConstraints_5.insets = new Insets(80, 0, 0, 0);
		gridBagConstraints_5.fill = GridBagConstraints.HORIZONTAL;
		container.add(jTextField_className,gridBagConstraints_5);
		
		GridBagConstraints gridBagConstraints_55 = new GridBagConstraints();
		gridBagConstraints_55.gridy=4;
		gridBagConstraints_55.gridx=0;
		gridBagConstraints_55.ipadx=100;
		gridBagConstraints_55.insets = new Insets(20, 0, 0, 0);
		gridBagConstraints_55.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_money,gridBagConstraints_55);
		
		GridBagConstraints gridBagConstraints_555 = new GridBagConstraints();
		gridBagConstraints_555.gridy=4;
		gridBagConstraints_555.gridx=1;
		gridBagConstraints_555.ipadx=100;
		gridBagConstraints_555.insets = new Insets(20, 0, 0, 0);
		gridBagConstraints_555.fill = GridBagConstraints.HORIZONTAL;
		container.add(jTextField_money,gridBagConstraints_555);
		
		
		
		GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.gridy=5;
		gridBagConstraints_6.gridx=1;
		gridBagConstraints_6.insets = new Insets(20, 0, 0, 0);
		gridBagConstraints_6.fill = GridBagConstraints.HORIZONTAL;
		container.add(jButton,gridBagConstraints_6);
		
		GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();
		gridBagConstraints_7.gridy=3;
		gridBagConstraints_7.gridx=0;
		gridBagConstraints_7.insets = new Insets(20, 0, 0, 0);
		gridBagConstraints_7.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_coachName,gridBagConstraints_7);
		
		GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();
		gridBagConstraints_8.gridy=3;
		gridBagConstraints_8.gridx=1;
		gridBagConstraints_8.ipadx=100;
		gridBagConstraints_8.insets = new Insets(20, 0, 0, 0);
		gridBagConstraints_8.fill = GridBagConstraints.HORIZONTAL;
		container.add(jComboBox_coachName,gridBagConstraints_8);
		
//		设置窗口
		setSize(400, 400);
		setTitle("班级信息修改");
		//setResizable(false);
		setModal(true);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);// 窗口居中
	}
}
