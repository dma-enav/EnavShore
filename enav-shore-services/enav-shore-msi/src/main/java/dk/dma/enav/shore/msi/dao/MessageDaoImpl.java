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

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import dk.dma.enav.shore.common.dao.DaoImpl;
import dk.dma.enav.shore.msi.domain.Message;

@Stateless
public class MessageDaoImpl extends DaoImpl implements MessageDao {
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Message findByMessageSeriesId(int messageNumber, int messageYear, String messageAuthority) {        
        
        // Execute and return the result
        try {
            return em
                .createNamedQuery("Message.findBySeriesIdentifier", Message.class)
                .setParameter("number", messageNumber)
                .setParameter("year", messageYear)
                .setParameter("authority", messageAuthority)
                .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
}
