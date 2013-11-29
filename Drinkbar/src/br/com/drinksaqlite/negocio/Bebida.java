package br.com.drinksaqlite.negocio;

public class Bebida {

	private String nome;
	private String fabricante;
	private String tipo;
	private String dataFabricacao;
	private double preco;

	public Bebida() {

	}

	public String getNome() {
		return nome;
	}

	public Bebida(String nome, String fabricante, String tipo,
			String dataFabricacao, double preco) {

		this.nome = nome;
		this.fabricante = fabricante;
		this.tipo = tipo;
		this.dataFabricacao = dataFabricacao;
		this.preco = preco;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(String dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
