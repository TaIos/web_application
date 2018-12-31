package cz.cvut.fit.tjv.cv.tvseries.persistence;

import javax.ejb.Stateless;

@Stateless
public class SerieController extends AbstractCRUDController<SerieEntity>{
    
    public SerieController() {
        super(SerieEntity.class);
    }
    
    @Override
    protected SerieId getEntityId(SerieEntity e) {
        return e.getId();
    }
}
