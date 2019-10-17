/**
 * 
 */
package com.enuminfo.optimized.backend.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.enuminfo.optimized.backend.model.Country;
import com.enuminfo.optimized.uitl.DataUtil;

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
	protected String getNamedQueryWithParameters(Map<String, Object> parameters) {
		return "SELECT * FROM tblcountry";
	}

	@Override
	protected List<Country> getSpecificValuesFromDB(List<Object[]> records) {
		List<Country> countries = new ArrayList<Country>();
		if (records.isEmpty()) {
			countries = DataUtil.countries;
		} else {
			for (int i = 0; i < records.size(); i++) {
				Object[] record = records.get(i);
				Country country = new Country();
				country.setId(Integer.parseInt(String.valueOf(record[0])));
				country.setName(String.valueOf(record[1]));
				country.setIsd(String.valueOf(record[2]));
				countries.add(country);
			}
		}
		return countries;
	}
	
	private List<Country> getPagingList(List<Country> countries, int start, int end) {
		List<Country> finalList = new ArrayList<Country>();
		if (end > countries.size()) end = countries.size();
		for (int i = start; i < end; i++) {
			finalList.add(countries.get(i));
		}
		return finalList;
	}

	@Override
	protected List<Country> getSpecificValuesFromDBWithPaging(List<Object[]> records, int start, int end) {
		List<Country> countries = new ArrayList<Country>();
		if (records.isEmpty()) {
			countries = DataUtil.countries;
		} else {
			for (int i = 0; i < records.size(); i++) {
				Object[] record = records.get(i);
				Country country = new Country();
				country.setId(Integer.parseInt(String.valueOf(record[0])));
				country.setName(String.valueOf(record[1]));
				country.setIsd(String.valueOf(record[2]));
				countries.add(country);
			}
		}
		return getPagingList(countries, start, end);
	}
}
