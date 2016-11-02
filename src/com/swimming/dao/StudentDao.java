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
}