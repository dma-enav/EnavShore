package dk.dma.enav.shore.msiweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dk.dma.enav.shore.msi.TestEJB;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    @EJB
    TestEJB testEJB;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        testEJB.helloworld();
        resp.setContentType("text/plain");
        PrintWriter writer = resp.getWriter();
        writer.println("Hello world");
        writer.close();
    }

}
