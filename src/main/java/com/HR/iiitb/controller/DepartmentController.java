package com.HR.iiitb.controller;

import com.HR.iiitb.bean.Department;
import com.HR.iiitb.dao.DepartmentDAO;
import com.HR.iiitb.service.DepartmentService;
import com.HR.iiitb.service.impl.DepartmentServiceImpl;
import com.HR.iiitb.util.DepartmentDetails;
import com.HR.iiitb.util.DeptName;
import com.HR.iiitb.util.SendResponse;
import com.HR.iiitb.util.UpdateDept;
import org.hibernate.HibernateException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/department")
public class DepartmentController {

    private DepartmentService departmentService = new DepartmentServiceImpl();

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDepartment(DepartmentDetails utilDepartment) {


        Department department = new Department();
        department.setHeadOfDepartment(utilDepartment.getHod());
        department.setCapacity(utilDepartment.getCapacity());
        department.setDepartmentName(utilDepartment.getDeptName());
        SendResponse sendResponse = new SendResponse();
        try{
            departmentService.createDepartment(department);
        }catch(HibernateException e){
            sendResponse.setFlag(1);
            sendResponse.setMessage("Department is already there Please given different name");
        }
            sendResponse.setFlag(0);
            sendResponse.setMessage("New Department is created");
        return Response.ok().entity(sendResponse).build();
    }

    @POST
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editDepartment(UpdateDept utilDepartment){
        Department department = new Department();
        department.setDepartmentName(utilDepartment.getNewDeptName());
        department.setCapacity(utilDepartment.getCapacity());
        department.setHeadOfDepartment(utilDepartment.getHod());
        SendResponse sendResponse = new SendResponse();

        try{
            department.setId(departmentService.getDeptId(utilDepartment.getPrevDeptName()));
            departmentService.updateDepartment(department);
        }catch (Exception e){
            sendResponse.setFlag(1);
            sendResponse.setMessage("Department cannot be updated");
            return Response.ok().entity(sendResponse).build();
        }
        sendResponse.setFlag(0);
        sendResponse.setMessage("Department is updated");
        return Response.ok().entity(sendResponse).build();
    }

    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDepartment(DeptName utilDepartment){

        SendResponse sendResponse = new SendResponse();
        try{
            Integer deptId = departmentService.getDeptId(utilDepartment.getDeptName());
            departmentService.deleteDepartment(deptId);
        }catch (Exception e){
           sendResponse.setFlag(1);
           sendResponse.setMessage("Department cannot be delete");
        }
        sendResponse.setFlag(0);
        sendResponse.setMessage("Department is deleted");
        return Response.ok().entity(sendResponse).build();
    }

    @Path("/getName")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartmentName(){

        List<String> department = departmentService.getDepartmentName();
        List<DeptName> dept = new ArrayList<>();
        for(int i=0;i<department.size();i++)
        {
            DeptName d = new DeptName();
            d.setDeptName(department.get(i));
            dept.add(d);
        }
        return Response.ok().entity(dept).build();
    }

    @Path("/getValue")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getData(DeptName deptName){

        Department department;
        department = departmentService.getDepartment(deptName.getDeptName());
        DepartmentDetails department1 = new DepartmentDetails();
        department1.setCapacity(department.getCapacity());
        department1.setHod(department.getHeadOfDepartment());
        department1.setDeptName(department.getDepartmentName());
        return  Response.ok().entity(department1).build();
    }
}
