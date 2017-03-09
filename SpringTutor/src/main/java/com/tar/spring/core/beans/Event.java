package com.tar.spring.core.beans;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by vitar on 08.03.17.
 */
public class Event {
    int id;
    String msg;
    Date date;
    DateFormat df;

    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);


    public Event(Date date, DateFormat df){
        id = AUTO_ID.getAndIncrement();
        this.date = date;
        this.df = df;
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(date) +
                '}';
    }

}
