package com.app.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.config.AppConfig;
import com.app.model.Employee;
import com.app.service.IEmployeeService;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
		IEmployeeService service=(IEmployeeService) 
				ac.getBean("employeeServiceImpl");
		Employee emp=new Employee();
		emp.setEmpId(507);
		emp.setEmpName("Sudheer");
		emp.setEmpSal(650.60);
		service.saveEmployee(emp);
		List<Employee> emps=service.getAllEmployees();
		emps.forEach(System.out::println);
		System.out.println("done");
	}

}
