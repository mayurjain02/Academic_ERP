package com.HR.iiitb.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.HR.iiitb.bean.Department;
import com.HR.iiitb.bean.Employee;


public class SessionUtil {

	private static  SessionFactory sessionFactory;

	static {
		try {
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(Department.class).addAnnotatedClass(Employee.class);

			sessionFactory = configuration.buildSessionFactory();
		}catch (Exception e)
		{
			throw new HibernateException(e);
		}
	}
	
	public static Session getSession() throws HibernateException
	{
		return sessionFactory.openSession();
	}
}
