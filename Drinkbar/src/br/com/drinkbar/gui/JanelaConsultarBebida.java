package br.com.drinkbar.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class JanelaConsultarBebida extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPanel painelTabelaBebida;
	private JPanel panel;
	private JLabel lblTipo;
	private JButton btnPesquisa;
	private DefaultTableModel modeloTabela;
	private JTable tabelaCliente;
	private JScrollPane jScrollPane;

	public JanelaConsultarBebida() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		lblTipo = new JLabel("Tipo:");
		panel.add(lblTipo);

		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(20);

		btnPesquisa = new JButton("Pesquisar");
		panel.add(btnPesquisa);

		painelTabelaBebida = new JPanel();
		contentPane.add(painelTabelaBebida, BorderLayout.CENTER);

		criarTabela();
	}

	// metodo responsavel por criar uma tabela
	public void criarTabela() {

		modeloTabela = new DefaultTableModel();
		tabelaCliente = new JTable(modeloTabela);
		jScrollPane = new JScrollPane(tabelaCliente);
		modeloTabela.addColumn("NOME");
		modeloTabela.addColumn("TIPO");
		modeloTabela.addColumn("FABRICANTE");
		modeloTabela.addColumn("DATA/FABR.");
		modeloTabela.addColumn("PREÇO");

		tabelaCliente.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabelaCliente.getColumnModel().getColumn(0).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(1).setPreferredWidth(50);
		tabelaCliente.getColumnModel().getColumn(1).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(2).setPreferredWidth(40);
		tabelaCliente.getColumnModel().getColumn(2).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(3).setPreferredWidth(10);
		tabelaCliente.getColumnModel().getColumn(3).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(4).setPreferredWidth(20);
		tabelaCliente.getColumnModel().getColumn(4).setResizable(false);

		painelTabelaBebida.setLayout(new BorderLayout(0, 0));
		painelTabelaBebida.add(jScrollPane);

	}// fim do metodo criar tabela
}
