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
		setTitle("日志");		
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
		
		String [] columnNames= {"操 作 名","时      间"};
		
//		定义表格数据数组
		String [][] tableValues =new String[40][2];
		
		for (int i = 0; i < 39; i++) {
			for (int j = 0; j <1; j++) {
				if(i%10==8){
				tableValues[i][0]="XXX缴费--560.00";
				tableValues[i][1]="2016-8-21 15:21";
				}
				else if (i%5==2) {
					tableValues[i][0]="XXX学员加入(离开)";
					tableValues[i][1]="2016-8-21 11:22";
				}
				else if (i%5==3) {
					tableValues[i][0]="XXX漏打卡";
					tableValues[i][1]="2016-8-21 09:21";
				}else {
					tableValues[i][0]="XXX学员正常考勤";
					tableValues[i][1]="2016-8-21 11:22";
				}
				
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
