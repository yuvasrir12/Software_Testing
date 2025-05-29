package com.ex;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class OrderServiceIntegrationTest {
	@Test
	public void testOrderPlacedSuccessfully()
	{
	PaymentService paymentService = new PaymentService();
	OrderService orderService = new OrderService(paymentService);
	String result = orderService.placeOrder("ORD123", 500); // Within limit
	assertEquals("Order placed successfully for orderId: ORD123", result);
	}
	@Test
	public void testOrderFailedDueToPaymentFailure()
	{
	PaymentService paymentService = new PaymentService();
	OrderService orderService = new OrderService(paymentService);
	String result = orderService.placeOrder("ORD124", 1500); // Exceeds limit
	assertEquals("Payment failed. Order not placed for orderId: ORD124", result);
	}
	//add this for regression testing
	 @Test
	    public void testEdgeCaseOrderAtLimit() {
	        PaymentService paymentService = new PaymentService();
	        OrderService orderService = new OrderService(paymentService);

	        // Regression test: Edge case at exactly 1000
	        String result = orderService.placeOrder("ORD003", 1000);
	        assertEquals("Order placed successfully for orderId: ORD003", result);
	    }

}
