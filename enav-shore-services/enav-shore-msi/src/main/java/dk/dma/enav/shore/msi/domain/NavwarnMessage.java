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

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class NavwarnMessage extends Message {

    private static final long serialVersionUID = 1L;
    
    private Date cancellationDate;
    @OneToMany
    private List<MessageItem> messageItem = new ArrayList<>();
    
    public NavwarnMessage() {        
    }

    public Date getCancellationDate() {
        return cancellationDate;
    }
    
    public void setCancellationDate(Date cancellationDate) {
        this.cancellationDate = cancellationDate;
    }
    
    public List<MessageItem> getMessageItem() {
        return messageItem;
    }
    
    public void setMessageItem(List<MessageItem> messageItem) {
        this.messageItem = messageItem;
    }
    
}
