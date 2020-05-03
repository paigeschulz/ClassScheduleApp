package com.example.thisisfinalproject;

import java.util.ArrayList;
import 	java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.time.LocalTime;

public class TimerActivity {
    public ArrayList<Course> MW(ArrayList<Course> courseList) {

        ArrayList<Course> MWList = new ArrayList<Course>();
        for(int i=0; i < courseList.size(); i++) {
            if(courseList.get(i).getDaysOfWeek() == "Monday and Wednesday") {
                MWList.add(courseList.get(i));
            }
        }
        return MWList;
    }

    public ArrayList<Course> MWF(ArrayList<Course> courseList) {
        ArrayList<Course> MWFList = new ArrayList<Course>();
        for(int i=0; i < courseList.size(); i++) {
            if(courseList.get(i).getDaysOfWeek() == "Monday, Wednesday, Friday") {
                MWFList.add(courseList.get(i));
            }
        }
        return MWFList;
    }
    public ArrayList<Course> TT(ArrayList<Course> courseList) {


        ArrayList<Course> TTList = new ArrayList<Course>();
        for(int i=0; i < courseList.size(); i++) {
            if(courseList.get(i).getDaysOfWeek() == "Tuesday and Thursday") {
                TTList.add(courseList.get(i));
            }
        }
        return TTList;
    }

    public Course getNextCourse(ArrayList<Course> courseList) {


        Calendar myDate = Calendar.getInstance();
        int day = myDate.get (Calendar.DAY_OF_WEEK);
        ArrayList<Course> MonWed = this.MW(courseList);
        ArrayList<Course> MonWedFri = this.MWF(courseList);
        ArrayList<Course> TuesThurs = this.TT(courseList);
        Course nextCourse = new Course();

        LocalTime now = LocalTime.now();
        LocalTime timeOne = LocalTime.now();
        if (day == 2 || day == 1 || day == 7 || day == 4 || day == 6) {
            if (MonWed.size() != 0) {
                for (int i  = 0; i < MonWed.size(); i++) {
                    LocalTime time = LocalTime.parse(MonWed.get(i).getTimeClass());
                    boolean isAfter = now.isAfter(time);
                    boolean isBeforeTimeOne = timeOne.isBefore(time);
                    if (timeOne == now && isAfter == false) {
                        nextCourse = MonWed.get(i);
                        timeOne = time;

                    }
                    if (isAfter == false && isBeforeTimeOne == false) {
                        nextCourse = MonWed.get(i);
                        timeOne = time;
                    }

                }
            }
            if (MonWedFri.size() != 0) {
                for (int i  = 0; i < MonWed.size(); i++) {
                    LocalTime time = LocalTime.parse(MonWed.get(i).getTimeClass());
                    boolean isAfter = now.isAfter(time);
                    boolean isBeforeTimeOne = timeOne.isBefore(time);
                    if (timeOne == now && isAfter == false) {
                        nextCourse = MonWed.get(i);
                        timeOne = time;

                    }
                    if (isAfter == false && isBeforeTimeOne == false) {
                        nextCourse = MonWed.get(i);
                        timeOne = time;
                    }

                }
            }


            if (MonWed.size() == 0 && MonWedFri.size() == 0) {
            if (TuesThurs.size() != 0) {
                for (int i = 0; i < MonWed.size(); i++) {
                    LocalTime time = LocalTime.parse(MonWed.get(i).getTimeClass());
                    boolean isAfter = now.isAfter(time);
                    boolean isBeforeTimeOne = timeOne.isBefore(time);
                    if (timeOne == now && isAfter == false) {
                        nextCourse = MonWed.get(i);
                        timeOne = time;

                    }
                    if (isAfter == false && isBeforeTimeOne == false) {
                        nextCourse = MonWed.get(i);
                        timeOne = time;
                    }

                }
            }
        }

    }
        if (day == 3 && day == 5) {
            if (TuesThurs.size() != 0) {
                for (int i = 0; i < MonWed.size(); i++) {
                    LocalTime time = LocalTime.parse(MonWed.get(i).getTimeClass());
                    boolean isAfter = now.isAfter(time);
                    boolean isBeforeTimeOne = timeOne.isBefore(time);
                    if (timeOne == now && isAfter == false) {
                        nextCourse = MonWed.get(i);
                        timeOne = time;

                    }
                    if (isAfter == false && isBeforeTimeOne == false) {
                        nextCourse = MonWed.get(i);
                        timeOne = time;
                    }

                }
            }
            if (TuesThurs.size() == 0) {
                if (MonWed.size() != 0) {
                    for (int i = 0; i < MonWed.size(); i++) {
                        LocalTime time = LocalTime.parse(MonWed.get(i).getTimeClass());
                        boolean isAfter = now.isAfter(time);
                        boolean isBeforeTimeOne = timeOne.isBefore(time);
                        if (timeOne == now && isAfter == false) {
                            nextCourse = MonWed.get(i);
                            timeOne = time;

                        }
                        if (isAfter == false && isBeforeTimeOne == false) {
                            nextCourse = MonWed.get(i);
                            timeOne = time;
                        }

                    }
                }
            }
            if (MonWedFri.size() != 0) {
                for (int i = 0; i < MonWed.size(); i++) {
                    LocalTime time = LocalTime.parse(MonWed.get(i).getTimeClass());
                    boolean isAfter = now.isAfter(time);
                    boolean isBeforeTimeOne = timeOne.isBefore(time);
                    if (timeOne == now && isAfter == false) {
                        nextCourse = MonWed.get(i);
                        timeOne = time;

                    }
                }
            }
        }
        return nextCourse;
    }
    public String timeUntilCourse(ArrayList<Course> listCourses) {
        Course nextCourse = getNextCourse(listCourses);
        String nextCourseTime = nextCourse.getTimeClass();



    }


}
