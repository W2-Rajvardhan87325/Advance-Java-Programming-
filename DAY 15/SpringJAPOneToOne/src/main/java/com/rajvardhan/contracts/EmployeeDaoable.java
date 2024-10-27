package com.rajvardhan.contracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajvardhan.entities.Employee;

public interface EmployeeDaoable extends JpaRepository<Employee, Integer> {

}
