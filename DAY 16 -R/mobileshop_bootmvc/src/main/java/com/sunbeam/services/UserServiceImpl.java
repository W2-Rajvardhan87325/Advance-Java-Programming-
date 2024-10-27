/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 27, 2024
 */

package com.sunbeam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.UserDao;
import com.sunbeam.entities.User;
import com.sunbeam.models.Credentials;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public User authenticate(Credentials cr) {
		User dbUser = userDao.findByEmail(cr.getEmail());
		if(dbUser != null && dbUser.getPassword().equals(cr.getPassword()))
			return dbUser;
		return null;
	}
}
