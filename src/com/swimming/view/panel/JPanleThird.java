package com.swimming.view.panel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class JPanleThird  {


	
	public JPanel getJpanelThird() {
	
		
		/*
		 * ���������������
		 */
		
		String [] columnNames= {"����","��","©��","1","2","3","4","5",
				"6","7","8","9","10","11","12","13","14","15","16","17",
				"18","19","20","21","22","23","24","25","26","27","28","29",
				"30","31"};
		
//		��������������
		String [][] tableValues =new String[120][35];
		
		for (int i = 0; i < 111; i++) {
			for (int j = 0; j <34; j++) {
				if(j == 0){
					if(i%2==0){
						tableValues[i][j]="����";
					}
					else{
						tableValues[i][j]="������";
					}
					
				}
				
				else if(j == 1){
					
					if(i%3==0){
						tableValues[i][j]="5";
					}
					else if(i%3==1){
						tableValues[i][j]="11";
					}
					else{
						tableValues[i][j]="8";
					}
					
				}
				

				else if(j == 2){
					
					tableValues[i][j]="������©��";
				}
				
				else{	
					if(j%5==4 || j%5==2){
					tableValues[i][j]="1";
					}
					else if(i%2==1&& j%5==3){	
						tableValues[i][j]="0";
					}
				}
				
			}
		}

		
//		�����������ݼ���
		JTable table = new JTable(tableValues,columnNames);
		
		int columncount = table.getColumnCount();
		
		
//          ���ñ����
		        for (int i = 0; i < columncount; i++) {

		          table.getColumnModel().getColumn(i).setPreferredWidth(33);

		        }
		        
		        table.getColumnModel().getColumn(2).setPreferredWidth(60);
		        table.getColumnModel().getColumn(1).setPreferredWidth(60);
		        table.getColumnModel().getColumn(0).setPreferredWidth(60);

		

		
		//JScrollPane scrollPane = new JScrollPane(table);
		
	    JScrollPane sp=new JScrollPane(table);
	    sp.setPreferredSize(new Dimension(1200, 800));
		JPanel jPanel = new JPanel();
		jPanel.add(sp);	
		
		return jPanel;
		
	}
}
