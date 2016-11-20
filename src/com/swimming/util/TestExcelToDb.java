package com.swimming.util;

import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;

import com.swimming.dao.StudentDao;
import com.swimming.dao.Impl.StudentDaoImpl;
import com.swimming.model.Student;

/**
 * @author Javen
 * @Email zyw205@gmail.com
 * 
 */
public class TestExcelToDb {
    public static void main(String[] args) {
        //得到表格中所有的数据
    	
    }
    public void ExcelToDb(){
    	StudentDao studentdao=new StudentDaoImpl();
    	int retval=0;
    	 File file=new File("");
         JFileChooser jfc=new JFileChooser();  
         jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
         jfc.setSelectedFile(file);
         retval = jfc.showOpenDialog(jfc);//显示“保存文件”对话框
         if(retval == JFileChooser.APPROVE_OPTION) {
             file = jfc.getSelectedFile();
             System.out.println("File to open " + file);
         }
        List<Student> listExcel=studentdao.getAllByExcel(file);
        List<Student> list=studentdao.allStudent();
        /*//得到数据库表中所有的数据
        List<StuEntity> listDb=StuService.getAllByDb();*/
        
    
        for (Student stuEntity : listExcel) {
        	  int tag = 0;
            for (Student student : list) {
				if(student.getStu_name().equals(stuEntity.getStu_name())){
					tag = 1;
					break;

				}

			}
			if (tag == 0) {
				studentdao.addStu(stuEntity);
			}

        }
    }
}