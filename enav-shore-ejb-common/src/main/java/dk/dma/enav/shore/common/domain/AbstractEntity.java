package dk.dma.enav.shore.common.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Base class for all entity beans
 */
@MappedSuperclass
public abstract class AbstractEntity<K> implements IEntity<K> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    protected K id;
        
    public K getId() {
        return this.id;
    }

    public void setId(K id) {
        this.id = id;
    }

    public boolean isNew() {
        return getId() == null;
    }

    public boolean isPersisted() {
        return !isNew();
    }

}
