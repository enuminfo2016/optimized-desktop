/**
 * 
 */
package com.enuminfo.optimized.uitl;

import java.util.ArrayList;
import java.util.List;

import com.enuminfo.optimized.backend.model.Bank;
import com.enuminfo.optimized.backend.model.Country;
import com.enuminfo.optimized.backend.model.Location;

/**
 * @author AKURATI
 */
public interface DataUtil {

	static List<Country> countries = new ArrayList<Country>();
	static List<Location> locations = new ArrayList<Location>();
	static List<Bank> banks = new ArrayList<Bank>();
}
