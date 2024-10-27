/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 27, 2024
 */

package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Mobile;

public interface MobileDao extends JpaRepository<Mobile, Integer> {

}
