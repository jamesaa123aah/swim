package com.swimming.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.net.ssl.SSLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class JPanelSecond {

	/*
	 * ������
	 */
	
	public JPanel getJPanelSecond() {
		// TODO Auto-generated constructor stub
	
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("�ְ����");
		//����һ���ӽڵ�
		DefaultMutableTreeNode nodeFirst = new DefaultMutableTreeNode("����ѧԱ",false);
		root.add(nodeFirst);
		//����һ���ӽڵ�
		DefaultMutableTreeNode nodeSecond = new DefaultMutableTreeNode("������",false);
		root.add(nodeSecond);
		
		root.add(new DefaultMutableTreeNode("���ϰ�"));
		
		JTree treeRoot = new JTree(root);
		
//		treeRoot �Ҽ��˵��¼�
		MouseListener ml = new MouseAdapter()
		{
		     public void mousePressed(MouseEvent e) 
		     {
		         int selRow = treeRoot.getRowForLocation(e.getX(), e.getY());
		         TreePath selPath = treeRoot.getPathForLocation(e.getX(), e.getY());
		         
		             if(e.getClickCount() == 2) 
		             {
		            		for (int i = 0; i < 100; i++)
		            		{
								if (selRow == i)
								{
									JOptionPane.showMessageDialog(null, i, "alert", JOptionPane.ERROR_MESSAGE); 
								}
		            		}
		             }
		            
		         
		
			         
		     }
		 };
		 treeRoot.addMouseListener(ml);
		
		
		
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new FlowLayout(0));
		jPanel.add(treeRoot);
		return  jPanel;
	}
}
