package com.zzace.coreswing.simplebuttonaction;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleButtonActionFrame extends JFrame {

	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 300;
	private JPanel buttonPanel;

	public SimpleButtonActionFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		buttonPanel = new JPanel();
		
		add(buttonPanel);

		// add button
		buttonPanel.add(makeButton("Yellow", Color.YELLOW));
		buttonPanel.add(makeButton("Blue", Color.BLUE));
		buttonPanel.add(makeButton("Red", Color.RED));

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	private JButton makeButton(String buttonName, Color backgroundColor) {
		JButton button = new JButton(buttonName);
		button.addActionListener(e -> buttonPanel.setBackground(backgroundColor));
		return button;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			SimpleButtonActionFrame sbaf = new SimpleButtonActionFrame();
		});
	}

}
