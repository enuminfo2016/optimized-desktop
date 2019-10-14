/**
 * 
 */
package com.enuminfo.optimized.frontend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.enuminfo.optimized.frontend.component.ComboBoxItem;
import com.enuminfo.optimized.frontend.model.Bank;
import com.enuminfo.optimized.uitl.DataUtil;

/**
 * @author AKURATI
 */
public class BankService extends AbstractService<Bank> {

	public BankService() {
		super(Bank.class);
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
		List<Bank> banks = new ArrayList<Bank>();
		// banks from database
		if (banks.isEmpty())
			banks = DataUtil.banks;
		return banks;
	}

	@Override
	public List<Bank> getListWithNamedQuery(Map<String, Object> parameters) {
		List<Bank> banks = new ArrayList<Bank>();
		// banks from database
		if (banks.isEmpty())
			banks = DataUtil.banks;
		return banks;
	}

	@Override
	public List<Bank> getListWithNamedQuery(Map<String, Object> parameters, int start, int end) {
		List<Bank> banks = new ArrayList<Bank>();
		// banks from database
		if (banks.isEmpty())
			banks = DataUtil.banks;
		return getPagingList(banks, start, end);
	}

	@Override
	public List<Bank> getListWithNamedQuery(int start, int end) {
		List<Bank> banks = new ArrayList<Bank>();
		// banks from database
		if (banks.isEmpty())
			banks = DataUtil.banks;
		return getPagingList(banks, start, end);
	}

	@Override
	public List<ComboBoxItem> getListOfReferences() {
		return null;
	}
	
	private List<Bank> getPagingList(List<Bank> banks, int start, int end) {
		List<Bank> finalList = new ArrayList<Bank>();
		if (end > banks.size()) end = banks.size();
		for (int i = start; i < end; i++) {
			finalList.add(banks.get(i));
		}
		return finalList;
	}
}
