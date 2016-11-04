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

	 
//	 ��ʵ�����ģʽ
	 private JPanleThird(){
		 my = new MyTableModel();
		 table = new JTable(my);
	 }
		 
	 public static JPanel getInstance() {
		
		 if(jPanel==null){
			 
			 jPanelThird = new JPanleThird();
			 jPanel = new JPanel();
		 }
		 

//			�����������ݼ���  ����������󡣡���
			my.addTableModelListener(jPanelThird);
			table = new JTable(my);
			
//			���ñ�Ŀ�
			table.getColumnModel().getColumn(2).setPreferredWidth(130);
			table.getColumnModel().getColumn(1).setPreferredWidth(150);
			table.getColumnModel().getColumn(0).setPreferredWidth(150);
			table.getColumnModel().getColumn(3).setPreferredWidth(80);
			
		    JScrollPane sp=new JScrollPane(table);
		    sp.setPreferredSize(new Dimension(1200, 800));
			
			jPanel.add(sp);
			
		return jPanel;
		
	}
	

	
//	 ��ʱ����Ҫ��׽�¼���ֱ��ɨ��table�Ϳ���
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
//			//һ�����ڵ�list
//			 List<Student> listOneKey = new LinkedList<Student>();
//			//ɨ��table	
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
			{ "����","һ������","©��","����","1","2","3","4","5",
					"6","7","8","9","10","11","12","13","14","15","16","17",
					"18","19","20","21","22","23","24","25","26","27","28","29",
					"30","31"};
		Object[][] data; 
		
	    public MyTableModel() {
			// TODO Auto-generated constructor stub
	    	
//	    	�����ݿ��ȡѧ��
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
		
	 // ����Ϊ�̳���AbstractTableModle�ķ����������Զ���
	 		/**
	 		 * �õ�����
	 		 */
	 		@Override
	 		public String getColumnName(int column)
	 		{
	 			return columnNames[column];
	 		}
	 		
	 		/**
	 		 * ��д�������õ��������
	 		 */
	 		@Override
	 		public int getColumnCount()
	 		{
	 			return columnNames.length;
	 		}

	 		/**
	 		 * �õ��������
	 		 */
	 		@Override
	 		public int getRowCount()
	 		{
	 			return data.length;
	 		}

	 		/**
	 		 * �õ���������Ӧ����
	 		 */
	 		@Override
	 		public Object getValueAt(int rowIndex, int columnIndex)
	 		{
	 			return data[rowIndex][columnIndex];
	 		}

	 		/**
	 		 * �õ�ָ���е���������
	 		 */
	 		@Override
	 		public Class<?> getColumnClass(int columnIndex)
	 		{
	 			return data[0][columnIndex].getClass();
	 		}

	 		/**
	 		 * ָ���������ݵ�Ԫ�Ƿ�ɱ༭.��������"����","ѧ��"���ɱ༭
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
	 		 * ������ݵ�ԪΪ�ɱ༭���򽫱༭���ֵ�滻ԭ����ֵ
	 		 */
	 		@Override
	 		public void setValueAt(Object aValue, int rowIndex, int columnIndex)
	 		{
	 			data[rowIndex][columnIndex] = aValue;
	 			/*֪ͨ���������ݵ�Ԫ�����Ѿ��ı�*/
	 			fireTableCellUpdated(rowIndex, columnIndex);
	 		}

		
	}

	
}
