package rest;

import java.util.function.Function;
import javax.ws.rs.Path;
import persistence.AbstractCRUDController;

//@Path("zakaznik")
public class ZakaznikResource extends AbstractCRUDResource {

	public ZakaznikResource(Function dtoToEntityConverter, Function entityToDtoConverter) {
		super(dtoToEntityConverter, entityToDtoConverter);
	}

	@Override
	protected AbstractCRUDController getController() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	protected boolean containsEntityId(Object dto) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
