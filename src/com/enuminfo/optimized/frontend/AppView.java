/*
 * 
 */
package com.enuminfo.optimized.frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdesktop.swingx.JXStatusBar;
import org.jvnet.flamingo.common.JCommandButton;
import org.jvnet.flamingo.common.JCommandToggleButton;
import org.jvnet.flamingo.common.icon.EmptyResizableIcon;
import org.jvnet.flamingo.ribbon.JRibbonBand;
import org.jvnet.flamingo.ribbon.JRibbonFrame;
import org.jvnet.flamingo.ribbon.RibbonApplicationMenu;
import org.jvnet.flamingo.ribbon.RibbonElementPriority;
import org.jvnet.flamingo.ribbon.RibbonTask;
import org.jvnet.flamingo.ribbon.resize.CoreRibbonResizePolicies;

import com.enuminfo.optimized.framework.View;
import com.enuminfo.optimized.frontend.component.AboutDialog;
import com.enuminfo.optimized.frontend.component.LookAndFeelDialog;
import com.enuminfo.optimized.frontend.component.MessageBox;
import com.enuminfo.optimized.frontend.contoller.BankController;
import com.enuminfo.optimized.frontend.contoller.CountryController;
import com.enuminfo.optimized.frontend.contoller.DashboardController;
import com.enuminfo.optimized.frontend.contoller.LocationController;
import com.enuminfo.optimized.uitl.I18n;
import com.enuminfo.optimized.uitl.ViewHelpers;

/**
 * @author AKURATI
 */
public class AppView extends JRibbonFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JXStatusBar xstatusBar;
	private JPanel centerPanel;
	private final boolean showExitDialog = false;

	public AppView(String title) {
		super(title);
		this.setIconImages(
				Arrays.asList(new ImageIcon(getClass().getResource(ViewHelpers.ICONS16 + "app.png")).getImage(),
						new ImageIcon(getClass().getResource(ViewHelpers.ICONS22 + "app.png")).getImage()));
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		initComponents();
		ViewHelpers.center(this);
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exitForm(e);
			}
		});
		getContentPane().add(buildStatusBar(), BorderLayout.SOUTH);
		configureRibbonMenu();
		DashboardController dashboardController = new DashboardController();
		centerPanel = new JPanel(new BorderLayout());
		centerPanel.setBorder(BorderFactory.createMatteBorder(0, -1, 0, -1,
				ViewHelpers.getSubstanceComponentBorderColor(centerPanel)));
		centerPanel.add(dashboardController.getPageView().asComponent(), BorderLayout.CENTER);
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		pack();
	}

	private void exitForm(WindowEvent evt) {
		if (showExitDialog) {
			if (MessageBox
					.showAskYesNo(I18n.COMMON.getString("MessageBox.Confirm.ProgramExit")) == MessageBox.NO_OPTION)
				return;
		}
		AppController.get().exit();
	}

	private void configureRibbonMenu() {
		RibbonTask fileTask = new RibbonTask(I18n.COMMON.getString("AppView.File"), getActionsBand(), getReferencesBand());
		fileTask.setKeyTip("F");
		RibbonTask helpTask = new RibbonTask(I18n.COMMON.getString("AppView.Window"), getViewBand(), getExtrasBand(),
				getHelpBand());
		helpTask.setKeyTip("H");
		this.getRibbon().addTask(fileTask);
		this.getRibbon().addTask(helpTask);
		configureTaskBar();
		configureApplicationMenu();
		this.getRibbon().configureHelp(ViewHelpers.createResizableIcon(
				new ImageIcon(getClass().getResource(ViewHelpers.ICONS16 + "help.png"))), new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

					}
				});
	}

	protected void configureTaskBar() {

	}

	protected void configureApplicationMenu() {
		RibbonApplicationMenu applicationMenu = new RibbonApplicationMenu();

		this.getRibbon().setApplicationMenu(applicationMenu);
	}

	private JRibbonBand getActionsBand() {
		JRibbonBand actionsBand = new JRibbonBand(I18n.COMMON.getString("AppView.ActionsBand"),
				new EmptyResizableIcon(22));
		actionsBand.setResizePolicies(CoreRibbonResizePolicies.getCorePoliciesRestrictive(actionsBand));
		JCommandButton cbtnDashboard = new JCommandButton(I18n.OPTIMIZED.getString("Action.Dashboard"), ViewHelpers
				.createResizableIcon(new ImageIcon(getClass().getResource(ViewHelpers.ICONS22 + "dashboard.png"))));
		cbtnDashboard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DashboardController controller = new DashboardController();
				addPageToCenter(controller.getPageView());
			}
		});
		cbtnDashboard.setActionKeyTip("D");
		actionsBand.addCommandButton(cbtnDashboard, RibbonElementPriority.TOP);		
		return actionsBand;
	}
	
	private JRibbonBand getReferencesBand() {
		JRibbonBand actionsBand = new JRibbonBand(I18n.COMMON.getString("AppView.ReferencesBand"),
				new EmptyResizableIcon(22));
		actionsBand.setResizePolicies(CoreRibbonResizePolicies.getCorePoliciesRestrictive(actionsBand));
		JCommandButton cbtnCountries = new JCommandButton(I18n.OPTIMIZED.getString("Action.Countries"), ViewHelpers
				.createResizableIcon(new ImageIcon(getClass().getResource(ViewHelpers.ICONS22 + "country.png"))));
		cbtnCountries.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onOpenCountries();
			}
		});
		cbtnCountries.setActionKeyTip("C");
		actionsBand.addCommandButton(cbtnCountries, RibbonElementPriority.TOP);
		JCommandButton cbtnLocations = new JCommandButton(I18n.OPTIMIZED.getString("Action.Locations"), ViewHelpers
				.createResizableIcon(new ImageIcon(getClass().getResource(ViewHelpers.ICONS22 + "country.png"))));
		cbtnLocations.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onOpenLocations();
			}
		});
		cbtnLocations.setActionKeyTip("L");
		actionsBand.addCommandButton(cbtnLocations, RibbonElementPriority.TOP);
		JCommandButton cbtnBanks = new JCommandButton(I18n.OPTIMIZED.getString("Action.Banks"), ViewHelpers
				.createResizableIcon(new ImageIcon(getClass().getResource(ViewHelpers.ICONS22 + "category.png"))));
		cbtnBanks.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onOpenBanks();
			}
		});
		cbtnBanks.setActionKeyTip("B");
		actionsBand.addCommandButton(cbtnBanks, RibbonElementPriority.TOP);
		return actionsBand;
	}

	private JRibbonBand getViewBand() {
		JRibbonBand viewBand = new JRibbonBand(I18n.COMMON.getString("AppView.ViewBand"), new EmptyResizableIcon(22));
		JCommandToggleButton cbtnStatusBar = new JCommandToggleButton(I18n.COMMON.getString("Action.StatusBar"),
				ViewHelpers.createResizableIcon(
						new ImageIcon(getClass().getResource(ViewHelpers.ICONS22 + "statusbar.png"))));
		cbtnStatusBar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onToogleStatusBar();
			}
		});
		cbtnStatusBar.setActionKeyTip("S");
		cbtnStatusBar.getActionModel().setSelected(true);
		viewBand.addCommandButton(cbtnStatusBar, RibbonElementPriority.TOP);
		JCommandButton cbtnLookAndFeel = new JCommandButton(I18n.COMMON.getString("Action.LookAndFeel"), ViewHelpers
				.createResizableIcon(new ImageIcon(getClass().getResource(ViewHelpers.ICONS22 + "laf.png"))));
		cbtnLookAndFeel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onLookAndFeel();
			}
		});
		cbtnLookAndFeel.setActionKeyTip("T");
		viewBand.addCommandButton(cbtnLookAndFeel, RibbonElementPriority.TOP);
		return viewBand;
	}

	private JRibbonBand getExtrasBand() {
		JRibbonBand extrasBand = new JRibbonBand(I18n.COMMON.getString("AppView.ExtrasBand"),
				new EmptyResizableIcon(22));
		extrasBand.setResizePolicies(CoreRibbonResizePolicies.getCorePoliciesRestrictive(extrasBand));
		JCommandButton cbtnSettings = new JCommandButton(I18n.COMMON.getString("Action.Settings"), ViewHelpers
				.createResizableIcon(new ImageIcon(getClass().getResource(ViewHelpers.ICONS22 + "settings.png"))));
		cbtnSettings.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onSettings();
			}
		});
		cbtnSettings.setActionKeyTip("E");
		extrasBand.addCommandButton(cbtnSettings, RibbonElementPriority.TOP);
		return extrasBand;
	}

	private JRibbonBand getHelpBand() {
		JRibbonBand helpBand = new JRibbonBand(I18n.COMMON.getString("AppView.HelpBand"), new EmptyResizableIcon(22));
		helpBand.setResizePolicies(CoreRibbonResizePolicies.getCorePoliciesRestrictive(helpBand));
		JCommandButton cbtnHelp = new JCommandButton(I18n.COMMON.getString("AppView.Help"), ViewHelpers
				.createResizableIcon(new ImageIcon(getClass().getResource(ViewHelpers.ICONS22 + "help.png"))));
		cbtnHelp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onHelp();
			}
		});
		cbtnHelp.setActionKeyTip("H");
		helpBand.addCommandButton(cbtnHelp, RibbonElementPriority.TOP);
		JCommandButton cbtnAbout = new JCommandButton(I18n.COMMON.getString("AppView.Help.About"), ViewHelpers
				.createResizableIcon(new ImageIcon(getClass().getResource(ViewHelpers.ICONS22 + "about.png"))));
		cbtnAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onAbout();
			}
		});
		cbtnAbout.setActionKeyTip("A");
		helpBand.addCommandButton(cbtnAbout, RibbonElementPriority.TOP);
		return helpBand;
	}

	private JXStatusBar buildStatusBar() {
		xstatusBar = new JXStatusBar();
		xstatusBar.setPreferredSize(new Dimension(15, 20));
		JLabel lblUser = new JLabel();
		lblUser.setText(I18n.COMMON.getString("AppView.StatusBar.User") + " : " + System.getProperty("user.name"));
		xstatusBar.add(lblUser, new JXStatusBar.Constraint(400));
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		dateFormat.applyPattern("EEEE', 'dd. MMMM yyyy");
		JLabel lblDate = new JLabel(" " + dateFormat.format(new Date()).toString());
		xstatusBar.add(lblDate, new JXStatusBar.Constraint(400));
		JLabel lblVersion = new JLabel(" " + I18n.OPTIMIZED.getString("App.Version"));
		xstatusBar.add(lblVersion, new JXStatusBar.Constraint(300));
		return xstatusBar;
	}

	public void onHelp() {
		MessageBox.showInfo("Help not implemented yet!");
	}

	public void onToogleStatusBar() {
		xstatusBar.setVisible(!xstatusBar.isVisible());
	}

	public void onLookAndFeel() {
		LookAndFeelDialog.showDialog();
	}

	public void onAbout() {
		AboutDialog.showDialog();
	}

	public void onSettings() {
		MessageBox.showInfo("Settings not implemented yet!");
	}

	private void addPageToCenter(View page) {
		centerPanel.removeAll();
		centerPanel.add(page.asComponent());
		centerPanel.revalidate();
		centerPanel.repaint();
		page.asComponent().requestFocus();
	}

	public void onOpenLocations() {
		LocationController controller = new LocationController();
		addPageToCenter(controller.getDataPageView());
	}

	public void onOpenBanks() {
		BankController controller = new BankController();
		addPageToCenter(controller.getDataPageView());
	}

	public void onOpenCountries() {
		CountryController controller = new CountryController();
		addPageToCenter(controller.getDataPageView());
	}
}
