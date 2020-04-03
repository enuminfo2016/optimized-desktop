/*
 * 
 */
package com.enuminfo.optimized.backend.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.enuminfo.optimized.backend.AbstractConnectionPool;
import com.enuminfo.optimized.backend.MySqlConnectionPool;
import com.enuminfo.optimized.backend.model.Base;

/**
 * @author AKURATI
 */
public abstract class AbstractRepository<T extends Base> {

	private final Class<T> modelClass;
	private final Logger appLogger;
	protected AbstractConnectionPool connectionPool;

	public AbstractRepository(Class<T> modelClass) {
		this.modelClass = modelClass;
		this.appLogger = LoggerFactory.getLogger(modelClass);
		try {
			this.connectionPool = new MySqlConnectionPool();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Class<T> getModelClass() {
		return modelClass;
	}

	public AbstractConnectionPool getConnectionPool() {
		return connectionPool;
	}
	
	public Logger getAppLogger() {
		return appLogger;
	}

	public abstract void save(T model);

	public T findOne(Integer id) {
		return null;
	}

	public void remove(T model) {
		
	}
	
	private List<Object[]> executeNamedQuery() {
		List<Object[]> records = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = connectionPool.getConnection();
			getAppLogger().info(getNamedQuery());
			preparedStatement = connection.prepareStatement(getNamedQuery());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int cols = resultSet.getMetaData().getColumnCount();
				Object[] arr = new Object[cols];
				for (int i = 0; i < cols; i++) {
					arr[i] = resultSet.getObject(i + 1);
				}
				records.add(arr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closePreparedStatement(preparedStatement);
			closeResultSet(resultSet);
			closeConnection(connection);
		}
		return records;
	}
	
	private List<Object[]> executeNamedQueryWithParameters(Map<String, Object> parameters) {
		List<Object[]> records = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		StringBuilder builder = new StringBuilder(getNamedQuery());
		try {
			connection = connectionPool.getConnection();
			builder.append(" WHERE ");
			parameters.forEach((key, value) -> builder.append(key + " = '" + value + "' AND "));
			String sqlQuery = builder.toString().substring(0, builder.toString().length() - 5);
			getAppLogger().info(sqlQuery);
			preparedStatement = connection.prepareStatement(sqlQuery);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int cols = resultSet.getMetaData().getColumnCount();
				Object[] arr = new Object[cols];
				for (int i = 0; i < cols; i++) {
					arr[i] = resultSet.getObject(i + 1);
				}
				records.add(arr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closePreparedStatement(preparedStatement);
			closeResultSet(resultSet);
			closeConnection(connection);
		}
		return records;
	}

	public List<T> findAll() {
		return getSpecificValuesFromDB(executeNamedQuery());
	}

	protected abstract List<T> getSpecificValuesFromDB(List<Object[]> records);

	protected abstract String getNamedQuery();

	public List<T> findByColumn(Map<String, Object> parameters) {
		return getSpecificValuesFromDB(executeNamedQueryWithParameters(parameters));
	}

	public List<T> findByColumnWithPaging(Map<String, Object> parameters, int start, int end) {
		return getSpecificValuesFromDBWithPaging(executeNamedQueryWithParameters(parameters), start, end);
	}

	public List<T> findAllWithPaging(int start, int end) {
		return getSpecificValuesFromDBWithPaging(executeNamedQuery(), start, end);
	}

	protected void closePreparedStatement(PreparedStatement preparedStatement) {
		try {
			if (preparedStatement != null)
				preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void closeResultSet(ResultSet resultSet) {
		try {
			if (resultSet != null)
				resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void closeConnection(Connection connection) {
		if (connection != null)
			connectionPool.free(connection);
	}
	
	protected List<T> getPagingList(List<T> list, int start, int end) {
		List<T> finalList = new ArrayList<T>();
		if (end > list.size()) end = list.size();
		for (int i = start; i < end; i++) {
			finalList.add(list.get(i));
		}
		return finalList;
	}

	protected List<T> getSpecificValuesFromDBWithPaging(List<Object[]> records, int start, int end) {
		List<T> list = getSpecificValuesFromDB(records);
		return getPagingList(list, start, end);
	}
}
