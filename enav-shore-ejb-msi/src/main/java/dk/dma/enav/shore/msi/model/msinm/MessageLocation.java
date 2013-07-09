package dk.dma.enav.shore.msi.model.msinm;

import net.jcip.annotations.Immutable;
import dk.dma.enav.model.geometry.Element;

/**
 * ComplexType
 */
@Immutable
public class MessageLocation {
    
    /**
     * The geometry element
     */
    private final Element element;
    
    public MessageLocation(Element element) {
        this.element = element;
    }
    
    public Element getElement() {
        return element;
    }

}
