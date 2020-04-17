/**
 * 
 */
package com.enuminfo.optimized.backend.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.enuminfo.optimized.backend.model.Country;

/**
 * @author AKURATI
 */
public class CountryRepository extends BaseRepository<Country> {
	
	public CountryRepository() {
		super(Country.class);
	}
	
	@Override
	protected String getSelectQuery() {
		return "SELECT * FROM tblcountry";
	}

	@Override
	protected String getInsertQuery() {
		return null;
	}

	@Override
	protected String getUpdateQuery() {
		return null;
	}

	@Override
	protected String getDeleteQuery() {
		return null;
	}

	@Override
	protected List<Country> getSpecificValues(List<Object[]> records) {
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
	protected Map<Integer, Object> putSpecificValues(Country model) {
		return null;
	}
}
