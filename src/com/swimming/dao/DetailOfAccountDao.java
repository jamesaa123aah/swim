package com.swimming.dao;

import java.util.List;

import com.swimming.model.DetailsOfAccount;

public interface DetailOfAccountDao {
	public void DetailsAccount(DetailsOfAccount d);
	public List DetailsAccountInfoAll();
	public List DetailsAccountInfoOfOne(String stu_name);
}
