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
import java.util.Date;
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

import dk.dma.enav.model.msi.GeneralCategory;
import dk.dma.enav.model.msi.MessageType;
import dk.dma.enav.model.msi.SpecificCategory;
import dk.dma.enav.shore.common.domain.BaseEntity;
import dk.dma.enav.shore.common.domain.IEntity;
import dk.dma.enav.shore.msi.domain.MessageCategory;
import dk.dma.enav.shore.msi.domain.MessageItem;
import dk.dma.enav.shore.msi.domain.MessageLocation;
import dk.dma.enav.shore.msi.domain.MessageLocation.LocationType;
import dk.dma.enav.shore.msi.domain.MessageSeriesIdentifier;
import dk.dma.enav.shore.msi.domain.NavwarnMessage;
import dk.dma.enav.shore.msi.domain.Point;
import dk.dma.enav.shore.msi.service.MessageService;

@RunWith(Arquillian.class)
public class MessageTestRemote {

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class, "msi_test.jar");
        jar.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        jar.addClass(dk.dma.enav.model.msi.MessageType.class);
        jar.addClass(dk.dma.enav.model.msi.MessageCategory.class);
        jar.addClass(dk.dma.enav.model.msi.GeneralCategory.class);
        jar.addClass(SpecificCategory.class);
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
        MessageSeriesIdentifier identifier = new MessageSeriesIdentifier();
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
        message.setIssueDate(new Date(System.currentTimeMillis()));
        
        // NavwarnMessage
        message.setCancellationDate((new SimpleDateFormat("dd-MM-yyyy")).parse("31-12-2013"));
        
        // MessageItem 's
        MessageItem item1 = new MessageItem();
        item1.setKeySubject("Bridge has collapsed");
        item1.setAmplifyingRemarks("Debris in water");
        
        MessageCategory cat1 = new MessageCategory();
        cat1.setGeneralCategory(GeneralCategory.AIDS_TO_NAVIGATION);
        cat1.setSpecificCategory(SpecificCategory.BUOY);
        cat1.setOtherCategory("Unlit");
        item1.setCategory(cat1);
        
        MessageLocation loc1 = new MessageLocation(LocationType.POLYGON);
        loc1.addPoint(new Point(56.120, 12.1684));
        loc1.addPoint(new Point(55.877, 12.622));
        loc1.addPoint(new Point(55.962, 12.576));
        item1.getLocation().add(loc1);
        MessageLocation loc2 = new MessageLocation(LocationType.POLYGON);
        loc2.addPoint(new Point(57.120, 13.1684));
        loc2.addPoint(new Point(57.877, 13.622));
        loc2.addPoint(new Point(57.962, 13.576));
        item1.getLocation().add(loc2);
        
        MessageItem item2 = new MessageItem();
        item2.setKeySubject("Plane crash");
        item2.setAmplifyingRemarks("Debris in water");
        MessageCategory cat2 = new MessageCategory();
        cat2.setGeneralCategory(GeneralCategory.DANGEROUS_WRECKS);
        cat2.setSpecificCategory(SpecificCategory.WRECK);
        cat2.setOtherCategory("Adrift");
        item2.setCategory(cat2);
        
        // Tie message items to navwarn message
        message.getMessageItem().add(item1);
        message.getMessageItem().add(item2);
        
        // Create navwarn message
        message = messageService.create(message);
        
        System.out.println("Message created with id: " + message.getId());
        
        // Get navwarn message and check fields
        
        
    }
    

}
