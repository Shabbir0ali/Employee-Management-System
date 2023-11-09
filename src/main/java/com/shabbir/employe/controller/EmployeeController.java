package com.shabbir.employe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shabbir.employe.model.Employee;
import com.shabbir.employe.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		return ResponseEntity.ok(this.employeeService.getAllEmployee());
	}

	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		Employee emp = this.employeeService.saveEmp(employee);
		return ResponseEntity.ok(emp);
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getSingleEmployee(@PathVariable Long id) {
		Employee emp = this.employeeService.findSingleEmployee(id);
		return ResponseEntity.ok(emp);
	}

	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		Employee emp = this.employeeService.updateEmployee(id, employee);
		return ResponseEntity.ok(emp);
	}
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
		this.employeeService.deleteEmployee(id);
		HashMap<String, Boolean> respose = new HashMap<String,Boolean>();
		respose.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(respose);
	}
}