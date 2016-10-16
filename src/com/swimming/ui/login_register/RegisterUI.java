package com.swimming.ui.login_register;

import java.awt.FlowLayout;

import javax.swing.JDialog;

public class RegisterUI extends JDialog {

	public RegisterUI() {
		// TODO Auto-generated constructor stub
		
		setLocationRelativeTo(null);// 窗口居中
		setDefaultCloseOperation(2);
        setLayout(new FlowLayout());// 设置布局流式布局
		setVisible(true);
		setSize(200,200);
	}
}
