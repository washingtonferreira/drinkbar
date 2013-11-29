package br.com.drinksaqlite.negocio;

import java.util.List;

public interface IRepositorioBebida {

	public List<Bebida> pesquisarBebida(String text) throws Exception;

	public void cadastrarBebida(Bebida novoBebida) throws Exception;

	public void atualizarBebidae(Bebida bebida) throws Exception;

	public void excluirBebida(String nome) throws Exception;

}
