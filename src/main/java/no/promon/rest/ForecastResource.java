package no.promon.rest;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import no.promon.CommandHandler;

import javax.inject.Inject;

@Path("/forecast")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class ForecastResource {

    @GET
    @Path("/{days}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getForecast(@PathParam("days") Integer days) {

        CommandHandler commandHandler = new CommandHandler();
        return Response.ok( commandHandler.printForecast(days)).build();
    }
}
