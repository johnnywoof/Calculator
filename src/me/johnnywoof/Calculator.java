package me.johnnywoof;

import com.sk89q.worldedit.internal.expression.Expression;
import com.sk89q.worldedit.internal.expression.ExpressionException;
import com.sk89q.worldedit.internal.expression.runtime.EvaluationException;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {

	private final JTextArea calculatorScreen;
	private final JTextField calculatorInput;
	private final JScrollPane scrollPane;

	public Calculator() {
		super("Calculator");

		this.calculatorScreen = new JTextArea();

		this.calculatorScreen.setEditable(false);
		this.calculatorScreen.setBackground(Color.WHITE);

		this.scrollPane = new JScrollPane();
		this.scrollPane.setViewportView(this.calculatorScreen);

		this.calculatorInput = new JTextField();

		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(450, 250));
		this.add(this.scrollPane, BorderLayout.CENTER);
		this.add(this.calculatorInput, BorderLayout.SOUTH);

		this.calculatorInput.addActionListener(e -> {
			String input = calculatorInput.getText();
			if (input.isEmpty()) {
				return;
			}
			try {
				Expression expression = Expression.compile(input);
				printMessage(input + " = " + expression.evaluate());
			} catch (EvaluationException e2) {
				printMessage(String.format(
						"'%s' could not be parsed as a valid expression", input));
			} catch (ExpressionException e2) {
				printMessage(String.format(
						"'%s' could not be evaluated (error: %s)", input, e2.getMessage()));
			}
			calculatorInput.setText("");
		});

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void printMessage(String message) {
		System.out.println(message);
		this.calculatorScreen.append(message + System.lineSeparator());
		this.scrollPane.repaint();
	}

}
