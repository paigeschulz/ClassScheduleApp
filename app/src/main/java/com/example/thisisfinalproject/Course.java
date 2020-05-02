package com.example.thisisfinalproject;

public class Course {
    private String className;
    private MapsActivity classLocation;
    private String daysOfWeek;
    private String timeClass;
    private String theAddress;
    private String theCity;
    private String theState;
    private String theZipCode;
    public Course() {}
    public Course(String name, String address, String city, String State, String zipCode, String days, String time) {
        this.className = name;
        this.theAddress = address;
        this.theCity = city;
        this.theState = State;
        this.theZipCode = zipCode;
        this.daysOfWeek = days;
        this.timeClass = time;
    }
    public void setName(String name) {
        this.className = name;
    }
    public String getName() {
        return this.className;
    }
    public void setAddress(String address) {
        this.theAddress = address;
    }
    public String getTheAddress() {
        return this.theAddress;
    }
    public void setCity(String city) {
        this.theCity = city;
    }
    public String getTheCity() {
        return this.theCity;
    }
    public void setTheState(String state) {
        this.theState = state;
    }
    public String getTheState() {
        return this.theState;
    }
    public void setTheZipCode(String zipCode) {
        this.theZipCode = zipCode;
    }
    public String getTheZipCode() {
        return this.theZipCode;
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
