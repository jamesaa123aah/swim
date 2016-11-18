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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.swimming.dao.CoachDao;
import com.swimming.dao.Impl.CoachDaoImpl;
import com.swimming.model.Coach;

public class CoachManagementInfoLook extends JDialog {

	JLabel jLabel_name = new JLabel("������");
	JComboBox jComboBox_name = new JComboBox<>();
	JTextField jTextField_name = new JTextField();
	
	//JLabel jLabel_id = new JLabel("�����ţ�");
	//JComboBox jComboBox_id = new JComboBox<>();
	
	
	JLabel jLabel_name1 = new JLabel("������");
	JLabel jLabel_name2 = new JLabel("");
	
	JLabel jLabel_sex1 = new JLabel("�Ա�");
	JLabel jLabel_sex2 = new JLabel("");
	
	JLabel jLabel_birhdate1 = new JLabel("�������£�");
	JLabel jLabel_birhdate2 = new JLabel("");
	
	JLabel jLabel_phone1 = new JLabel("�绰��");
	JLabel jLabel_phone2 = new JLabel("");
	
	
	JLabel jLabel_remark1 = new JLabel("��ע��");
	JTextArea jTextArea_remark2 = new JTextArea(60, 75);
	
	JButton jButton = new JButton("�鿴") ;
	
	
	public CoachManagementInfoLook() {
		// TODO Auto-generated constructor stub
		/*
		 * �س���
		 * ������¼
		 * 11/16
		 */
		this.getRootPane().setDefaultButton(jButton);
		
   setLayout(new GridBagLayout());		
   Container container = getContentPane();
   
    GridBagConstraints gridBagConstraints_0 = new GridBagConstraints();
    gridBagConstraints_0.gridy = 0;
	gridBagConstraints_0.gridx=0;
	gridBagConstraints_0.fill = GridBagConstraints.HORIZONTAL;
	container.add(jLabel_name,gridBagConstraints_0);
	
	
	GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
	gridBagConstraints_1.gridy = 0;
	gridBagConstraints_1.gridx = 1;
	gridBagConstraints_1.insets = new Insets(0, 0, 0, 0);
	gridBagConstraints_1.fill = GridBagConstraints.HORIZONTAL;
	
	/*
	 * ��Ŀǰ�еĽ���
	 * ȫ���г�
	 * ����Ӱ༶��ʱ�����ѡ��
	 * 11/6
	 * 19:34
	 */
	CoachDao coachDao = new CoachDaoImpl();
	List<Coach> list_allCoach = coachDao.allCoach();
	
	for (int i = 0; i < list_allCoach.size(); i++) {
		jComboBox_name.addItem(list_allCoach.get(i).getCoach_name());
	}
	container.add(jComboBox_name,gridBagConstraints_1);
	//container.add(jTextField_name,gridBagConstraints_1);
	
	
	GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
	gridBagConstraints_2.gridy=0;
	gridBagConstraints_2.gridx=2;
	gridBagConstraints_2.insets = new Insets(0, 30, 0, 0);
	gridBagConstraints_2.fill=GridBagConstraints.HORIZONTAL;
	//container.add(jLabel_id,gridBagConstraints_2);
	
	
	GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
	gridBagConstraints_3.gridy=0;
	gridBagConstraints_3.gridx=3;
	gridBagConstraints_3.weightx=20;
	gridBagConstraints_3.insets = new Insets(0, 0, 0, 0);
	gridBagConstraints_3.fill = GridBagConstraints.HORIZONTAL;
	//container.add(jComboBox_id,gridBagConstraints_3);
  
	GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
	gridBagConstraints_4.gridy=1;
	gridBagConstraints_4.gridx=0;
	gridBagConstraints_4.fill = GridBagConstraints.HORIZONTAL;
	gridBagConstraints_4.insets = new Insets(30, 0, 0, 0);
	container.add(jLabel_sex1, gridBagConstraints_4);
	
	GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
	gridBagConstraints_5.gridy=1;
	gridBagConstraints_5.gridx=1;
	gridBagConstraints_5.fill = GridBagConstraints.HORIZONTAL;
	gridBagConstraints_5.insets = new Insets(30, 0, 0, 0);
	container.add(jLabel_sex2, gridBagConstraints_5);

	GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
	gridBagConstraints_6.gridy=1;
	gridBagConstraints_6.gridx=2;
	gridBagConstraints_6.insets = new Insets(30, 30, 0, 0);
	gridBagConstraints_6.fill = GridBagConstraints.HORIZONTAL;
	container.add(jLabel_birhdate1, gridBagConstraints_6);
	
	GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();
	gridBagConstraints_7.gridy=1;
	gridBagConstraints_7.gridx=3;
	gridBagConstraints_7.fill = GridBagConstraints.HORIZONTAL;
	gridBagConstraints_7.insets = new Insets(30, 0, 0, 0);
	container.add(jLabel_birhdate2, gridBagConstraints_7);

	GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();
	gridBagConstraints_8.gridy=2;
	gridBagConstraints_8.gridx=0;
	gridBagConstraints_8.fill = GridBagConstraints.HORIZONTAL;
	gridBagConstraints_8.insets = new Insets(30, 0, 0, 0);
	container.add(jLabel_phone1, gridBagConstraints_8);
	
	GridBagConstraints gridBagConstraints_9 = new GridBagConstraints();
	gridBagConstraints_9.gridy=2;
	gridBagConstraints_9.gridx=1;
	gridBagConstraints_9.fill = GridBagConstraints.HORIZONTAL;
	gridBagConstraints_9.insets = new Insets(30, 0, 0, 0);
	container.add(jLabel_phone2, gridBagConstraints_9);
	
	GridBagConstraints gridBagConstraints_10 = new GridBagConstraints();
	gridBagConstraints_10.gridy=3;
	gridBagConstraints_10.gridx=0;
	gridBagConstraints_10.fill = GridBagConstraints.HORIZONTAL;
	gridBagConstraints_10.insets = new Insets(30, 0, 0, 0);
	container.add(jLabel_remark1, gridBagConstraints_10);
	
	GridBagConstraints gridBagConstraints_11 = new GridBagConstraints();
	gridBagConstraints_11.gridy=3;
	gridBagConstraints_11.gridx=1;
	gridBagConstraints_11.ipady=100;
	gridBagConstraints_11.ipadx=100;
	gridBagConstraints_11.fill = GridBagConstraints.HORIZONTAL;
	gridBagConstraints_11.insets = new Insets(30, 0, 0, 0);
	jTextArea_remark2.setLineWrap(true);
	container.add(new JScrollPane(jTextArea_remark2), gridBagConstraints_11);
	
	GridBagConstraints gridBagConstraints_12 = new GridBagConstraints();
	gridBagConstraints_12.gridy=0;
	gridBagConstraints_12.gridx=3;
	gridBagConstraints_12.weighty=30;
	gridBagConstraints_12.fill = GridBagConstraints.HORIZONTAL;
	container.add(jButton,gridBagConstraints_12);
	
//	��ť��Ӧ
	jButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			CoachDao coachDao = new CoachDaoImpl();
			List<Coach> list = new LinkedList();
			list=coachDao.queryoneCoach((String) jComboBox_name.getSelectedItem());
		
			
			jLabel_sex2.setText(list.get(0).getCoach_sex());
			jLabel_birhdate2.setText(list.get(0).getCoach_birth_date());
			jLabel_phone2.setText(list.get(0).getCoach_phone());
			jTextArea_remark2.setText(list.get(0).getCoach_remark());
			
			//dispose();
		}
	});
	
//		���ô���
		setSize(500, 360);
		setTitle("����Ա��Ϣ�鿴");
		//setResizable(false);
		setModal(true);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);// ���ھ���
	}
}
