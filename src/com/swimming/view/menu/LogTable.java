package com.swimming.view.menu;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class LogTable extends JDialog {

	public LogTable () {

		Container container = getContentPane();
		container.add(getJpanelThird2());
		
		
	
		
		setDefaultCloseOperation(2);
		setTitle("��־");		
        setLayout(new FlowLayout(0,10,20));// ���ò�����ʽ����
	    setModal(true);
		setSize(500,350);		
		setLocationRelativeTo(null);// ���ھ���
	}
	
//	�������
	public JPanel getJpanelThird2() {
	
		
		/*
		 * ���������������
		 */
		
		String [] columnNames= {"�� �� ��","ʱ      ��"};
		
//		��������������
		String [][] tableValues =new String[40][2];
		
		for (int i = 0; i < 39; i++) {
			for (int j = 0; j <1; j++) {
				if(i%10==8){
				tableValues[i][0]="XXX�ɷ�--560.00";
				tableValues[i][1]="2016-8-21 15:21";
				}
				else if (i%5==2) {
					tableValues[i][0]="XXXѧԱ����(�뿪)";
					tableValues[i][1]="2016-8-21 11:22";
				}
				else if (i%5==3) {
					tableValues[i][0]="XXX©��";
					tableValues[i][1]="2016-8-21 09:21";
				}else {
					tableValues[i][0]="XXXѧԱ��������";
					tableValues[i][1]="2016-8-21 11:22";
				}
				
			}
		}
		
//		�����������ݼ���
		JTable table = new JTable(tableValues,columnNames);
		
		int columncount = table.getColumnCount();
		
		
//          ���ñ����
		        for (int i = 0; i < columncount; i++) {

		          table.getColumnModel().getColumn(i).setPreferredWidth(80);

		        }

		
	    JScrollPane sp=new JScrollPane(table);
	    sp.setPreferredSize(new Dimension(450, 249));
		JPanel jPanel = new JPanel();
		jPanel.add(sp);	
		
		return jPanel;
		
	}
}
