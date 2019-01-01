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
import persistence.ObjednavkaEntity;

@Stateless
@Path("/objednavka")
public class ObjednavkaEntityFacadeREST extends AbstractFacade<ObjednavkaEntity> {

	@PersistenceContext(unitName = "cz.cvut.fit.tjv_Backend_war_1.0-SNAPSHOTPU")
	private EntityManager em;

	public ObjednavkaEntityFacadeREST() {
		super(ObjednavkaEntity.class);
	}

	@POST
        @Override
        @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void create(ObjednavkaEntity entity) {
		super.create(entity);
	}

	@PUT
        @Path("{id}")
        @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void edit(@PathParam("id") Long id, ObjednavkaEntity entity) {
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
	public ObjednavkaEntity find(@PathParam("id") Long id) {
		return super.find(id);
	}

	@GET
        @Override
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<ObjednavkaEntity> findAll() {
		return super.findAll();
	}

	@GET
        @Path("{from}/{to}")
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<ObjednavkaEntity> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
