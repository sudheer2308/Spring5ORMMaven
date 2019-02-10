package com.app.dao;

import java.util.List;

import com.app.model.Employee;

public interface IEmployeeDao {
	public int saveEmployee(Employee e);
	public void updateEmployee(Employee e);
	public void deleteEmployee(int id);
	public Employee getEmployeeById(int id);
	public List<Employee> getAllEmployees();
	}

