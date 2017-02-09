package com.ktds.dojun.daosupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class JDBCDaoSupport {

	public List selectList(QueryHandler queryHandler) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String query = queryHandler.preparedQuery();
			stmt = conn.prepareStatement(query);

			queryHandler.mappingParameters(stmt);

			rs = stmt.executeQuery();

			List result = new ArrayList();

			while (rs.next()) {
				result.add(queryHandler.getData(rs));

			}
			return result;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, rs);
		}
	}

	public Object selectOne(QueryHandler queryHandler) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String query = queryHandler.preparedQuery();
			stmt = conn.prepareStatement(query);

			queryHandler.mappingParameters(stmt);

			rs = stmt.executeQuery();

			Object result = null;
			if (rs.next()) {

				result = queryHandler.getData(rs);
			}

			return result;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, rs);
		}
	}

	public void loadOracleDriver() {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	private Connection getConnection() throws SQLException {
		String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		return DriverManager.getConnection(oracleUrl, "HR", "hrhr");
	}

	private void close(Connection conn, PreparedStatement stmt, ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
		}
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
		}

	}

}
