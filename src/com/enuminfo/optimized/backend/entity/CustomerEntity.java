/**
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.backend.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.enuminfo.optimized.backend.ColumnType;
import com.enuminfo.optimized.backend.TableType;

/**
 * Customer Entity
 * 
 * @author Kumar
 */
@Entity
@Table(name = TableType.CUSTOMER)
@NamedQueries({ @NamedQuery(name = CustomerEntity.FIND_ALL, query = "SELECT entity FROM CustomerEntity entity"),
		@NamedQuery(name = CustomerEntity.FIND_BY_NAME, query = "SELECT entity FROM CustomerEntity entity WHERE entity.companyName LIKE :companyName") })
@AttributeOverride(name = ColumnType.ID, column = @Column(name = ColumnType.ID))
public class CustomerEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String FIND_ALL = "Customer.FindAll";
	public static final String FIND_BY_NAME = "Customer.FindByName";

	@Column(name = ColumnType.COMPANY_NAME)
	private String companyName;

	@Column(name = ColumnType.COMPANY_ADDRESS)
	private String companyAddress;

	@Column(name = ColumnType.COMPANY_PHONE)
	private Long companyPhone;

	@Column(name = ColumnType.COMPANY_FAX)
	private Long companyFax;

	@Column(name = ColumnType.COMPANY_EMAIL)
	private String companyEmail;

	@Column(name = ColumnType.COMPANY_WEB_SITE)
	private String companyWebSite;

	@Column(name = ColumnType.PERSON_NAME)
	private String personName;

	@Column(name = ColumnType.PERSON_MOBILE)
	private Long personMobile;

	@Column(name = ColumnType.PERSON_FAX)
	private Long personFax;

	@Column(name = ColumnType.PERSON_EMAIL)
	private String personEmail;

	@Column(name = ColumnType.PERSON_DESIGNATION)
	private String personDesignation;

	@Column(name = ColumnType.ADDRESS_WORKS)
	private String addressWork;

	@Column(name = ColumnType.TYPE_OWNERSHIP)
	private String typeOfOwnership;

	@Column(name = ColumnType.COMPANY_NSIC)
	private String companyNsic;

	@Column(name = ColumnType.COMPANY_MSME)
	private String companyMsme;

	@Column(name = ColumnType.NATURE_BUSINESS)
	private String natureOfBusiness;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = ColumnType.COMPANY_BANK)
	private BankEntity companyBank;

	@Column(name = ColumnType.COMPANY_BANK_ACCOUNT)
	private String companyBankAccount;

	public CustomerEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public Long getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(Long companyPhone) {
		this.companyPhone = companyPhone;
	}

	public Long getCompanyFax() {
		return companyFax;
	}

	public void setCompanyFax(Long companyFax) {
		this.companyFax = companyFax;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getCompanyWebSite() {
		return companyWebSite;
	}

	public void setCompanyWebSite(String companyWebSite) {
		this.companyWebSite = companyWebSite;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Long getPersonMobile() {
		return personMobile;
	}

	public void setPersonMobile(Long personMobile) {
		this.personMobile = personMobile;
	}

	public Long getPersonFax() {
		return personFax;
	}

	public void setPersonFax(Long personFax) {
		this.personFax = personFax;
	}

	public String getPersonEmail() {
		return personEmail;
	}

	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}

	public String getPersonDesignation() {
		return personDesignation;
	}

	public void setPersonDesignation(String personDesignation) {
		this.personDesignation = personDesignation;
	}

	public String getAddressWork() {
		return addressWork;
	}

	public void setAddressWork(String addressWork) {
		this.addressWork = addressWork;
	}

	public String getTypeOfOwnership() {
		return typeOfOwnership;
	}

	public void setTypeOfOwnership(String typeOfOwnership) {
		this.typeOfOwnership = typeOfOwnership;
	}

	public String getCompanyNsic() {
		return companyNsic;
	}

	public void setCompanyNsic(String companyNsic) {
		this.companyNsic = companyNsic;
	}

	public String getCompanyMsme() {
		return companyMsme;
	}

	public void setCompanyMsme(String companyMsme) {
		this.companyMsme = companyMsme;
	}

	public String getNatureOfBusiness() {
		return natureOfBusiness;
	}

	public void setNatureOfBusiness(String natureOfBusiness) {
		this.natureOfBusiness = natureOfBusiness;
	}

	public BankEntity getCompanyBank() {
		return companyBank;
	}

	public void setCompanyBank(BankEntity companyBank) {
		this.companyBank = companyBank;
	}

	public String getCompanyBankAccount() {
		return companyBankAccount;
	}

	public void setCompanyBankAccount(String companyBankAccount) {
		this.companyBankAccount = companyBankAccount;
	}
}
