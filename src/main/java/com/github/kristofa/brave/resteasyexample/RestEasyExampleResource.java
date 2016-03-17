package com.github.kristofa.brave.resteasyexample;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.apache.http.client.ClientProtocolException;

/**
 * Our resource interface. Shared between client and server.
 * 
 * @author kristof
 */
@Path("/order")
public interface RestEasyExampleResource {

    @Path("/placeorder")
    @GET
    public Response placeorder() throws InterruptedException, ClientProtocolException, IOException;

    @Path("/b")
    @GET
    public Response b() throws InterruptedException;

    @Path("/c")
    @GET
    public Response c() throws InterruptedException;
    
    @Path("/d")
    @GET
    public Response d() throws InterruptedException;
    
    @Path("/e")
    @GET
    public Response e() throws InterruptedException;
    
    @Path("/f")
    @GET
    public Response f() throws InterruptedException;
    
    @Path("/g")
    @GET
    public Response g() throws InterruptedException;
    
    @Path("/h")
    @GET
    public Response h() throws InterruptedException;
    
    @Path("/i")
    @GET
    public Response i() throws InterruptedException;
}
