package dk.dma.enav.shore.msi;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

/*
 * Specific test EJBS under src/test/java that are deployed by test
 * Only run these container tests for specific profile (and only include dependencies for this special profile)
 * Cool!!!!!
 */

//@RunWith(Arquillian.class)
public class NavwarnMessageTest {

    //@Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class, "NavwarnMessageTest.jar");
        jar.addClass(Test2EJB.class);
        jar.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        // jar.addAsManifestResource("ejb-jar.xml", "ejb-jar.xml");
        System.out.println(jar.toString(true));
        return jar;
    }
    
    //@EJB
    Test2EJB test2EJB;

    //@Test
    public void createTest() {
        System.out.println("Hello world: " + test2EJB);
        test2EJB.hello();
    }

}
