package br.com.drinkbar.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

public class FrameMainBebida extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private PainelConsultarBebida consultarBebida;
	private PainelCadastroBebida cadastroBebida;

	public FrameMainBebida() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 720, 550);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		consultarBebida = new PainelConsultarBebida();
		cadastroBebida = new PainelCadastroBebida();

		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Cadastro", cadastroBebida);
		tabbedPane.addTab("Consultar", consultarBebida);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}

}
