package com.ktds.dojun.dao;

import java.util.List;

import com.ktds.dojun.vo.EmployeesVO;

public interface HRDao {
	
	public List<EmployeesVO> getAllEmployees();
	
	public List<EmployeesVO> getAllEmployeesWithDP();
	
	public EmployeesVO findOneEmployee(int employeeId);
	

}
