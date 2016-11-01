package com.swimming.view.menu.sub;

import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.swimming.dao.StudentDao;
import com.swimming.dao.Impl.StudentDaoImpl;
import com.swimming.model.Student;

public class StudentManagementInfoLook extends JDialog {

	
	JLabel jLabel_name = new JLabel("姓名：");
	//JComboBox jComboBox_name = new JComboBox<>();
	JTextField jTextField_name = new JTextField();
	
	
	
	JLabel jLabel_id = new JLabel("学号：");
	JComboBox jComboBox_id = new JComboBox<>();
	
	JLabel jLabel_name1 = new JLabel("姓名：");
	JLabel jLabel_name2 = new JLabel("张华");
	
	JLabel jLabel_sex1 = new JLabel("性别：");
	JLabel jLabel_sex2 = new JLabel("男");
	
	JLabel jLabel_birhdate1 = new JLabel("出生年月：");
	JLabel jLabel_birhdate2 = new JLabel("1995-10-08");
	
	JLabel jLabel_school1 = new JLabel("学校：");
	JLabel jLabel_school2 = new JLabel("四川大学");
	
	JLabel jLabel_phone1 = new JLabel("电话：");
	JLabel jLabel_phone2 = new JLabel("13456789648");
	
	JLabel jLabel_class1 = new JLabel("班级：");
	JLabel jLabel_class2 = new JLabel("杨经飞教练班");
	
	JLabel jLabel_money1 = new JLabel("余额(RMB)：");
	JLabel jLabel_money2 = new JLabel("3478");
	
	JLabel jLabel_times1 = new JLabel("次数：");
	JLabel jLabel_times2 = new JLabel("26");
	
	JLabel jLabel_remark1 = new JLabel("备注：");
	JTextArea jTextArea_remark2 = new JTextArea(60, 50);
	
	JButton jButton = new JButton("查看") ;
	
	public StudentManagementInfoLook() {
		// TODO Auto-generated constructor stub
		  setLayout(new GridBagLayout());// 设置网格组布局
		  Container container = getContentPane();
		   
		GridBagConstraints gridBagConstraints_0 = new GridBagConstraints();	
		gridBagConstraints_0.gridy = 0;
		gridBagConstraints_0.gridx=0;
		gridBagConstraints_0.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_name,gridBagConstraints_0);
		
		
		GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.gridy = 0;
		gridBagConstraints_1.gridx = 1;
		gridBagConstraints_1.insets = new Insets(0, 0, 0, 0);
		gridBagConstraints_1.weightx = 80;
		gridBagConstraints_1.fill = GridBagConstraints.HORIZONTAL;
		//container.add(jComboBox_name,gridBagConstraints_1);
		container.add(jTextField_name, gridBagConstraints_1);
	
//		jComboBox_name.addItem("李玉");
//		jComboBox_name.addItem("李俊东");
//		jComboBox_name.addItem("张锋");
//		jComboBox_name.addItem("熊波");
		
		GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.gridy=0;
		gridBagConstraints_2.gridx=2;
		gridBagConstraints_2.insets = new Insets(0, 60, 0, 0);
		gridBagConstraints_2.fill=GridBagConstraints.HORIZONTAL;
		container.add(jLabel_id,gridBagConstraints_2);
		
		
		GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		gridBagConstraints_3.gridy=0;
		gridBagConstraints_3.gridx=3;
		gridBagConstraints_3.weightx=20;
		gridBagConstraints_3.insets = new Insets(0, 0, 0, 0);
		gridBagConstraints_3.fill = GridBagConstraints.HORIZONTAL;
		container.add(jComboBox_id,gridBagConstraints_3);
		
		GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
		gridBagConstraints_4.gridy=1;
		gridBagConstraints_4.gridx=0;
		gridBagConstraints_4.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_4.insets = new Insets(30, 0, 0, 0);
		container.add(jLabel_sex1, gridBagConstraints_4);
		
		GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
		gridBagConstraints_5.gridy=1;
		gridBagConstraints_5.gridx=1;
		gridBagConstraints_5.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_5.insets = new Insets(30, 0, 0, 0);
		container.add(jLabel_sex2, gridBagConstraints_5);
	
		GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.gridy=1;
		gridBagConstraints_6.gridx=2;
		gridBagConstraints_6.insets = new Insets(30, 60, 0, 0);
		gridBagConstraints_6.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_birhdate1, gridBagConstraints_6);
		
		GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();
		gridBagConstraints_7.gridy=1;
		gridBagConstraints_7.gridx=3;
		gridBagConstraints_7.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_7.insets = new Insets(30, 0, 0, 0);
		container.add(jLabel_birhdate2, gridBagConstraints_7);
		
		
		GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();
		gridBagConstraints_8.gridy=2;
		gridBagConstraints_8.gridx=0;
		gridBagConstraints_8.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_8.insets = new Insets(30, 0, 0, 0);
		container.add(jLabel_school1, gridBagConstraints_8);
		
		GridBagConstraints gridBagConstraints_9 = new GridBagConstraints();
		gridBagConstraints_9.gridy=2;
		gridBagConstraints_9.gridx=1;
		gridBagConstraints_9.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_9.insets = new Insets(30, 0, 0, 0);
		container.add(jLabel_school2, gridBagConstraints_9);
		
		GridBagConstraints gridBagConstraints_10 = new GridBagConstraints();
		gridBagConstraints_10.gridy=2;
		gridBagConstraints_10.gridx=2;
		gridBagConstraints_10.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_10.insets = new Insets(30, 60, 0, 0);
		container.add(jLabel_class1, gridBagConstraints_10);
		
		GridBagConstraints gridBagConstraints_11 = new GridBagConstraints();
		gridBagConstraints_11.gridy=2;
		gridBagConstraints_11.gridx=3;
		gridBagConstraints_11.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_11.insets = new Insets(30, 0, 0, 0);
		container.add(jLabel_class2, gridBagConstraints_11);
		
		GridBagConstraints gridBagConstraints_12 = new GridBagConstraints();
		gridBagConstraints_12.gridy=3;
		gridBagConstraints_12.gridx=0;
		gridBagConstraints_12.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_12.insets = new Insets(30, 0, 0, 0);
		container.add(jLabel_phone1, gridBagConstraints_12);
		
		GridBagConstraints gridBagConstraints_13 = new GridBagConstraints();
		gridBagConstraints_13.gridy=3;
		gridBagConstraints_13.gridx=1;
		gridBagConstraints_13.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_13.insets = new Insets(30, 0, 0, 0);
		container.add(jLabel_phone2, gridBagConstraints_13);
		

		GridBagConstraints gridBagConstraints_14 = new GridBagConstraints();
		gridBagConstraints_14.gridy=4;
		gridBagConstraints_14.gridx=0;
		gridBagConstraints_14.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_14.insets = new Insets(30, 0, 0, 0);
		//container.add(jLabel_money1, gridBagConstraints_14);
		
		GridBagConstraints gridBagConstraints_15 = new GridBagConstraints();
		gridBagConstraints_15.gridy=4;
		gridBagConstraints_15.gridx=1;
		gridBagConstraints_15.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_15.insets = new Insets(30, 0, 0, 0);
		//container.add(jLabel_money2, gridBagConstraints_15);
		
		GridBagConstraints gridBagConstraints_16 = new GridBagConstraints();
		gridBagConstraints_16.gridy=4;
		gridBagConstraints_16.gridx=2;
		gridBagConstraints_16.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_16.insets = new Insets(30, 60, 0, 0);
		//container.add(jLabel_times1, gridBagConstraints_16);
		
		GridBagConstraints gridBagConstraints_17 = new GridBagConstraints();
		gridBagConstraints_17.gridy=4;
		gridBagConstraints_17.gridx=3;
		gridBagConstraints_17.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_17.insets = new Insets(30, 0, 0, 0);
		//container.add(jLabel_times2, gridBagConstraints_17);
		
		GridBagConstraints gridBagConstraints_18 = new GridBagConstraints();
		gridBagConstraints_18.gridy=5;
		gridBagConstraints_18.gridx=0;
		gridBagConstraints_18.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_18.insets = new Insets(30, 0, 0, 0);
		container.add(jLabel_remark1, gridBagConstraints_18);
		
		GridBagConstraints gridBagConstraints_19 = new GridBagConstraints();
		gridBagConstraints_19.gridy=5;
		gridBagConstraints_19.gridx=1;
		//gridBagConstraints_19.gridheight=80;
		gridBagConstraints_19.ipady=80;
		gridBagConstraints_19.ipadx=50;
		gridBagConstraints_19.fill = GridBagConstraints.BOTH;
		gridBagConstraints_19.insets = new Insets(30, 0, 0, 0);
		//jTextArea_remark2.setEditable(false);
		jTextArea_remark2.setLineWrap(true);
		
		container.add(new JScrollPane(jTextArea_remark2), gridBagConstraints_19);
		
		GridBagConstraints gridBagConstraints_20 = new GridBagConstraints();
		gridBagConstraints_20.gridy=6;
		gridBagConstraints_20.gridx=3;
		gridBagConstraints_19.weighty=30;
		gridBagConstraints_20.fill = GridBagConstraints.HORIZONTAL;
		container.add(jButton,gridBagConstraints_20);
		
		
//		按钮响应
		
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			
				StudentDao studentDao = new StudentDaoImpl();
				//JOptionPane.showMessageDialog(null, "bbbbb", "11111", JOptionPane.ERROR_MESSAGE); 
				
				List<Student> list2 = studentDao.allStudent();
				
//				不存在数据
				int tem = 0;
				Student student=new Student();
				for (Student student2 : list2) {
					if(student2.getStu_name().equals(jTextField_name.getText()))
						tem=1;
				}
				if(tem==1){
				List<Student> list  = studentDao.getLookStu(jTextField_name.getText());
				
				jLabel_sex2.setText( list.get(0).getStu_sex());		
				jLabel_school2.setText((String) list.get(0).getStu_school());
				jLabel_phone2.setText((String) list.get(0).getStu_phone());
				jLabel_birhdate2.setText((String) list.get(0).getStu_birthDate());
				jTextArea_remark2.setText((String) list.get(0).getStu_remark());
			    jLabel_class2.setText(list.get(0).getClass_name());
				
				}
				else{
					JOptionPane.showMessageDialog(null, "该学学员不存在", "11111", JOptionPane.ERROR_MESSAGE); 
				}
			}
		});
		
		
		
		//setResizable(false);
		setDefaultCloseOperation(2);
		setTitle("查看学员信息");		    
	    setModal(true);
		setSize(500,500);		
		setLocationRelativeTo(null);// 窗口居中
		setResizable(false);
		
			
	}
	
	/*
	 * 通过此函数
	 * 得到一个list
	 * list 包含从数据库
	 * 获取的数据
	 */
	private List getStudentInfo() {
		
		List<String> list_stu = new LinkedList();
		
		list_stu.add("ljd");
		list_stu.add("3423423");
		
		
		return list_stu;
		
	}
}
