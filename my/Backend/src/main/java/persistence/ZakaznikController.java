package persistence;

import java.util.Objects;

public class ZakaznikController extends AbstractCRUDController<ZakaznikEntity> {

	public ZakaznikController(Class<ZakaznikEntity> entityClass) {
		super(entityClass);
	}

	@Override
	protected Object getEntityId(ZakaznikEntity e) {
		return e.getId();
	}

	public ZakaznikEntity addObjednavka(int id, ObjednavkaEntity obj) {
		ZakaznikEntity e = retrieveEntity(id);
		e.getObjednavky().add(Objects.requireNonNull(obj));
		updateOrCreate(e);
		return e;
	}

	public ZakaznikEntity removeObjednavka(int id, ObjednavkaEntity obj) {
		ZakaznikEntity e = retrieveEntity(id);
		e.getObjednavky().remove(Objects.requireNonNull(obj));
		updateOrCreate(e);
		return e;
	}
}
