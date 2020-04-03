/**
 * 
 */
package com.enuminfo.optimized.backend.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		List<Bank> banks = new ArrayList<Bank>();
		for (int i = 0; i < records.size(); i++) {
			Object[] record = records.get(i);
			Bank bank = new Bank();
			bank.setId(Integer.parseInt(String.valueOf(record[0])));
			bank.setName(String.valueOf(record[1]));
			bank.setContact(String.valueOf(record[2]));
			bank.setEmail(String.valueOf(record[3]));
			bank.setAddress(String.valueOf(record[4]));
			bank.setBranch(String.valueOf(record[4]));
			bank.setIfsc(String.valueOf(record[5]));
			bank.setMicr(String.valueOf(record[5]));
			banks.add(bank);
		}
		return banks;
	}

	@Override
	protected String getNamedQuery() {
		return "SELECT * FROM tblbank";
	}

	@Override
	public void save(Bank model) {
		String sqlQuery = "INSERT INTO tblbank (id, name, contact, email, ifsc, micr, branch, address) VALUES (?,?,?,?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionPool.getConnection();
			getAppLogger().info(model.getId() + " => " + sqlQuery);
			preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, model.getId());
			preparedStatement.setString(2, model.getName());
			preparedStatement.setString(3, model.getContact());
			preparedStatement.setString(4, model.getEmail());
			preparedStatement.setString(5, model.getIfsc());
			preparedStatement.setString(6, model.getMicr());
			preparedStatement.setString(7, model.getBranch());
			preparedStatement.setString(8, model.getAddress());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closePreparedStatement(preparedStatement);
			closeConnection(connection);
		}
	}
}
