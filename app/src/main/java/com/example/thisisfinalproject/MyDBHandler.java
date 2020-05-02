package com.example.thisisfinalproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;


public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "studentDB.db";
    public static final String TABLE_NAME = "Course";
    public static final String COLUMN_NAME = "className";
  //  public static final MapsActivity COLUMN_LOCATION = "classLocation";
    public static final String COLUMN_ADDRESS = "streetAddress";
    public static final String COLUMN_CITY = "city";
    public static final String COLUMN_STATE = "state";
    public static final String COLUMN_ZIPCODE = "zipCode";
    public static final String COLUMN_DAYS = "daysOfWeek";
    public static final String COLUMN_TIME = "timeClass";
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE newsposts (\n" +
                "    className VARCHAR(255),\n" +
                "    streetAddress VARCHAR(255),\n" +
                "    city VARCHAR(1000),\n" +
                "    state VARCHAR(1000),\n" +
                "    zipCode VARCHAR(1000),\n" +
                "    daysOfWeek VARCHAR(1000),\n" +
                "    timeClass VARCHAR(1000)\n" +
                ");";
        db.execSQL(CREATE_TABLE);
    }
    public ArrayList<Course> load() {
        ArrayList<Course> courseList = new ArrayList<Course>();
        String query = "Select*FROM" + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {

                String className1 = cursor.getString(cursor.getColumnIndex("className"));
                String streetAddress1 = cursor.getString(cursor.getColumnIndex("streetAddress"));
                String city1 = cursor.getString(cursor.getColumnIndex("city"));
                String state1 = cursor.getString(cursor.getColumnIndex("state"));
                String zipCode1 = cursor.getString(cursor.getColumnIndex("zipCode"));
                String daysOfWeek1 = cursor.getString(cursor.getColumnIndex("daysOfWeek"));
                String timeClass1 = cursor.getString(cursor.getColumnIndex("timeClass"));
                Course course = new Course(className1, streetAddress1, city1, state1, zipCode1, daysOfWeek1, timeClass1);
                courseList.add(course);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return courseList;
    }

    public void add(Course course) {
        ContentValues arr = new ContentValues();
        arr.put(COLUMN_NAME, course.getName());
        arr.put(COLUMN_ADDRESS, course.getTheAddress());
        arr.put(COLUMN_CITY, course.getTheCity());
        arr.put(COLUMN_STATE, course.getTheState());
        arr.put(COLUMN_ZIPCODE, course.getTheZipCode());
        arr.put(COLUMN_DAYS, course.getDaysOfWeek());
        arr.put(COLUMN_TIME, course.getTimeClass());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

    public String loadHandler() {}
    public void addHandler(Course course) {}
    public Course findHandler(String studentname) {}
    public boolean deleteHandler(int ID) {}
    public boolean updateHandler(int ID, String name) {}
}
