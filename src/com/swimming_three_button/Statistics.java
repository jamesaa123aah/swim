package com.swimming_three_button;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Statistics extends JDialog {

	JLabel jLabel_date = new JLabel("日期：");
	JComboBox jComboBox_date = new JComboBox();
	
	JLabel jLabel_people = new JLabel("学员数：");
	JTextField jTextField_people = new JTextField("68"); 
	
	JButton jButton_search = new JButton("查看");
	
	
	public Statistics() {
		// TODO Auto-generated constructor stub
		Container container = getContentPane();
		setLayout(new GridBagLayout());	
		
		GridBagConstraints gridBagConstraints_0 = new GridBagConstraints();
		gridBagConstraints_0.gridy=0;
		gridBagConstraints_0.gridx=0;
		gridBagConstraints_0.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints_0.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_date,gridBagConstraints_0);
		
		GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.gridy=0;
		gridBagConstraints_1.gridx=1;
		gridBagConstraints_1.ipadx=80;
		gridBagConstraints_1.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints_1.fill = GridBagConstraints.HORIZONTAL;
		container.add(jComboBox_date,gridBagConstraints_1);
		
		GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.gridy=0;
		gridBagConstraints_2.gridx=2;
		gridBagConstraints_2.insets = new Insets(10,30, 0, 0);
		gridBagConstraints_2.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_people,gridBagConstraints_2);
		
		GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		gridBagConstraints_3.gridy=0;
		gridBagConstraints_3.gridx=3;
		gridBagConstraints_3.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints_3.fill = GridBagConstraints.HORIZONTAL;
		container.add(jTextField_people,gridBagConstraints_3);
		
		GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
		gridBagConstraints_4.gridy=1;
		gridBagConstraints_4.gridx=3;
		gridBagConstraints_4.insets = new Insets(30, 0, 0, 0);
		gridBagConstraints_4.fill = GridBagConstraints.HORIZONTAL;
		container.add(jButton_search,gridBagConstraints_4);
		
		
		setDefaultCloseOperation(2);
		setTitle("统计");		
	    setModal(true);
		setSize(350,200);		
		setLocationRelativeTo(null);// 窗口居中
	}
}
