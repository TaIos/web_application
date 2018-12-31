package cz.cvut.fit.tjv.cv.tvseries.persistence;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class SerieId implements Serializable {
    private String sTitle;
    
    private Integer eid;

    public SerieId() {
    }

    public SerieId(String sTitle, Integer eid) {
        this.sTitle = sTitle;
        this.eid = eid;
    }

    public String getsTitle() {
        return sTitle;
    }

    public void setsTitle(String sTitle) {
        this.sTitle = sTitle;
    }

    public Integer getEid() {
        return eid;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.sTitle);
        hash = 29 * hash + Objects.hashCode(this.eid);
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
        final SerieId other = (SerieId) obj;
        if (!Objects.equals(this.sTitle, other.sTitle)) {
            return false;
        }
        return Objects.equals(this.eid, other.eid);
    }
    
    
}
