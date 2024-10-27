/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 27, 2024
 */

package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Mobile;
import com.sunbeam.entities.Order;

public interface OrderService {
	Order addOrder(int userId, int mobileId);
	List<Mobile> findOrderedMobilesByUserId(int id);
}
