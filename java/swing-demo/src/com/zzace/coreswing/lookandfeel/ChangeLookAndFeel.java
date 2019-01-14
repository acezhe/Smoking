package com.zzace.coreswing.lookandfeel;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * 
 * @author ZhangZhe
 *
 */
public class ChangeLookAndFeel extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 300;
	private JPanel buttonPanel;
	private LookAndFeelInfo[] infos;
	private int index = 0;
	private String buttonName;

	public ChangeLookAndFeel() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		buttonPanel = new JPanel();
		add(buttonPanel);

		infos = UIManager.getInstalledLookAndFeels();

		// add button
		buttonPanel.add(makeButton());

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	private JButton makeButton() {

		JButton button = new JButton();
		buttonName = infos[index].getName();
		button.setText(buttonName);
		SwingUtilities.updateComponentTreeUI(this);

		button.addActionListener(e -> {

			if ((infos.length - 1) <= index) {
				index = -1;
			}
			index++;
			String className = infos[index].getClassName();
			try {
				UIManager.setLookAndFeel(className);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {
				e1.printStackTrace();
			}

			SwingUtilities.updateComponentTreeUI(this);

			buttonName = infos[index].getName();
			button.setText(buttonName);
		});

		return button;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			new ChangeLookAndFeel();
		});
	}

}
