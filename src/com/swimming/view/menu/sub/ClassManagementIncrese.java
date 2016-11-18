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
import javax.swing.JTextField;

import com.swimming.dao.CoachDao;
import com.swimming.dao.CourseDao;
import com.swimming.dao.Impl.CoachDaoImpl;
import com.swimming.dao.Impl.CourseDaoImpl;
import com.swimming.model.Coach;
import com.swimming.model.Course;

public class ClassManagementIncrese extends JDialog {

	JLabel jLabel_className = new JLabel("班级名：");
	JTextField jTextField_className = new JTextField();
	
	JLabel jLabel_coachName = new JLabel("教练名：");
	JComboBox jComboBox_coachName = new JComboBox();
	JTextField jTextField_coachName = new JTextField();
	
	JLabel jLabel_money = new JLabel("费用(RMB/次):");
	JTextField jTextField_money = new JTextField();
	
	JButton jButton = new JButton("确认");
	
	public ClassManagementIncrese() {
		// TODO Auto-generated constructor stub
		
		setLayout(new GridBagLayout());		
		Container container = getContentPane();
		
		GridBagConstraints gridBagConstraints_0 = new GridBagConstraints();
		gridBagConstraints_0.gridy=0;
		gridBagConstraints_0.gridx=0;
		gridBagConstraints_0.insets = new Insets(30, 0, 0, 0);
		gridBagConstraints_0.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_className,gridBagConstraints_0);
		
		GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.gridy=0;
		gridBagConstraints_1.gridx=1;
		gridBagConstraints_1.ipadx=100;
		gridBagConstraints_1.insets = new Insets(30, 0, 0, 0);
		gridBagConstraints_1.fill = GridBagConstraints.HORIZONTAL;
		container.add(jTextField_className,gridBagConstraints_1);
		
		GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.gridy=1;
		gridBagConstraints_2.gridx=0;
		gridBagConstraints_2.insets = new Insets(30, 0, 0, 0);
		gridBagConstraints_2.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_coachName,gridBagConstraints_2);
		
		GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		gridBagConstraints_3.gridy=1;
		gridBagConstraints_3.gridx=1;
		gridBagConstraints_3.ipadx=100;
		gridBagConstraints_3.insets = new Insets(30, 0, 0, 0);
		gridBagConstraints_3.fill = GridBagConstraints.HORIZONTAL;
		
		/*
		 * 将目前有的教练
		 * 全部列出
		 * 在添加班级的时候进行选择
		 * 11/6
		 */
		CoachDao coachDao = new CoachDaoImpl();
		Coach coach = new Coach();
		List<Coach> list_allCoach = coachDao.allCoach();
		
		for (int i = 0; i < list_allCoach.size(); i++) {
			jComboBox_coachName.addItem(list_allCoach.get(i).getCoach_name());
		}
		
		container.add(jComboBox_coachName,gridBagConstraints_3);
//		container.add(jTextField_coachName, gridBagConstraints_3);
		
		GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
		gridBagConstraints_4.gridy=2;
		gridBagConstraints_4.gridx=0;
		gridBagConstraints_4.insets = new Insets(30, 0, 0, 0);
		gridBagConstraints_4.fill = GridBagConstraints.HORIZONTAL;
		//container.add(jLabel_money,gridBagConstraints_4);
		
		GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
		gridBagConstraints_5.gridy=2;
		gridBagConstraints_5.gridx=1;
		gridBagConstraints_5.ipadx=100;
		gridBagConstraints_5.insets = new Insets(30, 0, 0, 0);
		gridBagConstraints_5.fill = GridBagConstraints.HORIZONTAL;
		//container.add(jTextField_money,gridBagConstraints_5);
		
		GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.gridy=3;
		gridBagConstraints_6.gridx=1;
		gridBagConstraints_6.insets = new Insets(30, 0, 0, 0);
		gridBagConstraints_6.fill = GridBagConstraints.HORIZONTAL;
		container.add(jButton,gridBagConstraints_6);
		
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Course course = new Course();
				
				course.setClass_name(jTextField_className.getText());
				//course.setCoach_name(jTextField_coachName.getText());
				course.setCoach_name((String) jComboBox_coachName.getSelectedItem());
				
				CourseDao courseDao = new CourseDaoImpl();
				courseDao.addClass(course);
				JOptionPane.showMessageDialog(null,"新增成功", "成功", JOptionPane.INFORMATION_MESSAGE);	
//				dispose();
			}
		});
	
		
//		设置窗口
		setSize(280, 300);
		setTitle("增加班级");
		//setResizable(false);
		setModal(true);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);// 窗口居中
	}
	
	
}
