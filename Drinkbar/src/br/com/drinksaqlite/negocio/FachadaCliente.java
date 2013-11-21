package br.com.drinksaqlite.negocio;

import br.com.drinkbar.dados.RecpositorioClienteDao;

public class FachadaCliente {

	private RecpositorioClienteDao reporCliente;

	public FachadaCliente() {

		this.reporCliente = new RecpositorioClienteDao();

	}

	public void cadastraCliente(Cliente novoCliente) throws Exception {

		this.reporCliente.cadastrarCliente(novoCliente);
	}

}
