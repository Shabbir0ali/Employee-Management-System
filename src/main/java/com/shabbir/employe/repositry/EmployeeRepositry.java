package com.shabbir.employe.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shabbir.employe.model.Employee;

public interface EmployeeRepositry extends JpaRepository<Employee, Long>{
}