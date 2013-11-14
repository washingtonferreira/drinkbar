package br.com.drinkbar.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class JanelaPrincipal extends JFrame {

	private JPanel panelImagemLog;
	private JLabel jlImgLog;
	private JMenuBar menuBar;
	private JMenu mnCadastro;
	private JMenuItem itemMenuCadastrarCliente;
	private JMenuItem itemMenuConsultarCliente;
	private JMenu menuBebida;
	private JMenu menuCadastroBebida;
	private JMenuItem itemMenuCadastrarBebida;
	private JMenuItem itemMenuConsultarBebida;

	public JanelaPrincipal() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 500);

		panelImagemLog = new JPanel();
		getContentPane().add(panelImagemLog, BorderLayout.CENTER);
		panelImagemLog.setLayout(new BorderLayout(0, 0));

		jlImgLog = new JLabel("New label");
		jlImgLog.setIcon(new ImageIcon(JanelaPrincipal.class
				.getResource("/br/com/drinkbar/gui/imagens/logMarca.jpg")));
		panelImagemLog.add(jlImgLog, BorderLayout.CENTER);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuCliente = new JMenu("Cliente");
		menuBar.add(menuCliente);

		mnCadastro = new JMenu("Cadastro");
		menuCliente.add(mnCadastro);

		itemMenuCadastrarCliente = new JMenuItem("Cadastrar");
		itemMenuCadastrarCliente.addActionListener(new trataEventos());
		mnCadastro.add(itemMenuCadastrarCliente);

		itemMenuConsultarCliente = new JMenuItem("Consultar");
		mnCadastro.add(itemMenuConsultarCliente);

		menuBebida = new JMenu("Bebida");
		menuBar.add(menuBebida);

		menuCadastroBebida = new JMenu("Cadastro");
		menuBebida.add(menuCadastroBebida);

		itemMenuCadastrarBebida = new JMenuItem("Cadastrar");
		itemMenuCadastrarBebida.addActionListener(new trataEventos());
		menuCadastroBebida.add(itemMenuCadastrarBebida);

		itemMenuConsultarBebida = new JMenuItem("Consultar");
		menuCadastroBebida.add(itemMenuConsultarBebida);

	}// fim do metodo construtor

	// classe responsavel por tratar os eventos solicitados pelo usuario
	private class trataEventos implements ActionListener {

		private JanelaCadastroCliente janelaCadastroCliente;
		private JanelaCadastroBebiba janelaCadastroBebida;

		@Override
		public void actionPerformed(ActionEvent evento) {

			if (evento.getSource() == itemMenuCadastrarCliente) {

				try {
					janelaCadastroCliente = new JanelaCadastroCliente();
					janelaCadastroCliente.setVisible(true);

				} catch (ParseException e) {

				}

			} else if (evento.getSource() == itemMenuCadastrarBebida) {

				try {
					janelaCadastroBebida = new JanelaCadastroBebiba();
					janelaCadastroBebida.setVisible(true);
				} catch (ParseException e) {

				}
			}
		}

	}// fim da classe trataEventos

}
