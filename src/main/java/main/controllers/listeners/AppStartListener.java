package main.controllers.listeners;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by admin on 20.04.2017.
 */
public class AppStartListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        PropertyConfigurator.configure(AppStartListener.class.getClassLoader().getResource("log4j.xml"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

