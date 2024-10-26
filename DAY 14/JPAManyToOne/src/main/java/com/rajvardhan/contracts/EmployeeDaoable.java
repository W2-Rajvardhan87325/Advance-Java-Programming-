package com.rajvardhan.contracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajvardhan.entities.Employee;

public interface EmployeeDaoable extends JpaRepository<Employee, Integer> {
	List<Employee> findByJob(String job);
	List<Employee> findByEnameStartsWith(String prefix);
}
