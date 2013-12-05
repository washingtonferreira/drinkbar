package br.com.drinkbar.gui;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import br.com.drinkbar.dados.RecpositorioClienteDao;
import br.com.drinkbar.dados.RepositorioBabidaDao;
import br.com.drinksaqlite.negocio.Cliente;
import br.com.drinksaqlite.negocio.FachadaCliente;

public class PainelCadastroCliente extends JPanel {
	private final JPanel panel = new JPanel();
	private JTextField textNome;
	private JTextField textEndereco;
	private JTextField textBairro;
	private JTextField textCidade;
	private JComboBox<String> comboBoxEstado;
	private JComboBox<String> comboBoxSexo;
	private JButton btnCancelar;
	private JButton btnListarCliente;
	private JButton btnSalvar;
	private JTextField textCep;
	private JTextField textTelefone;
	private JTextField textCpf;
	private FachadaCliente fachada;
	private DefaultTableModel modeloTabela;
	private JTable tabelaCliente;
	private JScrollPane jScrollPane;
	private RecpositorioClienteDao repCliente;
	private JPanel painelPrincipal;
	private JPanel painelCadastroCliente;
	private JLabel lbNome;
	private JLabel lbEndereco;
	private JLabel lbBairro;
	private JLabel lbCidade;
	private JLabel lbEstado;
	private JLabel lbCep;
	private JLabel lbTelefone;
	private JLabel lbCpf;
	private JPanel painelOperacoes;
	private JPanel painelTabelaCliente;
	private JLabel lbSexo;

	public PainelCadastroCliente() {
		setLayout(new BorderLayout(0, 0));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		fachada = new FachadaCliente();

		painelPrincipal = new JPanel();
		painelPrincipal.setLayout(null);
		painelPrincipal.setBounds(10, 11, 685, 464);
		panel.add(painelPrincipal);

		painelCadastroCliente = new JPanel();
		painelCadastroCliente.setLayout(null);
		painelCadastroCliente.setBorder(new TitledBorder(null,

		"Cadatro - Cliente", TitledBorder.LEADING, TitledBorder.TOP,

		null, Color.BLUE));
		painelCadastroCliente.setBounds(10, 11, 666, 442);
		painelPrincipal.add(painelCadastroCliente);

		lbNome = new JLabel("Nome:");
		lbNome.setBounds(10, 30, 46, 14);
		painelCadastroCliente.add(lbNome);

		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(10, 45, 463, 20);
		painelCadastroCliente.add(textNome);

		lbEndereco = new JLabel("Endere\u00E7o:");
		lbEndereco.setBounds(10, 76, 78, 14);
		painelCadastroCliente.add(lbEndereco);

		textEndereco = new JTextField();
		textEndereco.setColumns(10);
		textEndereco.setBounds(10, 92, 463, 20);
		painelCadastroCliente.add(textEndereco);

		lbBairro = new JLabel("Bairro: ");
		lbBairro.setBounds(10, 123, 65, 14);
		painelCadastroCliente.add(lbBairro);

		textBairro = new JTextField();
		textBairro.setColumns(10);
		textBairro.setBounds(10, 139, 120, 20);
		painelCadastroCliente.add(textBairro);

		lbCidade = new JLabel("Cidade:");
		lbCidade.setToolTipText("Informe a cidade do cliente");
		lbCidade.setBounds(503, 76, 46, 14);
		painelCadastroCliente.add(lbCidade);

		textCidade = new JTextField();
		textCidade.setColumns(10);
		textCidade.setBounds(503, 92, 153, 20);
		painelCadastroCliente.add(textCidade);

		lbEstado = new JLabel("Estado: ");
		lbEstado.setBounds(503, 123, 65, 14);
		painelCadastroCliente.add(lbEstado);

		comboBoxEstado = new JComboBox<String>();
		comboBoxEstado.setModel(new DefaultComboBoxModel<String>(new String[] {
				"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA ",
				"MT", "MS ", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN",
				"RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		comboBoxEstado.setBounds(503, 139, 46, 20);
		painelCadastroCliente.add(comboBoxEstado);

		lbCep = new JLabel("Cep:");
		lbCep.setBounds(160, 123, 46, 14);
		painelCadastroCliente.add(lbCep);

		textCep = new JTextField();
		textCep.setColumns(10);
		textCep.setBounds(158, 139, 120, 20);
		painelCadastroCliente.add(textCep);

		lbTelefone = new JLabel("Telefone:");
		lbTelefone.setBounds(310, 123, 89, 14);
		painelCadastroCliente.add(lbTelefone);

		textTelefone = new JTextField();
		textTelefone.setColumns(10);
		textTelefone.setBounds(310, 139, 120, 20);
		painelCadastroCliente.add(textTelefone);

		lbCpf = new JLabel("Cpf:");
		lbCpf.setBounds(503, 30, 46, 14);
		painelCadastroCliente.add(lbCpf);

		textCpf = new JTextField();
		textCpf.setColumns(10);
		textCpf.setBounds(503, 45, 153, 20);
		painelCadastroCliente.add(textCpf);

		comboBoxSexo = new JComboBox<String>();
		comboBoxSexo.setModel(new DefaultComboBoxModel<String>(new String[] {
				"M", "F" }));
		comboBoxSexo.setBounds(578, 139, 46, 20);
		painelCadastroCliente.add(comboBoxSexo);

		painelOperacoes = new JPanel();
		painelOperacoes.setLayout(null);
		painelOperacoes.setBorder(new TitledBorder(null, "Opera\u00E7\u00F5es",

		TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		painelOperacoes.setBounds(10, 170, 646, 64);
		painelCadastroCliente.add(painelOperacoes);

		btnSalvar = new JButton("");
		btnSalvar.addActionListener(new trataEventos());
		btnSalvar.setIcon(new ImageIcon(PainelCadastroCliente.class
				.getResource("/br/com/drinkbar/gui/imagens/adicionar.png")));
		btnSalvar.setToolTipText("Cadastrar cliente");
		btnSalvar.setBounds(172, 12, 65, 41);
		painelOperacoes.add(btnSalvar);

		btnCancelar = new JButton("");
		btnCancelar.setIcon(new ImageIcon(PainelCadastroCliente.class
				.getResource("/br/com/drinkbar/gui/imagens/cancel.png")));
		btnCancelar.setToolTipText("Cancelar cadastro");
		btnCancelar.setBounds(409, 12, 65, 41);
		painelOperacoes.add(btnCancelar);

		painelTabelaCliente = new JPanel();
		painelTabelaCliente.setBorder(new TitledBorder(null,

		"Lista de Cliente", TitledBorder.LEADING, TitledBorder.TOP,

		null, Color.BLUE));
		painelTabelaCliente.setBounds(10, 274, 646, 157);
		painelCadastroCliente.add(painelTabelaCliente);
		painelTabelaCliente.setLayout(new BorderLayout(0, 0));

		lbSexo = new JLabel("Sexo:");
		lbSexo.setBounds(578, 123, 65, 14);
		painelCadastroCliente.add(lbSexo);

		btnListarCliente = new JButton("Listar Clientes");
		btnListarCliente.addActionListener(new trataEventos());
		btnListarCliente.setBounds(10, 245, 120, 23);
		painelCadastroCliente.add(btnListarCliente);

		criarTabela();

	}

	// metodo responsavel por criar uma tabela
	public void criarTabela() {

		modeloTabela = new DefaultTableModel();
		tabelaCliente = new JTable(modeloTabela);
		jScrollPane = new JScrollPane(tabelaCliente);
		modeloTabela.addColumn("Nome");
		modeloTabela.addColumn("Cpf");
		modeloTabela.addColumn("Telefone");
		tabelaCliente.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabelaCliente.getColumnModel().getColumn(0).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(1).setPreferredWidth(20);
		tabelaCliente.getColumnModel().getColumn(1).setResizable(false);
		tabelaCliente.getColumnModel().getColumn(2).setPreferredWidth(20);
		tabelaCliente.getColumnModel().getColumn(2).setResizable(false);
		painelTabelaCliente.add(jScrollPane);

	}// fim do metodo criar tabela

	// metodo para preencher a tabela
	public void preencherTablela(String sql) {

		repCliente = new RecpositorioClienteDao();
		repCliente.abrirConexao();
		try {

			repCliente.comandoQuery = repCliente.conexao.prepareStatement(sql);
			repCliente.resultSet = repCliente.comandoQuery.executeQuery();

			ResultSet rs = repCliente.resultSet;

			do {

				modeloTabela.addRow(new Object[] {
						rs.getString("mome_cliente"),
						rs.getString("cpf_cliente"),
						rs.getString("telefone_cliente") });

			} while (rs.next());

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela: "
					+ e);
		}

		// repositorioCliente.fecharConexaoBancoDados();
	}// fim do metodo preencher a tabela

	// métodos responsável por limpar os campos após o cadastro de um cliente
	public void limpaCampos() {

		textCep.setText("");
		textCidade.setText("");
		textCpf.setText("");
		textTelefone.setText("");
		textBairro.setText("");
		textEndereco.setText("");
		textNome.setText("");

	}// fim do metodo limpar campo

	// classe destinada a tratar os eventos soliciados pelos clientes
	private class trataEventos implements ActionListener {

		private Cliente cliente;

		@Override
		public void actionPerformed(ActionEvent evento) {

			// condicao para cadastrar um cliente
			if (evento.getSource() == btnSalvar) {

				cliente = new Cliente();
				String sx = comboBoxSexo.getSelectedItem() + "";
				cliente.setNome(textNome.getText());
				cliente.setBairro(textBairro.getText());
				cliente.setCep(textCep.getText());
				cliente.setCidade(textCidade.getText());
				cliente.setCpf(textCpf.getText());
				cliente.setEndereco(textEndereco.getText());
				cliente.setTelefone(textTelefone.getText());
				cliente.setEstado(comboBoxEstado.getSelectedItem() + " ");
				cliente.setSexo(sx);
				// verifica se existe algum campo não preenchido
				if (textBairro.getText().isEmpty()
						|| textEndereco.getText().isEmpty()
						|| textNome.getText().isEmpty()
						|| textCep.getText().isEmpty()
						|| textCidade.getText().isEmpty()
						|| textCpf.getText().isEmpty()
						|| textTelefone.getText().isEmpty()) {

					JOptionPane.showMessageDialog(null,
							"Não pode haber campos vazios!", "ATENÇÂO",
							JOptionPane.ERROR_MESSAGE);

				} else {
					fachada.cadastraCliente(cliente);
					// limpaCampos();
				}

			}// fim da estrutura de condcao if

			// condicao para listar cliente
			else if (evento.getSource() == btnListarCliente) {

				preencherTablela("SELECT * FROM cliente");
			}

		}// fim do método actionPerformed
	}// fim da classe trataEventos

}
