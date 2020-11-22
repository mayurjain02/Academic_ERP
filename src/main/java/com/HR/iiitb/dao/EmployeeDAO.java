package com.HR.iiitb.dao;

import java.util.List;

import javax.persistence.Query;

import com.HR.iiitb.util.EmployeeDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.HR.iiitb.bean.Employee;
import com.HR.iiitb.util.SessionUtil;


public class EmployeeDAO {

	public List<EmployeeDTO> getAllEmployeeDetails(Integer deptId){
		
		Session session = SessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		String hql = "select e.Name , e.emailId, e.empId,e.phoneNo From Employee e, Department d where  d.DEPARTMENT_ID=:deptId and e.DEPARTMENT_ID = d.DEPARTMENT_ID";
		Query query = session.createNativeQuery(hql);
		query.setParameter("deptId", deptId);
		List<EmployeeDTO> empdetails = query.getResultList();

		transaction.commit();
		session.close();
		return empdetails;
	}
	
	public Employee getEmployee(String name) {
		
		Session session = SessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		String hql = "From Employee e where e.Name =:givenId";
		Query query = session.createQuery(hql);
		query.setParameter("givenId", name);

		Employee emp = (Employee) query.getSingleResult();
		
		transaction.commit();
		session.close();
		return emp;
	}
}
