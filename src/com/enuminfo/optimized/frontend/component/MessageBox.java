/*
 * 
 */
package com.enuminfo.optimized.frontend.component;

import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.JXErrorPane;
import org.jdesktop.swingx.error.ErrorInfo;

import com.enuminfo.optimized.frontend.I18n;

/**
 * @author Kumar
 */
public class MessageBox {

	public static final int OK_OPTION = JOptionPane.OK_OPTION;
	public static final int YES_OPTION = JOptionPane.YES_OPTION;
	public static final int NO_OPTION = JOptionPane.NO_OPTION;
	public static final int CANCEL_OPTION = JOptionPane.CANCEL_OPTION;
	public static final int CLOSED_OPTION = JOptionPane.CLOSED_OPTION;

	public MessageBox() {
		// TODO Auto-generated constructor stub
	}

	public static void showInfo(String message) {
		JOptionPane.showMessageDialog(new JFrame(), message, I18n.COMPONENT.getString("MessageBox.Title.Info"),
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static int showInfoOkCancel(String message) {
		return JOptionPane.showConfirmDialog(new JFrame(), message, I18n.COMPONENT.getString("MessageBox.Title.Info"),
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
	}

	public static int showInfoYesNo(String message) {
		return JOptionPane.showConfirmDialog(new JFrame(), message, I18n.COMPONENT.getString("MessageBox.Title.Info"),
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
	}

	public static int showInfoYesNoCancel(String message) {
		return JOptionPane.showConfirmDialog(new JFrame(), message, I18n.COMPONENT.getString("MessageBox.Title.Info"),
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void showWarning(String message) {
		JOptionPane.showMessageDialog(new JFrame(), message, I18n.COMPONENT.getString("MessageBox.Title.Warning"),
				JOptionPane.WARNING_MESSAGE);
	}

	public static int showWarningOkCancel(String message) {
		return JOptionPane.showConfirmDialog(new JFrame(), message,
				I18n.COMPONENT.getString("MessageBox.Title.Warning"), JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.WARNING_MESSAGE);
	}

	public static int showWarningYesNo(String message) {
		return JOptionPane.showConfirmDialog(new JFrame(), message,
				I18n.COMPONENT.getString("MessageBox.Title.Warning"), JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);
	}

	public static int showWarningYesNoCancel(String message) {
		return JOptionPane.showConfirmDialog(new JFrame(), message,
				I18n.COMPONENT.getString("MessageBox.Title.Warning"), JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.WARNING_MESSAGE);
	}

	public static int showAskOkCancel(String message) {
		return JOptionPane.showConfirmDialog(new JFrame(), message, I18n.COMPONENT.getString("MessageBox.Title.Ask"),
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
	}

	public static int showAskYesNo(String message) {
		return JOptionPane.showConfirmDialog(new JFrame(), message, I18n.COMPONENT.getString("MessageBox.Title.Ask"),
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	}

	public static int showAskYesNoCancel(String message) {
		return JOptionPane.showConfirmDialog(new JFrame(), message, I18n.COMPONENT.getString("MessageBox.Title.Ask"),
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
	}

	public static void showError(String errorMessage) {
		JOptionPane.showMessageDialog(new JFrame(), "<html><body>" + errorMessage + "</body></html>",
				I18n.COMPONENT.getString("MessageBox.Title.Error"), JOptionPane.ERROR_MESSAGE);
	}

	public static void showError(String errorMessage, Exception ex) {
		ErrorInfo errorInfo = new ErrorInfo(I18n.COMPONENT.getString("MessageBox.Title.Error"),
				"<html><body>" + errorMessage + "</body></html>", null, null, ex, Level.SEVERE, null);
		JXErrorPane.showDialog(new JFrame(), errorInfo);
	}
}
