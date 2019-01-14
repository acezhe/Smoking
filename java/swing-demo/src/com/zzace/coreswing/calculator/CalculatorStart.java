package com.zzace.coreswing.calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class CalculatorStart extends JFrame {
	
	public CalculatorStart() {
		add(new CalculatorPanel());
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			new CalculatorStart();
		});
	}

}
