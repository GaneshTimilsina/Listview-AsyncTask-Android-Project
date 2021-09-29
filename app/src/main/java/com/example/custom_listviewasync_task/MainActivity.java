package com.example.custom_listviewasync_task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Button hotelManagement_Bth, dispayData_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        hotelManagement_Bth = (Button) findViewById(R.id.hotelmanagement);
        dispayData_Btn = (Button) findViewById(R.id.displaydata);

        toolbar.setTitle("CA Project");  //Setting the title of Toolbar
        toolbar.setSubtitle("CustomListView & Async");
        setSupportActionBar(toolbar);

        hotelManagement_Bth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,P1ListViewIndianRestaurant.class));

            }
        });
        dispayData_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        dispayData_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, P2DisplayData.class));
            }
        });



    }
}