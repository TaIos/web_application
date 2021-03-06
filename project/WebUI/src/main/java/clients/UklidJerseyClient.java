/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:UklidEntityFacadeREST
 * [/uklid]<br>
 * USAGE:
 * <pre>
 * UklidJerseyClient client = new UklidJerseyClient();
 * Object response = client.XXX(...);
 * // do whatever with response
 * client.close();
 * </pre>
 *
 * @author slarty
 */
public class UklidJerseyClient {

	private WebTarget webTarget;
	private Client client;
	private static final String BASE_URI = "http://localhost:8080/Backend/rest";

	public UklidJerseyClient() {
		client = javax.ws.rs.client.ClientBuilder.newClient();
		webTarget = client.target(BASE_URI).path("uklid");
	}

	public String countREST() throws ClientErrorException {
		WebTarget resource = webTarget;
		resource = resource.path("count");
		return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
	}

	public void edit_XML(Object requestEntity, String id) throws ClientErrorException {
		webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
	}

	public void edit_JSON(Object requestEntity, String id) throws ClientErrorException {
		webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
	}

	public <T> T findAllUklidy_XML(Class<T> responseType) throws ClientErrorException {
		WebTarget resource = webTarget;
		return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
	}

	public <T> T findAllUklidy_JSON(Class<T> responseType) throws ClientErrorException {
		WebTarget resource = webTarget;
		return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
	}

	public void create_XML(Object requestEntity) throws ClientErrorException {
		webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
	}

	public void create_JSON(Object requestEntity) throws ClientErrorException {
		webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
	}

	public <T> T findUklid_XML(Class<T> responseType, String id) throws ClientErrorException {
		WebTarget resource = webTarget;
		resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
		return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
	}

	public <T> T findUklid_JSON(Class<T> responseType, String id) throws ClientErrorException {
		WebTarget resource = webTarget;
		resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
		return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
	}

	public void remove(String id) throws ClientErrorException {
		webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request().delete();
	}

	public <T> T findRangeUklidy_XML(Class<T> responseType, String from, String to) throws ClientErrorException {
		WebTarget resource = webTarget;
		resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{from, to}));
		return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
	}

	public <T> T findRangeUklidy_JSON(Class<T> responseType, String from, String to) throws ClientErrorException {
		WebTarget resource = webTarget;
		resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{from, to}));
		return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
	}

	public void close() {
		client.close();
	}

}
