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
	
	public RunExcel2DBSaveApplication() {
		new CountryExcelThread().run();
		new LocationExcelThread().run();
		new BankExcelThread().run();
	}

	public static void main(String[] args) {
		new RunExcel2DBSaveApplication();
	}
}
