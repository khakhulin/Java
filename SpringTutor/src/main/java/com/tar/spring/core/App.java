package com.tar.spring.core;

import com.tar.spring.core.beans.Client;
import com.tar.spring.core.beans.Event;
import com.tar.spring.core.beans.EventLogger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by vitar on 08.03.17.
 */
public class App {

    Client client;
    EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args){
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("App");
        Event event = ctx.getBean(Event.class);
        event.setMsg("test 1");
        app.logEvent(event);

        Event event1 = ctx.getBean(Event.class);
        event1.setMsg("event 2");
        app.logEvent(event1);

        ctx.close();
    }

    private void logEvent(Event eventMsg) {
        String msg = eventMsg.getMsg().replaceAll(client.getId(), client.getFullName());
        eventLogger.logEvent(eventMsg);
    }

}
