package br.com.drinkbar.gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import br.com.drinksaqlite.negocio.Cliente;
import br.com.drinksaqlite.negocio.FachadaCliente;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelConsultarCliente extends JPanel {
	private JTextField textPesquisaCliente;
	private JPanel painelPesquisaCliente;
	private JButton btnPesquisaCliente;
	private JPanel painelTabelaCliente;
	private DefaultTableModel modeloTabela;
	private JTable tabelaCliente;
	private JScrollPane jScrollPane;
	private FachadaCliente fachada;

	public PanelConsultarCliente() {
		setLayout(null);

		painelPesquisaCliente = new JPanel();
		painelPesquisaCliente.setBounds(0, 0, 694, 39);
		add(painelPesquisaCliente);

		fachada = new FachadaCliente();

		textPesquisaCliente = new JTextField();
		textPesquisaCliente.setColumns(30);
		painelPesquisaCliente.add(textPesquisaCliente);

		btnPesquisaCliente = new JButton("Pesquisar");
		btnPesquisaCliente.addActionListener(new trataEventos());
		painelPesquisaCliente.add(btnPesquisaCliente);

		painelTabelaCliente = new JPanel();
		painelTabelaCliente.setBounds(0, 39, 694, 429);
		add(painelTabelaCliente);
		painelTabelaCliente.setLayout(new BorderLayout(0, 0));

		criarTabela();

	}

	// metodo responsavel por criar uma tabela
	public void criarTabela() {

		modeloTabela = new DefaultTableModel();
		tabelaCliente = new JTable(modeloTabela);
		jScrollPane = new JScrollPane(tabelaCliente);
		modeloTabela.addColumn("NOME");
		modeloTabela.addColumn("CPF");
		modeloTabela.addColumn("TELEFONE");
		modeloTabela.addColumn("SEXO");
		modeloTabela.addColumn("ENDEREÇO");
		modeloTabela.addColumn("CEP");
		modeloTabela.addColumn("BAIRRO");
		modeloTabela.addColumn("CIDADE");

		tabelaCliente.getColumnModel().getColumn(0).setPreferredWidth(60);
		tabelaCliente.getColumnModel().getColumn(0).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(1).setPreferredWidth(40);
		tabelaCliente.getColumnModel().getColumn(1).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(2).setPreferredWidth(40);
		tabelaCliente.getColumnModel().getColumn(2).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(3).setPreferredWidth(1);
		tabelaCliente.getColumnModel().getColumn(3).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(4).setPreferredWidth(50);
		tabelaCliente.getColumnModel().getColumn(4).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(5).setPreferredWidth(20);
		tabelaCliente.getColumnModel().getColumn(5).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(6).setPreferredWidth(20);
		tabelaCliente.getColumnModel().getColumn(6).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(7).setPreferredWidth(30);
		tabelaCliente.getColumnModel().getColumn(7).setResizable(false);
		painelTabelaCliente.add(jScrollPane);

	}// fim do metodo criar tabela

	private class trataEventos implements ActionListener {

		private List<Cliente> clientes;

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnPesquisaCliente) {

				try {

					clientes = fachada.pesquisarCliente(textPesquisaCliente
							.getText());

					for (int i = 0; i < clientes.size(); i++) {

						modeloTabela.addRow(new Object[] {
								clientes.get(i).getNome(),
								clientes.get(i).getCpf(),
								clientes.get(i).getTelefone(),
								clientes.get(i).getSexo(),
								clientes.get(i).getEndereco(),
								clientes.get(i).getCep(),
								clientes.get(i).getBairro(),
								//clientes.get(i).getCidade() 
								});

					}

				} catch (Exception e1) {
					System.err.println(e1.getMessage());
				}

				textPesquisaCliente.setText("");

			}

		}
	}// fim da classe TratarEvento
}
