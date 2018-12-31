package cz.cvut.fit.tjv.cv.tvseries.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PersonDTO implements Serializable {
    private Integer id;
    private String name;
    private List<SerieDTO> favourites = new ArrayList<>();
    
    public PersonDTO() {}

    public PersonDTO(Integer id, String name, List<SerieDTO> favourites) {
        this.id = id;
        this.name = name;
        this.favourites = favourites;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<SerieDTO> getFavourites() {
        return favourites;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFavourites(List<SerieDTO> favourites) {
        this.favourites = favourites;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PersonDTO other = (PersonDTO) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PersonDTO{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}
