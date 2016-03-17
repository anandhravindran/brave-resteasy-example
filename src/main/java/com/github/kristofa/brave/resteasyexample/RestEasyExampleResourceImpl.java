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
	@Path("/placeorder")
	@GET
	public Response placeorder() throws InterruptedException,
			ClientProtocolException, IOException {

		final Random random = new Random();
		Thread.sleep(random.nextInt(1000));

		final RestEasyExampleResource client = ProxyFactory.create(
				RestEasyExampleResource.class,
				"http://localhost:8080/OrderFlowMock");
		
		ClientResponse<Void> response = (ClientResponse<Void>) client.b();
		response.releaseConnection();

		response = (ClientResponse<Void>) client.c();
		response.releaseConnection();
		
		response = (ClientResponse<Void>) client.d();
		response.releaseConnection();
		
		response = (ClientResponse<Void>) client.e();
		response.releaseConnection();
		
		response = (ClientResponse<Void>) client.f();
		response.releaseConnection();
		
		response = (ClientResponse<Void>) client.g();
		response.releaseConnection();
		
		response = (ClientResponse<Void>) client.h();
		response.releaseConnection();

		response = (ClientResponse<Void>) client.i();
		response.releaseConnection();
		return Response.ok().build();
	}

	@Override
	@Path("/b")
	@GET
	public Response b() throws InterruptedException {

		final Random random = new Random();
		Thread.sleep(random.nextInt(1000));

		return Response.ok().build();
	}

	@Override
	@Path("/c")
	@GET
	public Response c() throws InterruptedException {
		final Random random = new Random();
		Thread.sleep(random.nextInt(1000));

		return Response.ok().build();
	}

	@Override
	@Path("/d")
	@GET
	public Response d() throws InterruptedException {
		final Random random = new Random();
		Thread.sleep(random.nextInt(1000));

		return Response.ok().build();
	}

	@Override
	@Path("/e")
	@GET
	public Response e() throws InterruptedException {
		final Random random = new Random();
		Thread.sleep(1000 + random.nextInt(1000));

		return Response.ok().build();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Path("/f")
	@GET
	public Response f() throws InterruptedException {
		final Random random = new Random();
		Thread.sleep(2000 + random.nextInt(1000));
		
		final RestEasyExampleResource client = ProxyFactory.create(
				RestEasyExampleResource.class,
				"http://localhost:8080/OrderFlowMock");
		
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
