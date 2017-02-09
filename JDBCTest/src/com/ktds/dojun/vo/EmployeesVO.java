package com.ktds.dojun.vo;

import com.ktds.dojun.dao.support.annotation.Types;

public class EmployeesVO {

	@Types
	private int employeeId;
	@Types
	private String firstName;
	@Types
	private String lastName;
	@Types
	private String email;
	@Types
	private String phoneNumber;
	@Types
	private String hireDate;
	@Types
	private String jobId;
	@Types
	private int salary;
	@Types
	private double commissionPct;
	@Types
	private int managerId;
	@Types
	private int departmentId;
	
	// Departments 테이블을 조인하기 위한 선언
	private DepartmentVO departments;
	private JobVO jobs;
	
	// Departments 테이블을 조인하기 위한 게,세터
	
	public DepartmentVO getDepartments() {
		if (departments == null) {
			departments = new DepartmentVO();
		}
		return departments;
	}

	public void setDepartments(DepartmentVO departments) {
		this.departments = departments;
	}

	public JobVO getJobs() {
		if (jobs == null) {
			jobs = new JobVO();
		}
		return jobs;
	}

	public void setJobs(JobVO jobVO) {
		this.jobs = jobVO;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employee_id) {
		this.employeeId = employee_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jabId) {
		this.jobId = jabId;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(double commissionPct) {
		this.commissionPct = commissionPct;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
}
