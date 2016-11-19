package com.swimming.view.menu.sub;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream.GetField;
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

public class CoachManagementIncrease extends JDialog {

	JLabel jLabel_name = new JLabel("������");
	JTextField jTextField_name = new JTextField(8);
	
	JLabel jLabel_sex = new JLabel("�Ա�");
	String array_sex[] = {"��","Ů"};
	JComboBox jComboBox_sex = new JComboBox(array_sex);
	
	JLabel jLabel_birth_date = new JLabel("��������: ");
	String array_date[] = {"1995-08-05"};
	JComboBox jComboBox2 = new JComboBox(get_year());
	JComboBox jComboBox3 = new JComboBox(get_month());
	JComboBox jComboBox_birth_date = new JComboBox<>(array_date);
	JTextField jTextField_birth_date = new JTextField(8);
	
	JLabel jLabel_phone = new JLabel("�绰��");
	JTextField jTextField_phone = new JTextField(8);
		
	JLabel jLabel_remark = new JLabel("��ע��");
	JTextArea jTextArea_remark = new JTextArea();
	
	JButton jButton_confirm = new JButton("ȷ������");
	
	
	
	public CoachManagementIncrease() {
		// TODO Auto-generated constructor stub
		
		
//		����������������
		jLabel_name.setSize(40, 30);
		jLabel_name.setLocation(5, 5);
		add(jLabel_name);
		jTextField_name.setSize(100, 25);
		jTextField_name.setLocation(60, 10);
		add(jTextField_name);
		
//		�����Ա�ѡ������
		jLabel_sex.setSize(40, 25);
		jLabel_sex.setLocation(220, 5);
		add(jLabel_sex);
		jComboBox_sex.setSize(40, 30);
		jComboBox_sex.setLocation(260, 5);
		add(jComboBox_sex);
		
//		���ӳ�������
		jLabel_birth_date.setSize(60, 25);
		jLabel_birth_date.setLocation(5, 60);
		add(jLabel_birth_date);
		jTextField_birth_date.setSize(100, 30);
		jTextField_birth_date.setLocation(65, 60);
		//add(jComboBox_birth_date);
		add(jTextField_birth_date);
		
//		���ӵ绰����
		jLabel_phone.setSize(40, 25);
		jLabel_phone.setLocation(220,60);
		add(jLabel_phone);
		jTextField_phone.setSize(100, 25);
		jTextField_phone.setLocation(260, 60);
		add(jTextField_phone);
		
		
//		��ע
		jLabel_remark.setSize(40,200);
		jLabel_remark.setLocation(5, 100);
		add(jLabel_remark);
		jTextArea_remark.setSize(300, 200);
		jTextArea_remark.setLocation(45,100);
		jTextArea_remark.setLineWrap(true);
		JScrollPane js=new JScrollPane(jTextArea_remark);
		js.setSize(300, 200);
		js.setLocation(45,100);
		add(js);
		
//		ȷ�ϰ�ť
		jButton_confirm.setSize(90,30);
		jButton_confirm.setLocation(160, 320);
		add(jButton_confirm);
		
		
		
		jButton_confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				List<String> list_coach = new LinkedList<String>();
				
				list_coach = getCoachInfo();
				
				
				Coach coach = new Coach();
				coach.setCoach_name(list_coach.get(0));
				coach.setCoach_sex(list_coach.get(1));
				coach.setCoach_phone(list_coach.get(2));
				coach.setCoach_birth_date(list_coach.get(3));
				coach.setCoach_remark(list_coach.get(4));
				
				CoachDao coachDao = new CoachDaoImpl();
				coachDao.addCoach(coach);
				JOptionPane.showMessageDialog(null,"�����ɹ�", "�ɹ�", JOptionPane.INFORMATION_MESSAGE);	
				dispose();
			}
		});
		
		
//		�Ի�������
		setResizable(false);
		setDefaultCloseOperation(2);
		setTitle("��������Ա");		
        setLayout(null);// ���ò���
	    setModal(true);
		setSize(400,400);		
		setLocationRelativeTo(null);// ���ھ���
	}
	
	
	private  List getCoachInfo(){
		
		List<String> list_coach = new LinkedList<String>();
		
		//0.coach name 1.sex 2.phone 3.coach_birth 4.coach remark
 		list_coach.add(jTextField_name.getText());
		list_coach.add((String)jComboBox_sex.getSelectedItem());
		list_coach.add(jTextField_phone.getText());
		list_coach.add(jTextField_birth_date.getText());
		list_coach.add(jTextArea_remark.getText());
		
		
		
		
		return list_coach;
	}
	
	/*
	 *   �����������·ݵĴ���
	 *   ����һ����ݺ��·�����
	 *   ���ظ��ϱߵ�combox
	 */

	private String[] get_year() {
		// TODO Auto-generated method stub
		String[] arry = new String[201];
	    for (int i = 2015; i < 2201; i++) {
	        arry[i-2015] = i+"��";
	    }
	    return arry;
	}

	private String[] get_month() {
		// TODO Auto-generated method stub
		String[] arry = new String[12];
	    for (int i = 1; i < 13; i++) {
	        arry[i-1] = i+"��";
	    }
	    return arry;
	}
	

}
