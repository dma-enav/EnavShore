package dk.dma.enav.shore.msi.model.msinm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * InformationType
 * 
 * Navigational warning message
 */
public class NavwarnMessage extends Message {
    
    private Date cancellationDate;
    private List<MessageSeriesIdentifier> cancelMessage = new ArrayList<>();
    private List<MessageItem> messageItem = new ArrayList<>();
    
    public NavwarnMessage() {
        
    }

    public Date getCancellationDate() {
        return cancellationDate;
    }

    public void setCancellationDate(Date cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    public List<MessageSeriesIdentifier> getCancelMessage() {
        return cancelMessage;
    }

    public void setCancelMessage(List<MessageSeriesIdentifier> cancelMessage) {
        this.cancelMessage = cancelMessage;
    }

    public List<MessageItem> getMessageItem() {
        return messageItem;
    }

    public void setMessageItem(List<MessageItem> messageItem) {
        this.messageItem = messageItem;
    }
    
}
