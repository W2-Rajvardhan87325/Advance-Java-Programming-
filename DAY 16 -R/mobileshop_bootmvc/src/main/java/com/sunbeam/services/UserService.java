/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 27, 2024
 */

package com.sunbeam.services;

import com.sunbeam.entities.User;
import com.sunbeam.models.Credentials;

public interface UserService {
	User authenticate(Credentials cr);
}
