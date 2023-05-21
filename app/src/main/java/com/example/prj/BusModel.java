package com.example.prj;

public class BusModel {
    String busName;
    String time;

    public BusModel(String busName, String time) {
        this.busName = busName;
        this.time = time;
    }

    public String getBusName() {
        return busName;
    }

    public String getTime() {
        return time;
    }
}
