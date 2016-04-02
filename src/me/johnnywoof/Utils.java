package me.johnnywoof;

import javax.swing.*;

public class Utils {

	public static void dieByError(Exception e) {

		e.printStackTrace();

		JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());

		System.exit(-1);

	}

}
