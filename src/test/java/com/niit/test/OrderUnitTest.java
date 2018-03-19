package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDAO;
import com.niit.dao.OrderDetailsDAO;
import com.niit.model.OrderDetails;

public class OrderUnitTest
{

static OrderDetailsDAO orderDetailsDAO;

	
	@BeforeClass
	public static void executeFirst()
	{
			AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext();
			context.scan("com.niit.*");
			context.refresh();
			
			orderDetailsDAO=(OrderDetailsDAO)context.getBean("orderDetailsDAO");
	}
	
	@Test
	public void addOrderDerails()
	{
		OrderDetails orderDetails=new OrderDetails();
		
		orderDetails.setShippingAddr("Niit");
		assertTrue("Problem in Order Details Insertion ",orderDetailsDAO.confirmOrderDetails(orderDetails));     
		
	}
	
}
