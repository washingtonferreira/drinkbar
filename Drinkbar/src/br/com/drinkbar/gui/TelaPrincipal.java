package br.com.drinkbar.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.Color;
import java.awt.SystemColor;

/**
 * @author Diego Santos Tela Principal do sistema Drinks Bar....
 * */

public class TelaPrincipal extends JFrame {

	private JButton btnBebidas;
	private JButton btnClientes;
	private JPanel panelBntCliBeer;
	private JPanel panelBotoes;
	private JMenuItem itemMenuClientes;
	private JMenuItem itemMenuBebidas;
	private JMenu mnCadastros;
	private JMenuBar menuBar;

	public TelaPrincipal() {
		super("Drinks Bar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 500);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnCadastros = new JMenu("CADASTROS");
		menuBar.add(mnCadastros);

		itemMenuBebidas = new JMenuItem("BEBIDAS");
		itemMenuBebidas.setIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/br/com/drinkbar/gui/imagens/Beer_Icon_32.png")));
		itemMenuBebidas.addActionListener(new trataEventos());
		mnCadastros.add(itemMenuBebidas);

		itemMenuClientes = new JMenuItem("CLIENTES");
		itemMenuClientes.setIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/br/com/drinkbar/gui/imagens/group.png")));
		itemMenuClientes.addActionListener(new trataEventos());
		mnCadastros.add(itemMenuClientes);

		panelBotoes = new JPanel();
		getContentPane().add(panelBotoes, BorderLayout.CENTER);
		panelBotoes.setLayout(null);

		panelBntCliBeer = new JPanel();
		panelBntCliBeer.setBounds(0, 0, 584, 56);
		panelBotoes.add(panelBntCliBeer);
		panelBntCliBeer.setLayout(new GridLayout(1, 3));

		btnClientes = new JButton("Clientes");
		btnClientes.setBackground(SystemColor.menu);
		btnClientes.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnClientes.setForeground(Color.BLACK);
		btnClientes
				.setIcon(new ImageIcon(
						TelaPrincipal.class
								.getResource("/br/com/drinkbar/gui/imagens/users-icon (Custom).png")));
		panelBntCliBeer.add(btnClientes);

		btnBebidas = new JButton("Bebidas");
		btnBebidas.setBackground(SystemColor.menu);
		btnBebidas.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnBebidas.setIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/br/com/drinkbar/gui/imagens/Beer_Icon_32.png")));
		panelBntCliBeer.add(btnBebidas);

	}

	// classe responsavel por tratar os eventos solicitados pelo usuario
	private class trataEventos implements ActionListener {

		private JanelaCadastroCliente janelaCadastroCliente;
		private JanelaCadastroBebiba janelaCadastroBebida;

		@Override
		public void actionPerformed(ActionEvent evento) {

			if (evento.getSource() == itemMenuClientes) {

				try {
					janelaCadastroCliente = new JanelaCadastroCliente();
					janelaCadastroCliente.setVisible(true);

				} catch (ParseException e) {

				}

			} else if (evento.getSource() == itemMenuBebidas) {

				try {
					janelaCadastroBebida = new JanelaCadastroBebiba();
					janelaCadastroBebida.setVisible(true);
				} catch (ParseException e) {

				}
			}
		}

	}// fim da classe trataEventos
}