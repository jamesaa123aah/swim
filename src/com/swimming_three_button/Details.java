package com.swimming_three_button;

import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Details extends JDialog {

	JLabel jLabel = new JLabel("ѡ��ѧԱ��");
	JComboBox jComboBox = new JComboBox();
	JButton jButton = new JButton("�鿴");
	public Details() {
		
		// TODO Auto-generated constructor stub
    Container container = getContentPane();
	
        jComboBox.addItem("����");	
        jComboBox.addItem("����");	
        jComboBox.addItem("������");
    
        container.add(jLabel);
        container.add(jComboBox);
		container.add(jButton);
		container.add(getJpanelThird2());
		
		
		setDefaultCloseOperation(2);
		setTitle("��ϸ��");		
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
		
		String [] columnNames= {" �� �� ","ʱ      ��","��ϸ","ʣ����"};
		
//		��������������
		String [][] tableValues =new String[40][4];
		
		for (int i = 0; i < 39; i++) {
			for (int j = 0; j <1; j++) {
				tableValues[i][0]="����";
				tableValues[i][1]="2016-8-21 18:21";
				if(i%5==4)
				tableValues[i][2]="+340.00";
				else if (i%5==1) {
					tableValues[i][2]="+640.00";
				}
				else{
				tableValues[i][2]="-40.00";
				}
				
				tableValues[i][3] ="---";
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
