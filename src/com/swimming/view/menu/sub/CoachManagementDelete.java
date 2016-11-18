package com.swimming.view.menu.sub;

import java.awt.Container;
import java.awt.GridBagLayout;
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
import com.swimming.dao.Impl.CoachDaoImpl;
import com.swimming.model.Coach;

public class CoachManagementDelete extends JDialog {

	
//	姓名区域
	JLabel jLabel_name = new JLabel("姓名：");	
	JComboBox jComboBox_name = new JComboBox<>();
	JTextField jTextField_name = new JTextField(10);
	
//	教练员号
	JLabel jLabel_id = new JLabel("教练号：");
	String[] array_id = {"0005","0032","0086"};
	JComboBox jComboBox_id = new JComboBox<>(array_id);
	
	
//	按钮
	JButton jButton_confirm = new JButton("确认删除");
	public CoachManagementDelete() {
		// TODO Auto-generated constructor stub
		

		
		Container container = getContentPane();
		
//		姓名
		jLabel_name.setSize(90, 25);
		jLabel_name.setLocation(25, 10);
		container.add(jLabel_name);
		
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
			jComboBox_name.addItem(list_allCoach.get(i).getCoach_name());
		}
		jComboBox_name.setSize(100, 25);
		jComboBox_name.setLocation(80, 10);				
		jComboBox_name.setEditable(true);
		container.add(jComboBox_name);
		
//		教练员号
		jLabel_id.setSize(100,30);
		jLabel_id.setLocation(25, 50);
		//container.add(jLabel_id);
		jComboBox_id.setSize(100, 25);
		jComboBox_id.setLocation(80,50);
		//container.add(jComboBox_id);
		
//		按钮
		jButton_confirm.setSize(100,30);
		jButton_confirm.setLocation(80, 110);
		container.add(jButton_confirm);
		
		
		jButton_confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("000");
				CoachDao coachDao = new CoachDaoImpl();
				System.out.println("1111111");
//				学号暂时不使用
				coachDao.deleteCoach((String) jComboBox_name.getSelectedItem());
				JOptionPane.showMessageDialog(null,"删除成功", "成功", JOptionPane.INFORMATION_MESSAGE);	
//				System.out.println("222222");
//				dispose();
			}
		});
//		设置窗口
		setSize(250, 220);
		setTitle("教练员删除");
		//setResizable(false);
		setLayout(null);
		setModal(true);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);// 窗口居中
	}
}
