package com.swimming.view.menu.sub;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.swimming.dao.StudentDao;
import com.swimming.dao.Impl.StudentDaoImpl;
import com.swimming.model.Student;

public class StudentManagementInfochange extends JDialog{

	JLabel jLabel_name = new JLabel("姓名：");
	String array_name[] = {"张三","欧阳中翔"}; 
	JComboBox jComboBox_name = new JComboBox<>(array_name);
   JTextField jTextField_name1 = new JTextField();
	
	JLabel jLabel_id = new JLabel("学号：");
	String array_id[] = {"125436","100365"};
	JComboBox jComboBox_id = new JComboBox<>(array_id);
	
	JButton jButton_search = new JButton("查看");
	
	JLabel jLabel_name1 = new JLabel("姓名：");
	JTextField jTextField_name2 = new JTextField("张三");
	
	JLabel jLabel_sex1 = new JLabel("性别：");
	String array_sex[] = {"男","女"};
	JComboBox jComboBox_sex2 = new JComboBox<>(array_sex);
	
	JLabel jLabel_birhdate1 = new JLabel("出生年月：");
	JComboBox jComboBox_birthdate = new JComboBox<>();
	JTextField jTextField_birthdate2 = new JTextField();
	
	JLabel jLabel_school1 = new JLabel("学校：");
	JTextField jTextField_school2 = new JTextField("四川大学");
	
	JLabel jLabel_phone1 = new JLabel("电话：");
	JTextField jTextField_phone2 = new JTextField("13456789648");
	
	JLabel jLabel_class1 = new JLabel("班级：");
	JComboBox jComboBox_class2 = new JComboBox<>();
	JTextField jTextField_class2 = new JTextField();
	
	JLabel jLabel_money1 = new JLabel("余额(RMB)：");
	JTextField jTextField_money2 = new JTextField("466");
	
	JLabel jLabel_times1 = new JLabel("次数：");
	JTextField jTextField_time2 = new JTextField("12");
	
	JLabel jLabel_remark1 = new JLabel("备注：");
	JTextArea jTextArea_remark2 = new JTextArea(60, 75);
	
	JButton jButton = new JButton("确认修改") ;
	
	
	public StudentManagementInfochange() {
		// TODO Auto-generated constructor stub		
		setLayout(new GridBagLayout());// 设置网格组布局
		Container container = getContentPane();
		
		
		GridBagConstraints gridBagConstraints_0 = new GridBagConstraints();	
		gridBagConstraints_0.gridy = 0;
		gridBagConstraints_0.gridx=0;
		gridBagConstraints_0.insets = new Insets(0, 0, 0, 0);
		gridBagConstraints_0.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_name,gridBagConstraints_0);
		
		GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.gridy = 0;
		gridBagConstraints_1.gridx = 1;
		gridBagConstraints_1.insets = new Insets(0, 0, 0, 0);
		gridBagConstraints_1.fill = GridBagConstraints.HORIZONTAL;
		container.add(jTextField_name1,gridBagConstraints_1);
		
		GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.gridy=0;
		gridBagConstraints_2.gridx=2;
		gridBagConstraints_2.insets = new Insets(0, 60, 0, 0);
		gridBagConstraints_2.fill=GridBagConstraints.HORIZONTAL;
		//container.add(jLabel_id,gridBagConstraints_2);
		
		
		GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		gridBagConstraints_3.gridy=0;
		gridBagConstraints_3.gridx=3;
		gridBagConstraints_3.insets = new Insets(0, 0, 0, 0);
		gridBagConstraints_3.fill = GridBagConstraints.HORIZONTAL; 
		//container.add(jComboBox_id,gridBagConstraints_3);
		container.add(jButton_search,gridBagConstraints_3);
		
		GridBagConstraints gridBagConstraints_33 = new GridBagConstraints();
		gridBagConstraints_33.gridy=1;
		gridBagConstraints_33.gridx=0;
		gridBagConstraints_33.insets = new Insets(60, 0, 0, 0);
		gridBagConstraints_33.fill = GridBagConstraints.HORIZONTAL; 
		container.add(jLabel_name1,gridBagConstraints_33);
		
		GridBagConstraints gridBagConstraints_333 = new GridBagConstraints();
		gridBagConstraints_333.gridy=1;
		gridBagConstraints_333.gridx=1;
		gridBagConstraints_333.insets = new Insets(60, 0, 0, 0);
		gridBagConstraints_333.fill = GridBagConstraints.HORIZONTAL; 
		container.add(jTextField_name2,gridBagConstraints_333);
		
		GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
		gridBagConstraints_4.gridy=1;
		gridBagConstraints_4.gridx=2;
		gridBagConstraints_4.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_4.insets = new Insets(60, 60, 0, 0);
		container.add(jLabel_sex1, gridBagConstraints_4);
		
		GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
		gridBagConstraints_5.gridy=1;
		gridBagConstraints_5.gridx=3;
		gridBagConstraints_5.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_5.insets = new Insets(60, 0, 0, 0);
		container.add(jComboBox_sex2, gridBagConstraints_5);
		
		GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.gridy=2;
		gridBagConstraints_6.gridx=0;
		gridBagConstraints_6.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints_6.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_birhdate1, gridBagConstraints_6);
		
		GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();
		gridBagConstraints_7.gridy=2;
		gridBagConstraints_7.gridx=1;
		gridBagConstraints_7.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_7.insets = new Insets(10, 0, 0, 0);
		container.add(jTextField_birthdate2, gridBagConstraints_7);
		
		GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();
		gridBagConstraints_8.gridy=2;
		gridBagConstraints_8.gridx=2;
		gridBagConstraints_8.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_8.insets = new Insets(10, 60, 0, 0);
		container.add(jLabel_school1, gridBagConstraints_8);
		
		GridBagConstraints gridBagConstraints_9 = new GridBagConstraints();
		gridBagConstraints_9.gridy=2;
		gridBagConstraints_9.gridx=3;
		gridBagConstraints_9.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_9.insets = new Insets(10, 0, 0, 0);
		container.add(jTextField_school2, gridBagConstraints_9);
		
		GridBagConstraints gridBagConstraints_10 = new GridBagConstraints();
		gridBagConstraints_10.gridy=3;
		gridBagConstraints_10.gridx=0;
		gridBagConstraints_10.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_10.insets = new Insets(10, 0, 0, 0);
		container.add(jLabel_class1, gridBagConstraints_10);
		
		GridBagConstraints gridBagConstraints_11 = new GridBagConstraints();
		gridBagConstraints_11.gridy=3;
		gridBagConstraints_11.gridx=1;
		gridBagConstraints_11.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_11.insets = new Insets(10, 0, 0, 0);
		container.add(jTextField_class2, gridBagConstraints_11);
		
		GridBagConstraints gridBagConstraints_12 = new GridBagConstraints();
		gridBagConstraints_12.gridy=3;
		gridBagConstraints_12.gridx=2;
		gridBagConstraints_12.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_12.insets = new Insets(10, 60, 0, 0);
		container.add(jLabel_phone1, gridBagConstraints_12);
		
		GridBagConstraints gridBagConstraints_13 = new GridBagConstraints();
		gridBagConstraints_13.gridy=3;
		gridBagConstraints_13.gridx=3;
		gridBagConstraints_13.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_13.insets = new Insets(10, 0, 0, 0);
		container.add(jTextField_phone2, gridBagConstraints_13);
		
		GridBagConstraints gridBagConstraints_14 = new GridBagConstraints();
		gridBagConstraints_14.gridy=4;
		gridBagConstraints_14.gridx=0;
		gridBagConstraints_14.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_14.insets = new Insets(10, 0, 0, 0);
		//container.add(jLabel_money1, gridBagConstraints_14);
		
		GridBagConstraints gridBagConstraints_15 = new GridBagConstraints();
		gridBagConstraints_15.gridy=4;
		gridBagConstraints_15.gridx=1;
		gridBagConstraints_15.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_15.insets = new Insets(10, 0, 0, 0);
		//container.add(jTextField_money2, gridBagConstraints_15);
		
		GridBagConstraints gridBagConstraints_16 = new GridBagConstraints();
		gridBagConstraints_16.gridy=4;
		gridBagConstraints_16.gridx=2;
		gridBagConstraints_16.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_16.insets = new Insets(10, 60, 0, 0);
		//container.add(jLabel_times1, gridBagConstraints_16);
		
		GridBagConstraints gridBagConstraints_17 = new GridBagConstraints();
		gridBagConstraints_17.gridy=4;
		gridBagConstraints_17.gridx=3;
		gridBagConstraints_17.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_17.insets = new Insets(10, 0, 0, 0);
	//	container.add(jTextField_time2, gridBagConstraints_17);
		
		GridBagConstraints gridBagConstraints_18 = new GridBagConstraints();
		gridBagConstraints_18.gridy=5;
		gridBagConstraints_18.gridx=0;
		gridBagConstraints_18.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_18.insets = new Insets(30, 0, 0, 0);
		container.add(jLabel_remark1, gridBagConstraints_18);
		
		GridBagConstraints gridBagConstraints_19 = new GridBagConstraints();
		gridBagConstraints_19.gridy=5;
		gridBagConstraints_19.gridx=1;
		gridBagConstraints_19.ipady=150;
		gridBagConstraints_19.ipadx=150;
		gridBagConstraints_19.fill = GridBagConstraints.BOTH;
		gridBagConstraints_19.insets = new Insets(30, 0, 0, 0);
		container.add(jTextArea_remark2, gridBagConstraints_19);
		
		GridBagConstraints gridBagConstraints_20 = new GridBagConstraints();
		gridBagConstraints_20.gridy=6;
		gridBagConstraints_20.gridx=3;
		gridBagConstraints_19.weighty=30;
		gridBagConstraints_20.fill = GridBagConstraints.HORIZONTAL;
		container.add(jButton,gridBagConstraints_20);
		
		
		
		jButton_search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
StudentDao studentDao = new StudentDaoImpl();
				
				
				List<Student> list2 = studentDao.allStudent();
				
//				不存在数据
				int tem = 0;
				Student student=new Student();
				for (Student student2 : list2) {
					if(student2.getStu_name().equals(jTextField_name1.getText()));
						tem=1;
				}
				if(tem==1){
				List<Student> list  = studentDao.getLookStu(jTextField_name1.getText());
				
				jTextField_name2.setText(list.get(0).getStu_name());
				jComboBox_sex2.setSelectedItem((String) list.get(0).getStu_sex());
				jTextField_school2.setText((String) list.get(0).getStu_school());
				jTextField_phone2.setText((String) list.get(0).getStu_phone());
				jTextField_birthdate2.setText((String) list.get(0).getStu_birthDate());
				jTextArea_remark2.setText((String) list.get(0).getStu_remark());
			    jTextField_class2.setText(list.get(0).getClass_name());
				
				}
				else{
					JOptionPane.showMessageDialog(null, "该学学员不存在", "11111", JOptionPane.ERROR_MESSAGE); 
				}
			}
		});
		
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Student student = new Student();
				student.setStu_name(jTextField_name2.getText());
				student.setStu_birthDate(jTextField_birthdate2.getText());
				student.setStu_sex((String)jComboBox_sex2.getSelectedItem());
				student.setStu_phone(jTextField_phone2.getText());
				student.setStu_remark(jTextArea_remark2.getText());
				student.setStu_school(jTextField_school2.getText());
				student.setClass_name(jTextField_class2.getText());
				
				
				
				StudentDao studentDao = new StudentDaoImpl();
				studentDao.changeStu(student, jTextField_name1.getText());
			
				JOptionPane.showMessageDialog(null, "学员信息更新完成", "222", JOptionPane.ERROR_MESSAGE); 
			}
		});
		
		
		//setResizable(false);
				setDefaultCloseOperation(2);
				//setResizable(false);
				setTitle("修改学员信息");		
			    setModal(true);
				setSize(500,500);		
				setLocationRelativeTo(null);// 窗口居中
	}
	
	
}
