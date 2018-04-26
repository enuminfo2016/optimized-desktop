/**
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.frontend.form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.enuminfo.optimized.framework.AbstractFormDialogView;
import com.enuminfo.optimized.framework.DataPageController;
import com.enuminfo.optimized.frontend.I18n;
import com.enuminfo.optimized.frontend.ViewHelpers;
import com.enuminfo.optimized.frontend.component.ComboBoxItem;
import com.enuminfo.optimized.frontend.component.JTextFieldExt;
import com.enuminfo.optimized.frontend.contoller.AppController;
import com.enuminfo.optimized.frontend.model.SaleOrder;

import net.miginfocom.swing.MigLayout;

/**
 * Sale Order Form
 * @author Kumar
 */
public class SaleOrderForm extends AbstractFormDialogView<SaleOrder> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SaleOrder saleOrder;
	private boolean isNewModel = false;
	
	private JTextFieldExt textFieldExtOrderDate;
	private JTextFieldExt textFieldExtOrderNumber;
	private JComboBox<ComboBoxItem> comboBoxCustomer;
	
	private JButton btnAddLine;
	
	@SuppressWarnings("serial")
	private DefaultTableModel tableModel = new DefaultTableModel(new String[] {
			I18n.OPTIMIZED.getString("SaleOrder.Page.Product"), I18n.OPTIMIZED.getString("SaleOrder.Page.Quantity"),
			I18n.OPTIMIZED.getString("SaleOrder.Page.UnitPrice"), I18n.OPTIMIZED.getString("SaleOrder.Page.ActualPrice") },
			0) {

		@Override
		public boolean isCellEditable(int row, int column) {
			return true;
		}
	};
	
	private JTable orderLines = new JTable(tableModel);
	
	private JTextFieldExt textFieldExtProduct;
	private JTextFieldExt textFieldExtQuantity;
	private JTextFieldExt textFieldExtUnitPrice;
	private JTextFieldExt textFieldExtActualPrice;
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("EEEE', 'dd MMMM yyyy");
	
	public SaleOrderForm(DataPageController<SaleOrder> controller, SaleOrder saleOrder) {
		super(AppController.get().getView(), controller);
		this.saleOrder = saleOrder;
		if (saleOrder.getId() == 0)
			isNewModel = true;
	}

	@Override
	public String getFormTitle() {
		if (isNewModel)
			return I18n.OPTIMIZED.getString("SaleOrder.Form.NewTitle");
		else
			return I18n.OPTIMIZED.getString("SaleOrder.Form.EditTitle");
	}

	@Override
	public String getFormIconPath() {
		return ViewHelpers.ICONS16 + "category.png";
	}

	@Override
	public void buildUI() {
		initComponents();
		textFieldExtOrderDate = new JTextFieldExt(50);
		textFieldExtOrderDate.setEditable(false);
		textFieldExtOrderNumber = new JTextFieldExt(50);
		textFieldExtOrderNumber.requestFocus();
		comboBoxCustomer = new JComboBox<>();
		btnAddLine = new JButton(I18n.OPTIMIZED.getString("SaleOrder.Form.AddLine"));
		JScrollPane scrollPane = new JScrollPane(orderLines, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		orderLines.setFillsViewportHeight(true);
		JPanel panel = new JPanel(new MigLayout("insets 20 10 10 10", "[][50:100,fill][fill,grow]", ""));
		panel.add(new JLabel(I18n.OPTIMIZED.getString("SaleOrder.Form.OrderDate")), "gap para");
        panel.add(textFieldExtOrderDate, "span");
		panel.add(new JLabel(I18n.OPTIMIZED.getString("SaleOrder.Form.OrderNumber")), "gap para");
        panel.add(textFieldExtOrderNumber, "span");
		panel.add(new JLabel(I18n.OPTIMIZED.getString("SaleOrder.Form.Customer")), "gap para");
        panel.add(comboBoxCustomer, "span");
        panel.add(new JLabel(), "gap para");
        panel.add(btnAddLine, "gap para");
        btnAddLine.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textFieldExtProduct = new JTextFieldExt(20);
				textFieldExtQuantity = new JTextFieldExt(20);
				textFieldExtUnitPrice = new JTextFieldExt(20);
				textFieldExtActualPrice = new JTextFieldExt(20);
				tableModel.addRow(new Object[] { textFieldExtProduct, textFieldExtQuantity, textFieldExtUnitPrice, textFieldExtActualPrice });
			}
		});
        panel.add(scrollPane, "span");
		addPageToForm("", panel);
        popFields();
        pack();
        setSize(730, 630);
	}

	@Override
	public void popFields() {
		textFieldExtOrderDate.setText(DATE_FORMAT.format(new Date()));
	}

	@Override
	public void pushFields() {
		
	}

	@Override
	public SaleOrder getModel() {
		return saleOrder;
	}

	@Override
	public void onHelp() {
		
	}
}
