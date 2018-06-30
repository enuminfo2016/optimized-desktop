/**
 *
 */
package com.enuminfo.optimized.frontend.form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.enuminfo.optimized.frontend.I18n;
import com.enuminfo.optimized.frontend.ViewHelpers;
import com.enuminfo.optimized.frontend.component.ComboBoxItem;
import com.enuminfo.optimized.frontend.component.TextFieldExt;
import com.enuminfo.optimized.frontend.contoller.AppController;
import com.enuminfo.optimized.frontend.framework.AbstractFormDialogView;
import com.enuminfo.optimized.frontend.framework.DataPageController;
import com.enuminfo.optimized.frontend.model.OrderLine;
import com.enuminfo.optimized.frontend.model.SaleOrder;
import com.enuminfo.optimized.frontend.service.CategoryService;
import com.enuminfo.optimized.frontend.service.CustomerService;
import com.enuminfo.optimized.frontend.service.ProductService;

import net.miginfocom.swing.MigLayout;

/**
 * @author Kumar
 */
public class SaleOrderForm extends AbstractFormDialogView<SaleOrder> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SaleOrder saleOrder;
	private boolean isNewModel = false;

	private TextFieldExt textFieldExtOrderDate;
	private TextFieldExt textFieldExtOrderNumber;
	private JComboBox<ComboBoxItem> comboBoxCustomer;

	private JButton btnAddLine;

	@SuppressWarnings("serial")
	private DefaultTableModel tableModel = new DefaultTableModel(new String[] {
			I18n.OPTIMIZED.getString("SaleOrder.Page.Product"), I18n.OPTIMIZED.getString("SaleOrder.Page.Quantity"),
			I18n.OPTIMIZED.getString("SaleOrder.Page.UnitPrice"),
			I18n.OPTIMIZED.getString("SaleOrder.Page.ActualPrice") }, 0) {

		@Override
		public boolean isCellEditable(int row, int column) {
			return true;
		}
	};

	private JTable orderLines = new JTable(tableModel);

	private JComboBox<ComboBoxItem> comboBoxCategory;
	private JComboBox<ComboBoxItem> comboBoxProduct;
	private TextFieldExt textFieldExtQuantity;
	private TextFieldExt textFieldExtUnitPrice;

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
		addPageToForm(I18n.OPTIMIZED.getString("SaleOrder.Form.SalePage.Title"), buildSalePage());
		addPageToForm(I18n.OPTIMIZED.getString("SaleOrder.Form.OrderPage.Title"), buildOrderPage());
		popFields();
		pack();
		setSize(550, 730);
	}

	private JPanel buildOrderPage() {
		comboBoxCategory = new JComboBox<>();
		new CategoryService().getListOfReferences().forEach(item -> {
			comboBoxCategory.addItem(item);
		});
		comboBoxCategory.requestFocus();
		comboBoxProduct = new JComboBox<>();
		comboBoxCategory.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ComboBoxItem comboBoxItemCategory = (ComboBoxItem) comboBoxCategory.getSelectedItem();
					comboBoxProduct.removeAllItems();
					new ProductService().getListWithNamedQuery().forEach(item -> {
						if (item.getCId() == Integer.parseInt(comboBoxItemCategory.getKey()))
							comboBoxProduct.addItem(new ComboBoxItem(String.valueOf(item.getId()), item.getName()));
					});
				}
			}
		});
		textFieldExtQuantity = new TextFieldExt(20);
		textFieldExtUnitPrice = new TextFieldExt(20);
		btnAddLine = new JButton(I18n.OPTIMIZED.getString("SaleOrder.Form.AddLine"));
		JScrollPane scrollPane = new JScrollPane(orderLines, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		orderLines.setFillsViewportHeight(true);
		JPanel panel = new JPanel(new MigLayout("insets 20 10 10 10", "[][50:100,fill][fill,grow]", ""));
		panel.add(new JLabel(I18n.OPTIMIZED.getString("SaleOrder.Form.Category")), "gap para");
		panel.add(comboBoxCategory, "span");
		panel.add(new JLabel(I18n.OPTIMIZED.getString("SaleOrder.Form.Product")), "gap para");
		panel.add(comboBoxProduct, "span");
		panel.add(new JLabel(I18n.OPTIMIZED.getString("SaleOrder.Form.Quantity")), "gap para");
		panel.add(textFieldExtQuantity, "span");
		panel.add(new JLabel(I18n.OPTIMIZED.getString("SaleOrder.Form.UnitPrice")), "gap para");
		panel.add(textFieldExtUnitPrice, "span");
		panel.add(new JLabel(), "gap para");
		panel.add(btnAddLine, "gap para");
		btnAddLine.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ComboBoxItem comboBoxItemProduct = (ComboBoxItem) comboBoxProduct.getSelectedItem();
				tableModel.addRow(new Object[] { comboBoxItemProduct.getValue(), textFieldExtQuantity.getText(),
						textFieldExtUnitPrice.getText(), (Double.parseDouble(textFieldExtQuantity.getText())
								* Double.parseDouble(textFieldExtUnitPrice.getText())) });
			}
		});
		panel.add(new JLabel(), "span");
		panel.add(scrollPane, "span");
		return panel;
	}

	private JPanel buildSalePage() {
		textFieldExtOrderDate = new TextFieldExt(50);
		textFieldExtOrderDate.setEditable(false);
		textFieldExtOrderNumber = new TextFieldExt(50);
		textFieldExtOrderNumber.requestFocus();
		comboBoxCustomer = new JComboBox<>();
		new CustomerService().getListOfReferences().forEach(item -> {
			comboBoxCustomer.addItem(item);
		});
		JPanel panel = new JPanel(new MigLayout("insets 20 10 10 10", "[][50:100,fill][fill,grow]", ""));
		panel.add(new JLabel(I18n.OPTIMIZED.getString("SaleOrder.Form.OrderDate")), "gap para");
		panel.add(textFieldExtOrderDate, "span");
		panel.add(new JLabel(I18n.OPTIMIZED.getString("SaleOrder.Form.OrderNumber")), "gap para");
		panel.add(textFieldExtOrderNumber, "span");
		panel.add(new JLabel(I18n.OPTIMIZED.getString("SaleOrder.Form.Customer")), "gap para");
		panel.add(comboBoxCustomer, "span");
		return panel;
	}

	@Override
	public void popFields() {
		textFieldExtOrderDate.setText(DATE_FORMAT.format(new Date()));
		if (saleOrder.getId() != 0) {
			comboBoxCustomer
					.setSelectedItem(new ComboBoxItem(String.valueOf(saleOrder.getCId()), saleOrder.getCName()));
			textFieldExtOrderDate.setText(saleOrder.getOrderDate());
			textFieldExtOrderNumber.setText(saleOrder.getOrderNumber());
		}
	}

	@Override
	public void pushFields() {
		ComboBoxItem comboBoxItem = (ComboBoxItem) comboBoxCustomer.getSelectedItem();
		saleOrder.setCId(comboBoxItem.getKey());
		saleOrder.setCName(comboBoxItem.getValue());
		saleOrder.setOrderDate(textFieldExtOrderDate.getText());
		saleOrder.setOrderNumber(textFieldExtOrderNumber.getText());
		List<OrderLine> orderLines = new ArrayList<>();
		for (int row = 0; row < tableModel.getRowCount(); row++) {
			OrderLine line = new OrderLine();
			line.setProduct(String.valueOf(tableModel.getValueAt(row, 0)));
			line.setQuantity(Double.parseDouble(String.valueOf(tableModel.getValueAt(row, 1))));
			line.setUnitPrice(Double.parseDouble(String.valueOf(tableModel.getValueAt(row, 2))));
			orderLines.add(line);
		}
		saleOrder.setOrderLines(orderLines);
	}

	@Override
	public SaleOrder getModel() {
		return saleOrder;
	}

	@Override
	public void onHelp() {

	}

	@Override
	public boolean isMultiPageForm() {
		return true;
	}
}
