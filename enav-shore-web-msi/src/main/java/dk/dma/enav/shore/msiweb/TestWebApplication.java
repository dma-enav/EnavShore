package dk.dma.enav.shore.msiweb;

import static net.ftlines.wicket.cdi.ConversationPropagation.NONE;

import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import net.ftlines.wicket.cdi.CdiConfiguration;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class TestWebApplication extends WebApplication {

    public TestWebApplication() {
       
    }
    
    @Override
    public Class<? extends Page> getHomePage() {
        return TestPage.class;
    }
    
    @Override
    protected void init() {       
        super.init();
     // Enable CDI
        BeanManager bm;
        try {
            bm = (BeanManager) new InitialContext().lookup("java:comp/BeanManager");
        } catch (NamingException e) {
            throw new IllegalStateException("Unable to obtain CDI BeanManager", e);
        }

        // Configure CDI, disabling Conversations as we aren't using them
        new CdiConfiguration(bm).setPropagation(NONE).configure(this);

    }

}
