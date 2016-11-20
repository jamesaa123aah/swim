package com.swimming.util;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;










import javax.swing.JFileChooser;
import javax.swing.JLabel;

import com.swimming.dao.AttendanceDao;
import com.swimming.dao.PaymentDao;
import com.swimming.dao.StudentDao;
import com.swimming.dao.Impl.AttendanceDaoImpl;
import com.swimming.dao.Impl.PaymentDaoImpl;
import com.swimming.dao.Impl.StudentDaoImpl;
import com.swimming.model.Attendance;
import com.swimming.model.Payment;
import com.swimming.model.Student;
import com.swimming.view.panel.JpanelFirst;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class TestDbToExcel {
	public void AttendanceDbToExcel(String class_name){
		 try {
             WritableWorkbook wwb = null;
             	int retval;
                // 创建可写入的Excel工作簿
                String fileName = "book.xls";
               
                File file=new File(fileName);
                JFileChooser jfc=new JFileChooser();  
                jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
                jfc.setSelectedFile(file);
                retval = jfc.showSaveDialog(jfc);//显示“保存文件”对话框
                if(retval == JFileChooser.APPROVE_OPTION) {
                    file = jfc.getSelectedFile();
                    System.out.println("File to save " + file);
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                //以fileName为文件名来创建一个Workbook
                wwb = Workbook.createWorkbook(file);

                // 创建工作表
                WritableSheet ws = wwb.createSheet("学员", 0);
                StudentDao studentdao=new StudentDaoImpl();
                //查询数据库中所有的数据
                List<Student> list= studentdao.coursenameList(class_name);
               //要插入到的Excel表格的行号，默认从0开始
                Label labelName= new Label(0, 0, "姓名");//表示第0个
                
                for(int i=0;i<31;i++){
                	Label labelDay_i=new Label(i+1,0,String.valueOf(i+1));
                	ws.addCell(labelDay_i);
                }
                

                ws.addCell(labelName);
               
//                ws.addCell(labelName);
//                ws.addCell(labelSex);
//                ws.addCell(labelNum);
              
                for (int i = 0; i < list.size(); i++) {
                    
                    Label labelName_i= new Label(0, i+1, list.get(i).getStu_name()+"");
                   
                    ws.addCell(labelName_i);
                    
                }
                AttendanceDao attendanceDao = new AttendanceDaoImpl();
    	    	List<Attendance> list1 = new LinkedList<Attendance>();
    	    	list1 = attendanceDao.Attendance();
    	    	int number2 = list1.size();
    	    	
    	    	//这个月份所有考勤信息的条数,一条一条放入Jtable
    	    	for (int i = 0; i < number2; i++) {
    				
    	    		String name = list1.get(i).getStu_name();
    				String date = list1.get(i).getAttendance_date();
    				
    				/*
    				 * 日期解析
    				 */
    				List<String> list_date= new ArrayList<>();
    				list_date.add(date.substring(0, 4));
    				list_date.add(date.substring(5, 7));
    				list_date.add(date.substring(8, 10));
    				
    				String year = list_date.get(0);
    				String month = list_date.get(1);
    				if (month.length()==1) {
    					month="0"+month;
    				}
    				int day = Integer.parseInt(list_date.get(2));
    				
    				/*
    				 * 判断是否是选中的年
    				 */
    				if(year.equals(JpanelFirst.year)){
    				/*
    				 * 判断是否是
    				 * 选中的考勤月份
    				 */
    					
    				if (month.equals(JpanelFirst.month)) {
    					//检索整个Jtable,判断此时表中的学生是否有考勤信息,number 所有学员
    					
    					for (int k = 0; k < list.size(); k++) {
    						
    						if(name.equals(list.get(k).getStu_name())){
    							//data[k][day+3]=list.get(i).getForget();
//    							机器set ,所有tag = true;
    							//System.out.println(list1.get(i).getStu_name());
    							Label labelattendance_i= new Label(day,k+1,String.valueOf(list1.get(i).getForget()));
    						
    							ws.addCell(labelattendance_i);
    						}
    					}
    				}
    				}
    				}
               //写进文档
                wwb.write();
               // 关闭Excel工作簿对象
                wwb.close();
              
         } catch (Exception e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } 
	}
    
    public void DbToExcel(){
    	  try {
              WritableWorkbook wwb = null;
              	int retval;
                 // 创建可写入的Excel工作簿
                 String fileName = "book.xls";
                
                 File file=new File(fileName);
                 JFileChooser jfc=new JFileChooser();  
                 jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
                 jfc.setSelectedFile(file);
                 retval = jfc.showSaveDialog(jfc);//显示“保存文件”对话框
                 if(retval == JFileChooser.APPROVE_OPTION) {
                     file = jfc.getSelectedFile();
                     System.out.println("File to save " + file);
                 }
                 if (!file.exists()) {
                     file.createNewFile();
                 }
                 //以fileName为文件名来创建一个Workbook
                 wwb = Workbook.createWorkbook(file);

                 // 创建工作表
                 WritableSheet ws = wwb.createSheet("学员", 0);
                 StudentDao studentdao=new StudentDaoImpl();
                 //查询数据库中所有的数据
                 List<Student> list= studentdao.allStudent();
                //要插入到的Excel表格的行号，默认从0开始
                 Label labelName= new Label(0, 0, "姓名");//表示第0个
                 Label labelSex=new Label(1,0,"性别");
                 Label labelDate=new Label(2,0,"出生日期");
                 Label labelSchool=new Label(3,0,"学校");
                 Label labelPhone=new Label(4,0,"电话");
                 Label labelClass=new Label(5,0,"班级");
                 Label labelRemark=new Label(6,0,"备注");

                 ws.addCell(labelName);
                 ws.addCell(labelSex);
                 ws.addCell(labelDate);
                 ws.addCell(labelSchool);
                 ws.addCell(labelPhone);
                 ws.addCell(labelClass);
                 ws.addCell(labelRemark);
//                 ws.addCell(labelName);
//                 ws.addCell(labelSex);
//                 ws.addCell(labelNum);
               
                 for (int i = 0; i < list.size(); i++) {
                     
                     Label labelName_i= new Label(0, i+1, list.get(i).getStu_name()+"");
                     Label labelSex_i=new Label(1,i+1,list.get(i).getStu_sex()+"");
                     Label labelDate_i=new Label(2,i+1,list.get(i).getStu_birthDate()+"");
                     Label labelSchool_i=new Label(3,i+1,list.get(i).getStu_school()+"");
                     Label labelPhone_i=new Label(4,i+1,list.get(i).getStu_phone());
                     Label labelClass_i=new Label(5,i+1,list.get(i).getClass_name());
                     Label labelRemark_i=new Label(6,i+1,list.get(i).getStu_remark());
                     ws.addCell(labelName_i);
                     ws.addCell(labelSex_i);
                     ws.addCell(labelDate_i);
                     ws.addCell(labelSchool_i);
                     ws.addCell(labelPhone_i);
                     ws.addCell(labelClass_i);
                     ws.addCell(labelRemark_i);
                 }
               
                //写进文档
                 wwb.write();
                // 关闭Excel工作簿对象
                 wwb.close();
               
          } catch (Exception e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          } 
    }
}
