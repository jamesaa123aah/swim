package com.swimming.view.menu;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DrainPunch extends JDialog {

	public DrainPunch() {
		// TODO Auto-generated constructor stub
		

		Container container = getContentPane();
		container.add(getJpanelThird2());
		
		
		setDefaultCloseOperation(2);
		setTitle("一健考勤");		
        setLayout(new FlowLayout(2,10,20));// 设置布局流式布局
	    setModal(true);
		setSize(540,350);		
		setLocationRelativeTo(null);// 窗口居中
		
		setDefaultCloseOperation(2);
		setTitle("漏打卡");		
        setLayout(new FlowLayout(0,10,20));// 设置布局流式布局
	    setModal(true);
		setSize(500,350);		
		setLocationRelativeTo(null);// 窗口居中
	}
	
//	返回面板
	public JPanel getJpanelThird2() {
	
		
		/*
		 * 定义表格的列名数组
		 */
		
		String [] columnNames= {" 姓 名 ","时      间","操 作"};
		
//		定义表格数据数组
		String [][] tableValues =new String[40][3];
		
		for (int i = 0; i < 39; i++) {
			for (int j = 0; j <1; j++) {
				tableValues[i][0]="王一飞";
				tableValues[i][1]="2016-8-21 18:21";
				tableValues[i][2]="（删除）";
			}
		}
		
//		把列名和数据加入
		JTable table = new JTable(tableValues,columnNames);
		
		int columncount = table.getColumnCount();
		
		
//          设置表格宽度
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
