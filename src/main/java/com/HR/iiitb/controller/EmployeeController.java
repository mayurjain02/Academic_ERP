package com.HR.iiitb.controller;

import com.HR.iiitb.service.DepartmentService;
import com.HR.iiitb.service.EmployeeService;
import com.HR.iiitb.service.impl.DepartmentServiceImpl;
import com.HR.iiitb.service.impl.EmployeeServiceImpl;
import com.HR.iiitb.util.DeptName;
import com.HR.iiitb.util.EmployeeDTO;
import org.hibernate.HibernateException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/showAll")
public class EmployeeController {

    DepartmentService departmentService = new DepartmentServiceImpl();
    EmployeeService employeeService = new EmployeeServiceImpl();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response showAllEmployee(DeptName deptName){
        List<EmployeeDTO> employeeList = new ArrayList<>();

        try{
            Integer deptId = departmentService.getDeptId(deptName.getDeptName());
           employeeList = employeeService.getAllEmployee(deptId);
        }catch (Exception e){
                throw  new HibernateException(e);
        }
        return Response.ok().entity(employeeList).build();
    }
}
