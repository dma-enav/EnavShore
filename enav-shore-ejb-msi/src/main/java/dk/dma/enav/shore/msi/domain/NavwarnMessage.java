package dk.dma.enav.shore.msi.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class NavwarnMessage extends Message {

    private static final long serialVersionUID = 1L;
    
    private Date cancellationDate;
    
    public NavwarnMessage() {        
    }

    @Column(nullable = true)
    public Date getCancellationDate() {
        return cancellationDate;
    }
    
    public void setCancellationDate(Date cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

}
