package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDAO;
import com.niit.model.CartItem;


public class CartUnitTest
{
	static CartDAO cartDAO;

	
	@BeforeClass
	public static void executeFirst()
	{
			AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext();
			context.scan("com.niit.*");
			context.refresh();
			
			cartDAO=(CartDAO)context.getBean("cartDAO");
	}
	
	@Test
	public void addCartItem()
	{
		CartItem cartItem=new CartItem();
		
		cartItem.setProductId(1);
		cartItem.setOrderID(3);;
		cartItem.setQuantity(2);
		cartItem.setUsername("Joy");
		cartItem.setPaymentStatus("NP");
		cartItem.setSubTotal(986);
		
		assertTrue("Problem in Insertion",cartDAO.addCartItem(cartItem));

	}
	
}
