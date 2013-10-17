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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.formatter.Formatters;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import dk.dma.enav.model.msi.MessageType;
import dk.dma.enav.shore.common.domain.BaseEntity;
import dk.dma.enav.shore.common.domain.IEntity;
import dk.dma.enav.shore.msi.domain.MessageSeriesIndentifier;
import dk.dma.enav.shore.msi.domain.NavwarnMessage;
import dk.dma.enav.shore.msi.service.MessageService;

@RunWith(Arquillian.class)
public class NavwarnMessageTestRemote {

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class, "msi_test.jar");
        jar.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        jar.addClass(MessageType.class);
        jar.addClass(IEntity.class);    
        jar.addClass(BaseEntity.class);
        jar.addClass(MessageService.class);        
        jar.addPackages(true, "dk.dma.enav.shore.msi.domain");        
        System.out.println(jar.toString(Formatters.VERBOSE));
        return jar;
    }

    @EJB(lookup = "java:global/enav-shore-msi/MessageServiceImpl!dk.dma.enav.shore.msi.service.MessageService")
    private MessageService messageService;

    @Test
    public void createNavwarnTest() throws ParseException {
        NavwarnMessage message = new NavwarnMessage();
        
        // Message series identifier
        MessageSeriesIndentifier identifier = new MessageSeriesIndentifier();
        identifier.setAuthority("DMA");
        identifier.setYear(2013);
        identifier.setNumber(new Random(System.currentTimeMillis()).nextInt(1000) + 1);
        identifier.setType(MessageType.NAVAREA_WARNING);
        
        // Tie to message
        message.setSeriesIndentifier(identifier);
        identifier.setMessage(message);

        // Message
        message.setGeneralArea("Kattegat");
        message.setLocality("The Sound");
        message.getSpecificLocation().add("Copenhagen port");
        message.getSpecificLocation().add("Langebro bridge");
        message.getChartNumber().add("daddasd");
        message.getIntChartNumber().add(100);
        
        // NavwarnMessage
        message.setCancellationDate((new SimpleDateFormat("dd-MM-yyyy")).parse("31-12-2013"));
        
        
        messageService.create(message);
    }

}
