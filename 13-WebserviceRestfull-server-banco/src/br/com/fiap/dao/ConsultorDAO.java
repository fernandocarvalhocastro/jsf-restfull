package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Consultor;

public interface ConsultorDAO 
					extends GenericDAO<Consultor, Integer>{

	List<Consultor> listar();
	
}