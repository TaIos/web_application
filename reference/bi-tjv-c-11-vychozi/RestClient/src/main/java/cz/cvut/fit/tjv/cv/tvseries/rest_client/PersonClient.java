package cz.cvut.fit.tjv.cv.tvseries.rest_client;

import cz.cvut.fit.tjv.cv.tvseries.domain.PersonDTO;
import cz.cvut.fit.tjv.cv.tvseries.domain.SerieDTO;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PersonClient {

    private static final String RESOURCE_PATH = "/person";
    private static final String RESOURCE_ID_PATH = "{pid}";

    private static final PersonClient INSTANCE = new PersonClient();

    private PersonClient() {
    }

    public static PersonClient getInstance() {
        return INSTANCE;
    }

    public void createOrUpdateJson(PersonDTO e) {
        PersonDTO res = RestClient.processRequest(RESOURCE_PATH, t -> t.request(MediaType.APPLICATION_JSON).put(Entity.json(e), PersonDTO.class));
        e.setId(res.getId());
        e.setFavourites(res.getFavourites());
        e.setName(e.getName());
    }

    public void createOrUpdateXml(PersonDTO e) {
        RestClient.processRequest(RESOURCE_PATH, t -> t.request().put(Entity.xml(e)));
    }

    public PersonDTO retrieveJson(Integer id) {
        return RestClient.processRequest(RESOURCE_PATH, t -> t.path(RESOURCE_ID_PATH)
                .resolveTemplate("pid", id)
                .request(MediaType.APPLICATION_JSON).get(PersonDTO.class));
    }

    public PersonDTO retrieveXml(Integer id) {
        return RestClient.processRequest(RESOURCE_PATH, t -> t.path(RESOURCE_ID_PATH)
                .resolveTemplate("pid", id)
                .request(MediaType.APPLICATION_XML).get(PersonDTO.class));
    }

    public PersonDTO[] retrieveAllJson() {
        return RestClient.processRequest(RESOURCE_PATH, t -> t.request(MediaType.APPLICATION_JSON).get(PersonDTO[].class));
    }

    public PersonDTO[] retrieveAllXml() {
        return RestClient.processRequest(RESOURCE_PATH, t -> t.request(MediaType.APPLICATION_XML).get(PersonDTO[].class));
    }

    public void delete(Integer id) {
        RestClient.processRequest(RESOURCE_PATH,
                t -> {
                    int status = t.path(RESOURCE_ID_PATH).resolveTemplate("pid", id).request().delete().getStatus();
                    if (status != 204) {
                        throw new SeriesServiceException(null);
                    } else {
                        return null;
                    }
                });
    }

    private void addOrRemoveFavouriteJson(int pid, String sTitle, int editorId, boolean remove) {
        RestClient.processRequest(RESOURCE_PATH, t -> {
            int status = t.path(RESOURCE_ID_PATH).resolveTemplate("pid", pid).queryParam("remove", remove).request().post(Entity.json(new SerieDTO(sTitle, editorId, null))).getStatus();
            if (status != 200)
                throw new SeriesServiceException(null);
            else
                return null;
        });

    }

    public void addFavouriteJson(int pid, String sTitle, int editorId) {
        addOrRemoveFavouriteJson(pid, sTitle, editorId, false);
    }

    public void removeFavouriteJson(int pid, String sTitle, int editorId) {
        addOrRemoveFavouriteJson(pid, sTitle, editorId, true);
    }
}
