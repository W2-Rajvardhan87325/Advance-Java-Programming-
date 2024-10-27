/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 27, 2024
 */

package com.sunbeam.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.entities.Mobile;
import com.sunbeam.entities.Order;
import com.sunbeam.entities.User;
import com.sunbeam.services.MobileService;
import com.sunbeam.services.OrderService;

@Controller
public class ShopControllerImpl {
	@Autowired
	private MobileService mobileService;
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/mobiles")
	public String showMobiles(Model model) {
		List<Mobile> list = mobileService.findAllMobiles();
		model.addAttribute("mobileList", list);
		return "mobiles";
	}
	
	@GetMapping(value="/images/{imageName}", produces="image/jpeg")
	public void downloadImage(@PathVariable("imageName") String imageName, OutputStream respOut) throws IOException {
		String imagePath = "D:\\Nilesh\\aug-24\\DMC\\advjava\\day12\\MobileShopAssignmentDocs\\images\\" + imageName;
		try(FileInputStream fileIn = new FileInputStream(imagePath)) {
			FileCopyUtils.copy(fileIn, respOut);
		}
	}
	
	@RequestMapping("/placeorder")
	public String placeOrder(@RequestParam("mobile") int mobileId, HttpSession session, Model model) {
		User user = (User)session.getAttribute("user");
		Order order = orderService.addOrder(user.getId(), mobileId);
		if(order == null) {
			model.addAttribute("message", "Order Not Placed.");
			return "forward:mobiles";
		}
		return "redirect:userorders";
	}
	
	@RequestMapping("/userorders")
	public String showOrders(HttpSession session, Model model) {
		User user = (User)session.getAttribute("user");
		List<Mobile> list = orderService.findOrderedMobilesByUserId(user.getId());
		model.addAttribute("mobileList", list);
		return "orders";
	}
}
