package com.ktds.dojun.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ktds.dojun.daosupport.JDBCDaoSupport;
import com.ktds.dojun.daosupport.QueryHandler;
import com.ktds.dojun.daosupport.annotation.BindData;
import com.ktds.dojun.vo.DepartmentsVO;
import com.ktds.dojun.vo.DepartmentsVO;
import com.ktds.dojun.vo.EmployeesVO;

public class HRDaoImpl extends JDBCDaoSupport implements HRDao {

	@Override
	public List<EmployeesVO> getAllEmployees() {

		return selectList(new QueryHandler() {

			@Override
			public String preparedQuery() {
				String query = " SELECT   EMPLOYEE_ID, FIRST_NAME, LAST_NAME,  "
						+ "   EMAIL, PHONE_NUMBER, HIRE_DATE,  " + "   JOB_ID, SALARY, COMMISSION_PCT,  "
						+ "   MANAGER_ID, DEPARTMENT_ID " + " FROM EMPLOYEES ";

				return query;
			}

			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {

			}

			@Override
			public Object getData(ResultSet rs) {
				EmployeesVO employeesVO = new EmployeesVO();
				BindData.bindData(rs, employeesVO);

				return employeesVO;
			}
		});

	}

	@Override
	public List<EmployeesVO> getAllEmployeesWithDP() {

		return selectList(new QueryHandler() {

			@Override
			public String preparedQuery() {
				String query = " SELECT   E.EMPLOYEE_ID, E.FIRST_NAME, E.LAST_NAME,  "
						+ "   E.EMAIL, E.PHONE_NUMBER, E.HIRE_DATE, " + "   E.JOB_ID, E.SALARY, E.COMMISSION_PCT,  "
						+ "   E.MANAGER_ID, E.DEPARTMENT_ID, "
						+ " D.DEPARTMENT_ID D_DEPARTMENT_ID, D.DEPARTMENT_NAME, D.MANAGER_ID D_MANAGER_ID, D.LOCATION_ID D_LOCATION_ID "
						+ " FROM EMPLOYEES E,  DEPARTMENTS D " + " WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID ";
				return query;
			}

			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {

			}

			@Override
			public Object getData(ResultSet rs) {
				EmployeesVO employeesVO = new EmployeesVO();
				BindData.bindData(rs, employeesVO);

				DepartmentsVO departmentVO = employeesVO.getDepartmentsVO();
				BindData.bindData(rs, departmentVO);

				return employeesVO;
			}
		});

	}

	@Override
	public EmployeesVO findOneEmployee(int employeeId) {

		return (EmployeesVO) selectOne(new QueryHandler() {

			@Override
			public String preparedQuery() {

				StringBuffer query = new StringBuffer();
				query.append(" SELECT   EMPLOYEE_ID ");
				query.append("          , FIRST_NAME ");
				query.append("          , LAST_NAME ");
				query.append("          , EMAIL ");
				query.append("          , PHONE_NUMBER ");
				query.append("          , JOB_ID ");
				query.append("          , HIRE_DATE ");
				query.append("          , SALARY ");
				query.append("          , COMMISSION_PCT ");
				query.append("          , MANAGER_ID ");
				query.append("          , DEPARTMENT_ID ");
				query.append(" FROM     EMPLOYEES     ");
				query.append(" WHERE    EMPLOYEE_ID = ? ");

				return query.toString();
			}

			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				stmt.setInt(1, employeeId);

			}

			@Override
			public Object getData(ResultSet rs) {
				EmployeesVO employeesVO = new EmployeesVO();
				BindData.bindData(rs, employeesVO);
				return employeesVO;
			}

		});

	}

}
