package dk.dma.enav.shore.common.domain;

import java.io.Serializable;

/**
 * Interface for all entities
 */
public interface IEntity<K> extends Serializable {

    K getId();

    boolean isNew();

    boolean isPersisted();

}
