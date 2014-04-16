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
package dk.dma.enav.shore.msi.service;

import java.util.List;

import javax.ejb.Remote;

import dk.dma.enav.shore.msi.domain.Message;
import dk.dma.enav.shore.msi.domain.NavwarnMessage;
import dk.dma.enav.shore.msi.domain.NoticeMessage;

@Remote
public interface MessageService {
    
    /**
     * Returns all MSI and NtM messages
     * 
     * @return all MSI and NtM messages
     */
    List<Message> getAll();

    /**
     * Creates a new MSI message
     * 
     * @param navwarnMessage the MSI message to create
     * @return the created MSI message
     */
    NavwarnMessage create(NavwarnMessage navwarnMessage);
    
    /**
     * Creates a new NtM message
     * 
     * @param navwarnMessage the NtM message to create
     * @return the created NtM message
     */
    NoticeMessage create(NoticeMessage noticeMessage);
  
    /**
     * Returns the message with the given internal primary key
     * 
     * @param id the primary key
     * @return the associated message or null if not found
     */
    Message findById(Integer id);

    /**
     * Returns the message with the given combination of message number, year and authority
     * 
     * @param messageNumber the message number
     * @param messageYear the message year
     * @param messageAuthority the authority
     * @return the message or null if not found
     */
    Message findByMessageSeriesId(int messageNumber, int messageYear, String messageAuthority);        
}
