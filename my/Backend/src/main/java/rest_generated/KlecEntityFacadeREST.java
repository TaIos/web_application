/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest_generated;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import persistence.KlecEntity;

/**
 *
 * @author slarty
 */
@Stateless
@Path("/klec")
public class KlecEntityFacadeREST extends AbstractFacade<KlecEntity> {

	@PersistenceContext(unitName = "cz.cvut.fit.tjv_Backend_war_1.0-SNAPSHOTPU")
	private EntityManager em;

	public KlecEntityFacadeREST() {
		super(KlecEntity.class);
	}

	@POST
        @Override
        @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void create(KlecEntity entity) {
		super.create(entity);
	}

	@PUT
        @Path("{id}")
        @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void edit(@PathParam("id") Long id, KlecEntity entity) {
		super.edit(entity);
	}

	@DELETE
        @Path("{id}")
	public void remove(@PathParam("id") Long id) {
		super.remove(super.find(id));
	}

	@GET
        @Path("{id}")
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public KlecEntity find(@PathParam("id") Long id) {
		return super.find(id);
	}

	@GET
        @Override
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<KlecEntity> findAll() {
		return super.findAll();
	}

	@GET
        @Path("{from}/{to}")
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<KlecEntity> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
		return super.findRange(new int[]{from, to});
	}

	@GET
        @Path("count")
        @Produces(MediaType.TEXT_PLAIN)
	public String countREST() {
		return String.valueOf(super.count());
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
}
