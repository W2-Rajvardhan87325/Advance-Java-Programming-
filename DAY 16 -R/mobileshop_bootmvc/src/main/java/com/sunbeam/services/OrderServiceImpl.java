/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 27, 2024
 */

package com.sunbeam.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.MobileDao;
import com.sunbeam.daos.OrderDao;
import com.sunbeam.daos.UserDao;
import com.sunbeam.entities.Mobile;
import com.sunbeam.entities.Order;
import com.sunbeam.entities.User;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private MobileDao mobileDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private UserDao userDao;
	@Override
	public Order addOrder(int userId, int mobileId) {
		Optional<Mobile> om = mobileDao.findById(mobileId);
		Optional<User> ou = userDao.findById(userId);
		if(om.isPresent() && ou.isPresent()) {
			Order order = new Order(0, om.get(), ou.get());
			order = orderDao.save(order);
			return order;
		}
		return null;
	}
	@Override
	public List<Mobile> findOrderedMobilesByUserId(int userId) {
		/*
		List<Mobile> mobileList = new ArrayList<Mobile>();
		List<Order> orderList = orderDao.findByUserId(userId);
		for (Order order : orderList) {
			Mobile m = order.getMobile();
			mobileList.add(m);
		}
		return mobileList;
		*/

		List<Mobile> mobileList = orderDao.findMoobilesByUserId(userId);
		return mobileList;
	}
}
