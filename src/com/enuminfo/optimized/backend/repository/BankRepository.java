/**
 * 
 */
package com.enuminfo.optimized.backend.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.enuminfo.optimized.backend.model.Bank;

/**
 * @author AKURATI
 */
public class BankRepository extends BaseRepository<Bank> {

	public BankRepository() {
		super(Bank.class);
	}

	@Override
	protected String getSelectQuery() {
		return "SELECT * FROM tblbank";
	}

	@Override
	protected String getInsertQuery() {
		return null;
	}

	@Override
	protected String getUpdateQuery() {
		return null;
	}

	@Override
	protected String getDeleteQuery() {
		return null;
	}

	@Override
	protected List<Bank> getSpecificValues(List<Object[]> records) {
		List<Bank> banks = new ArrayList<Bank>();
		for (int i = 0; i < records.size(); i++) {
			Object[] record = records.get(i);
			Bank bank = new Bank();
			bank.setId(Integer.parseInt(String.valueOf(record[0])));
			bank.setName(String.valueOf(record[1]));
			bank.setContact(String.valueOf(record[2]));
			bank.setEmail(String.valueOf(record[3]));
			bank.setAddress(String.valueOf(record[4]));
			bank.setBranch(String.valueOf(record[5]));
			bank.setIfsc(String.valueOf(record[6]));
			bank.setMicr(String.valueOf(record[7]));
			banks.add(bank);
		}
		return banks;
	}

	@Override
	protected Map<Integer, Object> putSpecificValues(Bank model) {
		return null;
	}
}
