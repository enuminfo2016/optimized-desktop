/**
 * 
 */
package com.enuminfo.optimized.backend.thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.enuminfo.optimized.backend.model.Country;
import com.enuminfo.optimized.backend.repository.AbstractRepository;
import com.enuminfo.optimized.backend.repository.CountryRepository;

/**
 * @author AKURATI
 */
public class CountryExcelThread extends AbstractFileThread<Country> {
	
	private List<Country> countries = new ArrayList<Country>();
	
	public CountryExcelThread() {
		super(Country.class, "C:\\Users\\" + System.getProperty("user.name")  + "\\countries.csv");
	}

	@Override
	protected void convertArrayToSpecfic() {
		int i = 1;
		for (String[] model : list) {
			Country country = new Country();
			country.setId(i);
			country.setName(model[1]);
			country.setIsd(model[2]);
			countries.add(country);
			i++;
		}
		AbstractRepository<Country> repository = new CountryRepository();
		for (Iterator<Country> iterator = countries.iterator(); iterator.hasNext();) {
			repository.save(iterator.next());
		}
	}
}
