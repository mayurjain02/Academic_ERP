package com.HR.iiitb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.HR.iiitb.bean.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.HR.iiitb.bean.Department;
import com.HR.iiitb.util.SessionUtil;


public class DepartmentDAO {

	public void createDeaprtment(Department dept) {
		
		Session session = SessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(dept);
		
		transaction.commit();
		session.close();
		
	}
	
	public List<String> getDepartmentName(){
		
		Session session = SessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		String hql = "select distinct(d.departmentName) from Department d";
		Query query = session.createQuery(hql);
		
		List<String> departmentNames = new ArrayList<>();
		
		departmentNames = query.getResultList();
		
		transaction.commit();
		session.close();
		return departmentNames;
		
		
	}
	
	public Integer getDeptId(String deptname){
		
		Session session =SessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		String hql = "select d.id From Department d where d.departmentName = :givenName";
		Query query = session.createQuery(hql);
		query.setParameter("givenName", deptname);
		Integer deptId=(Integer)query.getResultList().get(0);
		
		transaction.commit();
		session.close();
		return deptId;
		
	}

	public Department getDepartment(Integer deptId){

		Session session =SessionUtil.getSession();
		Transaction transaction = session.beginTransaction();

		String hql = "From Department d where d.id =:givenId";
		Query query = session.createQuery(hql);
		query.setParameter("givenId",deptId);
		Department department =(Department) query.getResultList().get(0);

		transaction.commit();
		session.close();
		return department;
	}
	
	public void deleteDepart(Integer deptId)
	{
		Session sessoin = SessionUtil.getSession();
		Transaction transaction = sessoin.beginTransaction();
		
		String hql = "delete from Department d where d.id = :givenId";
		Query query = sessoin.createQuery(hql);
		query.setParameter("givenId", deptId);
		
		int row = query.executeUpdate();
		
		transaction.commit();
		sessoin.close();
	}
	
	public void updateDepartment(Department department) {
		
		Session session = SessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		System.out.println(department.getDepartmentName());
		String hql = "Update Department d SET d.departmentName =:givenName , d.capacity=:givenCapacity, d.headOfDepartment=:givenHOD where d.id=:givenId";
		Query query = session.createQuery(hql);
		query.setParameter("givenName", department.getDepartmentName());
		query.setParameter("givenCapacity", department.getCapacity());
		query.setParameter("givenHOD", department.getHeadOfDepartment());
		query.setParameter("givenId",department.getId());
		int row = query.executeUpdate();
		
		transaction.commit();
		session.close();
	}

	public Department getDept(String deptname){

		Session session =SessionUtil.getSession();
		Transaction transaction = session.beginTransaction();

		String hql = "From Department d where d.departmentName = :givenName";
		Query query = session.createQuery(hql);
		query.setParameter("givenName", deptname);
		Department dept =(Department) query.getResultList().get(0);

		transaction.commit();
		session.close();
		return dept;

	}
}
