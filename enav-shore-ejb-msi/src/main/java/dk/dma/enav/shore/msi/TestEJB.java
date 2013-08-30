package dk.dma.enav.shore.msi;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.dma.enav.shore.msi.domain.NavwarnMessage;

@Stateless
public class TestEJB {
    
    private static final Logger LOG = LoggerFactory.getLogger(TestEJB.class);
    
    @PersistenceContext(name = "msi")
    protected EntityManager em;

    public void helloworld() {
        NavwarnMessage message = new NavwarnMessage();
        message.setGeneralArea("BALTIC SEA");
        message.setLocality("GOTLAND");
        
        
        
        
        
        em.persist(message);
        
        LOG.info("id: " + message.getId());
    }

}
