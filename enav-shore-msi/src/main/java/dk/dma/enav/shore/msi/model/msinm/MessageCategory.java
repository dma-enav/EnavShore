package dk.dma.enav.shore.msi.model.msinm;

import net.jcip.annotations.Immutable;

/**
 * InformationType
 */
@Immutable
public class MessageCategory {

    private final GeneralCategory generalCategory;
    private final SpecificCategory specificCategory;
    private final String otherCategory;

    public MessageCategory(GeneralCategory generalCategory, SpecificCategory specificCategory, String otherCategory) {
        super();
        this.generalCategory = generalCategory;
        this.specificCategory = specificCategory;
        this.otherCategory = otherCategory;
    }

    public GeneralCategory getGeneralCategory() {
        return generalCategory;
    }

    public SpecificCategory getSpecificCategory() {
        return specificCategory;
    }

    public String getOtherCategory() {
        return otherCategory;
    }

}
