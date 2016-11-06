package com.swimming.view.menu.sub;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.swimming.dao.CoachDao;
import com.swimming.dao.CourseDao;
import com.swimming.dao.Impl.CoachDaoImpl;
import com.swimming.dao.Impl.CourseDaoImpl;
import com.swimming.model.Coach;
import com.swimming.model.Course;

public class ClassManagementInfoChange extends JDialog {

	JLabel jLabel_className = new JLabel("班级名：");
	JComboBox jComboBox_className1 = new JComboBox();
	JTextField jTextField_className1 = new JTextField();
	
	JButton jButton_search = new JButton("查看");
	
	JLabel jLabel_classID = new JLabel("班级号：");
	JComboBox jComboBox_classID = new JComboBox();
	
	JLabel jLabel_className2 = new JLabel("班级名：");
	JTextField jTextField_className2 = new JTextField();
	
	JLabel jLabel_coachName = new JLabel("教练名：");
	JComboBox jComboBox_coachName = new JComboBox();
	JTextField jTextField_coachName = new JTextField();
	
	JLabel jLabel_money = new JLabel("费用(RMB/次):");
	JTextField jTextField_money = new JTextField();
	
	JButton jButton = new JButton("确认修改");
	
	public ClassManagementInfoChange() {
		// TODO Auto-generated constructor stub
		setLayout(new GridBagLayout());		
		Container container = getContentPane();
		
		GridBagConstraints gridBagConstraints_0 = new GridBagConstraints();
		gridBagConstraints_0.gridy=0;
		gridBagConstraints_0.gridx=0;
		gridBagConstraints_0.insets = new Insets(20, 0, 0, 0);
		gridBagConstraints_0.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_className,gridBagConstraints_0);
		
		GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.gridy=0;
		gridBagConstraints_1.gridx=1;
		gridBagConstraints_1.ipadx=100;
		gridBagConstraints_1.insets = new Insets(20, 0, 0, 0);
		gridBagConstraints_1.fill = GridBagConstraints.HORIZONTAL;
		/*
		 * 
		 * 在选择班级时候
		 * 从数据库提供已有的班级
		 */
		CourseDao courseDao = new CourseDaoImpl();
		List<Course> list_class=courseDao.allClass();
		
		for (int i = 0;i<list_class.size();i++) {
			jComboBox_className1.addItem(list_class.get(i).getClass_name());
		}
		container.add(jComboBox_className1,gridBagConstraints_1);
		
		
		
		GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.gridy=1;
		gridBagConstraints_2.gridx=0;
		gridBagConstraints_2.insets = new Insets(20, 0, 0, 0);
		gridBagConstraints_2.fill = GridBagConstraints.HORIZONTAL;
		//container.add(jLabel_classID,gridBagConstraints_2);
		
		GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		gridBagConstraints_3.gridy=1;
		gridBagConstraints_3.gridx=1;
		gridBagConstraints_3.ipadx=100;
		gridBagConstraints_3.insets = new Insets(20, 0, 0, 0);
		gridBagConstraints_3.fill = GridBagConstraints.HORIZONTAL;
		//container.add(jComboBox_classID,gridBagConstraints_3);
		container.add(jButton_search,gridBagConstraints_3);
		
		GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
		gridBagConstraints_4.gridy=2;
		gridBagConstraints_4.gridx=0;
		gridBagConstraints_4.insets = new Insets(80, 0, 0, 0);
		gridBagConstraints_4.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_className2,gridBagConstraints_4);
		
		GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
		gridBagConstraints_5.gridy=2;
		gridBagConstraints_5.gridx=1;
		gridBagConstraints_5.ipadx=100;
		gridBagConstraints_5.insets = new Insets(80, 0, 0, 0);
		gridBagConstraints_5.fill = GridBagConstraints.HORIZONTAL;
		jTextField_className2.setEditable(false);
		container.add(jTextField_className2,gridBagConstraints_5);
		
		GridBagConstraints gridBagConstraints_55 = new GridBagConstraints();
		gridBagConstraints_55.gridy=4;
		gridBagConstraints_55.gridx=0;
		gridBagConstraints_55.ipadx=100;
		gridBagConstraints_55.insets = new Insets(20, 0, 0, 0);
		gridBagConstraints_55.fill = GridBagConstraints.HORIZONTAL;
		//container.add(jLabel_money,gridBagConstraints_55);
		
		GridBagConstraints gridBagConstraints_555 = new GridBagConstraints();
		gridBagConstraints_555.gridy=4;
		gridBagConstraints_555.gridx=1;
		gridBagConstraints_555.ipadx=100;
		gridBagConstraints_555.insets = new Insets(20, 0, 0, 0);
		gridBagConstraints_555.fill = GridBagConstraints.HORIZONTAL;
		//container.add(jTextField_money,gridBagConstraints_555);
		
		
		
		GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.gridy=5;
		gridBagConstraints_6.gridx=1;
		gridBagConstraints_6.insets = new Insets(20, 0, 0, 0);
		gridBagConstraints_6.fill = GridBagConstraints.HORIZONTAL;
		container.add(jButton,gridBagConstraints_6);
		
		GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();
		gridBagConstraints_7.gridy=3;
		gridBagConstraints_7.gridx=0;
		gridBagConstraints_7.insets = new Insets(20, 0, 0, 0);
		gridBagConstraints_7.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_coachName,gridBagConstraints_7);
		
		GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();
		gridBagConstraints_8.gridy=3;
		gridBagConstraints_8.gridx=1;
		gridBagConstraints_8.ipadx=100;
		gridBagConstraints_8.insets = new Insets(20, 0, 0, 0);
		gridBagConstraints_8.fill = GridBagConstraints.HORIZONTAL;		
		//container.add(jComboBox_coachName,gridBagConstraints_8);
		container.add(jTextField_coachName,gridBagConstraints_8);
		
//		查询按钮
		jButton_search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				//先列出信息
				CourseDao courseDao = new CourseDaoImpl();
				List<Course> list = new LinkedList<>();
				

				list = courseDao.queryoneClass((String) jComboBox_className1.getSelectedItem());
				
				jTextField_className2.setText(list.get(0).getClass_name());
				
				
				
				jTextField_coachName.setText(list.get(0).getCoach_name());
				
				
				

			}
		});
		
		
//		确认修改按钮
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
//				然后进行修改
				CourseDao courseDao = new CourseDaoImpl();
				Course course = new Course();
				course.setClass_name(jTextField_className2.getText());
				course.setCoach_name(jTextField_coachName.getText());
				courseDao.updateClass(course, (String) jComboBox_className1.getSelectedItem());
			     
				dispose();
			}
		});
		
//		设置窗口
		setSize(400, 400);
		setTitle("班级信息修改");
		//setResizable(false);
		setModal(true);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);// 窗口居中
	}
}
