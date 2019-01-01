package rest;

import cz.cvut.fit.tjv.clientviewdto.KlecDTO;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import persistence.AbstractCRUDController;
import persistence.KlecController;
import persistence.KlecEntity;

//@Path("/klec")
public class KlecResource {

	/*
	static final Function<KlecDTO, KlecEntity> DTO_TO_ENTITY_CONVERTER
		= d -> new KlecEntity(d.getId(),
			d.getPocetTukanu(),
			d.getVelikostKleceM3(),
			d.getVybaveni(),
			d.getProhlidkaId(),
			d.getJeUklizena());
	;

	static final Function<KlecEntity, KlecDTO> ENTITY_TO_DTO_CONVERTER
		= e -> e == null ? null : new KlecDTO(
				e.getId(),
				e.getPocetTukanu(),
				e.getVelikostKleceM3(),
				e.getVybaveni(),
				e.getProhlidkaId(),
				e.getJeUklizena().stream().map(DTO_TO_ENTITY_CONVERTER)
					.collect(Collectors.toList()));
	@EJB
	private KlecController controller;

	public KlecResource(Function dtoToEntityConverter, Function entityToDtoConverter) {
		super(dtoToEntityConverter, entityToDtoConverter);
	}

	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response retrieveById(@PathParam("id") Integer id) {
		return super.retrieveById(id);
	}

	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response deleteById(@PathParam("id") Integer id) {
		return super.deleteById(id);
	}

	@POST
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response addOrRemoveKlec(KlecDTO s, @PathParam("id") int id, @QueryParam("remove") boolean remove) {
		try {
			if (remove) {
				return Response
					.ok(entityToDtoConverter.apply(controller.removeFavourite(id, KlecResource.DTO_TO_ENTITY_CONVERTER.apply(s)))) .build();
			} else {
				return Response
					.ok(entityToDtoConverter.apply(controller.addFavourite(id, SerieResource.DTO_TO_ENTITY_CONVERTER.apply(s))))
					.build();
			}
		} catch (EJBException exception) {
			return Response.status(Response.Status.CONFLICT).build();
		}
	}

	@Override
	protected AbstractCRUDController getController() {
		return controller;
	}

	@Override
	protected boolean containsEntityId(KlecDTO dto) {
		return dto.getId() != null;
	}
	 */
}
