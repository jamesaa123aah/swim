package com.swimming.view.panel;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import com.swimming.dao.StudentDao;
import com.swimming.dao.Impl.StudentDaoImpl;
import com.swimming.model.Student;

public class JPanleThird  implements TableModelListener{


//	 my is abstract tablemodel
	 static public MyTableModel my =null; 
	 static JTable table =null;
	 private static JPanleThird jPanelThird = null;
	 private static JPanel jPanel = null;

	 
//	 单实例设计模式
	 private JPanleThird(){
		 my = new MyTableModel();
		 table = new JTable(my);
	 }
		 
	 public static JPanel getInstance() {
		
		 if(jPanel==null){
			 
			 jPanelThird = new JPanleThird();
			 jPanel = new JPanel();
		 }
		 

//			把列名和数据加入  监听这个对象。。。
			my.addTableModelListener(jPanelThird);
			table = new JTable(my);
			
//			设置表的宽
			table.getColumnModel().getColumn(2).setPreferredWidth(130);
			table.getColumnModel().getColumn(1).setPreferredWidth(150);
			table.getColumnModel().getColumn(0).setPreferredWidth(150);
			table.getColumnModel().getColumn(3).setPreferredWidth(80);
			
		    JScrollPane sp=new JScrollPane(table);
		    sp.setPreferredSize(new Dimension(1200, 800));
			
			jPanel.add(sp);
			
		return jPanel;
		
	}
	

	
//	 暂时不需要捕捉事件，直接扫描table就可以
	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
//		int row = e.getFirstRow();
//		int column = e.getColumn();
//		
//		if(column==1){
//			Boolean boolean1 = (Boolean) my.getValueAt(row, column);
//			System.out.println(boolean1);
////		Student student = new Student();
////		student.setStu_name((String) my.getValueAt(row, column-1));
////			listOneKey.add(student);
//			
//		}else if (column == 2) {
//			
//			my.setValueAt(my.getValueAt(row, column), row, column-1);
//			
//		}
//		
//		else{
//			String tem = (String) my.getValueAt(row, column);
//			System.out.println(tem);
//		}
		
	}

	public class MyTableModel extends AbstractTableModel{

	
//		public List<Student> getListOnekey() {
//			
//			//一健考勤的list
//			 List<Student> listOneKey = new LinkedList<Student>();
//			//扫描table	
//			//int a = my.getRowCount();
//			//System.out.println(a);
//			for (int i = 0; i < 5; i++) {
//				if((Boolean)my.getValueAt(i, 1)==true){
//					Student student = new Student();
//					student.setStu_name((String)my.getValueAt(i, 0));
//					listOneKey.add(student);
//				}
//			}
//			
//			System.out.println(listOneKey.get(0).getStu_name());
//			return listOneKey;
//			
//		}
		
		
		String[] columnNames =
			{ "姓名","一健考勤","漏打卡","次数","1","2","3","4","5",
					"6","7","8","9","10","11","12","13","14","15","16","17",
					"18","19","20","21","22","23","24","25","26","27","28","29",
					"30","31"};
		Object[][] data; 
		
	    public MyTableModel() {
			// TODO Auto-generated constructor stub
	    	
//	    	从数据库获取学生
	    	StudentDao studentDao = new StudentDaoImpl();
			List<Student> listAll ;
	    	listAll=studentDao.allStudent();
	    	int number = listAll.size();
	    	
	    	
	    	data= new Object[number][35];
	    	
	    	for (int i = 0; i < number; i++) {
				
	    		for (int j = 0; j < 35; j++) {
					
	    			switch (j) {
					case 0:
						data[i][j] = listAll.get(i).getStu_name();
						break;
					case 1:
						data[i][j] = new Boolean(false);
						break;
					case 2:
						data[i][j] = new Boolean(false);
						break;
					case 3:
						data[i][j]=10;
                        break;
					default:
						data[i][j]="0";
						break;
					}
				}
			}
	    	
		}
		
	 // 以下为继承自AbstractTableModle的方法，可以自定义
	 		/**
	 		 * 得到列名
	 		 */
	 		@Override
	 		public String getColumnName(int column)
	 		{
	 			return columnNames[column];
	 		}
	 		
	 		/**
	 		 * 重写方法，得到表格列数
	 		 */
	 		@Override
	 		public int getColumnCount()
	 		{
	 			return columnNames.length;
	 		}

	 		/**
	 		 * 得到表格行数
	 		 */
	 		@Override
	 		public int getRowCount()
	 		{
	 			return data.length;
	 		}

	 		/**
	 		 * 得到数据所对应对象
	 		 */
	 		@Override
	 		public Object getValueAt(int rowIndex, int columnIndex)
	 		{
	 			return data[rowIndex][columnIndex];
	 		}

	 		/**
	 		 * 得到指定列的数据类型
	 		 */
	 		@Override
	 		public Class<?> getColumnClass(int columnIndex)
	 		{
	 			return data[0][columnIndex].getClass();
	 		}

	 		/**
	 		 * 指定设置数据单元是否可编辑.这里设置"姓名","学号"不可编辑
	 		 */
	 		@Override
	 		public boolean isCellEditable(int rowIndex, int columnIndex)
	 		{
	 			if (columnIndex== 0)
	 				return false;
	 			else if(columnIndex == 3)
					return false;
	 			else
	 				return true;
	 		}
	 		
	 		/**
	 		 * 如果数据单元为可编辑，则将编辑后的值替换原来的值
	 		 */
	 		@Override
	 		public void setValueAt(Object aValue, int rowIndex, int columnIndex)
	 		{
	 			data[rowIndex][columnIndex] = aValue;
	 			/*通知监听器数据单元数据已经改变*/
	 			fireTableCellUpdated(rowIndex, columnIndex);
	 		}

		
	}

	
}
