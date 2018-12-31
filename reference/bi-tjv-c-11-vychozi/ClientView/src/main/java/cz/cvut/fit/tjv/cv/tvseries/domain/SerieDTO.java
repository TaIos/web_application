package cz.cvut.fit.tjv.cv.tvseries.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SerieDTO implements Serializable {
    private String title;
    private Integer editorId;
    private Date added;
    
    public SerieDTO() {}

    public SerieDTO(String title, Integer editor, Date added) {
        this.title = title;
        this.editorId = editor;
        this.added = added;
    }

    public String getTitle() {
        return title;
    }

    public Integer getEditorId() {
        return editorId;
    }

    public Date getAdded() {
        return added;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEditorId(Integer editorId) {
        this.editorId = editorId;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.title);
        hash = 71 * hash + Objects.hashCode(this.editorId);
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
        final SerieDTO other = (SerieDTO) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return Objects.equals(this.editorId, other.editorId);
    }

    @Override
    public String toString() {
        return "SerieDTO{" + "title=" + title + ", editor=" + editorId + ", added=" + added + '}';
    }
    
    
}
