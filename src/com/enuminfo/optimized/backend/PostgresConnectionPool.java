/**
 * 
 */
package com.enuminfo.optimized.backend;

import java.sql.SQLException;

/**
 * @author AKURATI
 */
public class PostgresConnectionPool extends AbstractConnectionPool {

	private static String driver = "org.postgresql.Driver";
	private static String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
	private static String username = "postgres";
	private static String password = "root";
	
	public PostgresConnectionPool() throws SQLException {
		super(driver, url, username, password);
	}
}
