package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import br.com.fiap.entity.Consultor;
import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.ConsultorRepository;

@ManagedBean
public class ListaConsultorBean {

	private List<Consultor> lista;
	
	private ConsultorRepository rep;
	
	@PostConstruct
	private void init(){
		rep = new ConsultorRepository();
		try {
			lista = rep.listar();
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}

	public List<Consultor> getLista() {
		return lista;
	}

	public void setLista(List<Consultor> lista) {
		this.lista = lista;
	}
	
}
