package com.HR.iiitb.service.impl;

import java.util.List;

import com.HR.iiitb.bean.Employee;
import com.HR.iiitb.service.EmployeeService;
import com.HR.iiitb.util.EmployeeDTO;


public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public List<EmployeeDTO> getAllEmployee(Integer deptId) {
		return employeeDAO.getAllEmployeeDetails(deptId);
	}

	@Override
	public Employee getEmployee(String empId) {
		return employeeDAO.getEmployee(empId);
	}

}
