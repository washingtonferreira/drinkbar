package br.com.drinkbar.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TelaConsultaCliente extends JFrame {

	private JPanel painelTabelaCliente;

	public TelaConsultaCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		JPanel painel = new JPanel();
		getContentPane().add(painel, BorderLayout.NORTH);

		JTextField textPesquisar = new JTextField();
		painel.add(textPesquisar);

		textPesquisar.setColumns(30);

		JButton bntPesquisar = new JButton("Pesquisar");
		painel.add(bntPesquisar);

		painelTabelaCliente = new JPanel();
		getContentPane().add(painelTabelaCliente, BorderLayout.CENTER);
		painelTabelaCliente.setLayout(new BorderLayout(0, 0));

		criarTabela();

	}

	// metodo responsavel por criar uma tabela
	public void criarTabela() {

		DefaultTableModel modeloTabela = new DefaultTableModel();
		JTable tabelaCliente = new JTable(modeloTabela);
		JScrollPane jScrollPane = new JScrollPane(tabelaCliente);
		modeloTabela.addColumn("ID");
		modeloTabela.addColumn("NOME");
		modeloTabela.addColumn("CPF");
		modeloTabela.addColumn("TELEFONE");
		modeloTabela.addColumn("SEXO");
		modeloTabela.addColumn("ENDEREÇO");
		modeloTabela.addColumn("CEP");
		modeloTabela.addColumn("BAIRRO");
		modeloTabela.addColumn("CIDADE");

		tabelaCliente.getColumnModel().getColumn(0).setPreferredWidth(5);
		tabelaCliente.getColumnModel().getColumn(0).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabelaCliente.getColumnModel().getColumn(1).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(2).setPreferredWidth(20);
		tabelaCliente.getColumnModel().getColumn(2).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(0).setPreferredWidth(20);
		tabelaCliente.getColumnModel().getColumn(0).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(1).setPreferredWidth(3);
		tabelaCliente.getColumnModel().getColumn(1).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(2).setPreferredWidth(80);
		tabelaCliente.getColumnModel().getColumn(2).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(0).setPreferredWidth(20);
		tabelaCliente.getColumnModel().getColumn(0).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(1).setPreferredWidth(30);
		tabelaCliente.getColumnModel().getColumn(1).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(2).setPreferredWidth(30);
		tabelaCliente.getColumnModel().getColumn(2).setResizable(false);
		painelTabelaCliente.add(jScrollPane);

	}// fim do metodo criar tabela

}
