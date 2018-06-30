/*
 * 
 */
package com.enuminfo.optimized.frontend.framework;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.JXTableHeader;
import org.jdesktop.swingx.decorator.HighlighterFactory;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.painter.decoration.DecorationAreaType;

import com.enuminfo.optimized.frontend.I18n;
import com.enuminfo.optimized.frontend.ViewHelpers;
import com.enuminfo.optimized.frontend.component.SearchField;
import com.enuminfo.optimized.frontend.model.Base;

import net.miginfocom.swing.MigLayout;

/**
 * @author Kumar
 */
public abstract class AbstractDataPageView<T extends Base> implements DataPageView<T> {

	protected DataPageController<T> controller;
	protected JComponent dataPageView;
	protected JSplitPane splitPane;
	private AbstractPreviewPanel<T> previewPanel;

	private Action acAddNew;
	private Action acEdit;
	private Action acDelete;
	private Action acRefresh;
	private Action acSearch;
	protected SearchField searchField;

	protected JXTable xtable;
	protected JXTableHeader xtableHeader;
	private EntityTableModel tableModel;

	private Action acFirstPage;
	private Action acPreviousPage;
	private Action acNextPage;
	private Action acLastPage;

	private JLabel lblCurrentPage;
	private JLabel lblFrom;
	private JLabel lblPageCount;
	private JLabel lblRecordsFound;
	private int currentPage = 0;
	private int rowCount = 0;
	private int pageCount = 0;
	private final int pageSize = 20;

	protected String searchFilter = "";

	public AbstractDataPageView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(DataPageController<T> controller) {
		this.controller = controller;
		initComponents();
	}

	private void initComponents() {
		JPanel viewPanel = new JPanel(new BorderLayout());
		viewPanel.add(getHeaderBar(), BorderLayout.NORTH);
		viewPanel.add(getTablePanel(), BorderLayout.CENTER);
		dataPageView = viewPanel;
		previewPanel = getPreviewPanel();
		if (previewPanel != null) {
			splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
			splitPane.setDividerSize(5);
			splitPane.setResizeWeight(0.7);
			splitPane.setTopComponent(viewPanel);
			splitPane.setBottomComponent(previewPanel);
			viewPanel.setMinimumSize(new Dimension(300, 300));
			previewPanel.setMinimumSize(new Dimension(220, 220));
			dataPageView = splitPane;
		}
		setCurrentPage(1);
	}

	@SuppressWarnings("serial")
	public JPanel getHeaderBar() {
		JPanel headerBar = new JPanel(new MigLayout("insets 2 2 2 2"));
		JLabel lblTitle = new JLabel(getTitle());
		lblTitle.setIcon(new ImageIcon(getClass().getResource(getIconPath())));
		lblTitle.setFont(lblTitle.getFont().deriveFont(Font.BOLD, 14));

		acSearch = new AbstractAction("search") {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				setTableFilter();
			}
		};
		searchField = new SearchField(acSearch);

		JToolBar tbHeader = new JToolBar();
		tbHeader.setFloatable(false);
		tbHeader.setRollover(true);
		tbHeader.setFocusable(false);
		buildHeaderBarActions();

		tbHeader.add(ViewHelpers.createToolButton(acAddNew, false, false));
		tbHeader.add(ViewHelpers.createToolButton(acEdit, false, false));
		tbHeader.add(ViewHelpers.createToolButton(acDelete, false, false));
		tbHeader.add(ViewHelpers.createToolButton(acRefresh, false, false));

		headerBar.setPreferredSize(new Dimension(searchField.getWidth(), searchField.getHeight() + 28));
		headerBar.add(lblTitle, "dock center, gapleft 4");
		headerBar.add(searchField, "dock east, gapright 4, width 250!, height pref!");
		headerBar.add(tbHeader, "dock east, gapright 10, width 250!, height pref!");

		SubstanceLookAndFeel.setDecorationType(headerBar, DecorationAreaType.HEADER);
		SubstanceLookAndFeel.setDecorationType(tbHeader, DecorationAreaType.HEADER);
		SubstanceLookAndFeel.setDecorationType(searchField, DecorationAreaType.GENERAL);
		return headerBar;
	}

	public JPanel getTablePanel() {
		JPanel tablePanel = new JPanel(new BorderLayout());
		xtable = new JXTable();
		xtable.setRowHeight(19);

		xtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				if (me.getButton() == MouseEvent.BUTTON1 && me.getClickCount() > 1) {
					controller.onEdit();
				}
			}
		});

		xtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		xtable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) {
					return;
				}
				if (previewPanel != null) {
					notifyPreviewPanel();
				}
			}
		});

		xtable.setColumnControlVisible(true);
		xtable.setHighlighters(HighlighterFactory.createSimpleStriping(HighlighterFactory.BEIGE));
		xtable.getTableHeader().setPreferredSize(new Dimension(xtable.getTableHeader().getPreferredSize().width, 19));

		tableModel = new EntityTableModel();
		addTableColumns();
		xtable.setModel(tableModel);

		xtable.setAutoResizeMode(getJXTableAutoResizeMode());

		JToolBar tbPager = new JToolBar();
		tbPager.setFloatable(false);
		tbPager.setRollover(true);
		tbPager.setFocusable(false);
		SubstanceLookAndFeel.setDecorationType(tbPager, DecorationAreaType.GENERAL);

		buildPagerActions();
		lblCurrentPage = new JLabel();
		lblFrom = new JLabel(I18n.COMMON.getString("AbstractPageView.Pager.From") + " ");
		lblPageCount = new JLabel();
		lblRecordsFound = new JLabel();

		tbPager.add(ViewHelpers.createToolButton(acFirstPage, false, false));
		tbPager.add(ViewHelpers.createToolButton(acPreviousPage, false, false));
		tbPager.add(new JLabel(" "));
		tbPager.add(lblCurrentPage);
		tbPager.add(lblFrom);
		tbPager.add(lblPageCount);
		tbPager.add(new JLabel(" "));
		tbPager.add(ViewHelpers.createToolButton(acNextPage, false, false));
		tbPager.add(ViewHelpers.createToolButton(acLastPage, false, false));
		tbPager.addSeparator();
		tbPager.add(Box.createGlue());
		tbPager.add(lblRecordsFound);

		tablePanel.add(new JScrollPane(xtable), BorderLayout.CENTER);
		tablePanel.add(tbPager, BorderLayout.SOUTH);

		setUpColumns();
		return tablePanel;
	}

	public EntityTableModel getTableModel() {
		return tableModel;
	}

	public AbstractPreviewPanel<T> getPreviewPanel() {
		return null;
	}

	public void notifyPreviewPanel() {
		if (xtable.getSelectedRow() == -1)
			return;
		previewPanel.setModel(getSelectedModel());
	}

	@Override
	public Component asComponent() {
		return dataPageView;
	}

	public abstract void addTableColumns();

	public int getJXTableAutoResizeMode() {
		return JXTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS;
	}

	@Override
	public void refreshData() {
		int start = ((pageSize * getCurrentPage()) - pageSize);
		int end = start + pageSize;
		tableModel.setData(getController().getData(searchFilter, start, end));
		tableModel.fireTableDataChanged();
		setPageCount();
		setNavigationRecordCount();
		if (tableModel.getRowCount() > 0)
			xtable.setRowSelectionInterval(0, 0);
	}

	private void setTableFilter() {
		searchFilter = searchField.getSearchTextField().getText();
		setCurrentPage(1);
		refreshData();
	}

	public String getSearchFilter() {
		return searchFilter;
	}

	public void setSearchFilter(String searchFilter) {
		this.searchFilter = searchFilter;
	}

	public void firstPage() {
		if (getCurrentPage() > 1) {
			setCurrentPage(1);
			refreshData();
		}
	}

	public void previousPage() {
		if (getCurrentPage() > 1) {
			setCurrentPage(getCurrentPage() - 1);
			refreshData();
		}
	}

	public void nextPage() {
		if (getCurrentPage() < getPageCount()) {
			setCurrentPage(getCurrentPage() + 1);
			refreshData();
		}
	}

	public void lastPage() {
		if (getCurrentPage() < getPageCount()) {
			setCurrentPage(getPageCount());
			refreshData();
		}
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		lblCurrentPage.setText(
				I18n.COMMON.getString("AbstractPageView.Pager.CurrentPage") + " " + String.valueOf(this.currentPage));
	}

	public int getCurrentPage() {
		return this.currentPage;
	}

	public void setPageCount() {
		rowCount = (int) Math.ceil((double) (getController().getDataSize(searchFilter)));
		pageCount = (int) Math.ceil((double) (rowCount / pageSize));
		double remainder = (rowCount % pageSize);
		if (remainder > 0)
			pageCount += 1;
		lblPageCount.setText(String.valueOf(pageCount));
	}

	public int getPageCount() {
		return this.pageCount;
	}

	public int getRowCount() {
		return this.rowCount;
	}

	private void setNavigationRecordCount() {
		if (getRowCount() > 1) {
			lblRecordsFound.setText(" " + String.valueOf(getRowCount()) + " "
					+ I18n.COMMON.getString("AbstractPageView.Pager.RecordsFound") + " ");
		} else {
			lblRecordsFound.setText(" " + String.valueOf(getRowCount()) + " "
					+ I18n.COMMON.getString("AbstractPageView.Pager.RecordFound") + " ");
		}
	}

	public void setUpColumns() {
		for (int i = 0; i < tableModel.getColumnCount(); i++) {
			xtable.getColumnExt(tableModel.getColumnName(i)).setPreferredWidth(tableModel.getColumn(i).getWidth());
			xtable.getColumnExt(tableModel.getColumnName(i)).setVisible(tableModel.getColumn(i).isVisible());
			if (xtable.getColumnExt(tableModel.getColumnName(i)).isVisible())
				xtable.moveColumn(xtable.convertColumnIndexToView(i), i);
		}
	}

	@Override
	public DataPageController<T> getController() {
		return this.controller;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getSelectedModel() {
		if (xtable.getSelectedRow() > -1)
			return (T) tableModel.getRowAt(xtable.convertRowIndexToModel(xtable.getSelectedRow()));
		return null;
	}

	@SuppressWarnings("serial")
	private void buildHeaderBarActions() {
		acAddNew = new AbstractAction(I18n.COMMON.getString("Action.AddNew"),
				new ImageIcon(getClass().getResource(ViewHelpers.ICONS16 + "addnew.png"))) {
			@Override
			public void actionPerformed(ActionEvent e) {
				getController().onAddNew();
			}
		};
		acAddNew.putValue(Action.SHORT_DESCRIPTION, I18n.COMMON.getString("Action.Hint.AddNew"));

		acEdit = new AbstractAction(I18n.COMMON.getString("Action.Edit"),
				new ImageIcon(getClass().getResource(ViewHelpers.ICONS16 + "edit.png"))) {
			@Override
			public void actionPerformed(ActionEvent e) {
				getController().onEdit();
			}
		};
		acEdit.putValue(Action.SHORT_DESCRIPTION, I18n.COMMON.getString("Action.Hint.Edit"));

		acDelete = new AbstractAction(I18n.COMMON.getString("Action.Delete"),
				new ImageIcon(getClass().getResource(ViewHelpers.ICONS16 + "delete.png"))) {
			@Override
			public void actionPerformed(ActionEvent e) {
				getController().onDelete();
			}
		};
		acDelete.putValue(Action.SHORT_DESCRIPTION, I18n.COMMON.getString("Action.Hint.Delete"));

		acRefresh = new AbstractAction(I18n.COMMON.getString("Action.Refresh"),
				new ImageIcon(getClass().getResource(ViewHelpers.ICONS16 + "refresh.png"))) {
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshData();
			}
		};
		acRefresh.putValue(Action.SHORT_DESCRIPTION, I18n.COMMON.getString("Action.Hint.Refresh"));
	}

	@SuppressWarnings("serial")
	private void buildPagerActions() {
		acFirstPage = new AbstractAction("firstPage",
				new ImageIcon(getClass().getResource(ViewHelpers.ICONS16 + "first.png"))) {
			@Override
			public void actionPerformed(ActionEvent e) {
				firstPage();
			}
		};
		acFirstPage.putValue(Action.SHORT_DESCRIPTION, I18n.COMMON.getString("Action.Hint.FirstPage"));

		acPreviousPage = new AbstractAction("previousPage",
				new ImageIcon(getClass().getResource(ViewHelpers.ICONS16 + "previous.png"))) {
			@Override
			public void actionPerformed(ActionEvent e) {
				previousPage();
			}
		};
		acPreviousPage.putValue(Action.SHORT_DESCRIPTION, I18n.COMMON.getString("Action.Hint.PreviousPage"));

		acNextPage = new AbstractAction("nextPage",
				new ImageIcon(getClass().getResource(ViewHelpers.ICONS16 + "next.png"))) {
			@Override
			public void actionPerformed(ActionEvent e) {
				nextPage();
			}
		};
		acNextPage.putValue(Action.SHORT_DESCRIPTION, I18n.COMMON.getString("Action.Hint.NextPage"));

		acLastPage = new AbstractAction("lastPage",
				new ImageIcon(getClass().getResource(ViewHelpers.ICONS16 + "last.png"))) {
			@Override
			public void actionPerformed(ActionEvent e) {
				lastPage();
			}
		};
		acLastPage.putValue(Action.SHORT_DESCRIPTION, I18n.COMMON.getString("Action.Hint.LastPage"));
	}
}
