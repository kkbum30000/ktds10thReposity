package com.ktds.dojun.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.dojun.dao.support.JDBCDaoSupport;
import com.ktds.dojun.dao.support.QueryHandler;
import com.ktds.dojun.dao.support.annotation.BindData;
import com.ktds.dojun.vo.CountriesVO;
import com.ktds.dojun.vo.DepartmentVO;
import com.ktds.dojun.vo.EmployeesVO;
import com.ktds.dojun.vo.JobVO;

public class HRDaoImpl extends JDBCDaoSupport implements HRDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeesVO> getAllEmployees() {

		return selectList(new QueryHandler() {

			@Override
			public String preparedQuery() {

				String query = " SELECT   EMPLOYEE_ID, FIRST_NAME, LAST_NAME,  "
						+ "   EMAIL, PHONE_NUMBER, HIRE_DATE,  " + "   JOB_ID, SALARY, COMMISSION_PCT,  "
						+ "   MANAGER_ID, DEPARTMENT_ID " + " FROM HR.EMPLOYEES ";

				return query;
			}

			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {

			}

			@Override
			public Object getData(ResultSet rs) {
				EmployeesVO employeesVO = new EmployeesVO();
				BindData.bindData(rs, employeesVO);
				
				return null;
			}

		}); // 인터페이스를 객체화 하기 불가능하므로, 구체화한다.

	}

	public List<DepartmentVO> printAllDP() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 로딩 실패");
			return null;
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		try {

			conn = DriverManager.getConnection(oracleUrl);

			String query = "SELECT  " + "DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID,  " + "   LOCATION_ID "
					+ "FROM HR.DEPARTMENTS; ";

			stmt = conn.prepareStatement(query);

			rs = stmt.executeQuery();

			DepartmentVO departmentVO = null;
			List<DepartmentVO> departments = new ArrayList<DepartmentVO>();

			while (rs.next()) {

				departmentVO = new DepartmentVO();
				departmentVO.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				departmentVO.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
				departmentVO.setManagerId(rs.getInt("MANAGER_ID"));
				departmentVO.setLocationId(rs.getInt("LOCATION_ID"));

				departments.add(departmentVO);
			}

			return departments;

		} catch (SQLException e) {
			System.out.println("인스턴스 연결 실패!");
			return null;

		} finally {

			try {
				if (rs != null) {

					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null) {

					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {

					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	@SuppressWarnings("unchecked")
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
			public void mappingParameters(PreparedStatement stmt) throws SQLException{

			}

			@Override
			public Object getData(ResultSet rs) {

				EmployeesVO employeesVO = new EmployeesVO();
				BindData.bindData(rs, employeesVO);

				DepartmentVO departmentVO = employeesVO.getDepartments();
				BindData.bindData(rs, departmentVO);

				return employeesVO;
			}

		});

	}

	@Override
	public List<EmployeesVO> getAllEmployeesWithDPAndJob() {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";

		try {
			conn = DriverManager.getConnection(oracleUrl, "HR", "hrhr");

			String query = " SELECT  E.EMPLOYEE_ID,  " + "        E.FIRST_NAME,  " + "        E.LAST_NAME, "
					+ "        E.EMAIL,  " + "        E.PHONE_NUMBER,  " + "        E.HIRE_DATE,  "
					+ "     	E.JOB_ID,  " + "    	E.SALARY,  " + "	    E.COMMISSION_PCT,  "
					+ " 	    E.MANAGER_ID,  " + " 	    E.DEPARTMENT_ID,  "
					+ "        D.DEPARTMENT_ID D_DEPARTMENT_ID,  " + "        D.DEPARTMENT_NAME,  "
					+ "        D.MANAGER_ID D_MANAGER_ID,  " + "        D.LOCATION_ID D_LOCATION_ID, "
					+ "        J.JOB_ID J_JOB_ID, " + "        J.JOB_TITLE, " + "        J.MAX_SALARY, "
					+ "        J.MIN_SALARY " + " FROM    EMPLOYEES E,   " + "        DEPARTMENTS D,  "
					+ "        JOBS J " + " WHERE   E.DEPARTMENT_ID = D.DEPARTMENT_ID  "
					+ " AND     E.JOB_ID = J.JOB_ID ";

			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();

			EmployeesVO employeesVO = null;
			DepartmentVO departmentVO= null;
			List<EmployeesVO> employees = new ArrayList<EmployeesVO>();

			while (rs.next()) {

				employeesVO = new EmployeesVO();
				BindData.bindData(rs, employeesVO);

				departmentVO = employeesVO.getDepartments();
				BindData.bindData(rs, departmentVO);

				JobVO jobVO = employeesVO.getJobs();
				BindData.bindData(rs, jobVO);

				employees.add(employeesVO);
			}
			return employees;

		} catch (SQLException e) {
			System.out.println("인스턴스 연결 실패!");
			e.printStackTrace();
			return null;
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (conn != null) {

					conn.close();
				}
			} catch (SQLException e) {
			}
		}

	}

	/*
	 * public List<DepartmentVO> getAllDepartmentWithLocations(){
	 * 
	 * try { Class.forName("oracle.jdbc.driver.DriverOracle"); } catch
	 * (ClassNotFoundException e) { return null; }
	 * 
	 * Connection conn = null; PreparedStatement stmt = null; ResultSet rs =
	 * null;
	 * 
	 * String query = " SELECT D.DEPARTMENT_ID, " + "       D.DEPARTMENT_NAME, "
	 * + "       D.MANAGER_ID, " + "       D.LOCATION_ID, " +
	 * "       L.LOCATION_ID L_LOCATION_ID, " + "       L.STREET_ADDRESS, " +
	 * "       L.POSTAL_CODE, " + "       L.CITY, " +
	 * "       L.STATE_PROVINCE, " + "       L.COUNTRY_ID " +
	 * " FROM   DEPARTMENTS D, " + "       LOCATIONS L " +
	 * " WHERE  D.LOCATION_ID = L.LOCATION_ID " ;
	 * 
	 * try { stmt = conn.prepareStatement(query); rs = stmt.executeQuery();
	 * DepartmentVO departmentVO; List<DepartmentVO> departments = new
	 * ArrayList<DepartmentVO> () ;
	 * 
	 * 
	 * while(rs.next()){
	 * 
	 * departmentVO = new DepartmentVO();
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	public List<CountriesVO> getAllCountriesWithRegions() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결 실패");
			return null;
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String orclaeUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		try {

			conn = DriverManager.getConnection(orclaeUrl, "HR", "hrhr");

			String query = " SELECT C.COUNTRY_ID,  " + "       C.COUNTRY_NAME,  " + "       C.REGION_ID, "
					+ "       R.REGION_ID R_REGION_ID,  " + "       R.REGION_NAME " + " FROM COUNTRIES C,  "
					+ "     REGIONS R " + " WHERE C.REGION_ID = R.REGION_ID ";

			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();

			CountriesVO countriesVO = null;
			List<CountriesVO> countries = new ArrayList<CountriesVO>();

			while (rs.next()) {

				countriesVO = new CountriesVO();
				countriesVO.setCountryId(rs.getString("COUNTRY_ID"));
				countriesVO.setContryName(rs.getString("COUNTRY_NAME"));
				countriesVO.setRegionID(rs.getInt("REGION_ID"));
				countriesVO.getRegionsVO().setRegionId(rs.getInt("R_REGION_ID"));
				countriesVO.getRegionsVO().setRegionName(rs.getString("REGION_NAME"));

				countries.add(countriesVO);

			}

			return countries;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("인스턴스 연결 실패");
			return null;

		} finally {
			try {
				if (rs != null) {

					rs.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}

		}
	}

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
