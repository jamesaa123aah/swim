package com.swimming.ui;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.xml.soap.Detail;

import com.swimming.ui.menu.management.ClassManagement;
import com.swimming.ui.menu.management.ClassManagementDelete;
import com.swimming.ui.menu.management.ClassManagementIncrese;
import com.swimming.ui.menu.management.ClassManagementInfoChange;
import com.swimming.ui.menu.management.ClassManagementInfoLook;
import com.swimming.ui.menu.management.CoachManagement;
import com.swimming.ui.menu.management.CoachManagementDelete;
import com.swimming.ui.menu.management.CoachManagementIncrease;
import com.swimming.ui.menu.management.CoachManagementInfoChange;
import com.swimming.ui.menu.management.CoachManagementInfoLook;
import com.swimming.ui.menu.management.MoneyManagement;
import com.swimming.ui.menu.management.Recovery;
import com.swimming.ui.menu.management.StudentManagement;
import com.swimming.ui.menu.management.StudentManagementDelete;
import com.swimming.ui.menu.management.StudentManagementIncrease;
import com.swimming.ui.menu.management.StudentManagementInfoLook;
import com.swimming.ui.menu.management.StudentManagementInfochange;
import com.swimming_three_button.Details;
import com.swimming_three_button.DrainPunch;
import com.swimming_three_button.LogTable;
import com.swimming_three_button.OneKeyAttendance;
import com.swimming_three_button.Statistics;

public  class MenuA {


//		菜单栏
		JMenuBar jMenuBar = new JMenuBar();		
		
//		菜单
		JMenu jMenu1 = new JMenu("操作");
		JMenu jMenu2 = new JMenu("管理");
		JMenu jMenu3 = new JMenu("学员管理");
		JMenu jMenu4 = new JMenu("班级管理");
		JMenu jMenu5 = new JMenu("教练管理");
		JMenu jMenu6 = new JMenu("缴费管理");
		JMenu jMenu7 = new JMenu("查看");
		
		
				
//		菜单项(1)
		JMenuItem jMenuItem1 = new JMenuItem("恢复");
		JMenuItem jMenuItem22 = new JMenuItem("导入");
		JMenuItem jMenuItem2 = new JMenuItem("导出");
		JMenuItem jMenuItem3 = new JMenuItem("查看日志");
		
//		菜单项(2)
		JMenuItem jMenuItem4 = new JMenuItem("学员管理");
		JMenuItem jMenuItem5 = new JMenuItem("班级管理");
		JMenuItem jMenuItem6 = new JMenuItem("教练管理");
		JMenuItem jMenuItem7 = new JMenuItem("财务管理");

//		菜单项--学员管理
		JMenuItem jMenuItem_student_increase = new JMenuItem("新增学员");
		JMenuItem jMenuItem_student_delete = new JMenuItem("删除学员");
		JMenuItem jMenuItem_student_change = new JMenuItem("修改学员信息");
		JMenuItem jMenuItem_student_view = new JMenuItem("查看学员信息");
//		菜单项--班级管理
		JMenuItem jMenuItem_class_increase = new JMenuItem("新增班级");
		JMenuItem jMenuItem_class_delete = new JMenuItem("删除班级");
		JMenuItem jMenuItem_class_change = new JMenuItem("修改班级信息");
		JMenuItem jMenuItem_class_view = new JMenuItem("查看班级信息");
//		菜单项--教练管理
		JMenuItem jMenuItem_coach_increase = new JMenuItem("新增教练");
		JMenuItem jMenuItem_coach_delete = new JMenuItem("删除教练");
		JMenuItem jMenuItem_coach_change = new JMenuItem("修改教练信息");
		JMenuItem jMenuItem_coach_view = new JMenuItem("查看教练信息");
//		菜单项--缴费管理
		JMenuItem jMenuItem_money1 = new JMenuItem("缴费");
		JMenuItem jMenuItem_money2 = new JMenuItem("查看明细");
//		菜单项--查看
		JMenuItem jMenuItem_one_key = new JMenuItem("一健考勤表");
		JMenuItem jMenuItem_forget = new JMenuItem("漏打表");
		JMenuItem jMenuItem_static = new JMenuItem("统计表");
		
		public  MenuA() {
			// TODO Auto-generated constructor stub
			
//		  往菜单栏里添加菜单
		
		  //jMenuBar.add(jMenu2);
		  jMenuBar.add(jMenu3);
		  jMenuBar.add(jMenu4);
		  jMenuBar.add(jMenu5);
		  jMenuBar.add(jMenu6);
		  jMenuBar.add(jMenu7);
		  jMenuBar.add(jMenu1);
		  
		  
//		  第（1）个菜单里菜单项的添加	  
		  jMenu1.add(jMenuItem1);
		  jMenu1.add(jMenuItem22);
		  jMenu1.add(jMenuItem2);
		  jMenu1.add(jMenuItem3);
	
          
//		  第（2）个菜单里菜单项的添加	  
		  jMenu2.add(jMenuItem4);
		  jMenu2.add(jMenuItem5);
		  jMenu2.add(jMenuItem6);
		  jMenu2.add(jMenuItem7);
		  
//		  学员管理菜单里加菜单项
		  jMenu3.add(jMenuItem_student_increase);
		  jMenu3.add(jMenuItem_student_delete);
		  jMenu3.add(jMenuItem_student_change);
		  jMenu3.add(jMenuItem_student_view);
		  
//		  班级管理菜单里加菜单项
		  jMenu4.add(jMenuItem_class_increase);
		  jMenu4.add(jMenuItem_class_delete);
		  jMenu4.add(jMenuItem_class_change);
		  jMenu4.add(jMenuItem_class_view);
//		  教练管理菜单里加菜单项
		  jMenu5.add(jMenuItem_coach_increase);
		  jMenu5.add(jMenuItem_coach_delete);
		  jMenu5.add(jMenuItem_coach_change);
		  jMenu5.add(jMenuItem_coach_view);
//		  财务管理菜单里加菜单项
		  jMenu6.add(jMenuItem_money1);
		  jMenu6.add(jMenuItem_money2);
//		  查看菜单里加菜单项
		  jMenu7.add(jMenuItem_one_key);
		  jMenu7.add(jMenuItem_forget);
		  jMenu7.add(jMenuItem_static);
		  

		  
		/*学员菜单相应
		 * 包括：
		 * 新增、
		 * 删除、
		 * 查看、
		 * 修改
		 */
		
//		  新增学员管理菜单响应
		  jMenuItem_student_increase.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentManagementIncrease studentManagementIncrease = new StudentManagementIncrease();
				studentManagementIncrease.setVisible(true);
				
			}
		});
		 
//		  删除学员管理菜单响应
		  jMenuItem_student_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentManagementDelete studentManagementDelete = new StudentManagementDelete();
				studentManagementDelete.setVisible(true);
			}
		});
		  
		  
//		  查看学员信息菜单管理
		  jMenuItem_student_view.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentManagementInfoLook studentManagementInfoLook = new StudentManagementInfoLook();
				studentManagementInfoLook.setVisible(true);
			}
		});
		  
//		  修改学员信息菜单管理
		  jMenuItem_student_change.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					StudentManagementInfochange studentManagementInfochange=new StudentManagementInfochange();
					studentManagementInfochange.setVisible(true);
				}
			});
		  
		  
		  
		  /*班级菜单响应
			 * 包括：
			 * 新增、
			 * 删除、
			 * 查看、
			 * 修改
			 */
			
		  jMenuItem_class_increase.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ClassManagementIncrese classManagementIncrese = new ClassManagementIncrese();
				classManagementIncrese.setVisible(true);
			}
		});
		  
		  jMenuItem_class_delete.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ClassManagementDelete classManagementDelete = new ClassManagementDelete();
					classManagementDelete.setVisible(true);
				}
			});
		  
		  jMenuItem_class_view.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ClassManagementInfoLook classManagementInfoLook = new ClassManagementInfoLook();
					classManagementInfoLook.setVisible(true);
				}
			});
		  
		  jMenuItem_class_change.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ClassManagementInfoChange classManagementInfoChange = new ClassManagementInfoChange();
					classManagementInfoChange.setVisible(true);
				}
			});
		  
		  
		  
		  /*教练菜单响应
			 * 包括：
			 * 新增、
			 * 删除、
			 * 查看、
			 * 修改
			 */
		  
		  jMenuItem_coach_increase.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CoachManagementIncrease coachManagementIncrease = new CoachManagementIncrease();
				coachManagementIncrease.setVisible(true);
			}
		});
		  
		  jMenuItem_coach_delete.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					CoachManagementDelete coachManagementDelete = new CoachManagementDelete();
					coachManagementDelete.setVisible(true);
				}
			});
		  
		  jMenuItem_coach_view.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					CoachManagementInfoLook coachManagementInfoLook = new CoachManagementInfoLook();
					coachManagementInfoLook.setVisible(true);
				}
			});
		  
		  jMenuItem_coach_change.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					CoachManagementInfoChange coachManagementInfoChange = new CoachManagementInfoChange();
					coachManagementInfoChange.setVisible(true);
				}
			});
		  
		
		  
		  jMenuItem6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CoachManagement coachManagement = new CoachManagement();
				coachManagement.setModal(true);
				coachManagement.setVisible(true);
			}
		});
		  
		  
		  
		  /*缴费管理菜单响应
		   * 包含：
		   * 缴费
		   * 明细
		   */
		  jMenuItem_money1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MoneyManagement moneyManagement = new MoneyManagement();
				moneyManagement.setModal(true);
				moneyManagement.setVisible(true);
			}
		});
		 
		  jMenuItem_money2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Details details = new Details();
					details.setModal(true);
					details.setVisible(true);
				}
			});
	
		  /*查看菜单响应
		   * 包含：
		   * 一健考勤
		   * 统计
		   * 漏打卡
		   */
		  
		  jMenuItem_one_key.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				OneKeyAttendance oneKeyAttendance = new OneKeyAttendance();
				oneKeyAttendance.setVisible(true);
			}
		});
		 
		  jMenuItem_forget.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DrainPunch drainPunch = new DrainPunch();
				drainPunch.setVisible(true);
			}
		});
		  
		  jMenuItem_static.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Statistics statistics = new Statistics();
				statistics.setVisible(true);
			}
		});
		  
	  /*菜单项响应事件(操作)
	   * 包括：
	   * 恢复
	   * 导入
	   * 导出
	   * 查看日志
	   */
		  jMenuItem2.addActionListener(null);
		  
		  
		  
//		  恢复
		  jMenuItem1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Recovery recovery = new Recovery();
				recovery.setVisible(true);
			}
		});
			
          		  	  
		  jMenuItem3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LogTable logTable = new LogTable();
				logTable.setModal(true);
				logTable.setVisible(true);
			}
		});
		}
}
