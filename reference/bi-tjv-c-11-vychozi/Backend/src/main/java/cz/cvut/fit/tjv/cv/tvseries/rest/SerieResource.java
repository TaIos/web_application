package cz.cvut.fit.tjv.cv.tvseries.rest;

import cz.cvut.fit.tjv.cv.tvseries.domain.SerieDTO;
import cz.cvut.fit.tjv.cv.tvseries.persistence.SerieController;
import cz.cvut.fit.tjv.cv.tvseries.persistence.SerieEntity;
import cz.cvut.fit.tjv.cv.tvseries.persistence.SerieId;
import java.util.function.Function;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/serie")
public class SerieResource extends AbstractCRUDResource<SerieEntity, SerieDTO> {
    
    static final Function<SerieEntity, SerieDTO> ENTITY_TO_DTO_CONVERTER
            = e -> e == null ? null : new SerieDTO(e.getTitle(), e.getId().getEid(), e.getAdded());
    static final Function<SerieDTO, SerieEntity> DTO_TO_ENTITY_CONVERTER
            = d -> new SerieEntity(new SerieId(d.getTitle(), d.getEditorId()), d.getAdded());

    @EJB
    private SerieController controller;
    
    public SerieResource() {
        super(DTO_TO_ENTITY_CONVERTER, ENTITY_TO_DTO_CONVERTER);
    }
    
    @Override
    protected SerieController getController() {
        return controller;
    }
    
    @GET
    @Path("/{pid}-{stitle}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response retrieveById(@PathParam("pid") Integer pid, @PathParam("stitle") String sTitle) {
        return super.retrieveById(new SerieId(sTitle, pid));
    }
    
    @DELETE
    @Path("/{pid}-{stitle}")
    public Response deleteById(@PathParam("pid") Integer pid, @PathParam("stitle") String sTitle) {
        return super.deleteById(new SerieId(sTitle, pid));
    }

    @Override
    protected boolean containsEntityId(SerieDTO dto) {
        return dto.getEditorId() != null && dto.getTitle() != null && !dto.getTitle().isEmpty();
    }
}
