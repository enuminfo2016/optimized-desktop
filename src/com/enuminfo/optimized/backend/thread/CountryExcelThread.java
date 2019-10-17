/**
 * 
 */
package com.enuminfo.optimized.backend.thread;

import com.enuminfo.optimized.backend.model.Country;
import com.enuminfo.optimized.uitl.DataUtil;

/**
 * @author AKURATI
 */
public class CountryExcelThread extends AbstractFileThread<Country> {
	
	public CountryExcelThread() {
		super(Country.class, "C:\\Users\\" + System.getProperty("user.name")  + "\\countries.csv");
	}

	@Override
	protected Object convertArrayToSpecfic() {
		int i = 1;
		for (String[] model : list) {
			Country country = new Country();
			country.setId(i);
			country.setName(model[1]);
			country.setIsd(model[2]);
			DataUtil.countries.add(country);
			i++;
		}
		return getInputFile() + " : " + DataUtil.countries.size();
	}
}
