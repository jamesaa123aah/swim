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

	
//	��������
	JLabel jLabel_name = new JLabel("������");	
	JComboBox jComboBox_name = new JComboBox<>();
	JTextField jTextField_name = new JTextField(10);
	
//	����Ա��
	JLabel jLabel_id = new JLabel("�����ţ�");
	String[] array_id = {"0005","0032","0086"};
	JComboBox jComboBox_id = new JComboBox<>(array_id);
	
	
//	��ť
	JButton jButton_confirm = new JButton("ȷ��ɾ��");
	public CoachManagementDelete() {
		// TODO Auto-generated constructor stub
		

		
		Container container = getContentPane();
		
//		����
		jLabel_name.setSize(90, 25);
		jLabel_name.setLocation(25, 10);
		container.add(jLabel_name);
		
		/*
		 * ��Ŀǰ�еĽ���
		 * ȫ���г�
		 * ����Ӱ༶��ʱ�����ѡ��
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
		
//		����Ա��
		jLabel_id.setSize(100,30);
		jLabel_id.setLocation(25, 50);
		//container.add(jLabel_id);
		jComboBox_id.setSize(100, 25);
		jComboBox_id.setLocation(80,50);
		//container.add(jComboBox_id);
		
//		��ť
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
//				ѧ����ʱ��ʹ��
				coachDao.deleteCoach((String) jComboBox_name.getSelectedItem());
				JOptionPane.showMessageDialog(null,"ɾ���ɹ�", "�ɹ�", JOptionPane.INFORMATION_MESSAGE);	
//				System.out.println("222222");
//				dispose();
			}
		});
//		���ô���
		setSize(250, 220);
		setTitle("����Աɾ��");
		//setResizable(false);
		setLayout(null);
		setModal(true);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);// ���ھ���
	}
}
