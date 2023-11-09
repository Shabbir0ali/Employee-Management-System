package com.shabbir.employe.service;

import java.util.List;

import com.shabbir.employe.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();

	Employee saveEmp(Employee employee);

	Employee findSingleEmployee(Long id);

	Employee updateEmployee(Long id, Employee employee);

	void deleteEmployee(Long id);
}