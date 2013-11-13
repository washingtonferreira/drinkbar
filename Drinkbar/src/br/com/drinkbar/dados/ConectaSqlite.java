package br.com.drinkbar.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Diego Santos
 * classe Responsavel por se conectar com o banco de dados.
 * */
import javax.swing.JOptionPane;

public class ConectaSqlite {

	private String driverDeConexao = "";
	private String url = "";
	Connection con;
	PreparedStatement comandoQuery;
	ResultSet resultSet;// fornece o resultado na consulta ao DB.

	public ConectaSqlite() {

		driverDeConexao = "org.sqlite.JDBC";
		url = "jdbc:sqlite:drinksbar.slqite";
	}

	public void abrirConexao() {

		try {
			Class.forName(driverDeConexao);
			con = DriverManager.getConnection(url);

			if (con != null) {

				JOptionPane.showMessageDialog(null, "Conexão bem sucedida",
						"Caonexao ao Banco de Dados",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}// fim do try
		catch (ClassNotFoundException e) {
			System.err.println("driver erro " + e.getMessage());
		} catch (SQLException e) {

			System.out.println("erro de url " + e.getMessage());

		}

	}// fim do metodo abrir conexao

	public void fecharConexaoBancoDados() {

		if (con != null) {
			try {
				con.close();

				if (comandoQuery != null) {

					comandoQuery.close();

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
