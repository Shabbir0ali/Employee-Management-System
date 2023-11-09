package com.shabbir.employe.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shabbir.employe.exception.ResourceNotFountExceptoin;
import com.shabbir.employe.model.Employee;
import com.shabbir.employe.repositry.EmployeeRepositry;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepositry employeeRepositry;

	@Override
	public List<Employee> getAllEmployee() {
		return this.employeeRepositry.findAll();
	}

	@Override
	public Employee saveEmp(Employee employee) {
		return this.employeeRepositry.save(employee);
	}

	@Override
	public Employee findSingleEmployee(Long id) {

		return this.employeeRepositry.findById(id)
				.orElseThrow(() -> new ResourceNotFountExceptoin("Employee not exit's with id" + id));
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		Employee employee2 = this.employeeRepositry.findById(id)
				.orElseThrow(() -> new ResourceNotFountExceptoin("Employee not exit's with id" + id));
		employee2.setFirstName(employee.getFirstName());
		employee2.setLastName(employee.getLastName());
		employee2.setEmailId(employee.getEmailId());
		
		Employee save = this.employeeRepositry.save(employee2);
		
		return save;
	}

	@Override
	public void deleteEmployee(Long id) {
		Employee emp = this.employeeRepositry.findById(id)
				.orElseThrow(() -> new ResourceNotFountExceptoin("Employee not exit's with id" + id));
		this.employeeRepositry.delete(emp);
	}

}