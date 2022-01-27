package de.malvik;

import junit.framework.TestCase;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.Test;

import java.io.File;

public class JettyServerTest extends TestCase {

    @Test
    public void testMain() throws Exception {
        //given
        Server server = new Server(8080);
        //when
        setWebappServlet(server);
        server.start();
        server.join();
        //then
        assertNotNull(server);
    }

    private static void setWebappServlet(Server server) {
        WebAppContext webapp = new WebAppContext();
        webapp.setWar(new File("webapp/target/webapp.war").getAbsolutePath());
        webapp.setContextPath("/web");
        server.setHandler(webapp);
    }
}