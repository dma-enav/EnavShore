package dk.dma.enav.shore.msi.service;

import javax.ejb.Remote;

import dk.dma.enav.shore.msi.domain.NavwarnMessage;

@Remote
public interface MessageService {
    
    void create(NavwarnMessage navwarnMessage);

}
