package com.tar.spring.core.beans;

/**
 * Created by vitar on 08.03.17.
 */
public class ConsoleEventLogger implements EventLogger {

    public void logEvent(Event event){
        System.out.println(event);
    }

}
