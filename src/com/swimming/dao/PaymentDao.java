package com.swimming.dao;

import java.util.List;

import com.swimming.model.Payment;

public interface PaymentDao {
	public void ChangeMoneyandTime(Payment p);
	public List MoneyandTime(String stu_name);
}
