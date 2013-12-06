package br.com.drinkbar.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.table.DefaultTableModel;

import br.com.drinksaqlite.negocio.Bebida;
import br.com.drinksaqlite.negocio.FachadaBebida;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PainelConsultarBebida extends JPanel {
	private JTextField textPesquisa;
	private JPanel painelTabelaBebida;
	private JLabel lbTipo;
	private JPanel panel;
	private JButton btnPesquisar;
	private DefaultTableModel modeloTabela;
	private JTable tabelaCliente;
	private JScrollPane jScrollPane;

	/**
	 * Create the panel.
	 */
	public PainelConsultarBebida() {
		setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 694, 39);
		add(panel);

		lbTipo = new JLabel("Tipo:");
		panel.add(lbTipo);

		textPesquisa = new JTextField();
		panel.add(textPesquisa);
		textPesquisa.setColumns(20);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new TrataEventos());
		panel.add(btnPesquisar);

		painelTabelaBebida = new JPanel();
		painelTabelaBebida.setBounds(10, 46, 674, 400);
		add(painelTabelaBebida);
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

		painelTabelaBebida.add(jScrollPane);

	}// fim do metodo criar tabela

	private class TrataEventos implements ActionListener {

		private List<Bebida> bebidas;
		private FachadaBebida fachada = new FachadaBebida();

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnPesquisar) {

				try {
					bebidas = fachada.pesquisarBebida(textPesquisa.getText());

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

	}// fim da classe actionPerformed
}
