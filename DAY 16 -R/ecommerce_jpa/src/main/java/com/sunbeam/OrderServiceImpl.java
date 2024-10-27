/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 27, 2024
 */

package com.sunbeam;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional//(propagation = Propagation.REQUIRED)
@Service
public class OrderServiceImpl implements OrderService {
	// auto-wire all required daos
	@Override
	public Order addOrder(Order order) {
		// order = orderDao.save(order);
		return null;
	}
}
