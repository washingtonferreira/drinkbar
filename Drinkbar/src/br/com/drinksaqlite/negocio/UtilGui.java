package br.com.drinksaqlite.negocio;

import javax.swing.JOptionPane;

public class UtilGui {

	public UtilGui() {
		// TODO Auto-generated constructor stub
	}

	public final static void successMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Sucesso",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public final static void errorMessage(String message) {

		JOptionPane.showMessageDialog(null, message, "Erro", 0);

	}

}
