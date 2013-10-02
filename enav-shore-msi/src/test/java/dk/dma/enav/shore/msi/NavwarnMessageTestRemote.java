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
package dk.dma.enav.shore.msi;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import dk.dma.enav.shore.common.domain.AbstractEntity;
import dk.dma.enav.shore.common.domain.IEntity;
import dk.dma.enav.shore.msi.domain.Message;
import dk.dma.enav.shore.msi.domain.NavwarnMessage;
import dk.dma.enav.shore.msi.service.MessageService;

@RunWith(Arquillian.class)
public class NavwarnMessageTestRemote {

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class, "test.jar");
        jar.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        jar.addClass(NavwarnMessage.class);
        jar.addClass(IEntity.class);
        jar.addClass(AbstractEntity.class);
        jar.addClass(Message.class);
        jar.addClass(MessageService.class);
        return jar;
    }

    @EJB(lookup = "java:global/enav-shore-msi/MessageServiceImpl!dk.dma.enav.shore.msi.service.MessageService")
    private MessageService messageService;

    @Test
    public void createTest() {
        NavwarnMessage message = new NavwarnMessage();
        message.setGeneralArea("The Sound");
        message.setLocality("Kattegat");
        messageService.create(message);
    }

}
