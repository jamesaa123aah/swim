package com.swimming.model;

public class Attendance {
	int attendance_number;
	String stu_name;
	String attendance_date;
	int forget;
	public int getAttendance_number() {
		return attendance_number;
	}
	public void setAttendance_number(int attendance_number) {
		this.attendance_number = attendance_number;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getAttendance_date() {
		return attendance_date;
	}
	public void setAttendance_date(String attendance_date) {
		this.attendance_date = attendance_date;
	}
	public int getForget() {
		return forget;
	}
	public void setForget(int forget) {
		this.forget = forget;
	}
	
}
