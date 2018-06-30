/**
 * 
 */
package com.enuminfo.optimized.frontend.preview;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.enuminfo.optimized.frontend.ViewHelpers;
import com.enuminfo.optimized.frontend.component.IconLabel;
import com.enuminfo.optimized.frontend.framework.AbstractPreviewPanel;
import com.enuminfo.optimized.frontend.model.Customer;

import net.miginfocom.swing.MigLayout;

/**
 * @author Kumar
 */
public class CustomerPreview extends AbstractPreviewPanel<Customer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Customer customer;

	private JLabel lblCompanyName;
	private JLabel lblPerson;
	private IconLabel lblAddress;
	private IconLabel lblPhone;
	private IconLabel lblMobile;
	private IconLabel lblEmail;
	private IconLabel lblWebSite;

	public CustomerPreview() {
		super();
	}

	@Override
	public void buildUI() {
		lblCompanyName = new JLabel();
		lblPerson = new JLabel();
		lblAddress = new IconLabel(new ImageIcon(getClass().getResource(ViewHelpers.ICONS16 + "location.png")));
		lblPhone = new IconLabel(new ImageIcon(getClass().getResource(ViewHelpers.ICONS16 + "phone.png")));
		lblMobile = new IconLabel(new ImageIcon(getClass().getResource(ViewHelpers.ICONS16 + "mobile.png")));
		lblEmail = new IconLabel(new ImageIcon(getClass().getResource(ViewHelpers.ICONS16 + "email.png")));
		lblWebSite = new IconLabel(new ImageIcon(getClass().getResource(ViewHelpers.ICONS16 + "homepage.png")));
		JPanel panel = new JPanel(new MigLayout("insets 10 20 10 20"));
		panel.add(lblCompanyName, "wrap");
		panel.add(lblPerson, "wrap");
		panel.add(lblAddress, "wrap");
		panel.add(lblPhone, "wrap");
		panel.add(lblMobile, "wrap");
		panel.add(lblEmail, "wrap");
		panel.add(lblWebSite, "wrap");
		addCenterComponent(panel);
	}

	@Override
	public void popFields() {
		customer = getModel();
		lblCompanyName.setText(customer.getCompanyName());
		lblPerson.setText(customer.getPersonName());
		lblAddress.setText(customer.getCompanyAddress());
		lblPhone.setText(String.valueOf(customer.getCompanyPhone()));
		lblMobile.setText(String.valueOf(customer.getPersonMobile()));
		lblEmail.setText(customer.getPersonEmail());
		lblWebSite.setText(customer.getCompanyWebSite());
	}
}
