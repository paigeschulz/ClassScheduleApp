package com.example.thisisfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;


public class FormActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(FormActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.time));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        Spinner mySpin = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> myAdapt = new ArrayAdapter<String>(FormActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.time2));
        myAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpin.setAdapter(myAdapt);

        Spinner spin = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(FormActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.time3));
        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapt);

        Spinner daysSpin = (Spinner) findViewById(R.id.daysSpinner);
        ArrayAdapter<String> daysAdapt = new ArrayAdapter<String>(FormActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.daysSpinner));
        daysAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daysSpin.setAdapter(daysAdapt);

        Button name;
        name = (Button) findViewById(R.id.addClass);
        name.setOnClickListener(this);

        Button name2;
        name = (Button) findViewById(R.id.buttonFinish);
        name.setOnClickListener(this);

    }
    public void onClick(View view) {
        Spinner hour = (Spinner) findViewById(R.id.spinner);
        Spinner minute =  (Spinner) findViewById(R.id.spinner2);
        Spinner amPM = (Spinner) findViewById(R.id.spinner3);
        String time = hour.getSelectedItem().toString() + ":" + minute.getSelectedItem().toString() + " " + amPM.getSelectedItem().toString();
        EditText nameClass = (EditText) findViewById(R.id.name);
        EditText streetAddress = (EditText) findViewById(R.id.Address);
        EditText city = (EditText) findViewById(R.id.Address2);
        EditText state = (EditText) findViewById(R.id.Address3);
        EditText zipCode = (EditText) findViewById(R.id.Address4);
        Spinner daysWeek = (Spinner) findViewById(R.id.daysSpinner);
        String daysConverted = daysWeek.getSelectedItem().toString();
        try {
            SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
            SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
            Date date = parseFormat.parse(time);
            DateFormat dateFormat = new SimpleDateFormat("HH:mm");
            String strDate = dateFormat.format(date);
            MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
            // I dont need this right?

            String name = nameClass.getText().toString();
            String address = streetAddress.getText().toString();
            String city2 = city.getText().toString();
            String state2 = state.getText().toString();
            String zipCode2 = zipCode.getText().toString();
            String days = daysConverted;

            Course course = new Course(name, address, city2, state2, zipCode2, days, strDate);
            dbHandler.add(course);
        } catch (java.text.ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


}
