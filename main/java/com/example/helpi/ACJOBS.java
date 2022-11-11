package com.example.helpi;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class ACJOBS implements Serializable {

    /*String accepteddate;
    String description;
    Double phno ;
    String possition;
    String postdate;
    String reqname;
    String title;*/
    @Exclude
    private String key;
    private String email;
    private String service;
    private String position;
    private String location;
    private String method;
    private String description;

    public  ACJOBS(){}
    public ACJOBS(String email, String service, String position, String location, String method, String description) {
        this.email = email;
        this.service = service;
        this.position = position;
        this.location = location;
        this.method = method;
        this.description = description;
    }

    /*  public ACJOBS(String accepteddate, String description, String phno, String possition, String postdate, String reqname, String title) {
        this.accepteddate = accepteddate;
        this.description = description;
        this.phno = phno;
        this.possition = possition;
        this.postdate = postdate;
        this.reqname = reqname;
        this.title = title;
    }*/

   /* public String getAccepteddate() {
        return accepteddate;
    }

    public String getDescription() {
        return description;
    }

    public Double getPhno() {
        return phno;
    }

    public String getPossition() {
        return possition;
    }

    public String getPostdate() {
        return postdate;
    }

    public String getReqname() {
        return reqname;
    }

    public String getTitle() {
        return title;
    }*/


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
