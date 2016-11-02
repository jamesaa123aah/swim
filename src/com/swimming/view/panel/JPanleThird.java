package com.swimming.view.panel;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import com.swimming.dao.StudentDao;
import com.swimming.dao.Impl.StudentDaoImpl;
import com.swimming.model.Student;

public class JPanleThird  {


	
	public JPanel getJpanelThird() {
	

		
//		�����������ݼ���
		JTable table = new JTable(new MyTableModel());
		
//		int columncount = table.getColumnCount();
//		
//		
////          ���ñ����
//		        for (int i = 0; i < columncount; i++) {
//
//		          table.getColumnModel().getColumn(i).setPreferredWidth(33);
//
//		        }
//		        
//		        table.getColumnModel().getColumn(2).setPreferredWidth(60);
//		        table.getColumnModel().getColumn(1).setPreferredWidth(60);
//		        table.getColumnModel().getColumn(0).setPreferredWidth(60);

		

//		���ñ�Ŀ�
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		//JScrollPane scrollPane = new JScrollPane(table);
		
	    JScrollPane sp=new JScrollPane(table);
	    sp.setPreferredSize(new Dimension(1200, 800));
		JPanel jPanel = new JPanel();
		jPanel.add(sp);	
		
		return jPanel;
		
	}
	
	private class MyTableModel extends AbstractTableModel{

		
		
		
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
						data[i][j]=0;
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
