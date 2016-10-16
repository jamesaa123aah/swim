package com.swimming.ui.login_register;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.swimming.ui.UiMain;

public class LoginUI extends JDialog{

	Container container = getContentPane();

//	用户名和密码框
	JLabel jLabel1 = new JLabel("用户名：");
	JTextField jTextField1 = new JTextField(15);
	JLabel jLabel2 = new JLabel("密    码：");
	JTextField jTextField2 = new JTextField(15);
	
//	按钮	
	JButton jButton1 = new JButton("登录");

	
	public LoginUI() {
		// TODO Auto-generated constructor stub
		
//		将组件加入界面
	    container.add(jLabel1);	   
	    container.add(jTextField1);
	    container.add(jLabel2);
	    container.add(jTextField2);
		container.add(jButton1);
		
		
//		登陆按钮监听事件
		jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				new UiMain();
				dispose();//本窗口销毁,释放内存资源
						
			}
		});
		
		
		setDefaultCloseOperation(2);
		setTitle("登录");
        setLayout(new FlowLayout(1,5,30));// 设置布局流式布局
		setVisible(true);
		setSize(300,240);
		setLocationRelativeTo(null);// 窗口居中
	}
}
