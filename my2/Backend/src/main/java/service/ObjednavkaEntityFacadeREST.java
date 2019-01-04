package service;

import dto.ObjednavkaDTO;
import entity.ObjednavkaEntity;
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
@Path("/objednavka")
public class ObjednavkaEntityFacadeREST extends AbstractFacade<ObjednavkaEntity> {

	@PersistenceContext(unitName = "tjv_Backend_war_1.0-SNAPSHOTPU")
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
	public void edit(@PathParam("id") Integer id, ObjednavkaEntity entity) {
		super.edit(entity);
	}

	@DELETE
	@Path("{id}")
	public void remove(@PathParam("id") Integer id) {
		super.remove(super.find(id));
	}

	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ObjednavkaDTO findObjednavku(@PathParam("id") Integer id) {
		ObjednavkaDTO objednavka = new ObjednavkaDTO();
		ArrayList<ObjednavkaEntity> res = new ArrayList<>();
		res.add(super.find(id));
		objednavka.setObjednavky(res);
		return objednavka;
	}

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ObjednavkaDTO findAllObjednavky() {
		ObjednavkaDTO objednavky = new ObjednavkaDTO();
		objednavky.setObjednavky(super.findAll());
		return objednavky;
	}

	@GET
	@Path("{from}/{to}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ObjednavkaDTO findRangeObjednavky(@PathParam("from") Integer from, @PathParam("to") Integer to) {
		ObjednavkaDTO objednavky = new ObjednavkaDTO();
		objednavky.setObjednavky(super.findRange(new int[]{from, to}));
		return objednavky;
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
