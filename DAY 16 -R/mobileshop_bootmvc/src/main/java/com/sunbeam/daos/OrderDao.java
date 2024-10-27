/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 27, 2024
 */

package com.sunbeam.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.entities.Mobile;
import com.sunbeam.entities.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {
	List<Order> findByUserId(int userId);
	@Query("select m from Order o join o.mobile m where o.user.id=?1")
	List<Mobile> findMoobilesByUserId(int userId);
}
