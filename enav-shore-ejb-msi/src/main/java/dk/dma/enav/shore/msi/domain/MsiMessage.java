package dk.dma.enav.shore.msi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import dk.dma.enav.shore.common.domain.AbstractEntity;

@Entity
public class MsiMessage extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    
    public MsiMessage() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

}
