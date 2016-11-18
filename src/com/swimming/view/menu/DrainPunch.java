package com.swimming.view.menu;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.swimming.dao.AttendanceDao;
import com.swimming.dao.Impl.AttendanceDaoImpl;
import com.swimming.model.Attendance;

public class DrainPunch extends JDialog {

	
	private JTable table;
	private DefaultTableModel model;
	private JButton deleteButton;
	Attendance attendance;
	AttendanceDao attendanceDao;
	
	public DrainPunch() {
		// TODO Auto-generated constructor stub
		

		Container container = getContentPane();
		deleteButton = new JButton("�Ƴ�");
		container.add(deleteButton);
		container.add(getJpanelThird2());
		

		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				//table.setRowSelectionInterval(1, 2);
				
				//table.setRowSelectionInterval(4, 4);
				
				//table.setRowSelectionInterval(6, 6);
				
				int row = table.getSelectedRow();
				if(row == -1){
					JOptionPane.showMessageDialog(null,"��ѡ��Ҫ�Ƴ�������!");
				}else{
					attendanceDao.setForgetToAttendance((int) table.getValueAt(row, 2));
					model.removeRow(row);
				
					
				}
			}
		});
		
		setDefaultCloseOperation(2);
		setTitle("©��");		
        setLayout(new FlowLayout(0,10,20));// ���ò�����ʽ����
	    setModal(true);
		setSize(500,350);		
		setLocationRelativeTo(null);// ���ھ���
	}
	
	
//	�������
	public JPanel getJpanelThird2() {
			
		String [] columnNames= {" �� �� ","ʱ      ��","���"};
		
		
		/*
		 * ��attendance���
		 * ��ȡ���Ǵ򿨵�����
		 * 2016/11/6 17:14
		 */
		attendance = new Attendance();
		attendanceDao = new AttendanceDaoImpl();
		
		List<Attendance> list_forget=attendanceDao.forgetAttendance();
		
		int size = list_forget.size();
		Object [][] tableValues =new Object[size][3];
			
       
			
		for (int i = 0; i < size; i++) {
			for (int j = 0; j <2; j++) {
				tableValues[i][0]=list_forget.get(i).getStu_name();
				tableValues[i][1]=list_forget.get(i).getAttendance_date();
				tableValues[i][2]=list_forget.get(i).getAttendance_number();
				
			}
		}
		

		model = new DefaultTableModel(tableValues, columnNames);
	         
		table = new JTable(model);
		
						

		
	    JScrollPane sp=new JScrollPane(table);
	    sp.setPreferredSize(new Dimension(450, 249));
		JPanel jPanel = new JPanel();
		jPanel.add(sp);	
		
		return jPanel;
		
	}
	
	
}
