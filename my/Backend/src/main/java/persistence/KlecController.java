package persistence;

public class KlecController extends AbstractCRUDController<KlecEntity> {

	public KlecController(Class<KlecEntity> entityClass) {
		super(entityClass);
	}

	@Override
	protected Object getEntityId(KlecEntity e) {
		return e.getId();
	}

}
