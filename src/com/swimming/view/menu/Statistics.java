package com.swimming.view.menu;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.swimming.dao.AttendanceDao;
import com.swimming.dao.CourseDao;
import com.swimming.dao.StudentDao;
import com.swimming.dao.Impl.AttendanceDaoImpl;
import com.swimming.dao.Impl.CourseDaoImpl;
import com.swimming.dao.Impl.StudentDaoImpl;
import com.swimming.model.Attendance;
import com.swimming.model.Course;
import com.swimming.model.Student;

public class Statistics extends JDialog {

	JLabel jLabel_year = new JLabel("年:");
	JComboBox jComboBox_year = new JComboBox(get_year());
	
	JLabel jLabel_month = new JLabel("月:");
	JComboBox jComboBox_month = new JComboBox(get_month());
	
	JLabel jLabel_day = new JLabel("日:");
	JComboBox jComboBox_day = new JComboBox(get_day());
	
	
	JLabel jLabel_year2 = new JLabel("年:");
	JComboBox jComboBox_year2 = new JComboBox(get_year());
	
	JLabel jLabel_month2 = new JLabel("月:");
	JComboBox jComboBox_month2 = new JComboBox(get_month());
	
	JLabel jLabel_day2 = new JLabel("日:");
	JComboBox jComboBox_day2 = new JComboBox(get_day());
	
	
	JLabel jLabel_people = new JLabel("总学员数：");
	JTextField jTextField_people = new JTextField("0"); 
	
	/*
	 * 选择要统计的班级
	 */
	JComboBox jComboBox_class = new JComboBox<>();
	JLabel jLabel_class_people = new JLabel("该班人数：");
	JTextField jTextField_class_people = new JTextField("0"); 
	
	
	JButton jButton_search = new JButton("查看");
	
	
	
	public Statistics() {
		// TODO Auto-generated constructor stub
		
		
		/*
		 *设置统计日期的默认值为当前年月日
		 *(1)获取当前日期
		 *(2)设置jcombobox的默认选项
		 * 
		 */
		Calendar a=Calendar.getInstance();
		
		String now_year = String.valueOf(a.get(Calendar.YEAR));
		String now_month = String.valueOf(a.get(Calendar.MONTH)+1);
		String now_day = String.valueOf(a.get(Calendar.DATE));
		if (now_day.length()==1) {
			now_day="0"+now_day;
		}else if (now_month.length()==1) {
			now_month="0"+now_month;
		}
		
		System.out.println(now_year);
		System.out.println(now_month);
		System.out.println(now_day);
		
		jComboBox_year.setSelectedItem(now_year);
		jComboBox_month.setSelectedItem(now_month);
		jComboBox_day.setSelectedItem(now_day);
		
		jComboBox_year2.setSelectedItem(now_year);
		jComboBox_month2.setSelectedItem(now_month);
		jComboBox_day2.setSelectedItem(now_day);
		
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
		
		
		Container container = getContentPane();
		setLayout(new GridBagLayout());	
		
		GridBagConstraints gridBagConstraints_0 = new GridBagConstraints();
		gridBagConstraints_0.gridy=0;
		gridBagConstraints_0.gridx=0;
		gridBagConstraints_0.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints_0.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_year,gridBagConstraints_0);
		
		GridBagConstraints gridBagConstraints_00 = new GridBagConstraints();
		gridBagConstraints_00.gridy=1;
		gridBagConstraints_00.gridx=0;
		gridBagConstraints_00.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints_00.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_year2,gridBagConstraints_00);
		
		GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.gridy=0;
		gridBagConstraints_1.gridx=1;
		//gridBagConstraints_1.ipadx=80;
		gridBagConstraints_1.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints_1.fill = GridBagConstraints.HORIZONTAL;
		container.add(jComboBox_year,gridBagConstraints_1);
		
		GridBagConstraints gridBagConstraints_11 = new GridBagConstraints();
		gridBagConstraints_11.gridy=1;
		gridBagConstraints_11.gridx=1;
		//gridBagConstraints_1.ipadx=80;
		gridBagConstraints_11.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints_11.fill = GridBagConstraints.HORIZONTAL;
		container.add(jComboBox_year2,gridBagConstraints_11);
		
		GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.gridy=3;
		gridBagConstraints_2.gridx=2;
		gridBagConstraints_2.insets = new Insets(10,0, 0, 0);
		gridBagConstraints_2.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_people,gridBagConstraints_2);
		
		GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		gridBagConstraints_3.gridy=3;
		gridBagConstraints_3.gridx=3;
		gridBagConstraints_3.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints_3.fill = GridBagConstraints.HORIZONTAL;
		container.add(jTextField_people,gridBagConstraints_3);
		
		GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
		gridBagConstraints_4.gridy=3;
		gridBagConstraints_4.gridx=5;
		gridBagConstraints_4.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints_4.fill = GridBagConstraints.HORIZONTAL;
		container.add(jButton_search,gridBagConstraints_4);
		
		GridBagConstraints gridBagConstraints_a = new GridBagConstraints();
		gridBagConstraints_a.gridy=4;
		gridBagConstraints_a.gridx=1;
		gridBagConstraints_a.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints_a.fill = GridBagConstraints.HORIZONTAL;
		container.add(jComboBox_class,gridBagConstraints_a);
		
		GridBagConstraints gridBagConstraints_b = new GridBagConstraints();
		gridBagConstraints_b.gridy=4;
		gridBagConstraints_b.gridx=2;
		gridBagConstraints_b.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints_b.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_class_people,gridBagConstraints_b);
		
		GridBagConstraints gridBagConstraints_c = new GridBagConstraints();
		gridBagConstraints_c.gridy=4;
		gridBagConstraints_c.gridx=3;
		gridBagConstraints_c.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints_c.fill = GridBagConstraints.HORIZONTAL;
		container.add(jTextField_class_people,gridBagConstraints_c);
		
		/*
		 * 加上
		 * 月和日的选择
		 */
		GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
		gridBagConstraints_5.gridy=0;
		gridBagConstraints_5.gridx=2;
		gridBagConstraints_5.insets = new Insets(10, 20, 0, 0);
		gridBagConstraints_5.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_month,gridBagConstraints_5);
		
		GridBagConstraints gridBagConstraints_55 = new GridBagConstraints();
		gridBagConstraints_55.gridy=1;
		gridBagConstraints_55.gridx=2;
		gridBagConstraints_55.insets = new Insets(10, 20, 0, 0);
		gridBagConstraints_55.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_month2,gridBagConstraints_55);
		
		GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.gridy=0;
		gridBagConstraints_6.gridx=3;
		gridBagConstraints_6.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints_6.fill = GridBagConstraints.HORIZONTAL;
		container.add(jComboBox_month,gridBagConstraints_6);
		
		GridBagConstraints gridBagConstraints_66 = new GridBagConstraints();
		gridBagConstraints_66.gridy=1;
		gridBagConstraints_66.gridx=3;
		gridBagConstraints_66.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints_66.fill = GridBagConstraints.HORIZONTAL;
		container.add(jComboBox_month2,gridBagConstraints_66);
		
		GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();
		gridBagConstraints_7.gridy=0;
		gridBagConstraints_7.gridx=4;
		gridBagConstraints_7.insets = new Insets(10, 20, 0, 0);
		gridBagConstraints_7.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_day,gridBagConstraints_7);
		
		GridBagConstraints gridBagConstraints_77 = new GridBagConstraints();
		gridBagConstraints_77.gridy=1;
		gridBagConstraints_77.gridx=4;
		gridBagConstraints_77.insets = new Insets(10, 20, 0, 0);
		gridBagConstraints_77.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_day2,gridBagConstraints_77);
		
		GridBagConstraints gridBagConstraints_8= new GridBagConstraints();
		gridBagConstraints_8.gridy=0;
		gridBagConstraints_8.gridx=5;
		gridBagConstraints_8.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints_8.fill = GridBagConstraints.HORIZONTAL;
		container.add(jComboBox_day,gridBagConstraints_8);
		
		GridBagConstraints gridBagConstraints_88= new GridBagConstraints();
		gridBagConstraints_88.gridy=1;
		gridBagConstraints_88.gridx=5;
		gridBagConstraints_88.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints_88.fill = GridBagConstraints.HORIZONTAL;
		container.add(jComboBox_day2,gridBagConstraints_88);
		
		jButton_search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String year1,year2,month1,month2,day1,day2;
				int num=0;
				int num2=0;
				String class_name=(String) jComboBox_class.getSelectedItem();
				
				StudentDao studentDao = new StudentDaoImpl();
				
				
				year1= (String) jComboBox_year.getSelectedItem();
				year2= (String) jComboBox_year2.getSelectedItem();
				month1= (String) jComboBox_month.getSelectedItem();
				month2= (String) jComboBox_month2.getSelectedItem();
				day1= (String) jComboBox_day.getSelectedItem();
				day2= (String) jComboBox_day2.getSelectedItem();
				
				AttendanceDao attendanceDao = new AttendanceDaoImpl();
				List<Attendance> list_statistics = attendanceDao.Attendance();
				for (Attendance attendance : list_statistics) {
					String date = attendance.getAttendance_date();
					
					String stu_name =attendance.getStu_name();
					
					String year0,month0,day0;
					year0 = date.substring(0, 4);
					//System.out.println("----"+year0);
					month0=date.substring(5,7);
					//System.out.println("----"+month0);
					day0=date.substring(8,10);
					//System.out.println("----"+day0);
					//System.out.println(day0);

					/*
					 * (1)年不相等直接比年
					 * （2）年相等、月不相等、直接比月份
					 * （3）年月相等、比日
					 */
					
					/*
					 * 月份
					 * 日0的
					 * 砍去
					 * 
					 */
					if (month0.substring(0, 1).equals("0")) {
						month0=month0.substring(1,2);
					}
					if (month1.substring(0, 1).equals("0")) {
						month1=month1.substring(1,2);
					}
					if (month2.substring(0, 1).equals("0")) {
						month2=month2.substring(1,2);
					}
					if (day0.substring(0, 1).equals("0")) {
						day0=day0.substring(1,2);
					}
					if (day1.substring(0, 1).equals("0")) {
						day1=day1.substring(1,2);
					}
					if (day2.substring(0, 1).equals("0")) {
						day2=day2.substring(1,2);
					}
//					情况（1）
					if(Integer.parseInt(year1)!=Integer.parseInt(year2)){
					
						if(Integer.parseInt(year1)==Integer.parseInt(year0)||Integer.parseInt(year0)==Integer.parseInt(year2)){

							
							
							if(Integer.parseInt(month1)!=Integer.parseInt(month2)){
								if(Integer.parseInt(month1)<=Integer.parseInt(month0) && Integer.parseInt(month0)<=Integer.parseInt(month2)){				
									if(Integer.parseInt(month1)==Integer.parseInt(month0)){
										if(Integer.parseInt(day0)>Integer.parseInt(day1)){
											num++;
											List<Student> list=studentDao.getLookStu(stu_name);
											if (list.get(0).getClass_name().equals(class_name)) {
												num2++;
											}
											System.out.println("aaaa");
										}
										
									}else if (Integer.parseInt(month2)==Integer.parseInt(month0)) {
										if(Integer.parseInt(day0)<Integer.parseInt(day2)){
											num++;
											List<Student> list=studentDao.getLookStu(stu_name);
											if (list.get(0).getClass_name().equals(class_name)) {
												num2++;
											}
											System.out.println("bbb");
										}
									}else if (Integer.parseInt(month0)>Integer.parseInt(month1)&&Integer.parseInt(month0)<Integer.parseInt(month2)) {
										num++;
										//System.out.println("month0:"+month0);
										//System.out.println("month2:"+month2);
										List<Student> list=studentDao.getLookStu(stu_name);
										if (list.get(0).getClass_name().equals(class_name)) {
											num2++;
										}
										System.out.println("ccc");
									}
									
									//System.out.println(year0+month0+day0);
								}
							}
							
							
						}
						
						if(Integer.parseInt(year1)<Integer.parseInt(year0)&&Integer.parseInt(year0)<Integer.parseInt(year2)){
							num++;
						}
					}
//					情况（2）
					if(Integer.parseInt(year1)==Integer.parseInt(year2) ){
						if (Integer.parseInt(year0)==Integer.parseInt(year1)||Integer.parseInt(year0)==Integer.parseInt(year2)) {
							
						
						if(Integer.parseInt(month1)!=Integer.parseInt(month2)){
							if(Integer.parseInt(month1)<=Integer.parseInt(month0) && Integer.parseInt(month0)<=Integer.parseInt(month2)){				
								if(Integer.parseInt(month1)==Integer.parseInt(month0)){
									if(Integer.parseInt(day0)>=Integer.parseInt(day1)){
										num++;
										//System.out.println("aaaa");
										List<Student> list=studentDao.getLookStu(stu_name);
										if (list.get(0).getClass_name().equals(class_name)) {
											num2++;
										}
									}
									
								}else if (Integer.parseInt(month2)==Integer.parseInt(month0)) {
									if(Integer.parseInt(day0)<=Integer.parseInt(day2)){
										num++;
										//System.out.println("bbb");
										List<Student> list=studentDao.getLookStu(stu_name);
										if (list.get(0).getClass_name().equals(class_name)) {
											num2++;
										}
									}
								}else if (Integer.parseInt(month0)>Integer.parseInt(month1)&&Integer.parseInt(month0)<Integer.parseInt(month2)) {
									num++;
									System.out.println("year0::"+year0+"-month0:"+month0+"-day0"+day0);
								
									List<Student> list=studentDao.getLookStu(stu_name);
									if (list.get(0).getClass_name().equals(class_name)) {
										num2++;
									}
									System.out.println("c2c2c2");
								}
								
								//System.out.println(year0+month0+day0);
							}
						}}
					}
					
//					情况（3）
					if(Integer.parseInt(year1)==Integer.parseInt(year2) && Integer.parseInt(year0)==Integer.parseInt(year1)){
						if(Integer.parseInt(month1)==Integer.parseInt(month2)){
							
							if(Integer.parseInt(month0)==Integer.parseInt(month2)||Integer.parseInt(month0)==Integer.parseInt(month1)){
								
								if(Integer.parseInt(day1)<=Integer.parseInt(day0) && Integer.parseInt(day0)<=Integer.parseInt(day2)){
									num++;
									System.out.println(stu_name);
									/*
									 * 2017/2/27
									 * 统计特定班级的学生
									 */
									List<Student> list=studentDao.getLookStu(stu_name);
									if (list.get(0).getClass_name().equals(class_name)) {
										num2++;
									}
								//System.out.println("3333");
								}
							}
							
//							if (Integer.parseInt(month0)==Integer.parseInt(month2)) {
//								if (Integer.parseInt(day0)<=Integer.parseInt(day2)) {
//									num++;
//
//									List<Student> list=studentDao.getLookStu(stu_name);
//									if (list.get(0).getClass_name().equals(class_name)) {
//										num2++;
//									}
//								}
//							}else if (Integer.parseInt(month0)==Integer.parseInt(month1)) {
//								
//							}
							
						}
					}
					
					
					
					

				}
				
				jTextField_people.setText(String.valueOf(num));
				num=0;
				jTextField_class_people.setText(String.valueOf(num2));
				num2=0;
			}
		});
		setDefaultCloseOperation(2);
		setTitle("统计");		
	    setModal(true);
		setSize(500,350);		
		setLocationRelativeTo(null);// 窗口居中
	}
	
	/*
	 *   年份下拉框和月份的创建
	 *   返回一个年份和月份数组
	 *   返回给上边的combox
	 */

	private static String[] get_year() {
		// TODO Auto-generated method stub
		String[] arry = new String[100];
	    for (int i = 2016; i < 2100; i++) {
	        arry[i-2016] = String.valueOf(i);
	    }
	    return arry;
	}

	private static String[] get_month() {
		// TODO Auto-generated method stub
		String[] arry = new String[12];
	    for (int i = 1; i < 13; i++) {
	        if(i<10){
	        	arry[i-1]="0"+i;
	        }
	    	else {
	    		 arry[i-1] = String.valueOf(i);
			}
	       
	    }
	    return arry;
	}
	
	private static String[] get_day() {
		// TODO Auto-generated method stub
		String[] arry = new String[31];
	    for (int i = 1; i < 32; i++) {
	    	 if(i<10){
		        	arry[i-1]="0"+i;
		        }
	    	 else {
	    		 arry[i-1] = String.valueOf(i);
			}
	       
	    }
	    return arry;
	}
}
