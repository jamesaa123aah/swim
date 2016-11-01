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
	 * 建立树
	 */
	JTree treeRoot;
	JPopupMenu popMenu;  
	JMenuItem addItem; 
	
	 public JPanelSecond() {
		// TODO Auto-generated constructor stub
		// TODO Auto-generated constructor stub
		   DefaultMutableTreeNode root = new DefaultMutableTreeNode("全部学员");
//			//创建一级子节点
//			DefaultMutableTreeNode nodeFirst = new DefaultMutableTreeNode("西瓜班",false);
//			root.add(nodeFirst);
//			 
//			//创建一级子节点
//			DefaultMutableTreeNode nodeSecond = new DefaultMutableTreeNode("恐龙班",false);
//			root.add(nodeSecond);
//			
		
//			数据库获取所有班级信息
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
	    	addItem = new JMenuItem("添加一健考勤");  
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
		JOptionPane.showMessageDialog(getContentPane(),"该班级加入一健考勤", "系统信息", JOptionPane.INFORMATION_MESSAGE);
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
		TreePath path = treeRoot.getPathForLocation(e.getX(), e.getY()); // 关键是这个方法的使用  
		if (path == null) {  
			   return;  
			   }  
		treeRoot.setSelectionPath(path);  

		  if (e.getButton() == 3) {  
			      popMenu.show(treeRoot, e.getX(), e.getY());  
			        }  
		  if(e.getButton()==1){
			  JOptionPane.showMessageDialog(getContentPane(),"被选中", "系统信息", JOptionPane.INFORMATION_MESSAGE);
		  }
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
