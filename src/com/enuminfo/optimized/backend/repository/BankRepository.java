/**
 * 
 */
package com.enuminfo.optimized.backend.repository;

import java.util.List;
import java.util.Map;

import com.enuminfo.optimized.backend.model.Bank;

/**
 * @author AKURATI
 */
public class BankRepository extends AbstractRepository<Bank> {

	public BankRepository() {
		super(Bank.class);
	}

	@Override
	protected List<Bank> getSpecificValuesFromDB(List<Object[]> records) {
		return null;
	}

	@Override
	protected String getNamedQuery() {
		return null;
	}

	@Override
	protected String getNamedQueryWithParameters(Map<String, Object> parameters) {
		return null;
	}

	@Override
	protected List<Bank> getSpecificValuesFromDBWithPaging(List<Object[]> records, int start, int end) {
		return null;
	}
}
