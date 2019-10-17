/**
 * 
 */
package com.enuminfo.optimized.backend.thread;

import com.enuminfo.optimized.backend.model.Bank;
import com.enuminfo.optimized.uitl.DataUtil;

/**
 * @author AKURATI
 */
public class BankExcelThread extends AbstractFileThread<Bank> {
	
	public BankExcelThread() {
		super(Bank.class, "C:\\Users\\" + System.getProperty("user.name")  + "\\ifscodes\\");
	}

	@Override
	protected Object convertArrayToSpecfic() {
		int i = 1;
		for (String[] model : list) {
			Bank bank = new Bank();
			bank.setId(i);
			bank.setName(model[0]);
			bank.setIfsc(model[1]);
			bank.setMicr(model[2]);
			bank.setBranch(model[3]);
			bank.setAddress(model[4]);
			bank.setContact(Long.parseLong(model[6]));
			DataUtil.banks.add(bank);
			i++;
		}
		return getInputFile() + " : " + DataUtil.banks.size();
	}
}
