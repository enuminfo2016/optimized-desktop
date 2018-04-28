/*
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.frontend.component;

import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * JTextFieldExt Component.
 * <p>
 * JTextField with max lenght property. <br/>
 * </p>
 * <p>
 * 
 * <pre>
 * <code>
 *      JTextFieldExt tfxName = new JTextFieldExt(50);
 * </code>
 * </pre>
 * </p>
 * 
 * @author Kumar
 */
public class JTextFieldExt extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int maxLength;

	public JTextFieldExt(int maxLength) {
		super();
		this.maxLength = maxLength;
		this.setDocument(new PlainDocumentExt(maxLength));
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
		this.setDocument(new PlainDocumentExt(maxLength));
	}
}

class PlainDocumentExt extends PlainDocument {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int maxLength;

	public PlainDocumentExt(int maxLength) {
		this.maxLength = maxLength;
	}

	@Override
	public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
		if (str.length() == 0)
			return;
		if (getLength() + str.length() <= maxLength) {
			super.insertString(offset, str, a);
		} else {
			Toolkit.getDefaultToolkit().beep();
		}
	}
}
