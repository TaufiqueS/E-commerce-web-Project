package com.niit.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.model.OrderDetails;

public class OrderDetailsDAOImpl implements OrderDetailsDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean confirmOrderDetails(OrderDetails orderDetails)
	{
		try
		{
			sessionFactory.getCurrentSession().save(orderDetails);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public List<OrderDetails> getOrderDetails(String username)
	{
	
		try
		{
			Session session=sessionFactory.openSession();
			Query query=(Query) session.createQuery("form OrderDetails where username=:username and paymentStatus='NP'");
			query.setParameter("username", username);
			List<OrderDetails> orderDetails=query.getResultList();
			return orderDetails;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public boolean updateOrderDetails(OrderDetails orderDetails)
	{
		try
		{
			sessionFactory.getCurrentSession().update(orderDetails);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

}
