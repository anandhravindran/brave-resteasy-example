package com.github.kristofa.brave.resteasyexample;

import java.io.IOException;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.apache.http.client.ClientProtocolException;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.springframework.stereotype.Repository;

/**
 * Example resource.
 * 
 * @author kristof
 */
@Repository
@Path("/order")
public class RestEasyExampleResourceImpl implements RestEasyExampleResource {

	/**
	 * A will call B.
	 * 
	 * @return
	 * @throws InterruptedException
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Path("/orderWorkflow")
	@GET
	public Response orderWorkflow() throws InterruptedException,
			ClientProtocolException, IOException {

		final Random random = new Random();
		Thread.sleep(random.nextInt(1000));

		final RestEasyExampleResource client = ProxyFactory.create(
				RestEasyExampleResource.class,
				"http://localhost:8080/");
		
		ClientResponse<Void> response = (ClientResponse<Void>) client.placeOrder();
		response.releaseConnection();

		response = (ClientResponse<Void>) client.oms();
		response.releaseConnection();
		
		response = (ClientResponse<Void>) client.dcOrDsv();
		response.releaseConnection();
		
		response = (ClientResponse<Void>) client.ship();
		response.releaseConnection();
		
		response = (ClientResponse<Void>) client.fedexOrWalmart();
		response.releaseConnection();
		
		/*response = (ClientResponse<Void>) client.g();
		response.releaseConnection();
		
		response = (ClientResponse<Void>) client.h();
		response.releaseConnection();

		response = (ClientResponse<Void>) client.i();
		response.releaseConnection();*/
		return Response.ok().build();
	}

	@Override
	@Path("/placeOrder")
	@GET
	public Response placeOrder() throws InterruptedException {

		final Random random = new Random();
		Thread.sleep(random.nextInt(1000));

		return Response.ok().build();
	}

	@Override
	@Path("/oms")
	@GET
	public Response oms() throws InterruptedException {
		final Random random = new Random();
		Thread.sleep(random.nextInt(1000));

		return Response.ok().build();
	}

	@Override
	@Path("/dcOrDsv")
	@GET
	public Response dcOrDsv() throws InterruptedException {
		final Random random = new Random();
		Thread.sleep(random.nextInt(1000));

		return Response.ok().build();
	}

	@Override
	@Path("/ship")
	@GET
	public Response ship() throws InterruptedException {
		final Random random = new Random();
		Thread.sleep(1000 + random.nextInt(1000));

		return Response.ok().build();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Path("/fedexOrWalmart")
	@GET
	public Response fedexOrWalmart() throws InterruptedException {
		final Random random = new Random();
		Thread.sleep(2000 + random.nextInt(1000));
		
		final RestEasyExampleResource client = ProxyFactory.create(
				RestEasyExampleResource.class,
				"http://localhost:8080/");
		
		ClientResponse<Void> response = (ClientResponse<Void>) client.g();
		response.releaseConnection();
		
		response = (ClientResponse<Void>) client.h();
		response.releaseConnection();

		return Response.ok().build();
	}

	@Override
	@Path("/g")
	@GET
	public Response g() throws InterruptedException {
		final Random random = new Random();
		Thread.sleep(3000 + random.nextInt(1000));

		return Response.ok().build();
	}

	@Override
	@Path("/h")
	@GET
	public Response h() throws InterruptedException {
		final Random random = new Random();
		Thread.sleep(random.nextInt(1000));

		return Response.ok().build();
	}

	@Override
	@Path("/i")
	@GET
	public Response i() throws InterruptedException {
		final Random random = new Random();
		Thread.sleep(5000 + random.nextInt(1000));

		return Response.ok().build();
	}

}
