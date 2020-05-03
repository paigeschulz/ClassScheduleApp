package com.example.thisisfinalproject;

import java.util.ArrayList;
import 	java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

public class TimerActivity {
    public ArrayList<Course> MW() {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        ArrayList<Course> courseList = dbHandler.load();
        ArrayList<Course> MWList = new ArrayList<Course>();
        for(int i=0; i < courseList.size(); i++) {
            if(courseList.get(i).getDaysOfWeek() == "Monday and Wednesday") {
                MWList.add(courseList.get(i));
            }
        }
        return MWList;
    }
    public ArrayList<Course> Monday() {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        ArrayList<Course> courseList = dbHandler.load();
        ArrayList<Course> MondayList = new ArrayList<Course>();
        for(int i=0; i < courseList.size(); i++) {
            if(courseList.get(i).getDaysOfWeek() == "Monday") {
                MondayList.add(courseList.get(i));
            }
        }
        return MondayList;
    }
    public ArrayList<Course> Tuesday() {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        ArrayList<Course> courseList = dbHandler.load();
        ArrayList<Course> TuesdayList = new ArrayList<Course>();
        for(int i=0; i < courseList.size(); i++) {
            if(courseList.get(i).getDaysOfWeek() == "Tuesday") {
                TuesdayList.add(courseList.get(i));
            }
        }
        return TuesdayList;
    }
    public ArrayList<Course> Wednesday() {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        ArrayList<Course> courseList = dbHandler.load();
        ArrayList<Course> WednesdayList = new ArrayList<Course>();
        for(int i=0; i < courseList.size(); i++) {
            if(courseList.get(i).getDaysOfWeek() == "Wednesday") {
                WednesdayList.add(courseList.get(i));
            }
        }
        return WednesdayList;
    }
    public ArrayList<Course> Thursday() {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        ArrayList<Course> courseList = dbHandler.load();
        ArrayList<Course> ThursdayList = new ArrayList<Course>();
        for(int i=0; i < courseList.size(); i++) {
            if(courseList.get(i).getDaysOfWeek() == "Thursday") {
                ThursdayList.add(courseList.get(i));
            }
        }
        return ThursdayList;
    }
    public ArrayList<Course> Friday() {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        ArrayList<Course> courseList = dbHandler.load();
        ArrayList<Course> FridayList = new ArrayList<Course>();
        for(int i=0; i < courseList.size(); i++) {
            if(courseList.get(i).getDaysOfWeek() == "Friday") {
                FridayList.add(courseList.get(i));
            }
        }
        return FridayList;
    }
    public ArrayList<Course> MWF() {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        ArrayList<Course> courseList = dbHandler.load();
        ArrayList<Course> MWFList = new ArrayList<Course>();
        for(int i=0; i < courseList.size(); i++) {
            if(courseList.get(i).getDaysOfWeek() == "Monday, Wednesday, Friday") {
                MWFList.add(courseList.get(i));
            }
        }
        return MWFList;
    }
    public ArrayList<Course> TT() {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        ArrayList<Course> courseList = dbHandler.load();
        ArrayList<Course> TTList = new ArrayList<Course>();
        for(int i=0; i < courseList.size(); i++) {
            if(courseList.get(i).getDaysOfWeek() == "Tuesday and Thursday") {
                TTList.add(courseList.get(i));
            }
        }
        return TTList;
    }

    public Course getNextCourse() {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        ArrayList<Course> courseList = dbHandler.load();
        Calendar myDate = Calendar.getInstance();
        int day = myDate.get (Calendar.DAY_OF_WEEK);
        ArrayList<Course> MonWed = this.MW();
        ArrayList<Course> Mon = this.Monday();
        ArrayList<Course> Tues = this.Tuesday();
        ArrayList<Course> Wed = this.Wednesday();
        ArrayList<Course> Thurs = this.Thursday();
        ArrayList<Course> Fri = this.Friday();
        ArrayList<Course> MonWedFri = this.MWF();
        ArrayList<Course> TuesThurs = this.TT();
        Course nextCourse = new Course();
        if(day == 1 || day == 7) {

        }
    }
}
