package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ConsultorDAO;
import br.com.fiap.entity.Consultor;

public class ConsultorDAOImpl 
			extends GenericDAOImpl<Consultor,Integer>
									implements ConsultorDAO{

	public ConsultorDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Consultor> listar() {
		return em.createQuery("from Consultor",
						Consultor.class).getResultList();
	}

}





