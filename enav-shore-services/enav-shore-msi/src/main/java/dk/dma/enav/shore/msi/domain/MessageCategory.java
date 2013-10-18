/* Copyright (c) 2011 Danish Maritime Authority
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this library.  If not, see <http://www.gnu.org/licenses/>.
 */
package dk.dma.enav.shore.msi.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import dk.dma.enav.model.msi.GeneralCategory;
import dk.dma.enav.model.msi.SpecificCategory;
import dk.dma.enav.shore.common.domain.BaseEntity;

@Entity
public class MessageCategory extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Enumerated(EnumType.STRING)
    private GeneralCategory generalCategory;
    @NotNull
    @Enumerated(EnumType.STRING)
    private SpecificCategory specificCategory;
    @NotNull    
    private String otherCategory;

    public MessageCategory() {

    }

    public GeneralCategory getGeneralCategory() {
        return generalCategory;
    }

    public void setGeneralCategory(GeneralCategory generalCategory) {
        this.generalCategory = generalCategory;
    }

    public SpecificCategory getSpecificCategory() {
        return specificCategory;
    }

    public void setSpecificCategory(SpecificCategory specificCategory) {
        this.specificCategory = specificCategory;
    }

    public String getOtherCategory() {
        return otherCategory;
    }

    public void setOtherCategory(String otherCategory) {
        this.otherCategory = otherCategory;
    }

}
