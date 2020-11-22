package com.HR.iiitb.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="DEPARTMENT_ID")
	private Integer id;
	
	@NotNull
	private String departmentName;
	
	@NotNull
	private Integer capacity;
	
	private String headOfDepartment;

	@JsonManagedReference
	@OneToMany(mappedBy = "department",fetch =FetchType.EAGER )
	private Set<Employee> employees;

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getHeadOfDepartment() {
		return headOfDepartment;
	}

	public void setHeadOfDepartment(String headOfDepartment) {
		this.headOfDepartment = headOfDepartment;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Department{" +
				"id=" + id +
				", departmentName='" + departmentName + '\'' +
				", capacity=" + capacity +
				", headOfDepartment='" + headOfDepartment + '\'' +
				/*", employee=" + employee +*/
				'}';
	}
}
