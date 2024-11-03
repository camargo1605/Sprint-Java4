package br.com.fiap.resource;

import br.com.fiap.bo.OficinaBO;
import br.com.fiap.to.OficinaTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
@Path("/oficina")
public class OficinaResource {

    private OficinaBO oficinaBO = new OficinaBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<OficinaTO> resultado = oficinaBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
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
        OficinaTO resultado = oficinaBO.findByEmail(email);
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
    public Response save(@Valid OficinaTO oficina) {
        OficinaTO resultado = oficinaBO.save(oficina);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.status(204);
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
        if (oficinaBO.delete(email)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid OficinaTO oficina, @PathParam("email") String email) {
        oficina.setEmail(email);
        OficinaTO resultado = oficinaBO.update(oficina);
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
