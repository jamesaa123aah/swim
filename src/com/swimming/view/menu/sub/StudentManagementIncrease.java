package com.swimming.view.menu.sub;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.swimming.dao.CourseDao;
import com.swimming.dao.StudentDao;
import com.swimming.dao.Impl.CourseDaoImpl;
import com.swimming.dao.Impl.StudentDaoImpl;
import com.swimming.model.Course;
import com.swimming.model.Student;
import com.swimming.view.mian_login_register.UiMain;
import com.swimming.view.panel.JPanelSecond;
import com.swimming.view.panel.JPanleThird;

public class StudentManagementIncrease extends JDialog{

	
	
	
	/*
	 * 新增学员界面
	 * 控件的初始化
	 */
	JLabel jLabel_adJust = new JLabel("     ");
	JLabel jLabel_adJust2 = new JLabel("                 ");
	
	JLabel jLabel_name = new JLabel("姓名：");
	JTextField jTextField_name = new JTextField(8);
	
		
	JLabel jLabel_sex = new JLabel("性别:");
	JComboBox jComboBox_sex = new JComboBox();
	
		
	JLabel jLabel_birth_date = new JLabel("出生日期:");	
	String array_date[] = {"1995-08-05"};
	JComboBox jComboBox_birth_date = new JComboBox<>(array_date);
	JTextField jTextField_birth_date = new JTextField(8);
	
		
	JLabel jLabel_school = new JLabel("学校：");
	JTextField jTextField_school = new JTextField(10);
	
	
	JLabel jLabel_phone = new JLabel("电话：");
	JTextField jTextField_phone = new JTextField(8);
	
	
	JLabel jLabel_class = new JLabel("班级：");
	String array_class[] = {"恐龙班","初级班班","高级班"};
	JComboBox jComboBox_class = new JComboBox<>();
	JTextField jTextField_class = new JTextField("请输入班级名字");
	
	JPanel jPanel_remark = new JPanel();
	JLabel jLabel_remark = new JLabel("备注：");
	JTextArea jTextArea_remark =new JTextArea("", 13, 20);
	
	JButton jButton_confirm = new JButton("确认增加");
	
	
	
	public StudentManagementIncrease() {
		// TODO Auto-generated constructor stub
		
//		增加姓名输入框
		add(jLabel_name);
		add(jTextField_name);	
		add(jLabel_adJust2);
	
		
		
		
//		增加性别选择框
		add(jLabel_sex);
		add(jComboBox_sex);
		jComboBox_sex.addItem("男");
		jComboBox_sex.addItem("女");
		
//		增加出生年月框
		add(jLabel_adJust);
		add(jLabel_birth_date);
		//add(jComboBox_birth_date);
		add(jTextField_birth_date);
		
//		增加学校输入框
		add(jLabel_school);
		add(jTextField_school);
		
//		增加电话输入框
		add(jLabel_phone);
		add(jTextField_phone);
		
//		增加班级选择框
		/*
		 * 
		 * 在选择班级时候
		 * 从数据库提供已有的班级
		 */
		CourseDao courseDao = new CourseDaoImpl();
		List<Course> list_class=courseDao.allClass();
		
		for (int i = 0;i<list_class.size();i++) {
			jComboBox_class.addItem(list_class.get(i).getClass_name());
		}
				

		add(jLabel_class);
		add(jComboBox_class);
		//add(jTextField_class);
		
//		增加备注框
		jPanel_remark.add(jLabel_remark);
		jPanel_remark.add(new JScrollPane(jTextArea_remark));		
		add(jPanel_remark);
		
		add(new JLabel("                                   "));
		add(jButton_confirm);
		
	
	
		
//		确认按钮响应
  jButton_confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/*
				 * 应该先判断是否重名
				 * 不重名的话正常添加，重名的话就不允许添加
				 */
				

//				可以根据此方法获取一个list(增加的学员信息)
				List list_stu = getStudentInfo();
				StudentDao studentDao=new StudentDaoImpl();
				
			
			   
				
				Student stu=new Student();
				//stu.setClass_name(jTextField_class.getText());
				stu.setClass_name((String) jComboBox_class.getSelectedItem());
				stu.setStu_name(jTextField_name.getText());
				stu.setStu_sex((String) jComboBox_sex.getSelectedItem());
				stu.setStu_school(jTextField_school.getText());
				stu.setStu_phone(jTextField_phone.getText());
				stu.setStu_birthDate(jTextField_birth_date.getText());
				stu.setStu_remark(jTextArea_remark.getText());
				
				/*
				 * 列出数据库所有学生名字
				 */
				List<Student> list_database = studentDao.allStudent();
				int size = list_database.size();
				int i ;
				for(i = 0;i<size;i++){
					if(jTextField_name.getText().equals(list_database.get(i).getStu_name())){
						JOptionPane.showMessageDialog(null,"名字重复!!", "失败!!", JOptionPane.ERROR_MESSAGE);
					   break;
					}
				}
				
				if(i==size){
				studentDao.addStu(stu);
				JOptionPane.showMessageDialog(null,"新增成功", "成功", JOptionPane.INFORMATION_MESSAGE);	
				JPanleThird.queryClass(JPanelSecond.select_classname);
				dispose();
				}
				
//				dispose();
				
				
			}
		});
		
		
		
		//setResizable(false);
		setDefaultCloseOperation(2);
		setResizable(false);
		setTitle("新增学员");		
        setLayout(new FlowLayout(0,10,20));// 设置布局流式布局
	    setModal(true);
		setSize(370,500);		
		setLocationRelativeTo(null);// 窗口居中
	}
	
	/*
	 * 将插入的学员数据进行封装
	 * 返回一个list
	 * 到后台
	 */
private List getStudentInfo() {
		
		
	List<String> list_stu = new LinkedList<String>();

	System.out.println("增加学员");
				
				
				
				//list_stu.add();
				list_stu.add(jTextField_name.getText());
				list_stu.add((String)jComboBox_sex.getSelectedItem());
				list_stu.add(jTextField_school.getText());
				list_stu.add(jTextField_phone.getText());
				list_stu.add((String) jComboBox_birth_date.getSelectedItem());
				list_stu.add(jTextArea_remark.getText());
				
				
//				输出的测试
//				Iterator iterator = list_stu.iterator();
//				while (iterator.hasNext()) {
//					System.out.println(iterator.next());
//				}
					
				
		
		
		return list_stu;
	}
}
