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
                // ������д���Excel������
                String fileName = "book.xls";
               
                File file=new File(fileName);
                JFileChooser jfc=new JFileChooser();  
                jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
                jfc.setSelectedFile(file);
                retval = jfc.showSaveDialog(jfc);//��ʾ�������ļ����Ի���
                if(retval == JFileChooser.APPROVE_OPTION) {
                    file = jfc.getSelectedFile();
                    System.out.println("File to save " + file);
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                //��fileNameΪ�ļ���������һ��Workbook
                wwb = Workbook.createWorkbook(file);

                // ����������
                WritableSheet ws = wwb.createSheet("ѧԱ", 0);
                StudentDao studentdao=new StudentDaoImpl();
                //��ѯ���ݿ������е�����
                List<Student> list= studentdao.coursenameList(class_name);
               //Ҫ���뵽��Excel�����кţ�Ĭ�ϴ�0��ʼ
                Label labelName= new Label(0, 0, "����");//��ʾ��0��
                
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
    	    	
    	    	//����·����п�����Ϣ������,һ��һ������Jtable
    	    	for (int i = 0; i < number2; i++) {
    				
    	    		String name = list1.get(i).getStu_name();
    				String date = list1.get(i).getAttendance_date();
    				
    				/*
    				 * ���ڽ���
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
    				 * �ж��Ƿ���ѡ�е���
    				 */
    				if(year.equals(JpanelFirst.year)){
    				/*
    				 * �ж��Ƿ���
    				 * ѡ�еĿ����·�
    				 */
    					
    				if (month.equals(JpanelFirst.month)) {
    					//��������Jtable,�жϴ�ʱ���е�ѧ���Ƿ��п�����Ϣ,number ����ѧԱ
    					
    					for (int k = 0; k < list.size(); k++) {
    						
    						if(name.equals(list.get(k).getStu_name())){
    							//data[k][day+3]=list.get(i).getForget();
//    							����set ,����tag = true;
    							//System.out.println(list1.get(i).getStu_name());
    							Label labelattendance_i= new Label(day,k+1,String.valueOf(list1.get(i).getForget()));
    						
    							ws.addCell(labelattendance_i);
    						}
    					}
    				}
    				}
    				}
               //д���ĵ�
                wwb.write();
               // �ر�Excel����������
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
                 // ������д���Excel������
                 String fileName = "book.xls";
                
                 File file=new File(fileName);
                 JFileChooser jfc=new JFileChooser();  
                 jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
                 jfc.setSelectedFile(file);
                 retval = jfc.showSaveDialog(jfc);//��ʾ�������ļ����Ի���
                 if(retval == JFileChooser.APPROVE_OPTION) {
                     file = jfc.getSelectedFile();
                     System.out.println("File to save " + file);
                 }
                 if (!file.exists()) {
                     file.createNewFile();
                 }
                 //��fileNameΪ�ļ���������һ��Workbook
                 wwb = Workbook.createWorkbook(file);

                 // ����������
                 WritableSheet ws = wwb.createSheet("ѧԱ", 0);
                 StudentDao studentdao=new StudentDaoImpl();
                 //��ѯ���ݿ������е�����
                 List<Student> list= studentdao.allStudent();
                //Ҫ���뵽��Excel�����кţ�Ĭ�ϴ�0��ʼ
                 Label labelName= new Label(0, 0, "����");//��ʾ��0��
                 Label labelSex=new Label(1,0,"�Ա�");
                 Label labelDate=new Label(2,0,"��������");
                 Label labelSchool=new Label(3,0,"ѧУ");
                 Label labelPhone=new Label(4,0,"�绰");
                 Label labelClass=new Label(5,0,"�༶");
                 Label labelRemark=new Label(6,0,"��ע");

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
               
                //д���ĵ�
                 wwb.write();
                // �ر�Excel����������
                 wwb.close();
               
          } catch (Exception e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          } 
    }
}
