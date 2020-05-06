package com.example.thisisfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.EditText;
import android.widget.TextView;
import org.w3c.dom.Text;
import java.sql.Time;
import java.text.FieldPosition;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import 	java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.time.format.DateTimeFormatter;

public class CountDownActivity extends AppCompatActivity {
// or is it textView instead?
    EditText txtNumber1;
    TextView tv;
    long diff;
    long oldLong;
    long NewLong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        txtNumber1 = (EditText) findViewById(R.id.txtNumber1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);
        tv = new TextView(this);
        tv = new TextView(this);
        Calendar myDate = Calendar.getInstance();
        int day = myDate.get(Calendar.DAY_OF_WEEK);
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        ArrayList<Course> courseList = dbHandler.load();
        Course nextCourse = TimerActivity.getNextCourse(courseList);
        String nextCourseTime = nextCourse.getTimeClass();
        String courseDays = nextCourse.getDaysOfWeek();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd, HH:mm");

        // https://stackoverflow.com/questions/11875403/android-countdown-timer-to-date

        Date now = new Date();
        String nextCourseDate = getNextDate(day, courseDays, nextCourseTime);
        String nowTime = simpleDateFormat.format(now);
        Date oldDate, newDate;
        try {
            oldDate = simpleDateFormat.parse(nowTime);
            newDate = simpleDateFormat.parse(nextCourseDate);
            oldLong = oldDate.getTime();
            NewLong = newDate.getTime();
            diff = NewLong - oldLong;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        MyCount counter = new MyCount(diff, 1000);
        counter.start();





    }
    public class MyCount extends CountDownTimer {
        MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            txtNumber1.setText("done!");
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String hms = (TimeUnit.MILLISECONDS.toDays(millis)) + "Day "
                    + (TimeUnit.MILLISECONDS.toHours(millis) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(millis)) + ":")
                    + (TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)) + ":"
                    + (TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))));
            System.out.println(hms + " " + "this is hms");
            txtNumber1.setText(/*context.getString(R.string.ends_in) + " " +*/ hms);
        }
    }
    protected String getNextDate(int dayWeek, String courseDays, String courseTime) {
        if (dayWeek == 6) {
            if (courseDays == "Monday and Wednesday" || courseDays == "Monday, Wednesday, Friday") {
                Date date = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.DATE, 2);
                date = c.getTime();
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                String date2 = simpleDateFormat1.format(date);
                String reformatted = date2 + "," + " " + courseTime;
                return reformatted;

            }
            if (courseDays == "Tuesday and Thursday") {
                Date date = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.DATE, 3);
                date = c.getTime();
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                String date2 = simpleDateFormat1.format(date);
                String reformatted = date2 + "," + " " + courseTime;
                return reformatted;
            }

        }
        if (dayWeek == 7) {
            if (courseDays == "Monday and Wednesday" || courseDays == "Monday, Wednesday, Friday") {
                Date date = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.DATE, 1);
                date = c.getTime();
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                String date2 = simpleDateFormat1.format(date);
                String reformatted = date2 + "," + " " + courseTime;
                return reformatted;
            }
            if (courseDays == "Tuesday and Thursday") {
                Date date = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.DATE, 2);
                date = c.getTime();
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                String date2 = simpleDateFormat1.format(date);
                String reformatted = date2 + "," + " " + courseTime;
                return reformatted;
            }

        }
        if (dayWeek == 1) {
            if (courseDays == "Monday and Wednesday" || courseDays == "Monday, Wednesday, Friday") {
                LocalTime now = LocalTime.now();
                LocalTime time = LocalTime.parse(courseTime);
                boolean isAfter = now.isAfter(time);
               if (isAfter == false) {
                   Date date = new Date();
                   SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                   String date2 = simpleDateFormat1.format(date);
                   String reformatted = date2 + "," + " " + courseTime;
                   return reformatted;

               }
                Date date = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.DATE, 2);
                date = c.getTime();
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                String date2 = simpleDateFormat1.format(date);
                String reformatted = date2 + "," + " " + courseTime;
                return reformatted;
            }
            if (courseDays == "Tuesday and Thursday") {
                Date date = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.DATE, 1);
                date = c.getTime();
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                String date2 = simpleDateFormat1.format(date);
                String reformatted = date2 + "," + " " + courseTime;
                return reformatted;
            }


        }
        if (dayWeek == 2) {
            if (courseDays == "Tuesday and Thursday") {
                LocalTime now = LocalTime.now();
                LocalTime time = LocalTime.parse(courseTime);
                boolean isAfter = now.isAfter(time);
                if (isAfter == false) {
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                    String date2 = simpleDateFormat1.format(date);
                    String reformatted = date2 + "," + " " + courseTime;
                    return reformatted;

                }
                Date date = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.DATE, 2);
                date = c.getTime();
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                String date2 = simpleDateFormat1.format(date);
                String reformatted = date2 + "," + " " + courseTime;
                return reformatted;
            }
            if (courseDays == "Monday and Wednesday" || courseDays == "Monday, Wednesday, Friday") {
                Date date = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.DATE, 1);
                date = c.getTime();
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                String date2 = simpleDateFormat1.format(date);
                String reformatted = date2 + "," + " " + courseTime;
                return reformatted;
            }


        }
        if (dayWeek == 3) {
            if (courseDays == "Monday and Wednesday" || courseDays == "Monday, Wednesday, Friday") {
                LocalTime now = LocalTime.now();
                LocalTime time = LocalTime.parse(courseTime);
                boolean isAfter = now.isAfter(time);
                if (isAfter == false) {
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                    String date2 = simpleDateFormat1.format(date);
                    String reformatted = date2 + "," + " " + courseTime;
                    return reformatted;

                }
                Date date = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                if (courseDays == "Monday and Wednesday") {
                    c.add(Calendar.DATE, 5);
                    date = c.getTime();
                    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                    String date2 = simpleDateFormat1.format(date);
                    String reformatted = date2 + "," + " " + courseTime;
                    return reformatted;
                }
                c.add(Calendar.DATE, 2);
                date = c.getTime();
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                String date2 = simpleDateFormat1.format(date);
                String reformatted = date2 + "," + " " + courseTime;
                return reformatted;
            }
            if (courseDays == "Tuesday and Thursday") {
                Date date = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.DATE, 1);
                date = c.getTime();
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                String date2 = simpleDateFormat1.format(date);
                String reformatted = date2 + "," + " " + courseTime;
                return reformatted;
            }


        }
        if (dayWeek == 4) {
            if (courseDays == "Tuesday and Thursday") {
                LocalTime now = LocalTime.now();
                LocalTime time = LocalTime.parse(courseTime);
                boolean isAfter = now.isAfter(time);
                if (isAfter == false) {
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                    String date2 = simpleDateFormat1.format(date);
                    String reformatted = date2 + "," + " " + courseTime;
                    return reformatted;

                }
                Date date = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.DATE, 5);
                date = c.getTime();
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                String date2 = simpleDateFormat1.format(date);
                String reformatted = date2 + "," + " " + courseTime;
                return reformatted;
            }
            if (courseDays == "Monday, Wednesday, Friday") {
                Date date = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.DATE, 1);
                date = c.getTime();
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                String date2 = simpleDateFormat1.format(date);
                String reformatted = date2 + "," + " " + courseTime;
                return reformatted;
            }
            if (courseDays == "Monday and Wednesday") {
                Date date = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.DATE, 4);
                date = c.getTime();
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                String date2 = simpleDateFormat1.format(date);
                String reformatted = date2 + "," + " " + courseTime;
                return reformatted;
            }


        }
        if (dayWeek == 5) {
            if (courseDays ==  "Monday, Wednesday, Friday") {
                LocalTime now = LocalTime.now();
                LocalTime time = LocalTime.parse(courseTime);
                boolean isAfter = now.isAfter(time);
                if (isAfter == true) {
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                    String date2 = simpleDateFormat1.format(date);
                    String reformatted = date2 + "," + " " + courseTime;
                    return reformatted;

                }
                Date date = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.DATE, 3);
                date = c.getTime();
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                String date2 = simpleDateFormat1.format(date);
                String reformatted = date2 + "," + " " + courseTime;
                return reformatted;
            }
            if (courseDays == "Tuesday and Thursday") {
                Date date = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.DATE, 4);
                date = c.getTime();
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                String date2 = simpleDateFormat1.format(date);
                String reformatted = date2 + "," + " " + courseTime;
                return reformatted;
            }


        }
        return "";




    }


}
