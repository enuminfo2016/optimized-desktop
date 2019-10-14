/*
 * 
 */
package com.enuminfo.optimized.frontend.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 * @author Kumar
 */
public class Splash extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String title;
	private final String iconPath;
	private final String imagePath;

	public Splash(String title, String iconPath, String imagePath) {
		this.title = title;
		this.iconPath = iconPath;
		this.imagePath = imagePath;
		initComponents();
	}

	private void initComponents() {
		setTitle(title);
		setIconImage(new ImageIcon(getClass().getResource(iconPath)).getImage());
		setResizable(false);
		setUndecorated(true);
		JLabel imgSplash = new JLabel(new ImageIcon(getClass().getResource(imagePath)));
		JProgressBar progressBar = new JProgressBar(0, 100);
		progressBar.setIndeterminate(true);
		progressBar.setPreferredSize(new Dimension(7, 7));
		progressBar.setBackground(new Color(165, 196, 238));
		progressBar.setForeground(new Color(243, 179, 69));
		getContentPane().add(imgSplash, BorderLayout.CENTER);
		getContentPane().add(progressBar, BorderLayout.SOUTH);
		pack();
		setLocationRelativeTo(null);
	}
}
