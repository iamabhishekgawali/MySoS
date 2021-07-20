package com.example.disastermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.net.PlacesClient;

public class map_place extends AppCompatActivity {

    Places places;
    PlacesClient placesClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_place);
        Places.initialize(getApplicationContext(),"AIzaSyDDWHtUOy7DSfAkYc4M44utd0yesgN73Ow");
        placesClient = Places.createClient(this);
    }
}
