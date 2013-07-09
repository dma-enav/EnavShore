package dk.dma.enav.shore.msi.model.msinm;

import java.util.ArrayList;
import java.util.List;

/**
 * FeatureType
 */
public class MessageItem {

    private String keySubject;
    private List<MessageLocation> location = new ArrayList<>();
    private MessageCategory messageCategory;
    private List<String> amplifyingRemarks = new ArrayList<>();

    public MessageItem() {

    }

    public String getKeySubject() {
        return keySubject;
    }

    public void setKeySubject(String keySubject) {
        this.keySubject = keySubject;
    }

    public List<MessageLocation> getLocation() {
        return location;
    }

    public void setLocation(List<MessageLocation> location) {
        this.location = location;
    }

    public MessageCategory getMessageCategory() {
        return messageCategory;
    }

    public void setMessageCategory(MessageCategory messageCategory) {
        this.messageCategory = messageCategory;
    }

    public List<String> getAmplifyingRemarks() {
        return amplifyingRemarks;
    }

    public void setAmplifyingRemarks(List<String> amplifyingRemarks) {
        this.amplifyingRemarks = amplifyingRemarks;
    }

}
