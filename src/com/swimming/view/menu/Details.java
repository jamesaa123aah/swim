package com.swimming.view.menu;

import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.swimming.dao.DetailOfAccountDao;
import com.swimming.dao.Impl.DetailOfAccountDaoImpl;
import com.swimming.model.DetailsOfAccount;

public class Details extends JDialog {

	
	private JTable table;
	private DefaultTableModel model;
	private DetailOfAccountDao detailOfAccountDao;
	
	
	JLabel jLabel = new JLabel("选择学员：");
	JComboBox jComboBox = new JComboBox();
	JButton jButton = new JButton("查看");
	public Details() {
		
		// TODO Auto-generated constructor stub
    Container container = getContentPane();
	
        jComboBox.addItem("张三");	
        jComboBox.addItem("李四");	
        jComboBox.addItem("王麻子");
    
        //container.add(jLabel);
        //container.add(jComboBox);
		//container.add(jButton);
		container.add(getJpanelThird2());
		
		
		setDefaultCloseOperation(2);
		setTitle("明细表");		
        setLayout(new FlowLayout(2,10,20));// 设置布局流式布局
	    setModal(true);
		setSize(540,350);		
		setLocationRelativeTo(null);// 窗口居中
	}


//	返回面板
	public JPanel getJpanelThird2() {
	
		
		/*
		 * 从数据库表中读取明细
		 * 11/6 18:48
		 */
		detailOfAccountDao = new DetailOfAccountDaoImpl();
		List<DetailsOfAccount> list_details = detailOfAccountDao.DetailsAccountInfoAll();
		
		int size = list_details.size();
		String [] columnNames= {" 姓 名 ","时      间","明细","剩余(钱/次数)"};
		Object [][] tableValues =new Object[size][4];
		
		
		for (int i = 0; i < size; i++) {
		
			tableValues[i][0]=list_details.get(i).getstu_name();
			tableValues[i][1]=list_details.get(i).getAccount_operation_date();
			tableValues[i][2]=list_details.get(i).getDetails();
			tableValues[i][3]=list_details.get(i).getMoney();
			
		}
		
		model = model = new DefaultTableModel(tableValues, columnNames);
		table = new JTable(model);
		
		int columncount = table.getColumnCount();
		
		
//          设置表格宽度
		          table.getColumnModel().getColumn(1).setPreferredWidth(80);

		        

		
		//JScrollPane scrollPane = new JScrollPane(table);
		
	    JScrollPane sp=new JScrollPane(table);
	    sp.setPreferredSize(new Dimension(499, 249));
		JPanel jPanel = new JPanel();
		jPanel.add(sp);	
		
		return jPanel;
		
	}

}
