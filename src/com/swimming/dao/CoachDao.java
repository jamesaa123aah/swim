package com.swimming.dao;

import java.util.List;

import com.swimming.model.Coach;

public interface CoachDao {
	public void addCoach(Coach c);
	public List allCoach();
	public void deleteCoach(String coach_name);
	public void updateCoach(Coach c,String oldname);
	public List queryoneCoach(String coach_name);
}
