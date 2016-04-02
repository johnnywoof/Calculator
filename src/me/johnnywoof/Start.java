package me.johnnywoof;

import javax.swing.*;

public class Start {

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			Utils.dieByError(e);
		}

		new Calculator();

	}

}
