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

    @Path("/orderWorkflow")
    @GET
    public Response orderWorkflow() throws InterruptedException, ClientProtocolException, IOException;

    @Path("/placeOrder")
    @GET
    public Response placeOrder() throws InterruptedException;

    @Path("/oms")
    @GET
    public Response oms() throws InterruptedException;
    
    @Path("/dcOrDsv")
    @GET
    public Response dcOrDsv() throws InterruptedException;
    
    @Path("/ship")
    @GET
    public Response ship() throws InterruptedException;
    
    @Path("/fedexOrWalmart")
    @GET
    public Response fedexOrWalmart() throws InterruptedException;
    
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
