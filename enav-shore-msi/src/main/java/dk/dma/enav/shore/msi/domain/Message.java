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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import dk.dma.enav.shore.common.domain.AbstractEntity;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Message extends AbstractEntity<Integer> {

    private static final long serialVersionUID = 1L;

    private String generalArea;
    private String locality;
    //private List<String> specificLocation = new ArrayList<>();

    public Message() {

    }

    @Column(nullable = false)
    public String getGeneralArea() {
        return generalArea;
    }

    public void setGeneralArea(String generalArea) {
        this.generalArea = generalArea;
    }
    
    @Column(nullable = false)
    public String getLocality() {
        return locality;
    }
    
    public void setLocality(String locality) {
        this.locality = locality;
    }
    

}
