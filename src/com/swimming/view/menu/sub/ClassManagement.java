package com.swimming.view.menu.sub;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class ClassManagement extends JDialog {

	JButton jButton1 = new JButton("�����༶");
	JButton jButton2 = new JButton("ɾ���༶");
	JButton jButton3 = new JButton("�޸İ༶��Ϣ");
	JButton jButton4 = new JButton("�鿴�༶��Ϣ");
	
	
	
	public ClassManagement() {
		// TODO Auto-generated constructor stub
		
		add(jButton1);
		add(jButton3);
		add(jButton2);	
		add(jButton4);
		
		
//		����
		jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			
				ClassManagementIncrese classManagementIncrese = new ClassManagementIncrese();
				classManagementIncrese.setVisible(true);
				dispose();
			}
		});
		

//		ɾ��
		jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ClassManagementDelete classManagementDelete = new ClassManagementDelete();
				classManagementDelete.setVisible(true);
				dispose();
			}
		});
        

//		�޸�
		jButton3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ClassManagementInfoChange classManagementInfoChange = new ClassManagementInfoChange();
				classManagementInfoChange.setVisible(true);
				dispose();
			}
		});
		

//		�鿴
		jButton4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ClassManagementInfoLook classManagementInfoLook = new ClassManagementInfoLook();
				classManagementInfoLook.setVisible(true);
				dispose();
			}
		});

//		����Dialog����
		setDefaultCloseOperation(2);
		setTitle("�༶����");		
        setLayout(new FlowLayout(1,20,30));// ���ò�����ʽ����
	    setModal(true);
		setSize(300,200);		
		setLocationRelativeTo(null);// ���ھ���
	}
}
