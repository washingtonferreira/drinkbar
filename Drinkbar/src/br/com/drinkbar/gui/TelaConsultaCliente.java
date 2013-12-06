package br.com.drinkbar.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.drinkbar.dados.RecpositorioClienteDao;
import br.com.drinksaqlite.negocio.Cliente;
import br.com.drinksaqlite.negocio.FachadaCliente;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

public class TelaConsultaCliente extends JFrame {

	private JPanel painelTabelaCliente;
	private FachadaCliente fachada;
	private RecpositorioClienteDao repCliente;
	private JTextField textPesquisar;
	private JButton bntPesquisar;
	private DefaultTableModel modeloTabela;
	private JTable tabelaCliente;
	private JLabel lblCpf;

	public TelaConsultaCliente() throws ParseException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 500);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		JPanel painel = new JPanel();
		getContentPane().add(painel, BorderLayout.NORTH);

		fachada = new FachadaCliente();
		
		lblCpf = new JLabel("Cpf:");
		painel.add(lblCpf);

		textPesquisar = new JTextField();
		MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
		textPesquisar = new JFormattedTextField(mascaraCpf);
		painel.add(textPesquisar);

		textPesquisar.setColumns(30);

		bntPesquisar = new JButton("Pesquisar");
		bntPesquisar.addActionListener(new trataEventos());
		painel.add(bntPesquisar);

		painelTabelaCliente = new JPanel();
		getContentPane().add(painelTabelaCliente, BorderLayout.CENTER);
		painelTabelaCliente.setLayout(new BorderLayout(0, 0));

		criarTabela();

	}

	// metodo responsavel por criar uma tabela
	public void criarTabela() {

		modeloTabela = new DefaultTableModel();
		tabelaCliente = new JTable(modeloTabela);
		JScrollPane jScrollPane = new JScrollPane(tabelaCliente);
		modeloTabela.addColumn("NOME");
		modeloTabela.addColumn("CPF");
		modeloTabela.addColumn("TELEFONE");
		modeloTabela.addColumn("SEXO");
		modeloTabela.addColumn("ENDEREÇO");
		modeloTabela.addColumn("CEP");
		modeloTabela.addColumn("BAIRRO");
		modeloTabela.addColumn("CIDADE");

		tabelaCliente.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabelaCliente.getColumnModel().getColumn(0).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(1).setPreferredWidth(20);
		tabelaCliente.getColumnModel().getColumn(1).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(2).setPreferredWidth(20);
		tabelaCliente.getColumnModel().getColumn(2).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(3).setPreferredWidth(3);
		tabelaCliente.getColumnModel().getColumn(3).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(4).setPreferredWidth(80);
		tabelaCliente.getColumnModel().getColumn(4).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(5).setPreferredWidth(20);
		tabelaCliente.getColumnModel().getColumn(5).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(6).setPreferredWidth(30);
		tabelaCliente.getColumnModel().getColumn(6).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(7).setPreferredWidth(30);
		tabelaCliente.getColumnModel().getColumn(7).setResizable(false);
		painelTabelaCliente.add(jScrollPane);

	}// fim do metodo criar tabela

	private class trataEventos implements ActionListener {

		private List<Cliente> clientes;

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == bntPesquisar) {

				try {

					clientes = fachada
							.pesquisarCliente(textPesquisar.getText());

					for (int i = 0; i < clientes.size(); i++) {

						modeloTabela.addRow(new Object[] {
								clientes.get(i).getNome(),
								clientes.get(i).getCpf(),
								clientes.get(i).getTelefone(),
								clientes.get(i).getSexo(),
								clientes.get(i).getEndereco(),
								clientes.get(i).getCep(),
								clientes.get(i).getBairro(),
								clientes.get(i).getCidade() });

					}

				} catch (Exception e1) {
					System.err.println(e1.getMessage());
				}

				textPesquisar.setText("");

			}

		}
	}// fim da classe TratarEvento

}
