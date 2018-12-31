package cz.cvut.fit.tjv.cv.tvseries.rest;

import cz.cvut.fit.tjv.cv.tvseries.domain.PersonDTO;
import cz.cvut.fit.tjv.cv.tvseries.domain.SerieDTO;
import cz.cvut.fit.tjv.cv.tvseries.persistence.PersonController;
import cz.cvut.fit.tjv.cv.tvseries.persistence.PersonEntity;
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

@Path("/person")
public class PersonResource extends AbstractCRUDResource<PersonEntity, PersonDTO> {

    @EJB
    private PersonController controller;

    public PersonResource() {
                super(d -> new PersonEntity(d.getId(), d.getName(), d.getFavourites()
                        .stream()
                        .map(SerieResource.DTO_TO_ENTITY_CONVERTER)
                        .collect(Collectors.toList())
                ),
                e -> new PersonDTO(e.getId(), e.getName(), e.getFavourites()
                        .stream()
                        .map(SerieResource.ENTITY_TO_DTO_CONVERTER)
                        .collect(Collectors.toList())
                )
        );
    }

    @Override
    protected PersonController getController() {
        return controller;
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
    public Response addOrRemoveFavourite(SerieDTO s, @PathParam("id") int id, @QueryParam("remove") boolean remove) {
        try {
            if (remove) {
                return Response
                        .ok(entityToDtoConverter.apply(controller.removeFavourite(id, SerieResource.DTO_TO_ENTITY_CONVERTER.apply(s))))
                        .build();
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
    protected boolean containsEntityId(PersonDTO dto) {
        return dto.getId() != null;
    }
}
