package com.swimming.view.panel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

import javax.net.ssl.SSLException;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import com.swimming.dao.CourseDao;
import com.swimming.dao.Impl.CourseDaoImpl;
import com.swimming.model.Course;

public class JPanelSecond  extends JFrame implements MouseListener, ActionListener {

	/*
	 * ������
	 */
	JTree treeRoot;
	JPopupMenu popMenu;  
	JMenuItem addItem; 
	
	 public JPanelSecond() {
		// TODO Auto-generated constructor stub
		// TODO Auto-generated constructor stub
		   DefaultMutableTreeNode root = new DefaultMutableTreeNode("ȫ��ѧԱ");
//			//����һ���ӽڵ�
//			DefaultMutableTreeNode nodeFirst = new DefaultMutableTreeNode("���ϰ�",false);
//			root.add(nodeFirst);
//			 
//			//����һ���ӽڵ�
//			DefaultMutableTreeNode nodeSecond = new DefaultMutableTreeNode("������",false);
//			root.add(nodeSecond);
//			
		
//			���ݿ��ȡ���а༶��Ϣ
			CourseDao courseDao = new CourseDaoImpl();
			List<Course> list=courseDao.allClass();
			
		
			for(int i = 0;i<list.size();i++){
			DefaultMutableTreeNode node1 = new DefaultMutableTreeNode(list.get(i).getClass_name(),false);
			root.add(node1);
			
			}
			
			
			
			treeRoot = new JTree(root);  
	    	treeRoot.setEditable(true);  
	    	treeRoot.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);  
	    	treeRoot.addMouseListener(this);  
	    	treeRoot.setCellEditor(new DefaultTreeCellEditor(treeRoot, new DefaultTreeCellRenderer()));  
	    	
	    	
	    	popMenu = new JPopupMenu();  
	    	addItem = new JMenuItem("���һ������");  
	    	addItem.addActionListener(this);  
	      
	    	
	    	popMenu.add(addItem);  
	    	
	    	
	    	
	}
	
	public JPanel getJPanelSecond() {
		// TODO Auto-generated constructor stub
	
		
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new FlowLayout(0));
		jPanel.add(treeRoot);
		return  jPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(getContentPane(),"�ð༶����һ������", "ϵͳ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		TreePath path = treeRoot.getPathForLocation(e.getX(), e.getY()); // �ؼ������������ʹ��  
		if (path == null) {  
			   return;  
			   }  
		treeRoot.setSelectionPath(path);  

		  if (e.getButton() == 3) {  
			      popMenu.show(treeRoot, e.getX(), e.getY());  
			        }  
		  if(e.getButton()==1){
			  JOptionPane.showMessageDialog(getContentPane(),"��ѡ��", "ϵͳ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
		  }
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
