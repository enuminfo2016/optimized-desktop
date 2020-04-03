/**
 * 
 */
package com.enuminfo.optimized.backend.thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.enuminfo.optimized.backend.model.Bank;
import com.enuminfo.optimized.backend.repository.AbstractRepository;
import com.enuminfo.optimized.backend.repository.BankRepository;

/**
 * @author AKURATI
 */
public class BankExcelThread extends AbstractFileThread<Bank> {
	
	private List<Bank> banks = new ArrayList<Bank>();

	public BankExcelThread() {
		super(Bank.class, "C:\\Users\\" + System.getProperty("user.name") + "\\ifscodes\\");
	}

	@Override
	protected void convertArrayToSpecfic() {
		int i = 1;
		for (String[] model : list) {
			Bank bank = new Bank();
			if (model[1] != null) {
				bank.setId(i);
				bank.setName(model[0]);
				bank.setIfsc(model[1]);
				bank.setMicr(model[2]);
				bank.setBranch(model[3]);
				bank.setAddress(model[4]);
				bank.setContact(model[5]);
				banks.add(bank);
				i++;
			}
		}
		AbstractRepository<Bank> repository = new BankRepository();
		for (Iterator<Bank> iterator = banks.iterator(); iterator.hasNext();) {
			repository.save(iterator.next());
		}
	}
}
