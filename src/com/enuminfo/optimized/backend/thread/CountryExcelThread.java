/**
 * 
 */
package com.enuminfo.optimized.backend.thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.enuminfo.optimized.backend.model.Country;

/**
 * @author AKURATI
 */
public class CountryExcelThread extends AbstractFileThread<Country> {
	
	private List<Country> countries;
	
	public CountryExcelThread() {
		super(Country.class, "C:\\Users\\" + System.getProperty("user.name")  + "\\countries.csv");
	}

	@Override
	protected void convertArrayToSpecfic() {
		countries = new ArrayList<Country>();
		int i = 1;
		for (String[] model : list) {
			Country country = new Country();
			country.setId(i);
			country.setName(model[1]);
			country.setIsd(model[2]);
			countries.add(country);
			i++;
		}
		//BaseRepository<Country> repository = new CountryRepository();
		for (Iterator<Country> iterator = countries.iterator(); iterator.hasNext();) {
			Country country = iterator.next();
			System.out.println(country.getId() + "\t" + country.getName() + "\t" + country.getIsd());
			//repository.save(iterator.next());
		}
	}
}
