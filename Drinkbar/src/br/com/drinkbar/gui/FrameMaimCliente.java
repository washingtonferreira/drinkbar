package br.com.drinkbar.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

public class FrameMaimCliente extends JFrame {

	private JPanel contentPane;
	private PainelCadastroCliente painelCliente;
	private JTabbedPane tabbedPane;

	public FrameMaimCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 720, 551);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		painelCliente = new PainelCadastroCliente();

		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Cadastro", painelCliente);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}
	
	

}
