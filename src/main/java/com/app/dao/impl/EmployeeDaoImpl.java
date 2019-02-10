package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IEmployeeDao;
import com.app.model.Employee;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {
	
	@Autowired
	private HibernateTemplate ht;

	public int saveEmployee(Employee e) {
		// TODO Auto-generated method stub
		return (Integer)ht.save(e);
	}

	public void updateEmployee(Employee e) {
		ht.update(e);
		
	}

	public void deleteEmployee(int id) {
		ht.delete(new Employee(id));
		
	}
	
	public Employee getEmployeeById(int id) {
		
		return ht.get(Employee.class,id);
	}

	public List<Employee> getAllEmployees() {
		
		return ht.loadAll(Employee.class);
	}

}
