/**
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.frontend.form;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.enuminfo.optimized.framework.AbstractFormDialogView;
import com.enuminfo.optimized.framework.DataPageController;
import com.enuminfo.optimized.frontend.I18n;
import com.enuminfo.optimized.frontend.ViewHelpers;
import com.enuminfo.optimized.frontend.component.ComboBoxItem;
import com.enuminfo.optimized.frontend.component.JTextFieldExt;
import com.enuminfo.optimized.frontend.component.MessageBox;
import com.enuminfo.optimized.frontend.contoller.AppController;
import com.enuminfo.optimized.frontend.model.Product;
import com.enuminfo.optimized.service.CategoryService;

import net.miginfocom.swing.MigLayout;

/**
 * Product Form
 * 
 * @author Kumar
 */
public class ProductForm extends AbstractFormDialogView<Product> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Product product;
	private boolean isNewModel = false;

	private JTextFieldExt textFieldExtName;
	private JTextFieldExt textFieldExtCode;
	private JComboBox<ComboBoxItem> comboBoxCategory;

	public ProductForm(DataPageController<Product> controller, Product product) {
		super(AppController.get().getView(), controller);
		this.product = product;
		if (product.getId() == 0)
			isNewModel = true;
	}

	@Override
	public String getFormTitle() {
		if (isNewModel)
			return I18n.OPTIMIZED.getString("Product.Form.NewTitle");
		else
			return I18n.OPTIMIZED.getString("Product.Form.EditTitle");
	}

	@Override
	public String getFormIconPath() {
		return ViewHelpers.ICONS16 + "category.png";
	}

	@Override
	public void buildUI() {
		initComponents();
		comboBoxCategory = new JComboBox<ComboBoxItem>();
		comboBoxCategory.setSelectedItem(null);
		new CategoryService().getListOfReferences().forEach(item -> {
			comboBoxCategory.addItem(item);
		});
		comboBoxCategory.requestFocus();
		textFieldExtName = new JTextFieldExt(50);
		textFieldExtCode = new JTextFieldExt(50);
		JPanel panel = new JPanel(new MigLayout("insets 20 10 10 10", "[][50:100,fill][fill,grow]", ""));
		panel.add(new JLabel(I18n.OPTIMIZED.getString("Product.Form.Category")), "gap para");
		panel.add(comboBoxCategory, "span");
		panel.add(new JLabel(I18n.OPTIMIZED.getString("Product.Form.Name")), "gap para");
		panel.add(textFieldExtName, "span");
		panel.add(new JLabel(I18n.OPTIMIZED.getString("Product.Form.Code")), "gap para");
		panel.add(textFieldExtCode, "span");
		addPageToForm("", panel);
		popFields();
		pack();
		setSize(430, 330);
	}

	@Override
	public void popFields() {
		if (product.getId() != 0) {
			comboBoxCategory.setSelectedItem(new ComboBoxItem(String.valueOf(product.getCId()), product.getCategory()));
			textFieldExtName.setText(product.getName());
			textFieldExtCode.setText(product.getCode());
		}
	}

	@Override
	public void pushFields() {
		ComboBoxItem comboBoxItem = (ComboBoxItem) comboBoxCategory.getSelectedItem();
		product.setCId(Integer.parseInt(comboBoxItem.getKey()));
		product.setCategory(comboBoxItem.getValue());
		product.setName(textFieldExtName.getText());
		product.setCode(textFieldExtCode.getText());
	}

	@Override
	public Product getModel() {
		return product;
	}

	@Override
	public void onHelp() {

	}

	@Override
	public boolean validateForm() {
		if (comboBoxCategory.getSelectedItem() == null) {
			MessageBox.showWarning(I18n.OPTIMIZED.getString("Product.Form.CategoryError"));
			comboBoxCategory.requestFocus();
			return false;
		} else if (textFieldExtName.getText().equals("")) {
			MessageBox.showWarning(I18n.OPTIMIZED.getString("Product.Form.NameError"));
			textFieldExtName.requestFocus();
			return false;
		} else if (textFieldExtCode.getText().equals("")) {
			MessageBox.showWarning(I18n.OPTIMIZED.getString("Product.Form.CodeError"));
			textFieldExtCode.requestFocus();
			return false;
		}
		return true;
	}
}
