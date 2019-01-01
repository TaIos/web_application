package persistence;

public class ObjednavkaController extends AbstractCRUDController<ObjednavkaEntity> {

	public ObjednavkaController(Class<ObjednavkaEntity> entityClass) {
		super(entityClass);
	}

	@Override
	protected Object getEntityId(ObjednavkaEntity e) {
		return e.getId();
	}
}
