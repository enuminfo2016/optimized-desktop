/**
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.frontend.form;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import com.enuminfo.optimized.framework.AbstractFormDialogView;
import com.enuminfo.optimized.framework.DataPageController;
import com.enuminfo.optimized.frontend.I18n;
import com.enuminfo.optimized.frontend.ViewHelpers;
import com.enuminfo.optimized.frontend.component.ComboBoxItem;
import com.enuminfo.optimized.frontend.component.JTextFieldExt;
import com.enuminfo.optimized.frontend.contoller.AppController;
import com.enuminfo.optimized.frontend.model.Customer;

import net.miginfocom.swing.MigLayout;

/**
 * Customer Form
 * 
 * @author Kumar
 */
public class CustomerForm extends AbstractFormDialogView<Customer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Customer customer;
	private boolean isNewModel = false;

	private JTextFieldExt textFieldExtCompanyName;
	private JTextPane textPaneCompanyAddress;
	private JTextFieldExt textFieldExtCompanyPhone;
	private JTextFieldExt textFieldExtCompanyFax;
	private JTextFieldExt textFieldExtCompanyEmail;
	private JTextFieldExt textFieldExtCompanyWebSite;

	private JTextFieldExt textFieldExtPersonName;
	private JTextFieldExt textFieldExtPersonDesignation;
	private JTextFieldExt textFieldExtPersonMobile;
	private JTextFieldExt textFieldExtPersonFax;
	private JTextFieldExt textFieldExtPersonEmail;

	private JComboBox<ComboBoxItem> comboBoxAddressWork;
	private JComboBox<ComboBoxItem> comboxBoxTypeOfOwnership;
	private JComboBox<ComboBoxItem> comboxBoxNatureOfBusiness;
	private JTextFieldExt textFieldExtNsic;
	private JTextFieldExt textFieldExtMsme;
	private JComboBox<ComboBoxItem> comboBoxBank;
	private JTextFieldExt textFieldExtBankAccount;

	public CustomerForm(DataPageController<Customer> controller, Customer customer) {
		super(AppController.get().getView(), controller);
		this.customer = customer;
		if (customer.getId() == 0)
			isNewModel = true;
	}

	@Override
	public String getFormTitle() {
		if (isNewModel)
			return I18n.OPTIMIZED.getString("Customer.Form.NewTitle");
		else
			return I18n.OPTIMIZED.getString("Customer.Form.EditTitle");
	}

	@Override
	public String getFormIconPath() {
		return ViewHelpers.ICONS16 + "customer.png";
	}

	@Override
	public void buildUI() {
		initComponents();
		addPageToForm(I18n.OPTIMIZED.getString("Customer.Form.CompanyPage.Title"), buildCompanyPage());
		addPageToForm(I18n.OPTIMIZED.getString("Customer.Form.PersonPage.Title"), buildPersonPage());
		addPageToForm(I18n.OPTIMIZED.getString("Customer.Form.AccountPage.Title"), buildAccountPage());
		popFields();
		pack();
		setSize(550, 530);
	}

	private JPanel buildAccountPage() {
		comboBoxAddressWork = new JComboBox<>();
		comboBoxAddressWork.requestFocus();
		comboxBoxTypeOfOwnership = new JComboBox<>();
		comboxBoxNatureOfBusiness = new JComboBox<>();
		textFieldExtNsic = new JTextFieldExt(50);
		textFieldExtMsme = new JTextFieldExt(50);
		comboBoxBank = new JComboBox<>();
		textFieldExtBankAccount = new JTextFieldExt(50);
		JPanel panel = new JPanel(new MigLayout("insets 20 10 10 10", "[][50:100,fill][fill,grow]", ""));
		panel.add(new JLabel(I18n.OPTIMIZED.getString("Customer.Form.AddressWork")), "gap para");
		panel.add(comboBoxAddressWork, "span");
		panel.add(new JLabel(I18n.OPTIMIZED.getString("Customer.Form.TypeOfOwnership")), "gap para");
		panel.add(comboxBoxTypeOfOwnership, "span");
		panel.add(new JLabel(I18n.OPTIMIZED.getString("Customer.Form.NatureOfBusiness")), "gap para");
		panel.add(comboxBoxNatureOfBusiness, "span");
		panel.add(new JLabel(I18n.OPTIMIZED.getString("Customer.Form.NSIC")), "gap para");
		panel.add(textFieldExtNsic, "span");
		panel.add(new JLabel(I18n.OPTIMIZED.getString("Customer.Form.MSME")), "gap para");
		panel.add(textFieldExtMsme, "span");
		panel.add(new JLabel(I18n.OPTIMIZED.getString("Customer.Form.BankAccount")), "gap para");
		panel.add(textFieldExtBankAccount, "span");
		panel.add(new JLabel(I18n.OPTIMIZED.getString("Customer.Form.Bank")), "gap para");
		panel.add(comboBoxBank, "span");
		return panel;
	}

	private JPanel buildPersonPage() {
		textFieldExtPersonName = new JTextFieldExt(50);
		textFieldExtPersonName.requestFocus();
		textFieldExtPersonDesignation = new JTextFieldExt(50);
		textFieldExtPersonFax = new JTextFieldExt(50);
		textFieldExtPersonEmail = new JTextFieldExt(50);
		textFieldExtPersonMobile = new JTextFieldExt(50);
		JPanel panel = new JPanel(new MigLayout("insets 20 10 10 10", "[][50:100,fill][fill,grow]", ""));
		panel.add(new JLabel(I18n.OPTIMIZED.getString("Customer.Form.PersonName")), "gap para");
		panel.add(textFieldExtPersonName, "span");
		panel.add(new JLabel(I18n.OPTIMIZED.getString("Customer.Form.PersonDesignation")), "gap para");
		panel.add(textFieldExtPersonDesignation, "span");
		panel.add(new JLabel(I18n.OPTIMIZED.getString("Customer.Form.PersonFax")), "gap para");
		panel.add(textFieldExtPersonFax, "span");
		panel.add(new JLabel(I18n.OPTIMIZED.getString("Customer.Form.PersonEmail")), "gap para");
		panel.add(textFieldExtPersonEmail, "span");
		panel.add(new JLabel(I18n.OPTIMIZED.getString("Customer.Form.PersonMobile")), "gap para");
		panel.add(textFieldExtPersonMobile, "span");
		return panel;
	}

	private JPanel buildCompanyPage() {
		textFieldExtCompanyName = new JTextFieldExt(50);
		textFieldExtCompanyName.requestFocus();
		textPaneCompanyAddress = new JTextPane();
		textPaneCompanyAddress.setPreferredSize(new Dimension(50, 200));
		textPaneCompanyAddress.setMargin(new Insets(0, 0, 0, 0));
		textFieldExtCompanyPhone = new JTextFieldExt(50);
		textFieldExtCompanyFax = new JTextFieldExt(50);
		textFieldExtCompanyEmail = new JTextFieldExt(50);
		textFieldExtCompanyWebSite = new JTextFieldExt(50);
		JPanel panel = new JPanel(new MigLayout("insets 20 10 10 10", "[][50:100,fill][fill,grow]", ""));
		panel.add(new JLabel(I18n.OPTIMIZED.getString("Customer.Form.CompanyName")), "gap para");
		panel.add(textFieldExtCompanyName, "span");
		panel.add(new JLabel(I18n.OPTIMIZED.getString("Customer.Form.CompanyAddress")), "gap para");
		panel.add(textPaneCompanyAddress, "span");
		panel.add(new JLabel(I18n.OPTIMIZED.getString("Customer.Form.CompanyPhone")), "gap para");
		panel.add(textFieldExtCompanyPhone, "span");
		panel.add(new JLabel(I18n.OPTIMIZED.getString("Customer.Form.CompanyFax")), "gap para");
		panel.add(textFieldExtCompanyFax, "span");
		panel.add(new JLabel(I18n.OPTIMIZED.getString("Customer.Form.CompanyEmail")), "gap para");
		panel.add(textFieldExtCompanyEmail, "span");
		panel.add(new JLabel(I18n.OPTIMIZED.getString("Customer.Form.CompanyWebSite")), "gap para");
		panel.add(textFieldExtCompanyWebSite, "span");
		return panel;
	}

	@Override
	public void popFields() {

	}

	@Override
	public void pushFields() {

	}

	@Override
	public Customer getModel() {
		return customer;
	}

	@Override
	public void onHelp() {

	}

	@Override
	public boolean isMultiPageForm() {
		return true;
	}
}
