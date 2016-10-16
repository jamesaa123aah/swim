package com.swimming.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.nio.channels.NonWritableChannelException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTree;
/*
 * 考勤系统主界面Ui
 * 布局分为3块，分别为：
 * 上部、中左、中右
 */
import javax.swing.SpringLayout.Constraints;
import javax.swing.WindowConstants;
import javax.swing.tree.DefaultMutableTreeNode;
public class UiMain extends JFrame{

	Container container = getContentPane();
	public UiMain() {
		// TODO Auto-generated constructor stub
		
		
		
		/*
		 * 主界面主要分为四个部分
		 * 第一部分：
		 * 菜单
		 * 另外三个部分分别是三个面板
		 * 三块固定面板的创建
		 */
		
//		在主界面设置菜单栏
		MenuA menuA = new MenuA();
		this.setJMenuBar(menuA.jMenuBar);

		
		
//		返回第一个面板到主界面
		JpanelFirst jpanelFirst = new JpanelFirst();
		JPanel jPanel1 = jpanelFirst.getJPanel();
				
//		返回第二个面板到主界面
		JPanelSecond jPanelSecond= new JPanelSecond();
		JPanel jPanel2 = jPanelSecond.getJPanelSecond();
				
//		返回第三个面板到主界面
		JPanleThird jPanleThird = new JPanleThird();
		JPanel jPanel3 = jPanleThird.getJpanelThird();
		
				
		
		/*
		 * 分割面板的创建
		 */
		
		//创建一个垂直的分割面板.
		final JSplitPane vSplitPane=new JSplitPane(JSplitPane.VERTICAL_SPLIT);

		//分割条上方的高度为30像素.
		vSplitPane.setDividerLocation(100);

		//定义分割条宽度.
		vSplitPane.setDividerSize(10);

		//在调整分割条位置时面板的重绘方式为连续绘制.
		vSplitPane.setContinuousLayout(true);
		
		container.add(vSplitPane,BorderLayout.CENTER);
		
		//将固定面板添加
		vSplitPane.setLeftComponent(jPanel1);
				
		//创建一个水平分割面板.
		final JSplitPane hSplitPane=new JSplitPane();

		//分隔条左侧的宽度为150像素.
		hSplitPane.setDividerLocation(150);
		
		//添加固定面板
		hSplitPane.setLeftComponent(jPanel2);
		hSplitPane.setRightComponent(jPanel3);
		
		//添加到指定区域.
		vSplitPane.setRightComponent(hSplitPane);
		
				

		/*
		 * 设置主容器的名字、大小，布局。
		 */
		
		setTitle("游泳考勤系统");

		setVisible(true);		

		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
	
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
	}
}
