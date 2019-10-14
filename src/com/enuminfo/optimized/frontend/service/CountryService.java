/**
 * 
 */
package com.enuminfo.optimized.frontend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.enuminfo.optimized.frontend.component.ComboBoxItem;
import com.enuminfo.optimized.frontend.model.Country;
import com.enuminfo.optimized.uitl.DataUtil;

/**
 * @author AKURATI
 */
public class CountryService extends AbstractService<Country> {

	public CountryService() {
		super(Country.class);
	}

	@Override
	public void add(Country model) {
		
	}

	@Override
	public void edit(Country model) {
		
	}

	@Override
	public Country getById(Integer id) {
		return null;
	}

	@Override
	public List<Country> getListWithNamedQuery() {
		List<Country> countries = new ArrayList<Country>();
		// countries from database
		if (countries.isEmpty())
			countries = DataUtil.countries;
		return countries;
	}

	@Override
	public List<Country> getListWithNamedQuery(Map<String, Object> parameters) {
		List<Country> countries = new ArrayList<Country>();
		// countries from database
		if (countries.isEmpty())
			countries = DataUtil.countries;
		return countries;
	}

	@Override
	public List<Country> getListWithNamedQuery(Map<String, Object> parameters, int start, int end) {
		List<Country> countries = new ArrayList<Country>();
		// countries from database
		if (countries.isEmpty())
			countries = DataUtil.countries;
		return getPagingList(countries, start, end);
	}

	@Override
	public List<Country> getListWithNamedQuery(int start, int end) {
		List<Country> countries = new ArrayList<Country>();
		// countries from database
		if (countries.isEmpty())
			countries = DataUtil.countries;
		return getPagingList(countries, start, end);
	}

	@Override
	public List<ComboBoxItem> getListOfReferences() {
		return null;
	}
	
	private List<Country> getPagingList(List<Country> countries, int start, int end) {
		List<Country> finalList = new ArrayList<Country>();
		if (end > countries.size()) end = countries.size();
		for (int i = start; i < end; i++) {
			finalList.add(countries.get(i));
		}
		return finalList;
	}
}
