package cz.cvut.fit.tjv.cv.tvseries.rest;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/seriesrest")
public class SeriesEndpoint extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return Stream
                .of(PersonResource.class, SerieResource.class)
                .collect(Collectors.toSet());
    }
    
}
