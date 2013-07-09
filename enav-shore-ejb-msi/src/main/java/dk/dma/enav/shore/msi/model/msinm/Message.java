package dk.dma.enav.shore.msi.model.msinm;

import java.util.ArrayList;
import java.util.List;

/**
 * InformationType 
 */
public abstract class Message {
    
    private MessageSeriesIdentifier messageSeriesIdentifier;
    private String generalArea;
    private String locality;
    private List<String> specificLocation = new ArrayList<>();
    private List<String> chartNumber = new ArrayList<>();
    private List<Integer> internationalNumber = new ArrayList<>();
    
    public Message() {
        
    }

    public MessageSeriesIdentifier getMessageSeriesIdentifier() {
        return messageSeriesIdentifier;
    }

    public void setMessageSeriesIdentifier(MessageSeriesIdentifier messageSeriesIdentifier) {
        this.messageSeriesIdentifier = messageSeriesIdentifier;
    }

    public String getGeneralArea() {
        return generalArea;
    }

    public void setGeneralArea(String generalArea) {
        this.generalArea = generalArea;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public List<String> getSpecificLocation() {
        return specificLocation;
    }

    public void setSpecificLocation(List<String> specificLocation) {
        this.specificLocation = specificLocation;
    }

    public List<String> getChartNumber() {
        return chartNumber;
    }

    public void setChartNumber(List<String> chartNumber) {
        this.chartNumber = chartNumber;
    }

    public List<Integer> getInternationalNumber() {
        return internationalNumber;
    }

    public void setInternationalNumber(List<Integer> internationalNumber) {
        this.internationalNumber = internationalNumber;
    }
    
}
