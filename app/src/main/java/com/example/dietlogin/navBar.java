package com.example.dietlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Random;

public class navBar extends AppCompatActivity {

    ImageButton bmi_button, calorie_button, tips_button;
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_bar);

        dl = (DrawerLayout) findViewById(R.id.drawer);
        abdt = new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();
        final String tips[] = {"Eat a healthy diet","Consume less salt and sugar","Reduce intake of harmful fats",
        "Avoid harmful use of alcohol","Don’t smoke","Check your blood pressure regularly","Get vaccinated",
                "Cover your mouth when coughing or sneezing","Prevent mosquito bites","Drink only safe water",
                "Talk to someone you trust if you're feeling down","Take antibiotics only as prescribed",
        "Clean your hands properly","Have regular check-ups"};
        Random random = new Random();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final NavigationView nav_view = (NavigationView)findViewById(R.id.nav_View);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.item1) {
                    Toast.makeText(navBar.this,"MyProfile",Toast.LENGTH_SHORT);
                }
                else if (id == R.id.item2) {
                    Toast.makeText(navBar.this,"EditProfile",Toast.LENGTH_SHORT);
                }
                else if (id == R.id.item3) {
                    Toast.makeText(navBar.this,"Settings",Toast.LENGTH_SHORT);
                }
                return true;
            }
        });

        bmi_button = findViewById(R.id.imageButton4);
        bmi_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),bmii.class);
                startActivity(intent);

            }
        });

        calorie_button = findViewById(R.id.imageButton3);
        calorie_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),calorie.class);
                startActivity(intent);
            }
        });
        tips_button = findViewById(R.id.imageButton2);
        tips_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = random.nextInt(tips.length);
                Toast.makeText(getApplicationContext(),tips[index],Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}