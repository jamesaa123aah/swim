package com.swimming.ui.menu.management;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Recovery extends JDialog {

	JLabel jLabel_date = new JLabel("ѡ��ָ��������ڣ���");
	JComboBox jComboBox_date = new JComboBox();
	
	JButton jButton = new JButton("�ָ���������");
	
	public Recovery() {
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
		gridBagConstraints_2.gridy=1;
		gridBagConstraints_2.gridx=0;
		gridBagConstraints_2.insets = new Insets(10,0, 0, 0);
		gridBagConstraints_2.fill = GridBagConstraints.HORIZONTAL;
		container.add(jButton,gridBagConstraints_2);
		
		
		setTitle("�ָ�");
		setSize(350,150);
		setModal(true);				
	    setLocationRelativeTo(null);// ���ھ���
	}
}
