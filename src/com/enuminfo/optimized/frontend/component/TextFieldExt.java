/*
 * 
 */
package com.enuminfo.optimized.frontend.component;

import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * @author AKURATI
 */
public class TextFieldExt extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int maxLength;

	public TextFieldExt(int maxLength) {
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
