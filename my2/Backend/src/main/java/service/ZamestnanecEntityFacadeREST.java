package service;

import dto.ZamestnanecDTO;
import entity.ZamestnanecEntity;
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
@Path("/zamestnanec")
public class ZamestnanecEntityFacadeREST extends AbstractFacade<ZamestnanecEntity> {

	@PersistenceContext(unitName = "tjv_Backend_war_1.0-SNAPSHOTPU")
	private EntityManager em;

	public ZamestnanecEntityFacadeREST() {
		super(ZamestnanecEntity.class);
	}

	@POST
	@Override
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void create(ZamestnanecEntity entity) {
		super.create(entity);
	}

	@PUT
	@Path("{id}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void edit(@PathParam("id") Long id, ZamestnanecEntity entity) {
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
	public ZamestnanecDTO findZamestnanec(@PathParam("id") Long id) {
		ZamestnanecDTO zamestnanec = new ZamestnanecDTO();
		ArrayList<ZamestnanecEntity> res = new ArrayList<>();
		res.add(super.find(id));
		zamestnanec.setZamestnanci(res);
		return zamestnanec;
	}

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ZamestnanecDTO findAllZamestnance() {
		ZamestnanecDTO zamestnanci = new ZamestnanecDTO();
		zamestnanci.setZamestnanci(super.findAll());
		return zamestnanci;
	}

	@GET
	@Path("{from}/{to}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ZamestnanecDTO findRangeZamestnance(@PathParam("from") Integer from, @PathParam("to") Integer to) {
		ZamestnanecDTO zamestnanci = new ZamestnanecDTO();
		zamestnanci.setZamestnanci(super.findRange(new int[]{from, to}));
		return zamestnanci;
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
