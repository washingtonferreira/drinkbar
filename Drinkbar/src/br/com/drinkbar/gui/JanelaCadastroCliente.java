package br.com.drinkbar.gui;

/**
 * @author Diego Santos
 * calsse responsável por criar a tela de cadastro de clientes e tratar seus respectivos eventos 
 *
 * */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import br.com.drinkbar.dados.RecpositorioClienteDao;
import br.com.drinksaqlite.negocio.cliente;

public class JanelaCadastroCliente extends JFrame {

	private JPanel painelPrincipal;
	private JPanel painelCadastroCliente;
	private JLabel jlNomeCliente;
	private JTextField jtextNomeCliente;
	private JLabel jlEndereco;
	private JTextField jtextEnderecoCliente;
	private JLabel jlBairro;
	private JTextField jtextBairroCliente;
	private JLabel jlCidade;
	private JTextField textCidadeCliente;
	private JLabel jlEstado;
	private JTextField textCep;
	private JTextField textTelefoneCliente;
	private JTextField textCpfCliente;
	private JButton jbntCadastrarCliente;
	private JButton jbntCancelarCliente;
	private JButton jbntSairCliente;
	private JComboBox<String> comboEstado;
	private JComboBox<String> comboSexoCliente;
	private JPanel painelOperacoes;
	private JPanel painelTabelaCliente;
	private Icon imagemAddCliente;
	private Icon imagemCancelar;
	private JLabel lblSexo;
	private RecpositorioClienteDao repositorioCLiente = new RecpositorioClienteDao();

	public JanelaCadastroCliente() throws ParseException {

		setTitle("DrinksBar - Cadastro de Cliente");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(691, 424);
		setResizable(false);

		painelPrincipal = new JPanel();
		getContentPane().add(painelPrincipal, BorderLayout.CENTER);
		// configurando o painel principal do frame como absoluto.
		painelPrincipal.setLayout(null);

		painelCadastroCliente = new JPanel();
		// configurando a borda do painel cadastro de cliente
		painelCadastroCliente.setBorder(new TitledBorder(null,
				"Cadatro - Cliente", TitledBorder.LEADING, TitledBorder.TOP,
				null, Color.BLUE));
		painelCadastroCliente.setBounds(10, 11, 666, 376);
		painelPrincipal.add(painelCadastroCliente);
		// configurando o painel de cadastro de cliente como absoluto.
		painelCadastroCliente.setLayout(null);

		jlNomeCliente = new JLabel("Nome:");
		jlNomeCliente.setBounds(10, 30, 46, 14);
		painelCadastroCliente.add(jlNomeCliente);

		jtextNomeCliente = new JTextField();
		jtextNomeCliente.setBounds(10, 45, 463, 20);
		painelCadastroCliente.add(jtextNomeCliente);
		jtextNomeCliente.setColumns(10);

		jlEndereco = new JLabel("Endere\u00E7o:");
		jlEndereco.setBounds(10, 76, 78, 14);
		painelCadastroCliente.add(jlEndereco);

		jtextEnderecoCliente = new JTextField();
		jtextEnderecoCliente.setBounds(10, 92, 463, 20);
		painelCadastroCliente.add(jtextEnderecoCliente);
		jtextEnderecoCliente.setColumns(10);

		jlBairro = new JLabel("Bairro: ");
		jlBairro.setBounds(10, 123, 65, 14);
		painelCadastroCliente.add(jlBairro);

		jtextBairroCliente = new JTextField();
		jtextBairroCliente.setBounds(10, 139, 120, 20);
		painelCadastroCliente.add(jtextBairroCliente);
		jtextBairroCliente.setColumns(10);

		jlCidade = new JLabel("Cidade:");
		jlCidade.setToolTipText("Informe a cidade do cliente");
		jlCidade.setBounds(503, 76, 46, 14);
		painelCadastroCliente.add(jlCidade);

		textCidadeCliente = new JTextField();
		textCidadeCliente.setBounds(503, 92, 153, 20);
		painelCadastroCliente.add(textCidadeCliente);
		textCidadeCliente.setColumns(10);

		jlEstado = new JLabel("Estado: ");
		jlEstado.setBounds(503, 123, 65, 14);
		painelCadastroCliente.add(jlEstado);

		comboEstado = new JComboBox<String>();
		comboEstado.setModel(new DefaultComboBoxModel<String>(new String[] {
				"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA ",
				"MT", "MS ", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN",
				"RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		comboEstado.setBounds(503, 139, 46, 20);
		painelCadastroCliente.add(comboEstado);

		JLabel jlCep = new JLabel("Cep:");
		jlCep.setBounds(160, 123, 46, 14);
		painelCadastroCliente.add(jlCep);

		textCep = new JTextField();
		textCep.setBounds(158, 139, 120, 20);
		painelCadastroCliente.add(textCep);
		textCep.setColumns(10);

		JLabel lblNewLabel = new JLabel("Telefone:");
		lblNewLabel.setBounds(310, 123, 89, 14);
		painelCadastroCliente.add(lblNewLabel);

		textTelefoneCliente = new JTextField();
		// criando uma MASCARA para o campo onde sera informado o TELEFONE
		MaskFormatter mascaraTelefone = new MaskFormatter("(##)#### - ####");
		textTelefoneCliente = new JFormattedTextField(mascaraTelefone);
		textTelefoneCliente.setColumns(10);
		textTelefoneCliente.setBounds(310, 139, 120, 20);
		painelCadastroCliente.add(textTelefoneCliente);

		JLabel jlCpf = new JLabel("Cpf:");
		jlCpf.setBounds(503, 30, 46, 14);
		painelCadastroCliente.add(jlCpf);

		textCpfCliente = new JTextField();
		// criando uma MASCARA para o campo onde sera informado o CPF
		MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
		textCpfCliente = new JFormattedTextField(mascaraCpf);
		textCpfCliente.setBounds(503, 45, 153, 20);
		painelCadastroCliente.add(textCpfCliente);
		textCpfCliente.setColumns(10);

		comboSexoCliente = new JComboBox<String>();
		comboSexoCliente.setModel(new DefaultComboBoxModel<String>(
				new String[] { "M", "F" }));
		comboSexoCliente.setBounds(578, 139, 46, 20);
		painelCadastroCliente.add(comboSexoCliente);

		imagemAddCliente = new ImageIcon(getClass().getResource(
				"imagens/adicionar.png"));
		imagemCancelar = new ImageIcon(getClass().getResource(
				"imagens/cancelar.png"));

		painelOperacoes = new JPanel();
		painelOperacoes.setBorder(new TitledBorder(null, "Opera\u00E7\u00F5es",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		painelOperacoes.setBounds(10, 170, 646, 64);
		painelCadastroCliente.add(painelOperacoes);
		painelOperacoes.setLayout(null);
		jbntCadastrarCliente = new JButton("");
		jbntCadastrarCliente.setBounds(112, 12, 65, 41);
		painelOperacoes.add(jbntCadastrarCliente);
		jbntCadastrarCliente.setIcon(imagemAddCliente);
		jbntCadastrarCliente.addActionListener(new trataEventos());
		jbntCadastrarCliente.setToolTipText("Cadastrar cliente");

		jbntCancelarCliente = new JButton("");
		jbntCancelarCliente.setToolTipText("Cancelar cadastro");
		jbntCancelarCliente.setBounds(289, 12, 65, 41);

		painelOperacoes.add(jbntCancelarCliente);

		jbntCancelarCliente.setIcon(imagemCancelar);
		jbntSairCliente = new JButton("");
		jbntSairCliente.setIcon(new ImageIcon(JanelaCadastroCliente.class
				.getResource("/br/com/drinkbar/gui/imagens/sair.jpg")));
		jbntSairCliente.addActionListener(new trataEventos());
		jbntSairCliente.setBounds(466, 12, 65, 41);
		painelOperacoes.add(jbntSairCliente);

		painelTabelaCliente = new JPanel();
		painelTabelaCliente.setBorder(new TitledBorder(null,
				"Lista de Cliente", TitledBorder.LEADING, TitledBorder.TOP,
				null, Color.BLUE));
		painelTabelaCliente.setBounds(10, 245, 646, 124);
		painelCadastroCliente.add(painelTabelaCliente);
		painelTabelaCliente.setLayout(new BorderLayout(0, 0));

		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(578, 123, 65, 14);
		painelCadastroCliente.add(lblSexo);

	}// fim do método construtor

	// classe destinada a tratar os eventos soliciados pelos clientes
	private class trataEventos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evento) {

			// tratando o evento sair da tela de cadastro de cliente
			if (evento.getSource() == jbntSairCliente) {

				if (JOptionPane.showConfirmDialog(null, "Deseja Sair?",
						"ATENÇÂO", JOptionPane.YES_NO_OPTION) == 0) {
					dispose();
				}// fim da condição interna

			}// fim do condição externa para o evento SAIR

			if (evento.getSource() == jbntCadastrarCliente) {

				cliente cliente = new cliente();

				try {
					String sx = comboSexoCliente.getSelectedItem() + "";
					char sexo = sx.charAt(0);
					cliente.setNome(jtextNomeCliente.getText());
					cliente.setBairro(jtextBairroCliente.getText());
					cliente.setCep(textCep.getText());
					cliente.setCidade(textCidadeCliente.getText());
					cliente.setCpf(textCpfCliente.getText());
					cliente.setEndereco(jtextEnderecoCliente.getText());
					cliente.setTelefone(textTelefoneCliente.getText());
					cliente.setEstado(comboEstado.getSelectedItem() + " ");
					cliente.setSexo(sexo);
					repositorioCLiente.cadastrarCliente(cliente);
				} catch (Exception e) {

					JOptionPane.showMessageDialog(null, e.getMessage());
				}

			}// fim da estrutura de condcao if

		}// fim do método actionPerformed
	}// fim da classe trataEventos

}
