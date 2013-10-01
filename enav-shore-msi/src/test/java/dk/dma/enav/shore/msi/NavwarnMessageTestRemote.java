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
