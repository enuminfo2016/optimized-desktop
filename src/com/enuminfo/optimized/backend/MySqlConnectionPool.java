/**
 * 
 */
package com.enuminfo.optimized.backend;

import java.sql.SQLException;

/**
 * @author AKURATI
 */
public class MySqlConnectionPool extends AbstractConnectionPool {
	
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/test";
	private static String username = "root";
	private static String password = "";

	public MySqlConnectionPool() throws SQLException {
		super(driver, url, username, password);
	}
}
