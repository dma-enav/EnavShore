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
package dk.dma.enav.shore.msi.dao;

import javax.ejb.Local;

import dk.dma.enav.shore.common.dao.Dao;
import dk.dma.enav.shore.msi.domain.Message;

@Local
public interface MessageDao extends Dao {

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
