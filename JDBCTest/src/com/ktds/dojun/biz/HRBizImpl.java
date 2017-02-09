package com.ktds.dojun.biz;

import java.util.ArrayList;
import java.util.List;

import com.ktds.dojun.dao.HRDao;
import com.ktds.dojun.dao.HRDaoImpl;
import com.ktds.dojun.vo.CountriesVO;
import com.ktds.dojun.vo.DepartmentVO;
import com.ktds.dojun.vo.EmployeesVO;
import com.ktds.dojun.vo.JobVO;

public class HRBizImpl implements HRBiz {

	private HRDao hrDao;

	public HRBizImpl() {
		hrDao = new HRDaoImpl();
	}

	@Override
	public void printAllEmployees() {

		List<EmployeesVO> allEmployees = hrDao.getAllEmployees();

		for (EmployeesVO employeesVO : allEmployees) {
			System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t%s\t%d\t%f\t%d\t%d\n", employeesVO.getEmployeeId(),
					employeesVO.getFirstName(), employeesVO.getLastName(), employeesVO.getEmail(),
					employeesVO.getPhoneNumber(), employeesVO.getHireDate(), employeesVO.getJobId(),
					employeesVO.getSalary(), employeesVO.getCommissionPct(), employeesVO.getManagerId(),
					employeesVO.getDepartmentId());

		}

	}

	@Override
	public void printAllEmployeesWithDP() {
		List<EmployeesVO> allEmployees = hrDao.getAllEmployeesWithDP();

		for (EmployeesVO employeesVO : allEmployees) {
			System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t%s\t%d\t%f\t%d\t%d\t%d\t%s\t%d\t%d\n",
					employeesVO.getEmployeeId(), employeesVO.getFirstName(), employeesVO.getLastName(),
					employeesVO.getEmail(), employeesVO.getPhoneNumber(), employeesVO.getHireDate(),
					employeesVO.getJobId(), employeesVO.getSalary(), employeesVO.getCommissionPct(),
					employeesVO.getManagerId(), employeesVO.getDepartmentId(),
					employeesVO.getDepartments().getDepartmentId(), employeesVO.getDepartments().getDepartmentName(),
					employeesVO.getDepartments().getManagerId(), employeesVO.getDepartments().getLocationId());
			// 체인이 길어질 경우, DaoImpl에 서술한 바와 같이 하면 된다.

		}
	}

	@Override
	public void printAllEmployeesWithDPAndJob() {
		List<EmployeesVO> allEmployees = hrDao.getAllEmployeesWithDPAndJob();

		for (EmployeesVO employeesVO : allEmployees) {
			DepartmentVO departmentVO = employeesVO.getDepartments();
			JobVO jobVO = employeesVO.getJobs();
			System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t%s\t%d\t%f\t%d\t%d\t%d\t%s\t%d\t%d\t%s\t%s\t%d\t%d\n",
					employeesVO.getEmployeeId(), employeesVO.getFirstName(), employeesVO.getLastName(),
					employeesVO.getEmail(), employeesVO.getPhoneNumber(), employeesVO.getHireDate(),
					employeesVO.getJobId(), employeesVO.getSalary(), employeesVO.getCommissionPct(),
					employeesVO.getManagerId(), employeesVO.getDepartmentId(), departmentVO.getDepartmentId(),
					departmentVO.getDepartmentName(), departmentVO.getManagerId(), departmentVO.getLocationId(),
					jobVO.getJobId(), jobVO.getJobTitle(), jobVO.getMaxSalary(), jobVO.getMinSalary());
		}
	}

	@Override
	public void printAllDP() {

		/*
		 * List<DepartmentVO> allEmployees = hrDao.getAllEmployees();
		 * 
		 * for (DepartmentVO departmentVO : allEmployees) {
		 * System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t%s\t%d\t%f\t%d\t%d\n",
		 * departmentVO.getEmployee_id(), departmentVO.getFirstName(),
		 * departmentVO.getLastName(), departmentVO.getEmail(),
		 * departmentVO.getPhoneNumber(), departmentVO.getHireDate(),
		 * departmentVO.getJabId(), departmentVO.getSalary(),
		 * departmentVO.getCommissionPct(), departmentVO.getManagerId(),
		 * departmentVO.getDepartmentId());
		 * 
		 * }
		 */

	}

	@Override
	public void printAllCountriesWithRegions() {
		List<CountriesVO> countries = hrDao.getAllCountriesWithRegions();
		for (CountriesVO countriesVO : countries) {
			System.out.printf("%s\t%s\t%d\t%d\t%s\n", countriesVO.getCountryId(), countriesVO.getContryName(),
					countriesVO.getRegionID(), countriesVO.getRegionsVO().getRegionId(),
					countriesVO.getRegionsVO().getRegionName()

			);
		}
	}
	
	
	public void findOneEmployee(int employeeId) {
		EmployeesVO employees = hrDao.findOneEmployee(employeeId);
		System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t%s\t%d\t%f\t%d\t%d\n", employees.getEmployeeId(),
				employees.getFirstName(), employees.getLastName(), employees.getEmail(),
				employees.getPhoneNumber(), employees.getHireDate(), employees.getJobId(),
				employees.getSalary(), employees.getCommissionPct(), employees.getManagerId(),
				employees.getDepartmentId());
	}
	
	
}