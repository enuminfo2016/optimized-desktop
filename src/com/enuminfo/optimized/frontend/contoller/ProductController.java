/**
 * 
 */
package com.enuminfo.optimized.frontend.contoller;

import static com.enuminfo.optimized.backend.repository.QueryParameter.with;

import java.util.List;

import com.enuminfo.optimized.frontend.form.ProductForm;
import com.enuminfo.optimized.frontend.framework.AbstractDataPageController;
import com.enuminfo.optimized.frontend.framework.DataPageView;
import com.enuminfo.optimized.frontend.model.Product;
import com.enuminfo.optimized.frontend.service.AbstractService;
import com.enuminfo.optimized.frontend.service.ProductService;
import com.enuminfo.optimized.frontend.view.ProductView;

/**
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
			return getService().getListWithNamedQueryAndParameters(with("code", "%" + filter + "%").parameters(), start,
					end);
	}

	@Override
	public int getDataSize(String filter) {
		if (filter.equals(""))
			return getService().getListWithNamedQuery().size();
		else
			return getService().getListWithNamedQueryAndParameters(with("code", "%" + filter + "%").parameters())
					.size();
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
