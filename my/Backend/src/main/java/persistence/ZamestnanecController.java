package persistence;

import java.util.Objects;

public class ZamestnanecController extends AbstractCRUDController<ZamestnanecEntity> {

	public ZamestnanecController(Class<ZamestnanecEntity> entityClass) {
		super(entityClass);
	}

	@Override
	protected Object getEntityId(ZamestnanecEntity e) {
		return e.getId();
	}

	public ZamestnanecEntity addUklid(int id, KlecEntity k) {
		ZamestnanecEntity e = retrieveEntity(id);
		e.getUkliziKlece().add(Objects.requireNonNull(k));
		updateOrCreate(e);
		return e;
	}

	public ZamestnanecEntity removeUklid(int id, KlecEntity k) {
		ZamestnanecEntity e = retrieveEntity(id);
		e.getUkliziKlece().remove(Objects.requireNonNull(k));
		updateOrCreate(e);
		return e;
	}
}
