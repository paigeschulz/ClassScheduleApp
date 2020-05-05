package com.example.thisisfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
// package com.example.thisisfinalproject;

import android.widget.Button;
//package example.abhiandriod.buttonexample;


//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonListenerActivity extends AppCompatActivity {

    Button simpleButton1, simpleButton2, simpleButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_listener);
        simpleButton1 = (Button) findViewById(R.id.simpleButton1);
        simpleButton2 = (Button) findViewById(R.id.simpleButton2);
        simpleButton3 = (Button) findViewById(R.id.simpleButton3);


        simpleButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Simple Button 1", Toast.LENGTH_LONG).show();//display the text of button1
                Intent intent = new Intent(view.getContext(), FormActivity.class);
                startActivity(intent);
            }
        });
        simpleButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Simple Button 2", Toast.LENGTH_LONG).show();//display the text of button2
                Intent intent = new Intent(view.getContext(), MapsActivity.class);
                startActivity(intent);

            }
            // this is for clicking the button and taking you to google maps!


        });
        simpleButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Simple Button 3", Toast.LENGTH_LONG).show();//display the text of button2
                Intent intent = new Intent(view.getContext(), CountDownActivity.class);
                startActivity(intent);

            }
        });
    }
}