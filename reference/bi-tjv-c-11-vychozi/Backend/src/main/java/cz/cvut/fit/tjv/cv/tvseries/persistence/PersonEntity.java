package cz.cvut.fit.tjv.cv.tvseries.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

 @Entity
@Table(name = "TJV_5_PERSON")
public class PersonEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tjv_5_seq")
    @SequenceGenerator(name = "tjv_5_seq", sequenceName = "TJV_5_SEQ", allocationSize = 1)
    @Column(name = "PID")
    private Integer id;
    
    @Column(name = "PNAME")
    private String name;
    
    @ManyToMany()
    @JoinTable(
            name = "TJV_5_SERIE_2_PERSON",
            joinColumns = @JoinColumn(name = "PID", referencedColumnName = "PID"),
            inverseJoinColumns = {@JoinColumn(name = "STITLE", referencedColumnName = "STITLE"), @JoinColumn(name = "EID", referencedColumnName = "EID", insertable = false)}
    )
    private Collection<SerieEntity> favourites = new ArrayList<>();

    
    public PersonEntity() {}

    public PersonEntity(Integer id, String name, Collection<SerieEntity> favourites) {
        this.id = id;
        this.name = name;
        this.favourites = favourites;
    }
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<SerieEntity> getFavourites() {
        return favourites;
    }

    public void setFavourites(Collection<SerieEntity> favourites) {
        this.favourites = favourites;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.id);
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
        final PersonEntity other = (PersonEntity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}
