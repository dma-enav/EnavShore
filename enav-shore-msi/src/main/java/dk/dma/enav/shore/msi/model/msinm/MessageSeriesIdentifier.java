package dk.dma.enav.shore.msi.model.msinm;

import java.io.Serializable;

import net.jcip.annotations.Immutable;

/**
 * ComplexType
 */
@Immutable
public class MessageSeriesIdentifier implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private final MessageType messageType;
    private final int messageNumber;
    private final int messageYear;
    private final String messageAuthority;

    public MessageSeriesIdentifier(MessageType messageType, int messageNumber, int messageYear, String messageAuthority) {
        super();
        this.messageType = messageType;
        this.messageNumber = messageNumber;
        this.messageYear = messageYear;
        this.messageAuthority = messageAuthority;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public int getMessageNumber() {
        return messageNumber;
    }

    public int getMessageYear() {
        return messageYear;
    }

    public String getMessageAuthority() {
        return messageAuthority;
    }
    
}
