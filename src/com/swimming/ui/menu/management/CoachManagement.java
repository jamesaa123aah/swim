package com.swimming.ui.menu.management;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class CoachManagement extends JDialog {

	JButton jButton1 = new JButton("新增教练员");
	JButton jButton2 = new JButton("删除教练员");
	JButton jButton3 = new JButton("修改教练员信息");
	JButton jButton4 = new JButton("查看教练员信息");
	
	
	
	public CoachManagement() {
		
		// TODO Auto-generated constructor stub
		
		
		
		add(jButton1);
		add(jButton3);
		add(jButton2);	
		add(jButton4);
				
//		新增教练员
		jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				CoachManagementIncrease coachManagementIncrease = new CoachManagementIncrease();
				coachManagementIncrease.setVisible(true);
				dispose();
			}
		});
		
//		教练员删除
		jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				CoachManagementDelete coachManagementDelete = new CoachManagementDelete();
				coachManagementDelete.setVisible(true);
				dispose();
			}
		});
		
//		修改教练员信息
		jButton3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CoachManagementInfoChange coachManagementInfoChange = new CoachManagementInfoChange();
				coachManagementInfoChange.setVisible(true);
				dispose();
			}
		});
		
//		查看教练员信息
		jButton4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CoachManagementInfoLook coachManagementInfoLook = new CoachManagementInfoLook();
				coachManagementInfoLook.setVisible(true);
				dispose();
			}
		});
		
		setDefaultCloseOperation(2);
		setTitle("教练员管理");		
        setLayout(new FlowLayout(1,20,30));// 设置布局流式布局
	    setModal(true);
		setSize(300,200);		
		setLocationRelativeTo(null);// 窗口居中
	}
}
