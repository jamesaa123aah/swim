package com.swimming.dao;

import java.util.List;

import com.swimming.model.Attendance;

public interface AttendanceDao {
	public void stuAttend(Attendance a);
	public List Attendance();
	public List forgetAttendance();
	public void setForgetToAttendance(int attendance_number);
}
