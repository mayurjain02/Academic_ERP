package com.HR.iiitb.service;

import java.util.List;

import com.HR.iiitb.bean.Department;
import com.HR.iiitb.dao.DepartmentDAO;



public interface DepartmentService {
	
	DepartmentDAO departmentDAO = new DepartmentDAO();
	
	void createDepartment(Department department) ;
	
	List<String> getDepartmentName();
	
	Integer getDeptId(String departmentName);
	
	void deleteDepartment(Integer deprtID);
	
	void updateDepartment(Department department);

	Department getDepartment(String deptName);

}
