package com.swimming.view.menu;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.xml.soap.Detail;

import com.swimming.util.TestDbToExcel;
import com.swimming.util.TestExcelToDb;
import com.swimming.view.menu.sub.ClassManagement;
import com.swimming.view.menu.sub.ClassManagementDelete;
import com.swimming.view.menu.sub.ClassManagementIncrese;
import com.swimming.view.menu.sub.ClassManagementInfoChange;
import com.swimming.view.menu.sub.ClassManagementInfoLook;
import com.swimming.view.menu.sub.CoachManagement;
import com.swimming.view.menu.sub.CoachManagementDelete;
import com.swimming.view.menu.sub.CoachManagementIncrease;
import com.swimming.view.menu.sub.CoachManagementInfoChange;
import com.swimming.view.menu.sub.CoachManagementInfoLook;
import com.swimming.view.menu.sub.MoneyManagement;
import com.swimming.view.menu.sub.Recovery;
import com.swimming.view.menu.sub.StudentManagement;
import com.swimming.view.menu.sub.StudentManagementDelete;
import com.swimming.view.menu.sub.StudentManagementIncrease;
import com.swimming.view.menu.sub.StudentManagementInfoLook;
import com.swimming.view.menu.sub.StudentManagementInfochange;
import com.swimming.view.panel.JPanelSecond;

public  class MenuA {


//		�˵���
		public JMenuBar jMenuBar = new JMenuBar();		
		
//		�˵�
		JMenu jMenu1 = new JMenu("����");
		JMenu jMenu2 = new JMenu("����");
		JMenu jMenu3 = new JMenu("ѧԱ����");
		JMenu jMenu4 = new JMenu("�༶����");
		JMenu jMenu5 = new JMenu("��������");
		JMenu jMenu6 = new JMenu("�ɷѹ���");
		JMenu jMenu7 = new JMenu("�鿴");
		
		
				
//		�˵���(1)
		JMenuItem jMenuItem1 = new JMenuItem("��������");
		JMenuItem jMenuItem22 = new JMenuItem("����ѧԱ��Ϣ");
		JMenuItem jMenuItem2 = new JMenuItem("����ѧԱ��Ϣ");
		JMenuItem jMenuItem3 = new JMenuItem("�鿴��־");
		
//		�˵���(2)
		JMenuItem jMenuItem4 = new JMenuItem("ѧԱ����");
		JMenuItem jMenuItem5 = new JMenuItem("�༶����");
		JMenuItem jMenuItem6 = new JMenuItem("��������");
		JMenuItem jMenuItem7 = new JMenuItem("�������");

//		�˵���--ѧԱ����
		JMenuItem jMenuItem_student_increase = new JMenuItem("����ѧԱ");
		JMenuItem jMenuItem_student_delete = new JMenuItem("ɾ��ѧԱ");
		JMenuItem jMenuItem_student_change = new JMenuItem("�޸�ѧԱ��Ϣ");
		JMenuItem jMenuItem_student_view = new JMenuItem("�鿴ѧԱ��Ϣ");
//		�˵���--�༶����
		JMenuItem jMenuItem_class_increase = new JMenuItem("�����༶");
		JMenuItem jMenuItem_class_delete = new JMenuItem("ɾ���༶");
		JMenuItem jMenuItem_class_change = new JMenuItem("�޸İ༶��Ϣ");
		JMenuItem jMenuItem_class_view = new JMenuItem("�鿴�༶��Ϣ");
//		�˵���--��������
		JMenuItem jMenuItem_coach_increase = new JMenuItem("��������");
		JMenuItem jMenuItem_coach_delete = new JMenuItem("ɾ������");
		JMenuItem jMenuItem_coach_change = new JMenuItem("�޸Ľ�����Ϣ");
		JMenuItem jMenuItem_coach_view = new JMenuItem("�鿴������Ϣ");
//		�˵���--�ɷѹ���
		JMenuItem jMenuItem_money1 = new JMenuItem("�ɷ�");
		
//		�˵���--�鿴
		JMenuItem jMenuItem_one_key = new JMenuItem("һ�����ڱ�");
		JMenuItem jMenuItem_forget = new JMenuItem("©���");
		JMenuItem jMenuItem_static = new JMenuItem("ͳ�Ʊ�");
		JMenuItem jMenuItem_money2 = new JMenuItem("�鿴��ϸ");
		
		public  MenuA() {
			// TODO Auto-generated constructor stub
			
//		  ���˵�������Ӳ˵�
		
		  //jMenuBar.add(jMenu2);
		  jMenuBar.add(jMenu3);
		  jMenuBar.add(jMenu4);
		  jMenuBar.add(jMenu5);
		  jMenuBar.add(jMenu6);
		  jMenuBar.add(jMenu7);
		  jMenuBar.add(jMenu1);
		  
		  
//		  �ڣ�1�����˵���˵�������	  
		  jMenu1.add(jMenuItem1);
		  jMenu1.add(jMenuItem22);
		  jMenu1.add(jMenuItem2);
		  //jMenu1.add(jMenuItem3);
	
          
//		  �ڣ�2�����˵���˵�������	  
		  jMenu2.add(jMenuItem4);
		  jMenu2.add(jMenuItem5);
		  jMenu2.add(jMenuItem6);
		  jMenu2.add(jMenuItem7);
		  
//		  ѧԱ����˵���Ӳ˵���
		  jMenu3.add(jMenuItem_student_increase);
		  jMenu3.add(jMenuItem_student_delete);
		  jMenu3.add(jMenuItem_student_change);
		  jMenu3.add(jMenuItem_student_view);
		  
//		  �༶����˵���Ӳ˵���
		  jMenu4.add(jMenuItem_class_increase);
		  jMenu4.add(jMenuItem_class_delete);
		  jMenu4.add(jMenuItem_class_change);
		  jMenu4.add(jMenuItem_class_view);
//		  ��������˵���Ӳ˵���
		  jMenu5.add(jMenuItem_coach_increase);
		  jMenu5.add(jMenuItem_coach_delete);
		  jMenu5.add(jMenuItem_coach_change);
		  jMenu5.add(jMenuItem_coach_view);
//		  �������˵���Ӳ˵���
		  jMenu6.add(jMenuItem_money1);
		  //jMenu6.add(jMenuItem_money2);
//		  �鿴�˵���Ӳ˵���
		  jMenu7.add(jMenuItem_one_key);
		  jMenu7.add(jMenuItem_forget);
		  jMenu7.add(jMenuItem_static);
		  jMenu7.add(jMenuItem_money2);
		  

		  
		/*ѧԱ�˵���Ӧ
		 * ������
		 * ������
		 * ɾ����
		 * �鿴��
		 * �޸�
		 */
		
//		  ����ѧԱ����˵���Ӧ
		  jMenuItem_student_increase.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentManagementIncrease studentManagementIncrease = new StudentManagementIncrease();
				studentManagementIncrease.setVisible(true);
				
			}
		});
		 
//		  ɾ��ѧԱ����˵���Ӧ
		  jMenuItem_student_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentManagementDelete studentManagementDelete = new StudentManagementDelete();
				studentManagementDelete.setVisible(true);
			}
		});
		  
		  
//		  �鿴ѧԱ��Ϣ�˵�����
		  jMenuItem_student_view.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentManagementInfoLook studentManagementInfoLook = new StudentManagementInfoLook();
				studentManagementInfoLook.setVisible(true);
			}
		});
		  
//		  �޸�ѧԱ��Ϣ�˵�����
		  jMenuItem_student_change.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					StudentManagementInfochange studentManagementInfochange=new StudentManagementInfochange();
					studentManagementInfochange.setVisible(true);
				}
			});
		  
		  
		  
		  /*�༶�˵���Ӧ
			 * ������
			 * ������
			 * ɾ����
			 * �鿴��
			 * �޸�
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
		  
		  
		  
		  /*�����˵���Ӧ
			 * ������
			 * ������
			 * ɾ����
			 * �鿴��
			 * �޸�
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
		  
		  
		  
		  /*�ɷѹ���˵���Ӧ
		   * ������
		   * �ɷ�
		   * ��ϸ
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
	
		  /*�鿴�˵���Ӧ
		   * ������
		   * һ������
		   * ͳ��
		   * ©��
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
		  
	  /*�˵�����Ӧ�¼�(����)
	   * ������
	   * �ָ�
	   * ����
	   * ����
	   * �鿴��־
	   */
		  jMenuItem2.addActionListener(new ActionListener() {
			
//			  ����
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				TestDbToExcel t = new TestDbToExcel();
				t.DbToExcel();
			}
		});
		  
		  jMenuItem22.addActionListener(new ActionListener() {
				
//			  ����
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				TestExcelToDb testExcelToDb = new TestExcelToDb();
				testExcelToDb.ExcelToDb();
			}
		});
		  
		  
//		  ����������Ϣ
		  jMenuItem1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				TestDbToExcel testDbToExcel = new TestDbToExcel();
				testDbToExcel.AttendanceDbToExcel(JPanelSecond.select_classname);
			
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
