package dk.dma.enav.shore.msi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import dk.dma.enav.shore.common.domain.AbstractEntity;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Message extends AbstractEntity<Integer> {

    private static final long serialVersionUID = 1L;

    private String generalArea;
    private String locality;
    //private List<String> specificLocation = new ArrayList<>();

    public Message() {

    }

    @Column(nullable = false)
    public String getGeneralArea() {
        return generalArea;
    }

    public void setGeneralArea(String generalArea) {
        this.generalArea = generalArea;
    }
    
    @Column(nullable = false)
    public String getLocality() {
        return locality;
    }
    
    public void setLocality(String locality) {
        this.locality = locality;
    }
    

}
