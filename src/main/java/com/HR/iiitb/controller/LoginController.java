package com.HR.iiitb.controller;

import java.net.URISyntaxException;


import javax.persistence.NoResultException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.HR.iiitb.util.SendResponse;
import com.HR.iiitb.util.User;


import com.HR.iiitb.bean.Employee;
import com.HR.iiitb.service.EmployeeService;
import com.HR.iiitb.service.impl.EmployeeServiceImpl;
import org.hibernate.HibernateException;


@Path("/login")
public class LoginController {

	@POST
	@Path("/check")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response checkCredentials(User user) throws URISyntaxException {

		EmployeeService employeeService = new EmployeeServiceImpl();
		SendResponse sendResponse = new SendResponse();
		Employee emp = null;
		try{
			emp = employeeService.getEmployee(user.getUsername());
		}catch (NoResultException e){
			sendResponse.setFlag(1);
			sendResponse.setMessage( "You are not a member");
			throw new HibernateException(e);
		}

		if (emp != null) {
			if (emp.getPassword().equals(user.getPassword())) {
				if(emp.getDepartment().getDepartmentName().equals("HR")) {
					sendResponse.setFlag(0);
					sendResponse.setMessage("successfull login");
				}else{
					sendResponse.setFlag(1);
					sendResponse.setMessage("Only Employees from HR Department can access this");
				}
			}else{
				sendResponse.setFlag(1);
				sendResponse.setMessage("Invalid login");
			}
		}

		return Response.ok().entity(sendResponse).build();
	}
}