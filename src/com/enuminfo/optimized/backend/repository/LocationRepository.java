/**
 * 
 */
package com.enuminfo.optimized.backend.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.enuminfo.optimized.backend.model.Location;

/**
 * @author AKURATI
 */
public class LocationRepository extends AbstractRepository<Location> {

	public LocationRepository() {
		super(Location.class);
	}

	@Override
	protected String getNamedQuery() {
		return "SELECT * FROM tbllocation";
	}

	@Override
	protected List<Location> getSpecificValuesFromDB(List<Object[]> records) {
		List<Location> locations = new ArrayList<Location>();
		for (int i = 0; i < records.size(); i++) {
			Object[] record = records.get(i);
			Location location = new Location();
			location.setId(Integer.parseInt(String.valueOf(record[0])));
			location.setName(String.valueOf(record[1]));
			location.setPin(Long.parseLong(String.valueOf(record[2])));
			location.setCity(String.valueOf(record[3]));
			location.setState(String.valueOf(record[4]));
			location.setCountry(String.valueOf(record[5]));
			locations.add(location);
		}
		return locations;
	}

	@Override
	public void save(Location model) {
		String sqlQuery = "INSERT INTO tbllocation (id, name, pin, city, state, country) VALUES (?,?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionPool.getConnection();
			getAppLogger().info(model.getId() + " => " + sqlQuery);
			preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, model.getId());
			preparedStatement.setString(2, model.getName());
			preparedStatement.setLong(3, model.getPin());
			preparedStatement.setString(4, model.getCity());
			preparedStatement.setString(5, model.getState());
			preparedStatement.setInt(6, Integer.parseInt(model.getCountry()));
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closePreparedStatement(preparedStatement);
			closeConnection(connection);
		}
	}
}
