/*
 * 
 */
package com.enuminfo.optimized.framework;

import com.enuminfo.optimized.backend.model.Base;
import com.enuminfo.optimized.backend.repository.BaseRepository;
import com.enuminfo.optimized.frontend.component.MessageBox;
import com.enuminfo.optimized.uitl.I18n;

/**
 * @author AKURATI
 */
public abstract class AbstractDataPageController<T extends Base> implements DataPageController<T> {

	private BaseRepository<T> service;
	private DataPageView<T> dataPageView;

	protected abstract BaseRepository<T> createRepository();

	@Override
	public BaseRepository<T> getRepository() {
		if (service == null)
			service = createRepository();
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
				getRepository().delete(dataPageView.getSelectedModel());
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
			getRepository().save(model);
		} catch (Exception e) {
			MessageBox.showError(I18n.COMMON.getString("Messages.Error.SaveError"), e);
		}
	}
}
