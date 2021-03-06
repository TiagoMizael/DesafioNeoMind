package br.com.neomind.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.com.neomind.EntityManager.JpaEntityManager;
import br.com.neomind.model.ClienteModel;

@Path("cliente")
public class ClienteService {
private JpaEntityManager JPAEM = new JpaEntityManager();
private EntityManager objEM = JPAEM.getEntityManager();

@GET
@Path("listar")
@Produces("application/json")
public List<ClienteModel> listar(){

    try {
        String query = "select c from ClienteModel c";
        List<ClienteModel> clientes = objEM.createQuery(query, ClienteModel.class).getResultList();
        objEM.close();
    return clientes;
    } catch (Exception e) {
        throw new WebApplicationException(500);
        }
    }

@GET
@Path("buscar/{id}")
@Produces("application/json")
public ClienteModel buscar(@PathParam("id") int id){
 
	try {
		ClienteModel cliente = objEM.find(ClienteModel.class, id);
		objEM.close();
		return cliente;
	} catch (Exception e) {
		throw new WebApplicationException(500);
		}
	}

 @POST
 @Path("cadastrar")
 @Consumes("application/json")
 public Response cadastrar(ClienteModel objClinte){
	 try {
		 objEM.getTransaction().begin();
		 objEM.persist(objClinte);
		 objEM.getTransaction().commit();
		 objEM.close();
		 return Response.status(200).entity("cadastro realizado.").build();
	 } catch (Exception e) {
		 throw new WebApplicationException(500);
	 	}
     }

 @PUT
 @Path("alterar")
 @Consumes("application/json")
 public Response alterar(ClienteModel objClinte){
	 try {
		 objEM.getTransaction().begin();
		 objEM.merge(objClinte);
		 objEM.getTransaction().commit();
		 objEM.close();
		 return Response.status(200).entity("cadastro alterado.").build();
	 } catch (Exception e) {
		 throw new WebApplicationException(500);
	 	}
 	}
 
 @DELETE
 @Path("excluir/{id}")
 public Response excluir(@PathParam("id") int id){
	 try {
		 ClienteModel objClinte = objEM.find(ClienteModel.class, id);
		 objEM.getTransaction().begin();
		 objEM.remove(objClinte);
		 objEM.getTransaction().commit();
		 objEM.close();
		 return Response.status(200).entity("cadastro exclu�do.").build();
	 } catch (Exception e) {
		 throw new WebApplicationException(500);
	 	}
 	}
}
