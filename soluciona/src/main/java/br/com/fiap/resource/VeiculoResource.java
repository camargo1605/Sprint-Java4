package br.com.fiap.resource;

import br.com.fiap.bo.VeiculoBO;
import br.com.fiap.to.VeiculoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/veiculo")
public class VeiculoResource {

    private VeiculoBO veiculoBO = new VeiculoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<VeiculoTO> resultado = veiculoBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(resultado);
        } else {
            response = Response.status(Response.Status.NOT_FOUND);
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{placa}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByPlaca(@PathParam("placa") String placa) {
        VeiculoTO resultado = veiculoBO.findByPlaca(placa);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(resultado);
        } else {
            response = Response.status(Response.Status.NOT_FOUND);
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid VeiculoTO veiculo) {
        VeiculoTO resultado = veiculoBO.save(veiculo);
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
    @Path("/{placa}")
    public Response delete(@PathParam("placa") String placa) {
        boolean resultado = veiculoBO.delete(placa);
        Response.ResponseBuilder response = null;
        if (resultado) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{placa}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid VeiculoTO veiculo, @PathParam("placa") String placa) {
        veiculo.setPlaca(placa);
        VeiculoTO resultado = veiculoBO.update(veiculo);
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
