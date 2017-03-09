package com.tar.spring.core.beans;

/**
 * Created by vitar on 08.03.17.
 */
public class Client {


    String id;

    String fullName;


    Client(){
        id = "10";
        fullName = "Bob";
    }

    public Client(String id, String fullName){
        this.id = id;
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }
    public String getFullName() {
        return fullName;
    }
}
