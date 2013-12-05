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
	public Connection conexao;
	public PreparedStatement comandoQuery = null;
	public ResultSet resultSet;// fornece o resultado na consulta ao DB.

	public ConectaSqlite() {

		driverDeConexao = "org.sqlite.JDBC";
		url = "jdbc:sqlite:drinksbar.sqlite";
	}

	public void abrirConexao() {

		try {
			Class.forName(driverDeConexao);
			conexao = DriverManager.getConnection(url);
		}// fim do try
		catch (ClassNotFoundException e) {
			System.err.println("driver erro " + e.getMessage());
		} catch (SQLException e) {

			System.out.println("erro de url " + e.getMessage());

		}

	}// fim do metodo abrir conexao

	public void fecharConexaoBancoDados() {

		try {

			if (conexao != null) {
				conexao.close();
			}
			if (comandoQuery != null) {
				comandoQuery.close();
			}
			if (resultSet != null) {

				resultSet.close();
			}
		} catch (SQLException e) {

			System.err.println(e.getClass().getName() + ": " + e.getMessage());

		}

	}// fim do metodo fecharBD

}
