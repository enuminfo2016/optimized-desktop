/**
 * 
 */
package com.enuminfo.optimized.backend.thread;

import com.enuminfo.optimized.backend.model.Location;
import com.enuminfo.optimized.uitl.DataUtil;

/**
 * @author AKURATI
 */
public class LocationExcelThread extends AbstractFileThread<Location> {
	
	public LocationExcelThread() {
		super(Location.class, "C:\\Users\\" + System.getProperty("user.name")  + "\\locations.csv");
	}

	@Override
	protected Object convertArrayToSpecfic() {
		int i = 1;
		for (String[] model : list) {
			Location location = new Location();
			location.setId(i);
			location.setName(model[1]);
			location.setPin(Long.parseLong(model[2]));
			location.setCity(model[3]);
			location.setState(model[4]);
			location.setCountry(model[5]);
			DataUtil.locations.add(location);
			i++;
		}
		return getInputFile() + " : " + DataUtil.locations.size();
	}
}
