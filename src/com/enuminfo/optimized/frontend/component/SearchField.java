/*
 * 
 */
package com.enuminfo.optimized.frontend.component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jdesktop.xswingx.PromptSupport;

import com.enuminfo.optimized.frontend.ViewHelpers;

/**
 * @author Kumar
 */
public class SearchField extends JPanel implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfSearch;
	private final Action acSearch;
	private String prompt;

	public SearchField(Action acSearch) {
		this(acSearch, "Search");
	}

	public SearchField(Action acSearch, String prompt) {
		super(new BorderLayout());
		this.acSearch = acSearch;
		this.prompt = prompt;
		initComponents();
	}

	private void initComponents() {
		ImageIcon icoSearch = new ImageIcon(getClass().getResource(ViewHelpers.ICONS12 + "search.png"));
		JLabel lblSearch = new JLabel();
		lblSearch.setIcon(icoSearch);
		lblSearch.setPreferredSize(new Dimension(22, 20));
		tfSearch = new JTextField(50);
		PromptSupport.setPrompt(prompt, tfSearch);
		tfSearch.addKeyListener(this);
		setBorder(tfSearch.getBorder());
		tfSearch.setBorder(null);
		add(lblSearch, BorderLayout.WEST);
		add(tfSearch, BorderLayout.CENTER);
		setPreferredSize(new Dimension(tfSearch.getPreferredSize().width, tfSearch.getPreferredSize().height + 6));
	}

	public final JTextField getSearchTextField() {
		return tfSearch;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (acSearch != null)
				acSearch.actionPerformed(null);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (acSearch != null)
			acSearch.actionPerformed(null);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}
