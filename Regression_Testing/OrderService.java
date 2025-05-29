package com.ex;

public class OrderService {
	private PaymentService paymentService;
	public OrderService(PaymentService paymentService)
	{
	this.paymentService = paymentService;
	}

	public String placeOrder(String orderId, double amount)
	{
	boolean paymentSuccess = paymentService.processPayment(orderId, amount);
	if (paymentSuccess) {
	return "Order placed successfully for orderId: " + orderId;
	} else {
	return "Payment failed. Order not placed for orderId: " + orderId;
	}
	}

}
