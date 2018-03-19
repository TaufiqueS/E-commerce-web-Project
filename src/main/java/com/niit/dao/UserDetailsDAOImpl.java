package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Category;
import com.niit.model.UserDetails;

@Repository("UserDetailsDAO")
@Transactional
public class UserDetailsDAOImpl implements UserDetailsDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	
	public boolean addUserDetails(UserDetails userdetails)
	{
		System.out.println("Adding User Details");
			try
			{
			sessionFactory.getCurrentSession().save(userdetails);
		
			return true;
			}
			catch(Exception e)
			{
			System.out.println("Exception Arised ::"+e);
			return false;
			}
	}
	
	

	//deleteCategory()
	
	public boolean deleteUserDetails(UserDetails userdetails)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(userdetails);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised :"+e);
			return false;
		}
		
	}
	//listUserDetails()
	
	public List<UserDetails> listUserDetails()
	{
		Session session=(Session) sessionFactory.openSession();
		Query query=session.createQuery("from UserDetails");
		List<UserDetails> listUserDetails=(List<UserDetails>)query.list();
		return listUserDetails ;
	}



	public UserDetails getUserDetails(int userId)
	{
		
		Session session=sessionFactory.openSession();
		UserDetails userdetails=(UserDetails)session.get(UserDetails.class,userId);
		session.close();
		return userdetails;
	}



}


	
	
