/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 27, 2024
 */

package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.MobileDao;
import com.sunbeam.entities.Mobile;

@Service
public class MobileServiceImpl implements MobileService {
	@Autowired
	private MobileDao mobileDao;
	@Override
	public List<Mobile> findAllMobiles() {
		List<Mobile> list = mobileDao.findAll();
		return list;
	}
}
