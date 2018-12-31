package cz.cvut.fit.tjv.cv.tvseries.rest_client;

import cz.cvut.fit.tjv.cv.tvseries.domain.SerieDTO;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

public class SerieClient {

    private static final String RESOURCE_PATH = "/serie";
    private static final String RESOURCE_ID_PATH = "{eid}-{stitle}";

    private static final SerieClient INSTANCE = new SerieClient();

    private SerieClient() {
    }

    public static SerieClient getInstance() {
        return INSTANCE;
    }

    public void createOrUpdateXml(SerieDTO e) {
        RestClient.processRequest(RESOURCE_PATH, t -> t.request().put(Entity.xml(e)));
    }

    public void createOrUpdateJson(SerieDTO e) {
        RestClient.processRequest(RESOURCE_PATH, t -> t.request().put(Entity.json(e)));
    }

    public SerieDTO retrieveXml(String title, Integer editorId) {
        return RestClient.processRequest(RESOURCE_PATH, t -> t.path(RESOURCE_ID_PATH)
                .resolveTemplate("eid", editorId)
                .resolveTemplate("stitle", title)
                .request(MediaType.APPLICATION_XML).get(SerieDTO.class));
    }

    public SerieDTO retrieveJson(String title, Integer editorId) {
        return RestClient.processRequest(RESOURCE_PATH, t -> t.path(RESOURCE_ID_PATH)
                .resolveTemplate("eid", editorId)
                .resolveTemplate("stitle", title)
                .request(MediaType.APPLICATION_JSON).get(SerieDTO.class));
    }

    public SerieDTO[] retrieveAllJson() {
        return RestClient.processRequest(RESOURCE_PATH, t -> t.request(MediaType.APPLICATION_JSON).get(SerieDTO[].class));
    }

    public SerieDTO[] retrieveAllXml() {
        return RestClient.processRequest(RESOURCE_PATH, t -> t.request(MediaType.APPLICATION_XML).get(SerieDTO[].class));
    }

    public void delete(String title, Integer editorId) {
        RestClient.processRequest(RESOURCE_PATH, t -> t.path(RESOURCE_ID_PATH)
                .resolveTemplate("eid", editorId)
                .resolveTemplate("stitle", title)
                .request().delete());
    }

}
