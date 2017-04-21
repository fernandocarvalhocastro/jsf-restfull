package br.com.fiap.repository;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.entity.Consultor;
import br.com.fiap.exception.WebServiceException;

public class ConsultorRepository {

	private static final String URL = "http://localhost:8080/13-WebserviceRestfull-server-banco/rest/consultor/";
	
	private Client client = Client.create();
	
	public List<Consultor> listar() throws WebServiceException{
		WebResource resource = client.resource(URL);
		
		//Chama o webservice
		ClientResponse response = resource.accept(
			MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		
		//Valida se deu certo a busca 
		if (response.getStatus() != 200){
			throw new WebServiceException("Http Status: " + 
					response.getStatus());
		}

		//Recupera a resposta do servidor
		Consultor[] array = 
				response.getEntity(Consultor[].class);
		return Arrays.asList(array);
	}
	
	public Consultor buscar(int codigo) throws WebServiceException{
		WebResource resource = client.resource(URL + codigo);
		
		ClientResponse response = resource
				.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		
		if (response.getStatus() != 200){
			throw new WebServiceException("Http Status: " +
					response.getStatus());
		}
		return response.getEntity(Consultor.class);
	}
	
	public void cadastrar(Consultor consultor) throws WebServiceException{
		WebResource resource = client.resource(URL);
		
		ClientResponse response = resource
				.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class,consultor);
		
		if (response.getStatus() != 201){
			throw new WebServiceException("Http Status: " +
					response.getStatus());
		}
	}
	
	public void atualizar(Consultor consultor) throws WebServiceException{
		WebResource resource = client.resource(URL + consultor.getCodigo());
		
		ClientResponse response = resource
				.type(MediaType.APPLICATION_JSON)
				.put(ClientResponse.class,consultor);
		
		if (response.getStatus() != 200){
			throw new WebServiceException("HTTP Status: " +
					response.getStatus());
		}
	}
	
	public void remover(int codigo) throws WebServiceException{
		WebResource resource = client.resource(URL + codigo);
		
		ClientResponse response = 
				resource.delete(ClientResponse.class);
		
		if (response.getStatus() != 204){
			throw new WebServiceException("HTTP Status: " +
					response.getStatus());
		}
	}
	
}









