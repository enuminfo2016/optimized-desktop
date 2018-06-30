/*
 * 
 */
package com.enuminfo.optimized.frontend.framework;

import com.enuminfo.optimized.frontend.I18n;
import com.enuminfo.optimized.frontend.component.MessageBox;
import com.enuminfo.optimized.frontend.model.Base;
import com.enuminfo.optimized.frontend.service.AbstractService;

/**
 * @author Kumar
 */
public abstract class AbstractDataPageController<T extends Base> implements DataPageController<T> {

	private AbstractService<T> service;
	private DataPageView<T> dataPageView;

	public AbstractDataPageController() {
		// TODO Auto-generated constructor stub
	}

	protected abstract AbstractService<T> createService();

	@Override
	public AbstractService<T> getService() {
		if (service == null)
			service = createService();
		return service;
	}

	protected abstract DataPageView<T> createDataPageView();

	@Override
	public DataPageView<T> getDataPageView() {
		if (dataPageView == null) {
			dataPageView = createDataPageView();
			dataPageView.init(this);
			dataPageView.refreshData();
		} else {
			dataPageView.refreshData();
		}
		return dataPageView;
	}

	@Override
	public void onEdit() {
		if (dataPageView == null)
			return;
		if (dataPageView.getSelectedModel() == null)
			return;
		openFormView(dataPageView.getSelectedModel());
	}

	@Override
	public void onDelete() {
		if (dataPageView == null)
			return;
		if (dataPageView.getSelectedModel() == null)
			return;
		if (MessageBox.showAskYesNo(I18n.COMMON.getString("MessageBox.Confirm.Delete")) == MessageBox.YES_OPTION) {
			try {
				getService().edit(dataPageView.getSelectedModel());
				onRefresh();
			} catch (Exception e) {
				MessageBox.showError(I18n.COMMON.getString("Messages.Error.DeleteError"), e);
			}
		}
	}

	@Override
	public void onRefresh() {
		if (dataPageView != null)
			dataPageView.refreshData();
	}

	@Override
	public void onSave(T model) {
		try {
			if (model.getId() == 0)
				getService().add(model);
			else
				getService().edit(model);
		} catch (Exception e) {
			MessageBox.showError(I18n.COMMON.getString("Messages.Error.SaveError"), e);
		}
	}
}
