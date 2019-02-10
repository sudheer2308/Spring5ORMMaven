package com.app.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dao.IEmployeeDao;
import com.app.model.Employee;
import com.app.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeDao dao;
	@Transactional
	public int saveEmployee(Employee e) {
		return dao.saveEmployee(e);
	}
	@Transactional
	public void updateEmployee(Employee e) {
		dao.updateEmployee(e);
		
	}
	@Transactional
	public void deleteEmployee(int id) {
		dao.deleteEmployee(id);
		
	}
	@Transactional//(readOnly = true)
	public Employee getEmployeeById(int id) {
		return dao.getEmployeeById(id);
	}
	@Transactional//(readOnly = true)//select	
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}

}
