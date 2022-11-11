package com.example.helpi;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class FINDJOBS implements Serializable {

    @Exclude
    private String key;
    private String email;
    private String service;
    private String position;
    private String location;
    private String method;
    private String description;

    public FINDJOBS(){}

    public FINDJOBS(String key, String email, String service, String position, String location, String method, String description) {
        this.key = key;
        this.email = email;
        this.service = service;
        this.position = position;
        this.location = location;
        this.method = method;
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}

