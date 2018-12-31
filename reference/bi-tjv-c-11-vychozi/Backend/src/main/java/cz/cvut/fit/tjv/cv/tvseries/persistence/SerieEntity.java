package cz.cvut.fit.tjv.cv.tvseries.persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TJV_5_SERIE")
public class SerieEntity implements Serializable {

    @EmbeddedId
    private SerieId id;
    
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "EID", referencedColumnName = "PID")
    private PersonEntity editor;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date added;
    
    @ManyToMany(mappedBy = "favourites")
    private Collection<PersonEntity> fans;
    
    public SerieEntity() {}

    public SerieEntity(SerieId id, Date added) {
        this.id = id;
        this.added = added;
    }

    public SerieId getId() {
        return id;
    }
    
    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public Collection<PersonEntity> getFans() {
        return fans;
    }

    public void setFans(Collection<PersonEntity> fans) {
        this.fans = fans;
    }

    public PersonEntity getEditor() {
        return editor;
    }

    public void setEditor(PersonEntity editor) {
        this.editor = editor;
    }

    public String getTitle() {
        return id.getsTitle();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final SerieEntity other = (SerieEntity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
