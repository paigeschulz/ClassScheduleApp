package com.example.thisisfinalproject;

public class Course {
    private String className;
    private MapsActivity classLocation;
    private String daysOfWeek;
    private String timeClass;
    public Course() {}
    public Course(String name, MapsActivity location, String days, String time) {
        this.className = name;
        this.classLocation = location;
        this.daysOfWeek = days;
        this.timeClass = time;
    }
    public void setName(String name) {
        this.className = name;
    }
    public String getName() {
        return this.className;
    }
    public void setLocation(MapsActivity location) {
        this.classLocation = location;
    }
    public MapsActivity getLocation() {
        return this.classLocation;
    }
    public void setDaysOfWeek(String days) {
        this.daysOfWeek = days;
    }
    public String getDaysOfWeek() {
        return this.daysOfWeek;
    }
    public void setTimeClass(String time) {
        this.timeClass = time;
    }
    public String getTimeClass() {
        return this.timeClass;
    }


}
