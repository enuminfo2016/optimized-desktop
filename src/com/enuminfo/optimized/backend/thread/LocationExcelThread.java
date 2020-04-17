/**
 * 
 */
package com.enuminfo.optimized.backend.thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.enuminfo.optimized.backend.model.Location;

/**
 * @author AKURATI
 */
public class LocationExcelThread extends AbstractFileThread<Location> {
	
	private List<Location> locations;

	public LocationExcelThread() {
		super(Location.class, "C:\\Users\\" + System.getProperty("user.name") + "\\locations.csv");
	}

	@Override
	protected void convertArrayToSpecfic() {
		locations = new ArrayList<Location>();
		int i = 1;
		for (String[] model : list) {
			Location location = new Location();
			location.setId(i);
			location.setName(model[1]);
			location.setPin(model[2]);
			location.setCity(model[3]);
			location.setState(model[4]);
			location.setCountry(Integer.parseInt(model[5]));
			locations.add(location);
			i++;
		}
		//BaseRepository<Location> repository = new LocationRepository();
		for (Iterator<Location> iterator = locations.iterator(); iterator.hasNext();) {
			Location location = iterator.next();
			System.out.println(location.getId() + "\t" + location.getName() + "\t" + location.getPin() + "\t" + location.getCity() + "\t" + location.getState() + "\t" + location.getCountry());
			//repository.save(iterator.next());
		}
	}
}
