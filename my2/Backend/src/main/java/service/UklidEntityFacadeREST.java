package service;

import dto.UklidDTO;
import entity.UklidEntity;
import entity.UklidKey;
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
import javax.ws.rs.core.PathSegment;

@Stateless
@Path("/uklid")
public class UklidEntityFacadeREST extends AbstractFacade<UklidEntity> {

	@PersistenceContext(unitName = "tjv_Backend_war_1.0-SNAPSHOTPU")
	private EntityManager em;

	private UklidKey getPrimaryKey(PathSegment pathSegment) {
		/*
		 * pathSemgent represents a URI path segment and any associated matrix parameters.
		 * URI path part is supposed to be in form of 'somePath;zam_id=zam_idValue;klec_id=klec_idValue'.
		 * Here 'somePath' is a result of getPath() method invocation and
		 * it is ignored in the following code.
		 * Matrix parameters are used as field names to build a primary key instance.
		 */
		entity.UklidKey key = new entity.UklidKey();
		javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
		java.util.List<String> zam_id = map.get("zam_id");
		if (zam_id != null && !zam_id.isEmpty()) {
			key.setZam_id(new java.lang.Integer(zam_id.get(0)));
		}
		java.util.List<String> klec_id = map.get("klec_id");
		if (klec_id != null && !klec_id.isEmpty()) {
			key.setKlec_id(new java.lang.Integer(klec_id.get(0)));
		}
		return key;
	}

	public UklidEntityFacadeREST() {
		super(UklidEntity.class);
	}

	@POST
	@Override
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void create(UklidEntity entity) {
		super.create(entity);
	}

	@PUT
	@Path("{id}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void edit(@PathParam("id") PathSegment id, UklidEntity entity) {
		super.edit(entity);
	}

	@DELETE
	@Path("{id_zam}-{id_klec}")
	public void remove(
		@PathParam("id_zam") Integer id_zam,
		@PathParam("id_klec") Integer id_klec) {
		UklidKey key = new UklidKey(id_zam, id_klec);
		super.remove(super.find(key));
	}

	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public UklidDTO findUklid(@PathParam("id") PathSegment id) {
		UklidDTO uklid = new UklidDTO();
		entity.UklidKey key = getPrimaryKey(id);
		ArrayList<UklidEntity> res = new ArrayList<>();
		res.add(super.find(key));
		uklid.setUklid(res);
		return uklid;
	}

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public UklidDTO findAllUklidy() {
		UklidDTO uklid = new UklidDTO();
		uklid.setUklid(super.findAll());
		return uklid;
	}

	@GET
	@Path("{from}/{to}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public UklidDTO findRangeUklidy(@PathParam("from") Integer from, @PathParam("to") Integer to) {
		UklidDTO uklid = new UklidDTO();
		uklid.setUklid(super.findRange(new int[]{from, to}));
		return uklid;
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
