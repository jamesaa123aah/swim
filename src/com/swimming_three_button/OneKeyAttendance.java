package com.swimming_three_button;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class OneKeyAttendance extends JDialog {

	JButton jButton = new JButton("ȷ��һ������");
	
	public OneKeyAttendance() {
		// TODO Auto-generated constructor stub
		
		Container container = getContentPane();
		
		container.add(jButton);
		container.add(getJpanelThird2());
		
		
		setDefaultCloseOperation(2);
		setTitle("һ������");		
        setLayout(new FlowLayout(2,10,20));// ���ò�����ʽ����
	    setModal(true);
		setSize(540,350);		
		setLocationRelativeTo(null);// ���ھ���
	}
	

//	�������
	public JPanel getJpanelThird2() {
	
		
		/*
		 * ���������������
		 */
		
		String [] columnNames= {" �� �� ","ʱ      ��","�� ��"};
		
//		��������������
		String [][] tableValues =new String[40][3];
		
		for (int i = 0; i < 39; i++) {
			for (int j = 0; j <1; j++) {
				tableValues[i][0]="��һ��";
				tableValues[i][1]="2016-8-21 18:21";
				tableValues[i][2]="��ɾ����";
			}
		}
		
//		�����������ݼ���
		JTable table = new JTable(tableValues,columnNames);
		
		int columncount = table.getColumnCount();
		
		
//          ���ñ����
		        for (int i = 0; i < columncount; i++) {

		          table.getColumnModel().getColumn(i).setPreferredWidth(80);

		        }

		
		//JScrollPane scrollPane = new JScrollPane(table);
		
	    JScrollPane sp=new JScrollPane(table);
	    sp.setPreferredSize(new Dimension(499, 249));
		JPanel jPanel = new JPanel();
		jPanel.add(sp);	
		
		return jPanel;
		
	}
}
