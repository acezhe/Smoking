package com.zzace.coreswing.drawframe;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class DrawFrameTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame = new DrawFrame();
		});
	}
}
