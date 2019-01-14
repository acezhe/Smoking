package com.zzace.coreswing.windowactionframe;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class WindowActionFrame extends JFrame {

	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 300;

	public WindowActionFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				WindowActionFrame w = WindowActionFrame.this;

				JButton yes = new JButton("Yes");
				JButton no = new JButton("No");
				w.remove(yes);
				w.remove(no);
				setLayout(new FlowLayout());
				yes.addActionListener(actionEvent -> {
					System.exit(0);
				});
				w.add(yes);
				no.addActionListener(actionEvent -> {
					w.remove(yes);
					w.remove(no);
					SwingUtilities.updateComponentTreeUI(WindowActionFrame.this);
				});
				add(no);
				SwingUtilities.updateComponentTreeUI(WindowActionFrame.this);

			}
		});

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			WindowActionFrame sbaf = new WindowActionFrame();
		});
	}

}
