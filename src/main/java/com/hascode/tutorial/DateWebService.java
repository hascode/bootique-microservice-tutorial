package com.hascode.tutorial;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.inject.Inject;

@Path("/")
public class DateWebService {
    @Inject
    private DateService dateService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getCurrentDate() {
        return Response.ok(dateService.getDate()).build();
    }
}