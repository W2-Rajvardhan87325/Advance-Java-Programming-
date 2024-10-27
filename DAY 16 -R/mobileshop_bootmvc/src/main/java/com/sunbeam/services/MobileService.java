/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 27, 2024
 */

package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Mobile;

public interface MobileService {
	List<Mobile> findAllMobiles();
}
