package com.zzace.coreswing.calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalculatorPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private double result;
	private JPanel insertPanel;
	private JLabel display;
	private boolean startInput;
	private String lastCommand;

	public CalculatorPanel() {
		result = 0;
		insertPanel = new JPanel(new GridLayout(5, 4));
		display = new JLabel("0.0");
		startInput = true;
		lastCommand = "";

		setLayout(new BorderLayout());
		display.setHorizontalAlignment(JLabel.CENTER);

		add(display, BorderLayout.NORTH);
		add(insertPanel, BorderLayout.CENTER);

		InsertAction insertAction = new InsertAction();
		CommandAction commandAction = new CommandAction();

		insertPanel.add(createButton("7", insertAction));
		insertPanel.add(createButton("8", insertAction));
		insertPanel.add(createButton("9", insertAction));
		insertPanel.add(createButton("+", commandAction));
		insertPanel.add(createButton("4", insertAction));
		insertPanel.add(createButton("5", insertAction));
		insertPanel.add(createButton("6", insertAction));
		insertPanel.add(createButton("-", commandAction));
		insertPanel.add(createButton("1", insertAction));
		insertPanel.add(createButton("2", insertAction));
		insertPanel.add(createButton("3", insertAction));
		insertPanel.add(createButton("*", commandAction));
		insertPanel.add(createButton("0", insertAction));
		insertPanel.add(createButton(".", insertAction));
		insertPanel.add(createButton("/", commandAction));
		insertPanel.add(createButton("=", commandAction));
		insertPanel.add(createButton("M+", commandAction));
		insertPanel.add(createButton("M", commandAction));
		insertPanel.add(createButton("<", commandAction));
		insertPanel.add(createButton("C", commandAction));

	}

	public JButton createButton(String name, ActionListener listener) {
		JButton button = new JButton(name);
		button.setActionCommand(name);
		button.addActionListener(listener);
		return button;

	}

	class InsertAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (startInput) {
				display.setText("");
				startInput = false;
			}

			display.setText(display.getText() + e.getActionCommand());
		}
	}

	class CommandAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (startInput) {
				if ("-".equals(e.getActionCommand())&&!"=".equals(lastCommand)) {
					display.setText("-");
					startInput = false;
				} else {
					lastCommand = e.getActionCommand();
				}
			} else {
				if ("-".equals(display.getText())) {
					
				} else {
					double value = Double.parseDouble(display.getText());
					calculate(value);
					lastCommand = e.getActionCommand();
					display.setText(String.valueOf(result));
					startInput = true;
				}
			}
		}

	}

	private void calculate(double value) {
		switch (lastCommand) {
		case "+":
			result += value;
			break;
		case "-":
			result -= value;
			break;
		case "*":
			result *= value;
			break;
		case "/":
			result /= value;
			break;
		case "=":
			result = value;
			break;
		default:
			result = value;

		}
	}

}
