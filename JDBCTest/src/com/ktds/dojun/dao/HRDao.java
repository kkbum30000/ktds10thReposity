package com.ktds.dojun.dao;

import java.util.List;

import com.ktds.dojun.vo.CountriesVO;
import com.ktds.dojun.vo.DepartmentVO;
import com.ktds.dojun.vo.EmployeesVO;

public interface HRDao {
	
	public List<EmployeesVO> getAllEmployees();
	
	public List<EmployeesVO> getAllEmployeesWithDP();
	
	public List<EmployeesVO> getAllEmployeesWithDPAndJob();
	//조인 메소드
	
//	public List<DepartmentVO> getAllDepartmentWithLocations();
	
	public List<CountriesVO> getAllCountriesWithRegions();
	
	public List<DepartmentVO> printAllDP();
	
	public EmployeesVO findOneEmployee(int employeeId);
	
}
