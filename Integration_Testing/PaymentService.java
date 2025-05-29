package com.ex;

public class PaymentService {
	public boolean processPayment(String orderId, double amount)
	{
	return amount <= 1000; // Payment succeeds if <= 1000
	}

}
