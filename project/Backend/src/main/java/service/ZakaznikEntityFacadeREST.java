package service;

import dto.ZakaznikDTO;
import entity.ZakaznikEntity;
import java.util.ArrayList;
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
@Path("/zakaznik")
public class ZakaznikEntityFacadeREST extends AbstractFacade<ZakaznikEntity> {

	@PersistenceContext(unitName = "tjv_Backend_war_1.0-SNAPSHOTPU")
	private EntityManager em;

	public ZakaznikEntityFacadeREST() {
		super(ZakaznikEntity.class);
	}

	@POST
	@Override
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void create(ZakaznikEntity entity) {
		super.create(entity);
	}

	@PUT
	@Path("{id}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void edit(@PathParam("id") Integer id, ZakaznikEntity entity) {
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
	public ZakaznikDTO findZakaznik(@PathParam("id") Integer id) {
		ZakaznikDTO zakaznik = new ZakaznikDTO();
		ArrayList<ZakaznikEntity> res = new ArrayList<>();
		res.add(super.find(id));
		zakaznik.setZakaznici(res);
		return zakaznik;
	}

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ZakaznikDTO findAllZakazniky() {
		ZakaznikDTO zakaznici = new ZakaznikDTO();
		zakaznici.setZakaznici(super.findAll());
		return zakaznici;
	}

	@GET
	@Path("{from}/{to}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ZakaznikDTO findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
		ZakaznikDTO zakaznici = new ZakaznikDTO();
		zakaznici.setZakaznici(super.findRange(new int[]{from, to}));
		return zakaznici;
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
