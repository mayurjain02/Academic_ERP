package com.HR.iiitb.service;

import java.util.List;

import com.HR.iiitb.bean.Employee;
import com.HR.iiitb.dao.EmployeeDAO;
import com.HR.iiitb.util.EmployeeDTO;


public interface EmployeeService {

	EmployeeDAO employeeDAO = new EmployeeDAO();
	
	public List<EmployeeDTO> getAllEmployee(Integer deptId);
	
	public Employee getEmployee(String empId); 
	
}
