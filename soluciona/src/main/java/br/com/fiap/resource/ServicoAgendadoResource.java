package br.com.fiap.resource;

import br.com.fiap.bo.ServicoAgendadoBO;
import br.com.fiap.to.ServicoAgendadoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/servicoAgendado")
public class ServicoAgendadoResource {
    private ServicoAgendadoBO servicoAgendadoBO = new ServicoAgendadoBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        ArrayList<ServicoAgendadoTO> resultado = servicoAgendadoBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(resultado);
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id){
        ServicoAgendadoTO resultado = servicoAgendadoBO.findById(id);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid ServicoAgendadoTO servicoAgendado) {
        ServicoAgendadoTO resultado = servicoAgendadoBO.save(servicoAgendado);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Response.ResponseBuilder response = null;
        if (servicoAgendadoBO.delete(id)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid ServicoAgendadoTO servicoAgendado, @PathParam("id") Long id) {
        servicoAgendado.setIdServicoAgendado(id);
        ServicoAgendadoTO resultado = servicoAgendadoBO.update(servicoAgendado);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }
}
