package service;

import dto.KlecDTO;
import entity.KlecEntity;
import java.util.ArrayList;
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

@Stateless
@Path("/klec")
public class KlecEntityFacadeREST extends AbstractFacade<KlecEntity> {

	@PersistenceContext(unitName = "tjv_Backend_war_1.0-SNAPSHOTPU")
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
	public KlecDTO findKlec(@PathParam("id") Long id) {
		KlecDTO klec = new KlecDTO();
		ArrayList<KlecEntity> res = new ArrayList<>();
		res.add(super.find(id));
		klec.setKlece(res);
		return klec;
	}

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public KlecDTO findAllKlece() {
		KlecDTO klece = new KlecDTO();
		klece.setKlece(super.findAll());
		return klece;
	}

	@GET
	@Path("{from}/{to}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public KlecDTO findRangeKlece(@PathParam("from") Integer from, @PathParam("to") Integer to) {
		KlecDTO klece = new KlecDTO();
		klece.setKlece(super.findRange(new int[]{from, to}));
		return klece;
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
