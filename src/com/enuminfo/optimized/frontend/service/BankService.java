/**
 * 
 */
package com.enuminfo.optimized.frontend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.enuminfo.optimized.backend.entity.BankEntity;
import com.enuminfo.optimized.backend.repository.BankRepository;
import com.enuminfo.optimized.frontend.component.ComboBoxItem;
import com.enuminfo.optimized.frontend.model.Bank;

/**
 * @author Kumar
 */
public class BankService extends AbstractService<Bank> {

	public BankService() {
		super(Bank.class);
	}

	@Override
	public Object getRepository() {
		return new BankRepository();
	}

	@Override
	public String getNamedQuery() {
		return BankEntity.FIND_ALL;
	}

	@Override
	public String getNamedQueryWithFilter() {
		return BankEntity.FIND_BY_NAME;
	}

	@Override
	public void add(Bank model) {

	}

	@Override
	public void edit(Bank model) {

	}

	@Override
	public Bank getById(Integer id) {
		return null;
	}

	@Override
	public List<Bank> getListWithNamedQuery() {
		List<Bank> banks = new ArrayList<>();
		return banks;
	}

	@Override
	public List<Bank> getListWithNamedQueryAndParameters(Map<String, Object> parameters) {
		List<Bank> banks = new ArrayList<>();
		return banks;
	}

	@Override
	public List<Bank> getListWithNamedQueryAndParameters(Map<String, Object> parameters, int start, int end) {
		List<Bank> banks = new ArrayList<>();
		return banks;
	}

	@Override
	public List<Bank> getListWithNamedQuery(int start, int end) {
		List<Bank> banks = new ArrayList<>();
		return banks;
	}

	@Override
	public List<ComboBoxItem> getListOfReferences() {
		return null;
	}
}
