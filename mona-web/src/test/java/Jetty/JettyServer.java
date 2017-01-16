package Jetty;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;

/**
 * Created by xiangyang on 16/11/13.
 */
@Slf4j
public class JettyServer {

    //jetty容器监听的端口，可以随意修改
    private int jettyPort = 8005;
    //webapp目录，同时用来定位web.xml，是相对项目主控pom的目录
    private String webappDir = "mona-web"+File.separatorChar+"src"+File.separatorChar+"main"+File.separatorChar+"webapp";

    public static void main(String[] args) throws Exception {
        JettyServer jetty = new JettyServer();
        jetty.start();
    }

    public void start() throws Exception {
        Server server = new Server(jettyPort);
        HandlerCollection collection = new HandlerCollection();
        collection.addHandler(createWebapp());
        server.setHandler(collection);
        server.start();
        server.join();
    }


    protected WebAppContext createWebapp() {
        WebAppContext webapp = new WebAppContext();
        webapp.setDescriptor(getWebDescriptor());
        webapp.setResourceBase(getAppRoot() + File.separatorChar + webappDir);
        webapp.setContextPath(File.separatorChar+"");
        webapp.setInitParameter("org.eclipse.jetty.servlet.Default.dirAllowed", "false");
        webapp.setInitParameter("org.eclipse.jetty.servlet.Default.useFileMappedBuffer", "false");
        return webapp;
    }


    private String getWebDescriptor() {
        return getAppRoot() + File.separatorChar + webappDir + File.separatorChar + "WEB-INF" + File.separatorChar + "web.xml";
    }


    protected String getAppRoot() {
        return System.getProperty("user.dir");
    }

}
