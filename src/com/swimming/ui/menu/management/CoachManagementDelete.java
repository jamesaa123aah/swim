package com.swimming.ui.menu.management;

import java.awt.Container;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class CoachManagementDelete extends JDialog {

	
//	��������
	JLabel jLabel_name = new JLabel("������");
	String[] array_name = {"��������","���Ľ���","�����ӽ���"};
	JComboBox jComboBox_name = new JComboBox<>(array_name);
	
//	����Ա��
	JLabel jLabel_id = new JLabel("�����ţ�");
	String[] array_id = {"0005","0032","0086"};
	JComboBox jComboBox_id = new JComboBox<>(array_id);
	
	
//	��ť
	JButton jButton_confirm = new JButton("ȷ��ɾ��");
	public CoachManagementDelete() {
		// TODO Auto-generated constructor stub
		

		
		Container container = getContentPane();
		
//		����
		jLabel_name.setSize(90, 25);
		jLabel_name.setLocation(25, 10);
		container.add(jLabel_name);
		jComboBox_name.setSize(100, 25);
		jComboBox_name.setLocation(80, 10);
		container.add(jComboBox_name);
		jComboBox_name.setEditable(true);
		
		
//		����Ա��
		jLabel_id.setSize(100,30);
		jLabel_id.setLocation(25, 50);
		container.add(jLabel_id);
		jComboBox_id.setSize(100, 25);
		jComboBox_id.setLocation(80,50);
		container.add(jComboBox_id);
		
//		��ť
		jButton_confirm.setSize(100,30);
		jButton_confirm.setLocation(80, 110);
		container.add(jButton_confirm);
		
//		���ô���
		setSize(250, 220);
		setTitle("����Աɾ��");
		//setResizable(false);
		setLayout(null);
		setModal(true);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);// ���ھ���
	}
}
