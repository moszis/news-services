package com.java.services.news_services.rest;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@PermitAll
@Path("/news")
public interface NewsService {

    @PermitAll
    @GET
    @Path("/")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response getAllNews();
    
    @PermitAll
    @GET
    @Path("/{limit}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response getAllNews(@PathParam("limit") int limit);


}

