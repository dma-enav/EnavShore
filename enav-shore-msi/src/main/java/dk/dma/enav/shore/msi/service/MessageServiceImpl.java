package dk.dma.enav.shore.msi.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dk.dma.enav.shore.msi.domain.NavwarnMessage;

@Stateless
public class MessageServiceImpl implements MessageService {
    
    @PersistenceContext(unitName = "msi")
    protected EntityManager em;

    @Override
    public void create(NavwarnMessage navwarnMessage) {
        em.persist(navwarnMessage);
    }

}
