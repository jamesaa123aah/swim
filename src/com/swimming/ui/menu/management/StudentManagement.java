package com.swimming.ui.menu.management;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class StudentManagement extends JDialog {

	JButton jButton1 = new JButton("新增学员");
	JButton jButton2 = new JButton("删除学员");
	JButton jButton3 = new JButton("修改学员信息");
	JButton jButton4 = new JButton("查看学员信息");
	
	
	
	public StudentManagement() {
		
		// TODO Auto-generated constructor stub
		
		add(jButton1);
		add(jButton3);
		add(jButton2);	
		add(jButton4);
		
//		增加学生按钮
		jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				StudentManagementIncrease studentManagementIncrease = new StudentManagementIncrease();
				studentManagementIncrease.setVisible(true);
				dispose();
				
			}
		});
		
		
//		删除学员按钮
		jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				StudentManagementDelete studentManagementDelete = new StudentManagementDelete();
				studentManagementDelete.setVisible(true);
				dispose();
			}
		});
		
		
		
//		查看学生信息
		jButton4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				StudentManagementInfoLook studentManagementInfoLook = new StudentManagementInfoLook();
				studentManagementInfoLook.setVisible(true);
				dispose();
			}
		});
		
		
//		修改学员信息
		jButton3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				StudentManagementInfochange studentManagementInfochange=new StudentManagementInfochange();
				studentManagementInfochange.setVisible(true);
				dispose();
			}
		});
		
//		设置窗口
		setDefaultCloseOperation(2);
		setTitle("学员管理");		
        setLayout(new FlowLayout(1,20,30));// 设置布局流式布局
	    setModal(true);
		setSize(300,200);		
		setLocationRelativeTo(null);// 窗口居中
	}
}
