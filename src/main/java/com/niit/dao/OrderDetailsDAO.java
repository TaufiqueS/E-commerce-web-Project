package com.niit.dao;

import java.util.List;

import com.niit.model.OrderDetails;

public interface OrderDetailsDAO 
{

	public boolean confirmOrderDetails(OrderDetails orderDetails);
	public List<OrderDetails> getOrderDetails(String username);
	public boolean updateOrderDetails(OrderDetails orderDetails);
	
}
