package com.HR.iiitb.service.impl;

import java.util.List;

import com.HR.iiitb.bean.Department;
import com.HR.iiitb.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	@Override
	public void createDepartment(Department department) {
		departmentDAO.createDeaprtment(department);
		
	}

	@Override
	public List<String> getDepartmentName() {
		return departmentDAO.getDepartmentName();
	}

	@Override
	public Integer getDeptId(String departmentName) {
		return departmentDAO.getDeptId(departmentName);
	}

	@Override
	public void deleteDepartment(Integer deprtID) {
		
		departmentDAO.deleteDepart(deprtID);
		
	}

	@Override
	public void updateDepartment(Department department) {
		
		departmentDAO.updateDepartment(department);
	}

	@Override
	public Department getDepartment(String deptName) {
		return departmentDAO.getDept(deptName);
	}

}
