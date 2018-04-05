package com.fragmentspart1.joeynelson.fragmentspart1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String ULTIMATE_PERMISSION = "ultimate.permission.joey" ;
    private static final String ATTRACTIONS_INTENT = "attractions.intent.joey";
    private static final String RESTAURANTS_INTENT = "restaurants.intent.joey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAttractions = findViewById(R.id.btnAttractions);
        Button btnRestaurants = findViewById(R.id.btnRestaurants);

        btnAttractions.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                requestPermissionAndFindAttractions();
            }
        });

        btnRestaurants.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                requestPermissionAndFindRestaurants();
            }
        });
    }

    private void requestPermissionAndFindAttractions() {
        if (ContextCompat.checkSelfPermission(this, ULTIMATE_PERMISSION)
                == PackageManager.PERMISSION_GRANTED) {
            Intent aIntent = new Intent(ATTRACTIONS_INTENT) ;
            Toast.makeText(MainActivity.this, "Attractions in action! ",
                    Toast.LENGTH_LONG).show() ;
            sendBroadcast(aIntent) ;
        }
        else{
            ActivityCompat.requestPermissions(this, new String[]{ULTIMATE_PERMISSION}, 1) ;
        }
    }

    private void requestPermissionAndFindRestaurants() {
        if (ContextCompat.checkSelfPermission(this, ULTIMATE_PERMISSION)
                == PackageManager.PERMISSION_GRANTED) {
            Intent rIntent = new Intent(RESTAURANTS_INTENT) ;
            Toast.makeText(MainActivity.this, "Restaurants in action! ",
                    Toast.LENGTH_LONG).show() ;
            sendBroadcast(rIntent) ;
        }
        else{
            ActivityCompat.requestPermissions(this, new String[]{ULTIMATE_PERMISSION}, 2) ;
        }
    }

    public void onRequestPermissionsResult(int code, String[] permissions, int[] results) {
        if (results.length > 0) {
            if (results[0] == PackageManager.PERMISSION_GRANTED) {
                if(code == 1){
                    Intent aIntent = new Intent(ATTRACTIONS_INTENT) ;
                    Toast.makeText(MainActivity.this, "Attractions in action! ",
                            Toast.LENGTH_LONG).show() ;
                    sendBroadcast(aIntent) ;
                }
                if(code == 2){
                    Intent rIntent = new Intent(RESTAURANTS_INTENT) ;
                    Toast.makeText(MainActivity.this, "Restaurants in action! ",
                            Toast.LENGTH_LONG).show() ;
                    sendBroadcast(rIntent) ;
                }
            }
            else {
                Toast.makeText(this, "Permission Denied!", Toast.LENGTH_SHORT) ;
            }
        }
    }
}
