package br.com.fiap.resource;

import br.com.fiap.bo.ClienteBO;
import br.com.fiap.to.ClienteTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/cliente")
public class ClienteResource {
    private ClienteBO clienteBO = new ClienteBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<ClienteTO> resultado = clienteBO.findAll();
        Response.ResponseBuilder response = null;
        if ( resultado != null ) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("email") String email) {
        ClienteTO resultado = clienteBO.findById(email);
        Response.ResponseBuilder response = null;
        if ( resultado != null ) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid ClienteTO cliente) {
        ClienteTO resultado = clienteBO.save(cliente);
        Response.ResponseBuilder response = null;
        if ( resultado != null ) {
            response = Response.created(null);
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{email}")
    public Response delete(@PathParam("email") String email) {
        Response.ResponseBuilder response = null;
        if (clienteBO.delete(email)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid ClienteTO cliente, @PathParam("email") String email) {
        cliente.setEmail(email);
        ClienteTO resultado = clienteBO.update(cliente);
        Response.ResponseBuilder response = null;
        if ( resultado != null ) {
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }
}
