package dk.dma.enav.shore.msiweb;

import javax.ejb.EJB;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

import dk.dma.enav.shore.msi.TestEJB;

public class TestPage extends WebPage {

    private static final long serialVersionUID = 1L;
    
    @EJB
    TestEJB testEJB;

    public TestPage() {
        testEJB.helloworld();
        add(new Label("message", "Hello World!"));
    }

}
