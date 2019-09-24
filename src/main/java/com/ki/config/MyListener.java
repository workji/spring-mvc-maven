package com.ki.config;

import com.ki.entity.Counter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Enumeration;

public class MyListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("count", new Counter(0));
        Enumeration<String> parameters = sce.getServletContext().getInitParameterNames();

        System.out.println("Listener Show: ");
        while (parameters.hasMoreElements()) {
            String key = parameters.nextElement();
            System.out.println(key + " : " + sce.getServletContext().getInitParameter(key));
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // something for save
    }
}
