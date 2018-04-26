/**
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.frontend.contoller;

import java.util.List;

import com.enuminfo.optimized.framework.AbstractDataPageController;
import com.enuminfo.optimized.framework.DataPageView;
import com.enuminfo.optimized.frontend.form.ProductForm;
import com.enuminfo.optimized.frontend.model.Product;
import com.enuminfo.optimized.frontend.view.ProductView;
import com.enuminfo.optimized.service.AbstractService;
import com.enuminfo.optimized.service.ProductService;

/**
 * Product Controller
 * @author Kumar
 */
public class ProductController extends AbstractDataPageController<Product> {

	@Override
	public void openFormView(Product product) {
		new ProductForm(this, product).showDialog();
	}

	@Override
	public void onAddNew() {
		openFormView(new Product());
	}

	@Override
	public List<Product> getData(String filter, int start, int end) {
		if (filter.equals(""))
			return getService().getListWithNamedQuery(start, end);
		else
			return getService().getListWithNamedQueryAndParameters(filter, start, end);
	}

	@Override
	public int getDataSize(String filter) {
		if (filter.equals(""))
			return getService().getListWithNamedQuery().size();
		else
			return getService().getListWithNamedQueryAndParameters(filter).size();
	}

	@Override
	public String getName() {
		return ProductController.class.getSimpleName();
	}

	@Override
	protected AbstractService<Product> createService() {
		return new ProductService();
	}

	@Override
	protected DataPageView<Product> createDataPageView() {
		return new ProductView();
	}
}