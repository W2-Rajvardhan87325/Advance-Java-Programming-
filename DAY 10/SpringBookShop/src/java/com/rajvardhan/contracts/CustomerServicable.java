package com.rajvardhan.contracts;

import com.rajvardhan.entities.Customer;
import com.rajvardhan.models.Credentials;

public interface CustomerServicable {
	Customer authenticate(Credentials cr);
}
