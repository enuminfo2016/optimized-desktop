/*
 * 
 */
package com.enuminfo.optimized.framework;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import org.jdesktop.swingx.JXStatusBar;

import com.enuminfo.optimized.backend.model.Base;
import com.enuminfo.optimized.frontend.AppController;
import com.enuminfo.optimized.uitl.I18n;
import com.enuminfo.optimized.uitl.ViewHelpers;

/**
 * @author AKURATI
 */
public abstract class AbstractFormDialogView<T extends Base> extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected DataPageController<T> controller;
	protected JMenuBar menuBar;
	protected JToolBar toolBar;
	protected JTabbedPane tpPages;
	protected JXStatusBar xstatusBar;

	// menu and toolbar actions
	protected Action acSave;
	protected Action acPrintPreview;
	protected Action acPrint;
	protected Action acClose;
	protected Action acHelp;

	public AbstractFormDialogView(JFrame parent, DataPageController<T> controller) {
		super(parent);
		this.controller = controller;
	}

	public void initComponents() {
		setLayout(new BorderLayout());
		setIconImage(new ImageIcon(getClass().getResource(getFormIconPath())).getImage());
		setTitle(getFormTitle());
		buildFormActions();
		setJMenuBar(buildMenuBar());
		getContentPane().add(buildToolBar(), BorderLayout.NORTH);
		getContentPane().add(buildStatusBar(), BorderLayout.SOUTH);
		if (isMultiPageForm()) {
			tpPages = new JTabbedPane();
			tpPages.setFocusable(false);
			getContentPane().add(tpPages, BorderLayout.CENTER);
		}
	}

	public abstract String getFormTitle();

	public abstract String getFormIconPath();

	public abstract void buildUI();

	public abstract void popFields();

	public abstract void pushFields();

	public boolean onSave() {
		if (!validateForm()) {
			return false;
		}
		pushFields();
		controller.onSave(getModel());
		return true;
	}

	public boolean validateForm() {
		return true;
	}

	public abstract T getModel();

	public void addPageToForm(String title, JPanel page) {
		if (isMultiPageForm()) {
			tpPages.add(title, page);
		} else {
			getContentPane().add(page, BorderLayout.CENTER);
		}
	}

	public boolean isMultiPageForm() {
		return false;
	}

	public boolean isPrintable() {
		return false;
	}

	public void onPrintPreview() {

	}

	public void onPrint() {

	}

	public abstract void onHelp();

	public void showDialog() {
		buildUI();
		setLocationRelativeTo(AppController.get().getView());
		setModalityType(ModalityType.APPLICATION_MODAL);
		setVisible(true);
	}

	public void onCloseForm() {
		setVisible(false);
		dispose();
	}

	private JMenuBar buildMenuBar() {
		menuBar = new JMenuBar();
		// File menu
		// JMenu mnuFile = new
		// JMenu(I18n.COMMON.getString("AbstractFormView.Menu.File"));
		JMenu mnuFile = new JMenu("");
		mnuFile.add(acSave);
		mnuFile.add(new JSeparator());
		if (isPrintable()) {
			mnuFile.add(acPrintPreview);
			mnuFile.add(acPrint);
			mnuFile.add(new JSeparator());
		}
		mnuFile.add(acClose);
		menuBar.add(mnuFile);
		return menuBar;
	}

	private JToolBar buildToolBar() {
		toolBar = new JToolBar();
		toolBar.setRollover(true);
		toolBar.add(ViewHelpers.createToolButton(acSave, true, true));
		if (isPrintable()) {
			toolBar.add(ViewHelpers.createToolButton(acPrintPreview, true, true));
			toolBar.add(ViewHelpers.createToolButton(acPrint, true, true));
		}
		toolBar.add(ViewHelpers.createToolButton(acClose, true, true));
		return toolBar;
	}

	@SuppressWarnings("serial")
	private void buildFormActions() {
		acSave = new AbstractAction(I18n.COMMON.getString("Action.Save"),
				new ImageIcon(getClass().getResource(ViewHelpers.ICONS16 + "save.png"))) {
			@Override
			public void actionPerformed(ActionEvent evt) {
				if (onSave()) {
					controller.onRefresh();
					onCloseForm();
				}
			}
		};
		acSave.putValue(Action.SHORT_DESCRIPTION, I18n.COMMON.getString("Action.Hint.Save"));
		acSave.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_S));
		acSave.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));

		acPrintPreview = new AbstractAction(I18n.COMMON.getString("Action.PrintPreview"),
				new ImageIcon(getClass().getResource(ViewHelpers.ICONS16 + "printpreview.png"))) {
			@Override
			public void actionPerformed(ActionEvent evt) {
				onPrintPreview();
			}
		};
		acPrintPreview.putValue(Action.SHORT_DESCRIPTION, I18n.COMMON.getString("Action.Hint.PrintPreview"));
		acPrintPreview.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_V));
		acPrintPreview.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));

		acPrint = new AbstractAction(I18n.COMMON.getString("Action.Print"),
				new ImageIcon(getClass().getResource(ViewHelpers.ICONS16 + "print.png"))) {
			@Override
			public void actionPerformed(ActionEvent evt) {
				onPrint();
			}
		};
		acPrint.putValue(Action.SHORT_DESCRIPTION, I18n.COMMON.getString("Action.Hint.Print"));
		acPrint.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_D));
		acPrint.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));

		acHelp = new AbstractAction(I18n.COMMON.getString("Action.Help"),
				new ImageIcon(getClass().getResource(ViewHelpers.ICONS16 + "help.png"))) {
			@Override
			public void actionPerformed(ActionEvent evt) {
				onHelp();
			}
		};
		acHelp.putValue(Action.SHORT_DESCRIPTION, I18n.COMMON.getString("Action.Hint.Help"));
		acHelp.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_F1));
		acHelp.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));

		acClose = new AbstractAction(I18n.COMMON.getString("Action.Close"),
				new ImageIcon(getClass().getResource(ViewHelpers.ICONS16 + "close.png"))) {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onRefresh();
				onCloseForm();
			}
		};
		acClose.putValue(Action.SHORT_DESCRIPTION, I18n.COMMON.getString("Action.Hint.Close"));
		acClose.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_X));
		acClose.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
	}

	private JXStatusBar buildStatusBar() {
		xstatusBar = new JXStatusBar();
		xstatusBar.setPreferredSize(new Dimension(15, 20));
		return xstatusBar;
	}
}
