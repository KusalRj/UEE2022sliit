package com.example.helpi;


import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class CREJOBS implements Serializable {
    @Exclude
    private String key;
    private String title;
    private String description;
    private String name;
    private String possition;
    private String psotdate;

    public CREJOBS(){}
    public CREJOBS(String title, String description, String name, String possition, String psotdate) {
        this.title = title;
        this.description = description;
        this.name = name;
        this.possition = possition;
        this.psotdate = psotdate;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getPossition() {
        return possition;
    }

    public String getPsotdate() {
        return psotdate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPossition(String possition) {
        this.possition = possition;
    }

    public void setPsotdate(String psotdate) {
        this.psotdate = psotdate;
    }
}
