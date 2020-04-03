/**
 * 
 */
package com.enuminfo.optimized.backend.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.enuminfo.optimized.backend.model.Country;

/**
 * @author AKURATI
 */
public class CountryRepository extends AbstractRepository<Country> {
	
	public CountryRepository() {
		super(Country.class);
	}
	
	@Override
	protected String getNamedQuery() {
		return "SELECT * FROM tblcountry";
	}

	@Override
	protected List<Country> getSpecificValuesFromDB(List<Object[]> records) {
		List<Country> countries = new ArrayList<Country>();
		for (int i = 0; i < records.size(); i++) {
			Object[] record = records.get(i);
			Country country = new Country();
			country.setId(Integer.parseInt(String.valueOf(record[0])));
			country.setName(String.valueOf(record[1]));
			country.setIsd(String.valueOf(record[2]));
			countries.add(country);
		}
		return countries;
	}

	@Override
	public void save(Country model) {
		String sqlQuery = "INSERT INTO tblcountry (id, name, isd) VALUES (?,?,?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionPool.getConnection();
			getAppLogger().info(model.getId() + " => " + sqlQuery);
			preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, model.getId());
			preparedStatement.setString(2, model.getName());
			preparedStatement.setString(3, model.getIsd());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closePreparedStatement(preparedStatement);
			closeConnection(connection);
		}
	}
}
