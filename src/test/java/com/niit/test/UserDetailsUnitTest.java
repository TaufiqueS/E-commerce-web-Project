package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.dao.UserDetailsDAO;
import com.niit.model.Category;
import com.niit.model.UserDetails;


public class UserDetailsUnitTest 
{
	static UserDetailsDAO userDetailsDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
			AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext();
			context.scan("com.niit.*");
			context.refresh();
			
			userDetailsDAO=(UserDetailsDAO)context.getBean("userDetailsDAO");
	}
	
	
	@Test
	public void addUserDetailsTest()
	{
		UserDetails userdetails=new UserDetails();
		//category.setCategoryId(categoryId);
		userdetails.setMobileNo("8425025021");
		userdetails.setUsername("Joy");
		userdetails.setEnable(true);
		userdetails.setPassword("Welcome");
		userdetails.setRole("ROLE_ADMIN");
		userdetails.setEmailId("joy@gmail.com");
		assertTrue("Problem in Category Insertion",userDetailsDAO.addUserDetails(userdetails));
	}
	
	@Ignore
	@Test
	public void deletUserDetailsTest()
	{
		UserDetails userdetails=userDetailsDAO.getUserDetails(2);
		assertTrue("Problem in Deletion:",userDetailsDAO.deleteUserDetails(userdetails));
	}
	
	@Ignore
	@Test
	public void getUserDetailsTest()
	{
		assertNotNull("Problem in get Category",userDetailsDAO.getUserDetails(3));
	}
	
	@Ignore
	@Test
	public void listUserDetailsTest()
	{
		List<UserDetails> listUserDetails=userDetailsDAO.listUserDetails();
		assertNotNull("No UserDetails",listUserDetails);
		
		for(UserDetails userdetails:listUserDetails)
		{
			
			System.out.print(userdetails.getUsername()+":::");
			System.out.println(userdetails.getEmailId());
		}
	}
	
}