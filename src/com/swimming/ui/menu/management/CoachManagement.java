package com.swimming.ui.menu.management;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class CoachManagement extends JDialog {

	JButton jButton1 = new JButton("��������Ա");
	JButton jButton2 = new JButton("ɾ������Ա");
	JButton jButton3 = new JButton("�޸Ľ���Ա��Ϣ");
	JButton jButton4 = new JButton("�鿴����Ա��Ϣ");
	
	
	
	public CoachManagement() {
		
		// TODO Auto-generated constructor stub
		
		
		
		add(jButton1);
		add(jButton3);
		add(jButton2);	
		add(jButton4);
				
//		��������Ա
		jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				CoachManagementIncrease coachManagementIncrease = new CoachManagementIncrease();
				coachManagementIncrease.setVisible(true);
				dispose();
			}
		});
		
//		����Աɾ��
		jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				CoachManagementDelete coachManagementDelete = new CoachManagementDelete();
				coachManagementDelete.setVisible(true);
				dispose();
			}
		});
		
//		�޸Ľ���Ա��Ϣ
		jButton3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CoachManagementInfoChange coachManagementInfoChange = new CoachManagementInfoChange();
				coachManagementInfoChange.setVisible(true);
				dispose();
			}
		});
		
//		�鿴����Ա��Ϣ
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
		setTitle("����Ա����");		
        setLayout(new FlowLayout(1,20,30));// ���ò�����ʽ����
	    setModal(true);
		setSize(300,200);		
		setLocationRelativeTo(null);// ���ھ���
	}
}