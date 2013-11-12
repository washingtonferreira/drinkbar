package br.com.drinkbar.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class JanelaCadastroBebiba extends JFrame {
	private JTextField textNomeBebida;
	private JTextField textFabricante;
	private JTextField textTipoBebida;
	private JTextField textDataFabricacaoBebida;
	private JTextField textPrecoBebida;
	private JPanel painelPrincipal;
	private JPanel painelCadastro;
	private JLabel jlNome;
	private JLabel jlFabricante;
	private JLabel jlTipo;
	private JLabel lblDataDeFabricao = new JLabel(
			"Data de Fabrica\u00E7\u00E3o:");
	private JLabel lblPreo;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private JButton btnSair;

	public JanelaCadastroBebiba() {
		setTitle("DrinksBar - Cadastro de Bebidas");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 274);

		painelPrincipal = new JPanel();
		getContentPane().add(painelPrincipal, BorderLayout.CENTER);
		painelPrincipal.setLayout(null);

		painelCadastro = new JPanel();
		painelCadastro.setBorder(new TitledBorder(null, "Cadastro - Bebida",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		painelCadastro.setBounds(10, 11, 464, 213);
		painelPrincipal.add(painelCadastro);
		painelCadastro.setLayout(null);

		jlNome = new JLabel("Nome:");
		jlNome.setBounds(10, 27, 46, 14);
		painelCadastro.add(jlNome);

		textNomeBebida = new JTextField();
		textNomeBebida.setColumns(10);
		textNomeBebida.setBounds(10, 42, 268, 20);
		painelCadastro.add(textNomeBebida);

		jlFabricante = new JLabel("Fabricante:");
		jlFabricante.setBounds(301, 27, 80, 14);
		painelCadastro.add(jlFabricante);

		textFabricante = new JTextField();
		textFabricante.setColumns(10);
		textFabricante.setBounds(301, 42, 153, 20);
		painelCadastro.add(textFabricante);

		jlTipo = new JLabel("Tipo:");
		jlTipo.setBounds(10, 73, 46, 14);
		painelCadastro.add(jlTipo);

		textTipoBebida = new JTextField();
		textTipoBebida.setColumns(10);
		textTipoBebida.setBounds(10, 88, 153, 20);
		painelCadastro.add(textTipoBebida);

		lblDataDeFabricao.setBounds(184, 73, 164, 14);
		painelCadastro.add(lblDataDeFabricao);

		textDataFabricacaoBebida = new JTextField();
		textDataFabricacaoBebida.setColumns(10);
		textDataFabricacaoBebida.setBounds(181, 88, 153, 20);
		painelCadastro.add(textDataFabricacaoBebida);

		textPrecoBebida = new JTextField();
		textPrecoBebida.setBounds(354, 88, 100, 20);
		painelCadastro.add(textPrecoBebida);
		textPrecoBebida.setColumns(10);

		lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setBounds(354, 73, 46, 14);
		painelCadastro.add(lblPreo);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(49, 154, 89, 23);
		painelCadastro.add(btnCadastrar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(187, 154, 89, 23);
		painelCadastro.add(btnCancelar);

		btnSair = new JButton("sair");
		btnSair.setBounds(325, 154, 89, 23);
		painelCadastro.add(btnSair);
	}

}
