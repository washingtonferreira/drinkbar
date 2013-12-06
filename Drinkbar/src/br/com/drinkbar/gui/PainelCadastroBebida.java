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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import br.com.drinkbar.dados.RecpositorioClienteDao;
import br.com.drinksaqlite.negocio.Bebida;
import br.com.drinksaqlite.negocio.FachadaBebida;

public class PainelCadastroBebida extends JPanel {
	private JTextField textNome;
	private JTextField textFabricante;
	private JTextField textTipo;
	private JTextField textPreco;
	private JTextField textDataFab;
	private JPanel painelTabelaBebidas;
	private DefaultTableModel modeloTabela;
	private JTable tabelaCliente;
	private JScrollPane jScrollPane;
	private JButton btnListarBebidas;
	private JButton bntSalvar;
	private JButton bntCancelar;
	private FachadaBebida fachada;

	public PainelCadastroBebida() {
		setLayout(new BorderLayout(0, 0));

		fachada = new FachadaBebida();

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Cadastro - Bebida",

		TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel_1.setBounds(10, 11, 674, 221);
		panel.add(panel_1);

		JLabel lbNome = new JLabel("Nome:");
		lbNome.setBounds(10, 27, 46, 14);
		panel_1.add(lbNome);

		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(10, 42, 268, 20);
		panel_1.add(textNome);

		JLabel lbFabricante = new JLabel("Fabricante:");
		lbFabricante.setBounds(301, 27, 80, 14);
		panel_1.add(lbFabricante);

		textFabricante = new JTextField();
		textFabricante.setColumns(10);
		textFabricante.setBounds(301, 42, 153, 20);
		panel_1.add(textFabricante);

		bntSalvar = new JButton("");
		bntSalvar.addActionListener(new TrataEventos());
		bntSalvar.setIcon(new ImageIcon(PainelCadastroBebida.class
				.getResource("/br/com/drinkbar/gui/imagens/adicionar.png")));
		bntSalvar.setToolTipText("Cadastrar bebida");
		bntSalvar.setBounds(181, 135, 65, 41);
		panel_1.add(bntSalvar);

		bntCancelar = new JButton("");
		bntCancelar.setIcon(new ImageIcon(PainelCadastroBebida.class
				.getResource("/br/com/drinkbar/gui/imagens/cancel.png")));
		bntCancelar.setToolTipText("Cancelar cadastro");
		bntCancelar.setBounds(427, 135, 65, 41);
		panel_1.add(bntCancelar);

		JLabel lbTipo = new JLabel("Tipo:");
		lbTipo.setBounds(476, 27, 46, 14);
		panel_1.add(lbTipo);

		textTipo = new JTextField();
		textTipo.setColumns(10);
		textTipo.setBounds(476, 42, 153, 20);
		panel_1.add(textTipo);

		JLabel lbDataFab = new JLabel("Data de Fabrica\u00E7\u00E3o:");
		lbDataFab.setBounds(13, 73, 164, 14);
		panel_1.add(lbDataFab);

		JLabel label_4 = new JLabel("Pre\u00E7o:");
		label_4.setBounds(187, 73, 46, 14);
		panel_1.add(label_4);

		textPreco = new JTextField();
		textPreco.setColumns(10);
		textPreco.setBounds(187, 88, 100, 20);
		panel_1.add(textPreco);

		textDataFab = new JTextField();
		textDataFab.setColumns(10);
		textDataFab.setBounds(10, 88, 153, 20);
		panel_1.add(textDataFab);

		btnListarBebidas = new JButton("Listar Bebidas");
		btnListarBebidas.addActionListener(new TrataEventos());
		btnListarBebidas.setBounds(10, 243, 155, 23);
		panel.add(btnListarBebidas);

		painelTabelaBebidas = new JPanel();
		painelTabelaBebidas.setBounds(10, 277, 674, 193);
		panel.add(painelTabelaBebidas);
		painelTabelaBebidas.setLayout(new BorderLayout(0, 0));

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

		painelTabelaBebidas.add(jScrollPane);

	}// fim do metodo criar tabela

	public void limpaCampos() {

		textDataFab.setText("");
		textFabricante.setText("");
		textNome.setText("");
		textPreco.setText("");
		textTipo.setText("");
	}

	// metodo para preencher a tabela
	public void preencherTablela(String sql) {

		RecpositorioClienteDao repCliente = new RecpositorioClienteDao();
		repCliente.abrirConexao();
		try {

			repCliente.comandoQuery = repCliente.conexao.prepareStatement(sql);
			repCliente.resultSet = repCliente.comandoQuery.executeQuery();

			ResultSet rs = repCliente.resultSet;

			do {

				modeloTabela.addRow(new Object[] { rs.getString("nome_bebida"),
						rs.getString("tipo_bebida"),
						rs.getString("fabricante_bebida"),
						rs.getString("dataFabricacao_bebida"),
						rs.getDouble("preco_bebida") });

			} while (rs.next());

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela: "
					+ e);
		}

		// repositorioCliente.fecharConexaoBancoDados();
	}// fim do metodo preencher a tabel

	private class TrataEventos implements ActionListener {

		private Bebida bebida;

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnListarBebidas) {

				preencherTablela("SELECT * FROM bebida");
			} else if (e.getSource() == bntSalvar) {

				bebida = new Bebida();

				try {

					double preco = Double.parseDouble(textPreco.getText());

					bebida.setDataFabricacao(textDataFab.getText());
					bebida.setFabricante(textFabricante.getText());
					bebida.setNome(textNome.getText());
					bebida.setPreco(preco);
					bebida.setTipo(textTipo.getText());

					fachada.cadastrarBebida(bebida);

				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

				limpaCampos();
			}
		}// fim da classe actionPerformed

	}
}
