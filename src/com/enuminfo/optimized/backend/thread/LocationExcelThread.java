/**
 * 
 */
package com.enuminfo.optimized.backend.thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.enuminfo.optimized.backend.model.Location;
import com.enuminfo.optimized.backend.repository.AbstractRepository;
import com.enuminfo.optimized.backend.repository.LocationRepository;

/**
 * @author AKURATI
 */
public class LocationExcelThread extends AbstractFileThread<Location> {
	
	private List<Location> locations = new ArrayList<Location>();

	public LocationExcelThread() {
		super(Location.class, "C:\\Users\\" + System.getProperty("user.name") + "\\locations.csv");
	}

	@Override
	protected void convertArrayToSpecfic() {
		int i = 1;
		for (String[] model : list) {
			Location location = new Location();
			location.setId(i);
			location.setName(model[1]);
			location.setPin(Long.parseLong(model[2]));
			location.setCity(model[3]);
			location.setState(model[4]);
			location.setCountry(model[5]);
			locations.add(location);
			i++;
		}
		AbstractRepository<Location> repository = new LocationRepository();
		for (Iterator<Location> iterator = locations.iterator(); iterator.hasNext();) {
			repository.save(iterator.next());
		}
	}
}
