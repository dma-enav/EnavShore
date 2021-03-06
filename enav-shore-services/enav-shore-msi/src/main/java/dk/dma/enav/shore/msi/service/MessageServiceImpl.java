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

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;

import dk.dma.enav.shore.msi.dao.MessageDao;
import dk.dma.enav.shore.msi.domain.Message;
import dk.dma.enav.shore.msi.domain.NavwarnMessage;
import dk.dma.enav.shore.msi.domain.NoticeMessage;

@Stateless
public class MessageServiceImpl implements MessageService {
    
    @Inject
    private Logger log;
    
    @EJB
    private MessageDao messageDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public NavwarnMessage create(NavwarnMessage navwarnMessage) {
        log.info("Creating navwarn message");
        return messageDao.saveEntity(navwarnMessage);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public NoticeMessage create(NoticeMessage noticeMessage) {
        log.info("Creating notice message");
        return messageDao.saveEntity(noticeMessage);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Message> getAll() {
        return messageDao.getAll(Message.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Message findById(Integer id) {
        return messageDao.getByPrimaryKey(Message.class, id);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Message findByMessageSeriesId(int messageNumber, int messageYear, String messageAuthority) {        
        return messageDao.findByMessageSeriesId(messageNumber, messageYear, messageAuthority);
    }
}
