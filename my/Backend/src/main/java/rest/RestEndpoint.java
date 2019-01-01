package rest;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//@ApplicationPath("/endpoint")
public class RestEndpoint extends Application {

	/*
	@Override
	public Set<Class<?>> getClasses() {
		return Stream
			.of(KlecResource.class, ObjednavkaResource.class,
				ZakaznikResource.class, ZamestnanecResource.class)
			.collect(Collectors.toSet());
	}
*/
}
