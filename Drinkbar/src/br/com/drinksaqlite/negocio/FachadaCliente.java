package br.com.drinksaqlite.negocio;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.drinkbar.dados.RecpositorioClienteDao;

public class FachadaCliente {

	private static Logger LOG = Logger.getLogger(FachadaCliente.class);
	private RecpositorioClienteDao reporCliente;

	public FachadaCliente() {

		this.reporCliente = new RecpositorioClienteDao();

	}

	public void cadastraCliente(Cliente novoCliente) {

		LOG.debug("Cadastrando Cliente:\n" + novoCliente);
		try {
			this.reporCliente.cadastrarCliente(novoCliente);
		} catch (Exception e) {
			LOG.error("Erro ao cadastrar cliente: " + e.getMessage());
		}
	}

	public List<Cliente> pesquisarCliente(String text) throws Exception {

		return this.reporCliente.pesquisarCliente(text);

	}

}
