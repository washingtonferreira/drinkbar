package br.com.drinksaqlite.negocio;

import br.com.drinkbar.dados.RepositorioBabidaDao;

public class FachadaBebida {

	private RepositorioBabidaDao repBebida;

	public FachadaBebida() {

		this.repBebida = new RepositorioBabidaDao();

	}

	public void cadastrarBebida(Bebida novoBebida) throws Exception {

		this.repBebida.cadastrarBebida(novoBebida);
	}

}
