package com.zzace.coreswing.drawframe;

import javax.swing.JFrame;

public class DrawFrame extends JFrame {
	public DrawFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new DrawComponent());
		pack();
		setVisible(true);
		
	}
}
