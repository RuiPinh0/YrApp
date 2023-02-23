package no.promon.client;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/")
@RegisterRestClient
public interface YrClient {

    @GET
    @Path("/classic")
    @Consumes(MediaType.TEXT_PLAIN)
    String getForecast(@QueryParam("lat") Double lat, @QueryParam("lon") Double lon);

}
