package com.swimming.dao;

import java.util.List;

import com.swimming.model.Coach;
import com.swimming.model.Student;

public interface StudentDao {
	public void addStu(Student stu);
	public void deleteStu(String stu_name);
	public List getLookStu(String stuName);
	public void changeStu(Student student,String oldname);
	public List allStudent(); 
	public List mistStudent(String strName);
	public List nameList();
	public List StudentList(String coursename);
	public List coursenameList(String class_name);//每个班级的姓名排序
}
