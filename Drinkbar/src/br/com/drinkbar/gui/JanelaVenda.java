package br.com.drinkbar.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.Color;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.SwingConstants;

import br.com.drinkbar.dados.RecpositorioClienteDao;
import br.com.drinksaqlite.negocio.Bebida;
import br.com.drinksaqlite.negocio.Cliente;
import br.com.drinksaqlite.negocio.Transacao;

public class JanelaVenda extends JFrame {

	private JPanel contentPane;
	private JTextField textConsultarCliente;
	private JTextField textNome;
	private JTextField textTelefone;
	private JTextField textEndereco;
	private JTextField textCidade;
	private JTextField textBairro;
	private JTextField textConsultarBebida;
	private final JLabel lblPreco = new JLabel("Preco:");
	private JTextField textPrecoBebida;
	private JTextField textPrecoTotal;
	private JTextField textCep;
	private JTextField textEstado;
	private JLabel lbCidade;
	private JLabel lblCpf;
	private JPanel painelInformacaoCliente;
	private JButton btnConsultarCliente;
	private JLabel lblTelefone;
	private JLabel label;
	private JLabel lbBairro;
	private JLabel lblNome;
	private JPanel painelPrincipal;
	private JPanel painelBebida;
	private JButton btnConsultarBebida;
	private JLabel lbNomeBebida;
	private JButton btnAdicionarBebida;
	private JPanel painelTabelaBebida;
	private JButton btnSalvar;
	private JButton btnCancelarVenda;
	private JLabel lblPreoTotal;
	private JLabel blCep;
	private DefaultTableModel modeloTabela;
	private JTable tabelaCliente;
	private JScrollPane jScrollPane;

	private RecpositorioClienteDao rep;
	private String sql;
	private JLabel lblEstado;
	private JButton btnRemover;

	public JanelaVenda() throws ParseException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 536);
		setLocationRelativeTo(null);
		setResizable(false);

		rep = new RecpositorioClienteDao();

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new TitledBorder(null, "Venda",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		contentPane.add(painelPrincipal, BorderLayout.CENTER);
		painelPrincipal.setLayout(null);

		painelInformacaoCliente = new JPanel();
		painelInformacaoCliente.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"Informa\u00E7\u00F5es/Cliente", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.BLUE));
		painelInformacaoCliente.setBounds(10, 30, 554, 167);
		painelPrincipal.add(painelInformacaoCliente);
		painelInformacaoCliente.setLayout(null);

		lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(146, 11, 46, 14);
		painelInformacaoCliente.add(lblCpf);

		textConsultarCliente = new JTextField();
		MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
		textConsultarCliente = new JFormattedTextField(mascaraCpf);
		textConsultarCliente.setBounds(180, 8, 148, 20);
		painelInformacaoCliente.add(textConsultarCliente);
		textConsultarCliente.setColumns(10);

		btnConsultarCliente = new JButton("Consultar");
		btnConsultarCliente.addActionListener(new TrataEventos());
		btnConsultarCliente.setBounds(338, 7, 89, 23);
		painelInformacaoCliente.add(btnConsultarCliente);

		lblNome = new JLabel("Nome: ");
		lblNome.setBounds(10, 42, 46, 14);
		painelInformacaoCliente.add(lblNome);

		textNome = new JTextField();
		textNome.setBounds(49, 39, 298, 20);
		painelInformacaoCliente.add(textNome);
		textNome.setColumns(10);

		lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setBounds(361, 41, 82, 14);
		painelInformacaoCliente.add(lblTelefone);

		textTelefone = new JTextField();
		textTelefone.setBounds(416, 39, 128, 20);
		painelInformacaoCliente.add(textTelefone);
		textTelefone.setColumns(10);

		label = new JLabel("Endere\u00E7o:");
		label.setBounds(10, 67, 337, 14);
		painelInformacaoCliente.add(label);

		textEndereco = new JTextField();
		textEndereco.setColumns(10);
		textEndereco.setBounds(10, 83, 337, 20);
		painelInformacaoCliente.add(textEndereco);

		lbCidade = new JLabel("Cidade:");
		lbCidade.setToolTipText("Informe a cidade do cliente");
		lbCidade.setBounds(361, 67, 46, 14);
		painelInformacaoCliente.add(lbCidade);

		textCidade = new JTextField();
		textCidade.setColumns(10);
		textCidade.setBounds(361, 83, 153, 20);
		painelInformacaoCliente.add(textCidade);

		lbBairro = new JLabel("Bairro: ");
		lbBairro.setBounds(8, 113, 65, 14);
		painelInformacaoCliente.add(lbBairro);

		textBairro = new JTextField();
		textBairro.setColumns(10);
		textBairro.setBounds(5, 130, 120, 20);
		painelInformacaoCliente.add(textBairro);

		blCep = new JLabel("Cep:");
		blCep.setBounds(200, 114, 46, 14);
		painelInformacaoCliente.add(blCep);

		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(376, 114, 46, 14);
		painelInformacaoCliente.add(lblEstado);

		textCep = new JTextField();
		textCep.setBounds(200, 130, 128, 20);
		painelInformacaoCliente.add(textCep);
		textCep.setColumns(10);

		textEstado = new JTextField();
		textEstado.setBounds(376, 130, 138, 20);
		painelInformacaoCliente.add(textEstado);
		textEstado.setColumns(10);

		painelBebida = new JPanel();
		painelBebida.setBorder(new TitledBorder(null, "Bebidas",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		painelBebida.setBounds(10, 208, 554, 268);
		painelPrincipal.add(painelBebida);
		painelBebida.setLayout(null);

		textConsultarBebida = new JTextField();
		textConsultarBebida.setBounds(46, 16, 156, 20);
		painelBebida.add(textConsultarBebida);
		textConsultarBebida.setColumns(10);

		btnConsultarBebida = new JButton("Consultar");
		btnConsultarBebida.addActionListener(new TrataEventos());
		btnConsultarBebida.setBounds(212, 15, 89, 23);
		painelBebida.add(btnConsultarBebida);

		lbNomeBebida = new JLabel("Tipo:");
		lbNomeBebida.setBounds(10, 19, 46, 14);
		painelBebida.add(lbNomeBebida);
		lblPreco.setBounds(311, 11, 46, 31);
		painelBebida.add(lblPreco);

		textPrecoBebida = new JTextField();
		textPrecoBebida.setBounds(355, 16, 89, 20);
		painelBebida.add(textPrecoBebida);
		textPrecoBebida.setColumns(10);

		btnAdicionarBebida = new JButton("Adicionar");
		btnAdicionarBebida.addActionListener(new TrataEventos());
		btnAdicionarBebida.setBounds(10, 47, 89, 23);
		painelBebida.add(btnAdicionarBebida);

		painelTabelaBebida = new JPanel();
		painelTabelaBebida.setBorder(new TitledBorder(null, "Lista de Bebidas",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		painelTabelaBebida.setBounds(10, 76, 534, 131);
		painelBebida.add(painelTabelaBebida);
		painelTabelaBebida.setLayout(new BorderLayout(0, 0));

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 218, 89, 23);
		painelBebida.add(btnSalvar);

		btnCancelarVenda = new JButton("Cancelar");
		btnCancelarVenda.setBounds(109, 218, 89, 23);
		painelBebida.add(btnCancelarVenda);

		lblPreoTotal = new JLabel("Pre\u00E7o Total:");
		lblPreoTotal.setBounds(255, 222, 106, 14);
		painelBebida.add(lblPreoTotal);

		textPrecoTotal = new JTextField();
		textPrecoTotal.setBackground(Color.LIGHT_GRAY);
		textPrecoTotal.setForeground(Color.RED);
		textPrecoTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textPrecoTotal.setFont(new Font("Verdana", Font.PLAIN, 30));
		textPrecoTotal.setText("0.0");
		textPrecoTotal.setEditable(false);
		textPrecoTotal.setBounds(331, 218, 195, 39);
		painelBebida.add(textPrecoTotal);
		textPrecoTotal.setColumns(10);

		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new TrataEventos());
		btnRemover.setBounds(113, 47, 89, 23);
		painelBebida.add(btnRemover);

		criarTabela();
	}

	// metodo responsavel por criar uma tabela
	public void criarTabela() {

		modeloTabela = new DefaultTableModel();
		tabelaCliente = new JTable(modeloTabela);
		jScrollPane = new JScrollPane(tabelaCliente);
		modeloTabela.addColumn("Tipo");
		modeloTabela.addColumn("Nome");
		modeloTabela.addColumn("Fabricante");
		modeloTabela.addColumn("Data/Fabri.");
		modeloTabela.addColumn("Preço");
		tabelaCliente.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabelaCliente.getColumnModel().getColumn(0).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(1).setPreferredWidth(50);
		tabelaCliente.getColumnModel().getColumn(1).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(2).setPreferredWidth(50);
		tabelaCliente.getColumnModel().getColumn(2).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(3).setPreferredWidth(20);
		tabelaCliente.getColumnModel().getColumn(3).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(4).setPreferredWidth(20);
		tabelaCliente.getColumnModel().getColumn(4).setResizable(false);
		painelTabelaBebida.add(jScrollPane);

	}// fim do metodo criar tabela

	public void removerRow() {

		int linhaSelecionada = tabelaCliente.getSelectedRow();
		if (linhaSelecionada >= 0) {

			modeloTabela.removeRow(linhaSelecionada);
		}

	}

	private class TrataEventos implements ActionListener {

		private Transacao transacao = new Transacao();
		private Cliente cliente = new Cliente();

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnConsultarCliente
					&& !textConsultarCliente.equals("")) {

				try {
					transacao.PesquisaClienteVenda(
							textConsultarCliente.getText(), cliente);
					textBairro.setText(cliente.getBairro());
					textCep.setText(cliente.getCep());
					textCidade.setText(cliente.getCidade());
					textEndereco.setText(cliente.getEndereco());
					textEstado.setText(cliente.getEstado());
					textNome.setText(cliente.getNome());
					textTelefone.setText(cliente.getTelefone());

				} catch (Exception e1) {

				}

				textConsultarCliente.setText("");
				// rep.fecharConexaoBancoDados();
			}// fim do if p/ btnConsultarCliente
			else if (e.getSource() == btnConsultarBebida
					&& !textConsultarBebida.equals("")) {
				Bebida bebida = new Bebida();
				try {
					transacao.consultarBebida(textConsultarBebida.getText(),
							bebida);
					textPrecoBebida.setText(String.valueOf(bebida.getPreco()));

				} catch (Exception e1) {
					
				}

			}// fim do else if p/btnConsultarBebida
			else if (e.getSource() == btnAdicionarBebida) {

				String criterio = textConsultarBebida.getText();

				try {
					transacao.povoarTabelaBebida(criterio, modeloTabela);

					// atualiza o total a pagar
					double precoBebibaConsulta = Double
							.parseDouble(textPrecoBebida.getText());
					double precoTotal = Double.parseDouble(textPrecoTotal
							.getText());
					precoTotal = precoTotal + precoBebibaConsulta;
					String valorAtualizado = String.valueOf(precoTotal);
					textPrecoTotal.setText(valorAtualizado);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

			}// fim do else if p/btnConsultarBebida
			else if (e.getSource() == btnRemover) {

				removerRow();

			}
		}// fim do metodo actionPerformed

	}// fim da classe TrataEventos

}
