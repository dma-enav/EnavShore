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

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class NoticeMessage extends Message {

    private static final long serialVersionUID = 1L;

    @ElementCollection
    private List<String> lightsListNumbers = new ArrayList<>();
    private String authority;
    private String amplifyingRemarks;

    public NoticeMessage() {

    }

    public List<String> getLightsListNumbers() {
        return lightsListNumbers;
    }

    public void setLightsListNumbers(List<String> lightsListNumbers) {
        this.lightsListNumbers = lightsListNumbers;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getAmplifyingRemarks() {
        return amplifyingRemarks;
    }

    public void setAmplifyingRemarks(String amplifyingRemarks) {
        this.amplifyingRemarks = amplifyingRemarks;
    }

}
