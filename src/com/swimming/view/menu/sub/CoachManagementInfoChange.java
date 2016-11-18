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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.swimming.dao.CoachDao;
import com.swimming.dao.Impl.CoachDaoImpl;
import com.swimming.model.Coach;

public class CoachManagementInfoChange extends JDialog{

	JLabel jLabel_name = new JLabel("姓名：");
	JComboBox jComboBox_name = new JComboBox<>();
	
	JLabel jLabel_id = new JLabel("教练号：");
	JComboBox jComboBox_id = new JComboBox<>();
	
	JLabel jLabel_name1 = new JLabel("姓名：");
	JTextField jTextField_name = new JTextField("");
	
	JLabel jLabel_sex1 = new JLabel("性别：");
	String array_sex[] = {"男","女"};
	JComboBox jComboBox_sex2 = new JComboBox<>(array_sex);
	JTextField jTextField_sex2 = new JTextField();
	
	JLabel jLabel_birhdate1 = new JLabel("出生年月：");
	String array_birthdate[] = {"1990-10-10","1890-06-10"};
	JComboBox jComboBox_birthdate = new JComboBox<>(array_birthdate);
	JTextField jTextField_birthdate = new JTextField();
	
	JLabel jLabel_phone1 = new JLabel("电话：");
	JTextField jTextField_phone2 = new JTextField("");
	
	
	JLabel jLabel_remark1 = new JLabel("备注：");
	JTextArea jTextArea_remark2 = new JTextArea(60, 75);
	
	JButton jButton_search = new JButton("查看");
	JButton jButton = new JButton("确认修改") ;
	public CoachManagementInfoChange() {
		// TODO Auto-generated constructor stub
		/*
		 * 回车键
		 * 监听登录
		 * 11/16
		 */
		this.getRootPane().setDefaultButton(jButton_search);
  
		setLayout(new GridBagLayout());
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
		//gridBagConstraints_1.weightx = 30;
		gridBagConstraints_1.fill = GridBagConstraints.HORIZONTAL;
		/*
		 * 将目前有的教练
		 * 全部列出
		 * 在添加班级的时候进行选择
		 * 11/6
		 * 19:34
		 */
		CoachDao coachDao = new CoachDaoImpl();
		List<Coach> list_allCoach = coachDao.allCoach();
		
		for (int i = 0; i < list_allCoach.size(); i++) {
			jComboBox_name.addItem(list_allCoach.get(i).getCoach_name());
		}
		container.add(jComboBox_name,gridBagConstraints_1);
		
		GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.gridy=0;
		gridBagConstraints_2.gridx=2;
		gridBagConstraints_2.insets = new Insets(0, 60, 0, 0);
		gridBagConstraints_2.fill=GridBagConstraints.HORIZONTAL;
		container.add(jButton_search,gridBagConstraints_2);
		
		
		GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		gridBagConstraints_3.gridy=0;
		gridBagConstraints_3.gridx=3;
		gridBagConstraints_3.insets = new Insets(0, 0, 0, 0);
		//gridBagConstraints_3.weightx=30;
		gridBagConstraints_3.fill = GridBagConstraints.HORIZONTAL; 
		//container.add(jComboBox_id,gridBagConstraints_3);
		
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
		jTextField_name.setEditable(false);
		container.add(jTextField_name,gridBagConstraints_333);
		
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
		jTextField_sex2.setEnabled(false);
		container.add(jTextField_sex2, gridBagConstraints_5);
		
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
		jTextField_birthdate.setEditable(false);
		container.add(jTextField_birthdate, gridBagConstraints_7);
		
		GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();
		gridBagConstraints_8.gridy=2;
		gridBagConstraints_8.gridx=2;
		gridBagConstraints_8.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_8.insets = new Insets(30, 60, 0, 0);
		container.add(jLabel_phone1, gridBagConstraints_8);
		
		GridBagConstraints gridBagConstraints_9 = new GridBagConstraints();
		gridBagConstraints_9.gridy=2;
		gridBagConstraints_9.gridx=3;
		gridBagConstraints_9.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_9.insets = new Insets(30, 0, 0, 0);
		container.add(jTextField_phone2, gridBagConstraints_9);
		
		GridBagConstraints gridBagConstraints_18 = new GridBagConstraints();
		gridBagConstraints_18.gridy=5;
		gridBagConstraints_18.gridx=0;
		gridBagConstraints_18.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_18.insets = new Insets(30, 0, 0, 0);
		container.add(jLabel_remark1, gridBagConstraints_18);
		
		GridBagConstraints gridBagConstraints_19 = new GridBagConstraints();
		gridBagConstraints_19.gridy=5;
		gridBagConstraints_19.gridx=1;
		gridBagConstraints_19.ipady=100;
		gridBagConstraints_19.ipadx=100;
		jTextArea_remark2.setLineWrap(true);
		gridBagConstraints_19.fill = GridBagConstraints.BOTH;
		gridBagConstraints_19.insets = new Insets(30, 0, 0, 0);
		container.add(new JScrollPane(jTextArea_remark2), gridBagConstraints_19);
		
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
				
				CoachDao coachDao = new CoachDaoImpl();
				List<Coach> list = new LinkedList();
				list=coachDao.queryoneCoach((String) jComboBox_name.getSelectedItem());
			
				jTextField_name.setText(list.get(0).getCoach_name());
				jTextField_sex2.setText(list.get(0).getCoach_sex());
				jTextField_birthdate.setText(list.get(0).getCoach_birth_date());
				jTextField_phone2.setText(list.get(0).getCoach_phone());
				jTextArea_remark2.setText(list.get(0).getCoach_remark());
			
			}
		});
		
		
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				CoachDao coachDao = new CoachDaoImpl();
				Coach coach = new Coach();
				
				coach.setCoach_name(jTextField_name.getText());
				coach.setCoach_sex(jTextField_sex2.getText());
				coach.setCoach_phone(jTextField_phone2.getText());
				coach.setCoach_birth_date(jTextField_birthdate.getText());
				coach.setCoach_remark(jTextArea_remark2.getText());
				
				
				coachDao.updateCoach(coach,jTextField_name.getText());
			  
				JOptionPane.showMessageDialog(null,"修改成功", "成功", JOptionPane.INFORMATION_MESSAGE);	
				
			}
		});
//		设置窗口
		setSize(500, 450);
		setTitle("教练员信息修改");
		//setResizable(false);
		setModal(true);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);// 窗口居中
	}
}
