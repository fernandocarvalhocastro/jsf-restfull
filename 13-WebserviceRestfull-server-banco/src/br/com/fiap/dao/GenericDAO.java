package br.com.fiap.dao;

import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;

public interface GenericDAO<T,K> {

	void cadastrar(T entity);
	void alterar(T entity);
	void remover(K codigo) throws IdNotFoundException;
	T pesquisar(K codigo);
	void salvar() throws DBException;
	
}
