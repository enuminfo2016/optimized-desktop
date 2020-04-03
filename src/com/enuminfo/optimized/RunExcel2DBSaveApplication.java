/**
 * 
 */
package com.enuminfo.optimized;

import com.enuminfo.optimized.backend.thread.BankExcelThread;
import com.enuminfo.optimized.backend.thread.CountryExcelThread;
import com.enuminfo.optimized.backend.thread.LocationExcelThread;

/**
 * @author SIVA KUMAR
 */
public class RunExcel2DBSaveApplication {

	public static void main(String[] args) {
		new CountryExcelThread().run();
		new LocationExcelThread().run();
		new BankExcelThread().run();		
	}
}
