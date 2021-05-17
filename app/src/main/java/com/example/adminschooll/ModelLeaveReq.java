package com.example.adminschooll;

public class ModelLeaveReq {
    String Name, Id, Leave, Days;

    public ModelLeaveReq(String name, String id, String leave, String days) {
        Name = name;
        Id = id;
        Leave = leave;
        Days = days;
    }
public ModelLeaveReq(){}
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getLeave() {
        return Leave;
    }

    public void setLeave(String leave) {
        Leave = leave;
    }

    public String getDays() {
        return Days;
    }

    public void setDays(String days) {
        Days = days;
    }
}