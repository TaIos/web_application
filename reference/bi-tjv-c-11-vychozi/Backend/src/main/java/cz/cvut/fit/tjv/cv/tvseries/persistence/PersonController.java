package cz.cvut.fit.tjv.cv.tvseries.persistence;

import java.util.Objects;
import javax.ejb.Stateless;

@Stateless
public class PersonController extends AbstractCRUDController<PersonEntity> {

    public PersonController() {
        super(PersonEntity.class);
    }

    @Override
    protected Integer getEntityId(PersonEntity e) {
        return e.getId();
    }

    public PersonEntity addFavourite(int id, SerieEntity s)  {
        PersonEntity e = retrieveEntity(id);
        e.getFavourites()
                .add(Objects.requireNonNull(s));
        updateOrCreate(e);
        return e;
    }

    public PersonEntity removeFavourite(int id, SerieEntity s) {
        PersonEntity e = retrieveEntity(id);
        e.getFavourites()
                .remove(Objects.requireNonNull(s));
        updateOrCreate(e);
        return e;
    }
}
