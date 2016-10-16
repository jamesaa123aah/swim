package com.swimming.ui;

import java.awt.event.ActionEvent;   
import java.awt.event.ActionListener;   
import java.text.SimpleDateFormat;   
import java.util.Date;   
  
import javax.swing.JTextField;   
import javax.swing.Timer;   
import javax.swing.JFrame;   

public class NowTime 
{
	public JTextField time = new JTextField(11);
	//添加 显示时间的JTextField
	
	public NowTime() {
		// TODO Auto-generated constructor stub
		  setTimer(time);  
	}
	
    //设置Timer 1000ms实现一次动作 实际是一个线程   
   public void setTimer(JTextField time){   
        final JTextField varTime = time;   
        Timer timeAction = new Timer(1000, new ActionListener() {          
  
            public void actionPerformed(ActionEvent e) {       
                long timemillis = System.currentTimeMillis();   
                //转换日期显示格式   
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
                varTime.setText(df.format(new Date(timemillis)));   
            }      
        });            
        timeAction.start();        
    }   
  
  public JTextField get_time() {
	
	  return time;
}
 
}