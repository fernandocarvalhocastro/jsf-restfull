package br.com.fiap.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.entity.Consultor;
import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.ConsultorRepository;

@ManagedBean
public class ConsultorBean {

	private Consultor consultor;
	
	private ConsultorRepository rep;
	
	//Método de inicialização do Bean
	@PostConstruct
	private void init(){
		consultor = new Consultor();
		rep = new ConsultorRepository();
	}
	
	//Método para o clique do botão
	public void cadastrar(){
		FacesMessage msg;
		try {
			rep.cadastrar(consultor);
			msg = new FacesMessage("Cadastro realizado!");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
		} catch (WebServiceException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
			msg.setSeverity(FacesMessage.SEVERITY_FATAL);
		}
		//Adiciona a mensagem para a tela
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Consultor getConsultor() {
		return consultor;
	}

	public void setConsultor(Consultor consultor) {
		this.consultor = consultor;
	}
	
}
