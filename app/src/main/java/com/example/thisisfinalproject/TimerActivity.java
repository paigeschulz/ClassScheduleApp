package com.example.thisisfinalproject;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Time;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import 	java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.time.format.DateTimeFormatter;

public class TimerActivity {
    public static ArrayList<Course> MW(ArrayList<Course> courseList) {

        ArrayList<Course> MWList = new ArrayList<Course>();
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getDaysOfWeek() == "Monday and Wednesday") {
                MWList.add(courseList.get(i));
            }
        }
        return MWList;
    }

    public static ArrayList<Course> MWF(ArrayList<Course> courseList) {
        ArrayList<Course> MWFList = new ArrayList<Course>();
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getDaysOfWeek() == "Monday, Wednesday, Friday") {
                MWFList.add(courseList.get(i));
            }
        }
        return MWFList;
    }

    public static ArrayList<Course> TT(ArrayList<Course> courseList) {


        ArrayList<Course> TTList = new ArrayList<Course>();
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getDaysOfWeek() == "Tuesday and Thursday") {
                TTList.add(courseList.get(i));
            }
        }
        return TTList;
    }

    public static Course getNextCourse(ArrayList<Course> courseList) {


        Calendar myDate = Calendar.getInstance();
        int day = myDate.get(Calendar.DAY_OF_WEEK);
        ArrayList<Course> MonWed = MW(courseList);
        ArrayList<Course> MonWedFri = MWF(courseList);
        ArrayList<Course> TuesThurs = TT(courseList);
        Course nextCourse = new Course();

        LocalTime now = LocalTime.now();
        LocalTime timeOne = LocalTime.now();
        if (day == 2 || day == 1 || day == 7 || day == 4 || day == 6) {
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
            if (MonWedFri.size() != 0) {
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
                for (int i = 0; i < TuesThurs.size(); i++) {
                    LocalTime time = LocalTime.parse(TuesThurs.get(i).getTimeClass());
                    boolean isAfter = now.isAfter(time);
                    boolean isBeforeTimeOne = timeOne.isBefore(time);
                    if (timeOne == now && isAfter == false) {
                        nextCourse = TuesThurs.get(i);
                        timeOne = time;

                    }
                    if (isAfter == false && isBeforeTimeOne == false) {
                        nextCourse = TuesThurs.get(i);
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
}

  /**  public static String timeUntilCourse(ArrayList<Course> listCourses) {
        Course nextCourse = getNextCourse(listCourses);
        String nextCourseTime = nextCourse.getTimeClass();
        ArrayList<Course> MonWed = this.MW(listCourses);
        ArrayList<Course> MonWedFri = this.MWF(listCourses);
        ArrayList<Course> TuesThurs = this.TT(listCourses);
        Calendar myDate = Calendar.getInstance();
        int day = myDate.get(Calendar.DAY_OF_WEEK);
       // LocalTime now = LocalTime.now();
        //new code
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime now = LocalDateTime.now();




} **/
