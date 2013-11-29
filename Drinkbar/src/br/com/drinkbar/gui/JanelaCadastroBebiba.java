package br.com.drinkbar.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.ImageIcon;

import br.com.drinksaqlite.negocio.Bebida;
import br.com.drinksaqlite.negocio.FachadaBebida;

public class JanelaCadastroBebiba extends JFrame {
	private JTextField textNomeBebida;
	private JTextField textFabricante;
	private JTextField textTipoBebida;
	private JTextField textDataFabricacaoBebida;
	private JTextField textPrecoBebida;
	private JPanel painelPrincipal;
	private JPanel painelCadastro;
	private JLabel jlNome;
	private JLabel jlFabricante;
	private JLabel jlTipo;
	private JLabel lblDataDeFabricao = new JLabel(
			"Data de Fabrica\u00E7\u00E3o:");
	private JLabel lblPreo;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private JButton btnSair;
	private FachadaBebida fachada;

	public JanelaCadastroBebiba() throws ParseException {
		setTitle("DrinksBar - Cadastro de Bebidas");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(496, 271);
		setLocationRelativeTo(null);
		setResizable(false);

		fachada = new FachadaBebida();

		painelPrincipal = new JPanel();
		getContentPane().add(painelPrincipal, BorderLayout.CENTER);
		painelPrincipal.setLayout(null);

		painelCadastro = new JPanel();
		painelCadastro.setBorder(new TitledBorder(null, "Cadastro - Bebida",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		painelCadastro.setBounds(10, 11, 470, 221);
		painelPrincipal.add(painelCadastro);
		painelCadastro.setLayout(null);

		jlNome = new JLabel("Nome:");
		jlNome.setBounds(10, 27, 46, 14);
		painelCadastro.add(jlNome);

		textNomeBebida = new JTextField();
		textNomeBebida.setColumns(10);
		textNomeBebida.setBounds(10, 42, 268, 20);
		painelCadastro.add(textNomeBebida);

		jlFabricante = new JLabel("Fabricante:");
		jlFabricante.setBounds(301, 27, 80, 14);
		painelCadastro.add(jlFabricante);

		textFabricante = new JTextField();
		textFabricante.setColumns(10);
		textFabricante.setBounds(301, 42, 153, 20);
		painelCadastro.add(textFabricante);

		jlTipo = new JLabel("Tipo:");
		jlTipo.setBounds(10, 73, 46, 14);
		painelCadastro.add(jlTipo);

		textTipoBebida = new JTextField();
		textTipoBebida.setColumns(10);
		textTipoBebida.setBounds(10, 88, 153, 20);
		painelCadastro.add(textTipoBebida);

		lblDataDeFabricao.setBounds(184, 73, 164, 14);
		painelCadastro.add(lblDataDeFabricao);

		textDataFabricacaoBebida = new JTextField();
		// criando a mascara para o campo onde sera informado a DATA
		MaskFormatter mascaraCelular = new MaskFormatter("##/##/####");
		textDataFabricacaoBebida = new JFormattedTextField(mascaraCelular);
		textDataFabricacaoBebida.setColumns(10);
		textDataFabricacaoBebida.setBounds(181, 88, 153, 20);
		painelCadastro.add(textDataFabricacaoBebida);

		textPrecoBebida = new JTextField();
		textPrecoBebida.setBounds(354, 88, 100, 20);
		painelCadastro.add(textPrecoBebida);
		textPrecoBebida.setColumns(10);

		lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setBounds(354, 73, 46, 14);
		painelCadastro.add(lblPreo);

		btnCadastrar = new JButton("");
		btnCadastrar.setIcon(new ImageIcon(JanelaCadastroBebiba.class
				.getResource("/br/com/drinkbar/gui/imagens/Add-icon.png")));
		btnCadastrar.setToolTipText("Cadastrar bebida");
		btnCadastrar.addActionListener(new TrataEvento());
		btnCadastrar.setBounds(67, 135, 65, 41);
		painelCadastro.add(btnCadastrar);

		btnCancelar = new JButton("");
		btnCancelar.setIcon(new ImageIcon(JanelaCadastroBebiba.class
				.getResource("/br/com/drinkbar/gui/imagens/cancel.png")));
		btnCancelar.setToolTipText("Cancelar cadastro");
		btnCancelar.setBounds(199, 135, 65, 41);
		painelCadastro.add(btnCancelar);

		btnSair = new JButton("");
		btnSair.setToolTipText("Sair");
		btnSair.addActionListener(new TrataEvento());
		btnSair.setIcon(new ImageIcon(JanelaCadastroBebiba.class
				.getResource("/br/com/drinkbar/gui/imagens/sair.jpg")));
		btnSair.setBounds(331, 135, 65, 41);
		painelCadastro.add(btnSair);
	}// fim do metodo costrutor construtor

	private class TrataEvento implements ActionListener {

		private Bebida bebida;

		@Override
		public void actionPerformed(ActionEvent evento) {

			if (evento.getSource() == btnSair) {

				if (JOptionPane.showConfirmDialog(null, "Deseja Sair?",
						"ATENÇÂO!", JOptionPane.YES_NO_OPTION) == 0) {

					dispose();

				}// fim do if menor

			}// fim do if maior
			else if (evento.getSource() == btnCadastrar) {

				bebida = new Bebida();

				try {

					double preco = Double
							.parseDouble(textPrecoBebida.getText());

					bebida.setDataFabricacao(textDataFabricacaoBebida.getText());
					bebida.setFabricante(textFabricante.getText());
					bebida.setNome(textNomeBebida.getText());
					bebida.setPreco(preco);
					bebida.setTipo(textTipoBebida.getText());

					fachada.cadastrarBebida(bebida);

				} catch (Exception e) {

					JOptionPane.showMessageDialog(null, e.getMessage());
				}

			}

		}// fim dp metoso actionPerformed
	}// fim da classe TrataEvento

}
