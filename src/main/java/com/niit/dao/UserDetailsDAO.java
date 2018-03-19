package com.niit.dao;

import java.util.List;

import com.niit.model.UserDetails;


public interface UserDetailsDAO 
{
	public boolean addUserDetails(UserDetails userdetails);
	public boolean deleteUserDetails(UserDetails userdetails);
	public UserDetails getUserDetails(int userdetails);
	public List<UserDetails> listUserDetails();

}
