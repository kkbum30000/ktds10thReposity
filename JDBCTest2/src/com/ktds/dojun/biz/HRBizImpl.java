package com.ktds.dojun.biz;

import java.util.List;

import com.ktds.dojun.dao.HRDao;
import com.ktds.dojun.dao.HRDaoImpl;
import com.ktds.dojun.vo.EmployeesVO;

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
	public void printAllEmployeesWithDp() {
		List<EmployeesVO> allEmployees = hrDao.getAllEmployeesWithDP();

		for (EmployeesVO employeesVO : allEmployees) {
			System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t%s\t%d\t%f\t%d\t%d\t%d\t%s\t%d\t%d\n",
					employeesVO.getEmployeeId(), employeesVO.getFirstName(), employeesVO.getLastName(),
					employeesVO.getEmail(), employeesVO.getPhoneNumber(), employeesVO.getHireDate(),
					employeesVO.getJobId(), employeesVO.getSalary(), employeesVO.getCommissionPct(),
					employeesVO.getManagerId(), employeesVO.getDepartmentId(),
					employeesVO.getDepartmentsVO().getDepartmentId(),
					employeesVO.getDepartmentsVO().getDepartmentName(), employeesVO.getDepartmentsVO().getManagerId(),
					employeesVO.getDepartmentsVO().getLocationId());
		}
	}

	@Override
	public void findOneEmployee(int employeeId) {
		EmployeesVO employees = hrDao.findOneEmployee(employeeId);
		System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t%s\t%d\t%f\t%d\t%d\n", employees.getEmployeeId(),
				employees.getFirstName(), employees.getLastName(), employees.getEmail(), employees.getPhoneNumber(),
				employees.getHireDate(), employees.getJobId(), employees.getSalary(), employees.getCommissionPct(),
				employees.getManagerId(), employees.getDepartmentId());
	}

}
