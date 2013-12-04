package br.com.drinkbar.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import java.awt.Color;

import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class PainelCadastroCliente extends JPanel {
	private final JPanel panel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	
	public PainelCadastroCliente() {
		setLayout(new BorderLayout(0, 0));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 11, 685, 464);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null,
						"Cadatro - Cliente", TitledBorder.LEADING, TitledBorder.TOP,
						null, Color.BLUE));
		panel_2.setBounds(10, 11, 666, 442);
		panel_1.add(panel_2);
		
		JLabel label = new JLabel("Nome:");
		label.setBounds(10, 30, 46, 14);
		panel_2.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 45, 463, 20);
		panel_2.add(textField);
		
		JLabel label_1 = new JLabel("Endere\u00E7o:");
		label_1.setBounds(10, 76, 78, 14);
		panel_2.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 92, 463, 20);
		panel_2.add(textField_1);
		
		JLabel label_2 = new JLabel("Bairro: ");
		label_2.setBounds(10, 123, 65, 14);
		panel_2.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 139, 120, 20);
		panel_2.add(textField_2);
		
		JLabel label_3 = new JLabel("Cidade:");
		label_3.setToolTipText("Informe a cidade do cliente");
		label_3.setBounds(503, 76, 46, 14);
		panel_2.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(503, 92, 153, 20);
		panel_2.add(textField_3);
		
		JLabel label_4 = new JLabel("Estado: ");
		label_4.setBounds(503, 123, 65, 14);
		panel_2.add(label_4);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(503, 139, 46, 20);
		panel_2.add(comboBox);
		
		JLabel label_5 = new JLabel("Cep:");
		label_5.setBounds(160, 123, 46, 14);
		panel_2.add(label_5);
		
		JFormattedTextField formattedTextField = new JFormattedTextField((AbstractFormatter) null);
		formattedTextField.setColumns(10);
		formattedTextField.setBounds(158, 139, 120, 20);
		panel_2.add(formattedTextField);
		
		JLabel label_6 = new JLabel("Telefone:");
		label_6.setBounds(310, 123, 89, 14);
		panel_2.add(label_6);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField((AbstractFormatter) null);
		formattedTextField_1.setColumns(10);
		formattedTextField_1.setBounds(310, 139, 120, 20);
		panel_2.add(formattedTextField_1);
		
		JLabel label_7 = new JLabel("Cpf:");
		label_7.setBounds(503, 30, 46, 14);
		panel_2.add(label_7);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField((AbstractFormatter) null);
		formattedTextField_2.setColumns(10);
		formattedTextField_2.setBounds(503, 45, 153, 20);
		panel_2.add(formattedTextField_2);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(578, 139, 46, 20);
		panel_2.add(comboBox_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null, "Opera\u00E7\u00F5es",
						TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel_3.setBounds(10, 170, 646, 64);
		panel_2.add(panel_3);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(PainelCadastroCliente.class.getResource("/br/com/drinkbar/gui/imagens/adicionar.png")));
		button.setToolTipText("Cadastrar cliente");
		button.setBounds(112, 12, 65, 41);
		panel_3.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(PainelCadastroCliente.class.getResource("/br/com/drinkbar/gui/imagens/cancel.png")));
		button_1.setToolTipText("Cancelar cadastro");
		button_1.setBounds(289, 12, 65, 41);
		panel_3.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(PainelCadastroCliente.class.getResource("/br/com/drinkbar/gui/imagens/sair.jpg")));
		button_2.setBounds(466, 12, 65, 41);
		panel_3.add(button_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null,
						"Lista de Cliente", TitledBorder.LEADING, TitledBorder.TOP,
						null, Color.BLUE));
		panel_4.setBounds(10, 274, 646, 157);
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel label_8 = new JLabel("Sexo:");
		label_8.setBounds(578, 123, 65, 14);
		panel_2.add(label_8);
		
		JButton button_3 = new JButton("Listar Clientes");
		button_3.setBounds(10, 245, 120, 23);
		panel_2.add(button_3);

	}

}
