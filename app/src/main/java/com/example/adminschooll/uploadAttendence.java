package com.example.adminschooll;

public class uploadAttendence{
    public String name;
    public String url;

    public uploadAttendence() {
    }

    public uploadAttendence(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }


    public String getUrl() {
        return url;
    }

}
