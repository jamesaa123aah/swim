package com.swimming.view.menu.sub;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.swimming.dao.CourseDao;
import com.swimming.dao.Impl.CourseDaoImpl;
import com.swimming.model.Course;

public class ClassManagementDelete extends JDialog {

	JLabel jLabel_className = new JLabel("�༶����");
	JComboBox jComboBox_class = new JComboBox();
	JTextField jTextField_className = new JTextField();
	
	JLabel jLabel_classID = new JLabel("�༶�ţ�");
	JComboBox jComboBox_classID = new JComboBox();
	
	JButton jButton = new JButton("ȷ��ɾ��");
	
	
	
	public ClassManagementDelete() {
		// TODO Auto-generated constructor stub
		setLayout(new GridBagLayout());		
		Container container = getContentPane();
		
		GridBagConstraints gridBagConstraints_0 = new GridBagConstraints();
		gridBagConstraints_0.gridy=0;
		gridBagConstraints_0.gridx=0;
		gridBagConstraints_0.insets = new Insets(30, 0, 0, 0);
		gridBagConstraints_0.fill = GridBagConstraints.HORIZONTAL;
		container.add(jLabel_className,gridBagConstraints_0);
		
		GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.gridy=0;
		gridBagConstraints_1.gridx=1;
		gridBagConstraints_1.ipadx=50;
		gridBagConstraints_1.insets = new Insets(30, 0, 0, 0);
		gridBagConstraints_1.fill = GridBagConstraints.HORIZONTAL;
		/*
		 * 
		 * ��ѡ��༶ʱ��
		 * �����ݿ��ṩ���еİ༶
		 */
		CourseDao courseDao = new CourseDaoImpl();
		List<Course> list_class=courseDao.allClass();
		
		for (int i = 0;i<list_class.size();i++) {
			jComboBox_class.addItem(list_class.get(i).getClass_name());
		}
		container.add(jComboBox_class,gridBagConstraints_1);
		
		
		GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.gridy=1;
		gridBagConstraints_2.gridx=0;
		gridBagConstraints_2.insets = new Insets(30, 0, 0, 0);
		gridBagConstraints_2.fill = GridBagConstraints.HORIZONTAL;
//		container.add(jLabel_classID,gridBagConstraints_2);
		
		GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		gridBagConstraints_3.gridy=1;
		gridBagConstraints_3.gridx=1;
		gridBagConstraints_3.ipadx=100;
		gridBagConstraints_3.insets = new Insets(30, 0, 0, 0);
		gridBagConstraints_3.fill = GridBagConstraints.HORIZONTAL;
//		container.add(jComboBox_classID,gridBagConstraints_3);
		
		GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.gridy=2;
		gridBagConstraints_6.gridx=1;
		gridBagConstraints_6.insets = new Insets(30, 0, 0, 0);
		gridBagConstraints_6.fill = GridBagConstraints.HORIZONTAL;
		container.add(jButton,gridBagConstraints_6);
		
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CourseDao courseDao = new CourseDaoImpl();
				
				//courseDao.deleteClass(jTextField_className.getText());
				courseDao.deleteClass((String) jComboBox_class.getSelectedItem());
				JOptionPane.showMessageDialog(null,"ɾ���ɹ�", "�ɹ�", JOptionPane.INFORMATION_MESSAGE);	
				//courseDao.deleteClass(cousre_name);
			}
		});
//		���ô���
		setSize(250, 230);
		setTitle("�༶ɾ��");
		//setResizable(false);
		setModal(true);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);// ���ھ���
	}
}
