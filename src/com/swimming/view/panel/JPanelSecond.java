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
import javax.swing.table.AbstractTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import com.swimming.dao.CourseDao;
import com.swimming.dao.Impl.CourseDaoImpl;
import com.swimming.model.Course;

public class JPanelSecond  extends JFrame {

	/*
	 * 建立树
	 */
	public static JTree treeRoot;
	JPopupMenu popMenu;  
	JMenuItem addItem; 
	public static DefaultMutableTreeNode root,choosen;
	public static String select_classname = null;
	
	public static  DefaultTreeModel model;
	
	
	 public JPanelSecond() {
		// TODO Auto-generated constructor stub
		// TODO Auto-generated constructor stub
		  root = new DefaultMutableTreeNode("全部学员");
	
		  treeRoot = new JTree(root);
		  model = (DefaultTreeModel) treeRoot.getModel();
		
//			数据库获取所有班级信息
			CourseDao courseDao = new CourseDaoImpl();
			List<Course> list=courseDao.allClass();
			
		
			for(int i = 0;i<list.size();i++){
				
			choosen=(DefaultMutableTreeNode)treeRoot.getLastSelectedPathComponent();
			DefaultMutableTreeNode node1 = new DefaultMutableTreeNode(list.get(i).getClass_name(),false);
			
			if (choosen==null) {
				choosen=root;
			}
			model.insertNodeInto(node1, choosen, 0);
			}
			
			
			
			  
	    	treeRoot.setEditable(true);  
	    	treeRoot.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);  
	    	//treeRoot.addMouseListener(this);  
	    	treeRoot.setCellEditor(new DefaultTreeCellEditor(treeRoot, new DefaultTreeCellRenderer()));  
	    	
	    	
	    	treeRoot.addTreeSelectionListener(new TreeSelectionListener() {
				
				@Override
				public void valueChanged(TreeSelectionEvent e) {
					// TODO Auto-generated method stub
					//DefaultMutableTreeNode note = (DefaultMutableTreeNode) treeRoot.getLastSelectedPathComponent();
				   // String name = note.toString();//获得这个结点的名称
				    //System.out.println(name);
				    //JPanleThird.my.data=new Object[2][40];
				    //JPanleThird.my.setValueAt("1", 4, 12);
				    //JPanleThird.my.remove(4, 1);
					DefaultMutableTreeNode note = (DefaultMutableTreeNode) treeRoot.getLastSelectedPathComponent();
				    String name = note.toString();//获得这个结点的名称
				    JPanleThird.queryClass(name);
					
				   // JPanleThird.queryClass(JPanelSecond.select_classname);
				    /*
				     * 获取选中的班级
				     */
				    select_classname=name;
				    
				    System.out.println(select_classname);
				    JPanleThird.queryClass(JPanelSecond.select_classname);
				}
			});
	    	
	    	
	    	
	}
	
	 public static void add(String a) {
		
		
			
		 
		 DefaultMutableTreeNode node1 = new DefaultMutableTreeNode(a,false);
		 if (choosen==null) {
				choosen=root;
			}
			model.insertNodeInto(node1, choosen, 0);
			}
	
	 
	public JPanel getJPanelSecond() {
		// TODO Auto-generated constructor stub
	
		
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new FlowLayout(0));
		jPanel.add(treeRoot);
		return  jPanel;
	}

	
	class A extends AbstractTableModel{

		
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getValueAt(int arg0, int arg1) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
