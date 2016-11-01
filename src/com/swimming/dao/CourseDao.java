package com.swimming.dao;

import java.util.List;

import com.swimming.model.Course;

public interface CourseDao {
	public void addClass(Course c);
	public List allClass();
	public void deleteClass(String cousre_name);
	public void updateClass(Course c,String course_name);
	public List queryoneClass(String course_name);
}
