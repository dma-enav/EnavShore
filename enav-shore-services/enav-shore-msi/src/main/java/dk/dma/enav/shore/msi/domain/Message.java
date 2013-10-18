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
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import dk.dma.enav.shore.common.domain.BaseEntity;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Message extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private MessageSeriesIdentifier seriesIndentifier;
    @NotNull
    private String generalArea;
    @NotNull
    private String locality;
    @ElementCollection
    private List<String> specificLocation = new ArrayList<>();
    @ElementCollection
    private List<String> chartNumber = new ArrayList<>();
    @ElementCollection
    private List<Integer> intChartNumber = new ArrayList<>();
    @NotNull
    private Date issueDate;

    public Message() {

    }
    
    public MessageSeriesIdentifier getSeriesIndentifier() {
        return seriesIndentifier;
    }
    
    public void setSeriesIndentifier(MessageSeriesIdentifier seriesIndentifier) {
        this.seriesIndentifier = seriesIndentifier;
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
    
    public List<Integer> getIntChartNumber() {
        return intChartNumber;
    }
    
    public void setIntChartNumber(List<Integer> intChartNumber) {
        this.intChartNumber = intChartNumber;
    }
    
    public Date getIssueDate() {
        return issueDate;
    }
    
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
    
}
