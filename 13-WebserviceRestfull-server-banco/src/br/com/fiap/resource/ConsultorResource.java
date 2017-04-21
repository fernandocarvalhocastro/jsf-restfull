package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.ConsultorBO;
import br.com.fiap.entity.Consultor;

@Path("/consultor")
public class ConsultorResource {

	//GET POST PUT DELETE
	private ConsultorBO bo = new ConsultorBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Consultor> listar(){
		return bo.listar();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Consultor buscar(@PathParam("id") int codigo){
		return bo.buscar(codigo);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Consultor consultor, 
			@Context UriInfo uriInfo){
		bo.cadastrar(consultor);
		UriBuilder url = UriBuilder.fromPath(uriInfo.getPath());
		url.path(String.valueOf(consultor.getCodigo()));
		return Response.created(url.build()).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Consultor consultor,
			@PathParam("id") int codigo){
		consultor.setCodigo(codigo);
		bo.atualizar(consultor);
		return Response.ok().build(); //200 OK
	}
	
	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") int codigo){
		bo.remover(codigo);
	}
	
}




