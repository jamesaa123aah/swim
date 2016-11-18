package com.swimming.view.menu;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.swimming.dao.AttendanceDao;
import com.swimming.dao.Impl.AttendanceDaoImpl;
import com.swimming.model.Attendance;

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
	
	
	JLabel jLabel_people = new JLabel("学员数：");
	JTextField jTextField_people = new JTextField("68"); 
	
	JButton jButton_search = new JButton("查看");
	
	
	
	public Statistics() {
		// TODO Auto-generated constructor stub
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
					
					
					String year0,month0,day0;
					year0 = date.substring(0, 4);
					month0=date.substring(5,7);
					day0=date.substring(8,10);
					//System.out.println(day0);

					/*
					 * (1)年不相等直接比年
					 * （2）年相等、月不相等、直接比月份
					 * （3）年月相等、比日
					 */
//					情况（1）
					if(Integer.parseInt(year1)!=Integer.parseInt(year2)){
						if (Integer.parseInt(year1)<=Integer.parseInt(year0) && Integer.parseInt(year0)<=Integer.parseInt(year2)){
							num++;
						}
					}
//					情况（2）
					if(Integer.parseInt(year1)==Integer.parseInt(year2)){
						if(Integer.parseInt(month1)!=Integer.parseInt(month2)){
							if(Integer.parseInt(month1)<=Integer.parseInt(month0) && Integer.parseInt(month0)<=Integer.parseInt(month2)){
								num++;
								System.out.println(year0+month0+day0);
							}
						}
					}
					
//					情况（3）
					if(Integer.parseInt(year1)==Integer.parseInt(year2)){
						if(Integer.parseInt(month1)==Integer.parseInt(month2)){
							if(Integer.parseInt(day1)<=Integer.parseInt(day0) && Integer.parseInt(day0)<=Integer.parseInt(day2)){
								num++;
								System.out.println(year0+month0+day0);
							}
						}
					}
					
					
					
					

				}
				
				jTextField_people.setText(String.valueOf(num));
				num=0;
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
