/**
 * 
 */
package com.enuminfo.optimized.frontend.component;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jdesktop.swingx.JXHeader;

import com.enuminfo.optimized.uitl.I18n;
import com.enuminfo.optimized.uitl.ViewHelpers;

import net.miginfocom.swing.MigLayout;

/**
 * @author AKURATI
 */
public class SetupDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JXHeader xheader;
    private JButton btnOk;
    private Action actionOk;
    private JButton btnCancel;
    private Action actionCancel;
    private int initialVal;
    private String strBtnOk;
    private String strBtnCancel;
    
    public SetupDialog(JFrame frame, int initialVal) {
    	super(frame);
		this.initialVal = initialVal;
		initializeComponents();
		setLocationRelativeTo(null);
    }

	private void initializeComponents() {
		setTitle(I18n.OPTIMIZED.getString("App.Title") + " Setup");
    	setIconImage(new ImageIcon(getClass().getResource(ViewHelpers.ICONS16 + "app.png")).getImage());
    	setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    	xheader = new JXHeader();
    	xheader.setTitle("<html><body><b>" + System.getProperty("user.name") + "</b></body></html>");
    	xheader.setIcon(new ImageIcon(getClass().getResource("/images/icons22/customer.png")));
    	getContentPane().add(xheader, BorderLayout.NORTH);
    	getContentPane().add(new JScrollPane(buildCenterPanel()), BorderLayout.CENTER);
    	if (initialVal == 1) {
    		strBtnOk = "Proceed";
    		strBtnCancel = "Quit";
    	} else if (initialVal == 0) {
    		strBtnOk = "Save";
    		strBtnCancel = "Cancel";
    	}
    	actionOk = new AbstractAction(strBtnOk, new ImageIcon(getClass().getResource("/images/icons16/ok.png"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		actionCancel = new AbstractAction(strBtnCancel, new ImageIcon(getClass().getResource("/images/icons16/cancel.png"))) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (initialVal == 1) System.exit(0);
				else if (initialVal == 0) { setVisible(false); dispose(); }
			}
		};
		btnOk = new JButton(actionOk);
		btnCancel = new JButton(actionCancel);
    	JPanel buttonPanel = new JPanel(new MigLayout("nogrid, fillx, aligny 100%, gapy unrel"));
        buttonPanel.add(btnOk, "align center");
        buttonPanel.add(btnCancel, "align center");
    	JPanel buttonBar = new JPanel(new BorderLayout());
        buttonBar.add(buttonPanel, BorderLayout.CENTER);
    	getContentPane().add(buttonBar, BorderLayout.SOUTH);
        setModal(true);
	}

	private JPanel buildCenterPanel() {
		JPanel panel = new JPanel(new MigLayout("insets 10 20 10 20"));
		
		return panel;
	}

	public static void showDialog(int initialVal) {
		JFrame frame = new JFrame();
    	new SetupDialog(frame, initialVal);
    }
}
