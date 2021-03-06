package br.com.drinkbar.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

import br.com.drinksaqlite.negocio.Bebida;
import br.com.drinksaqlite.negocio.FachadaBebida;

public class JanelaConsultarBebida extends JFrame {

	private JPanel contentPane;
	private JTextField textPesquisaBebida;
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

		textPesquisaBebida = new JTextField();
		panel.add(textPesquisaBebida);
		textPesquisaBebida.setColumns(20);

		btnPesquisa = new JButton("Pesquisar");
		btnPesquisa.addActionListener(new TrataEventos());
		panel.add(btnPesquisa);

		painelTabelaBebida = new JPanel();
		contentPane.add(painelTabelaBebida, BorderLayout.CENTER);
		painelTabelaBebida.setLayout(new BorderLayout(0, 0));

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
		modeloTabela.addColumn("PRE�O");

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

		painelTabelaBebida.add(jScrollPane);

	}// fim do metodo criar tabela

	private class TrataEventos implements ActionListener {

		private List<Bebida> bebidas;
		private FachadaBebida fachada = new FachadaBebida();

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnPesquisa) {

				try {
					bebidas = fachada.pesquisarBebida(textPesquisaBebida
							.getText());

					for (int i = 0; i < bebidas.size(); i++) {

						modeloTabela.addRow(new Object[] {
								bebidas.get(i).getNome(),
								bebidas.get(i).getTipo(),
								bebidas.get(i).getFabricante(),
								bebidas.get(i).getDataFabricacao(),
								bebidas.get(i).getPreco() });
					}

				} catch (Exception e1) {
				
				}

			}
		}

	}// fim da classe  actionPerformed
}
