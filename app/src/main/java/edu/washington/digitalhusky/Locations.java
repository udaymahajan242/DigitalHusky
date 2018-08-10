package edu.washington.digitalhusky;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class Locations extends AppCompatActivity {

    Toolbar toolbar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);

        toolbar = (Toolbar) findViewById(R.id.toolbarStores);
        toolbar.setTitle("Favorite Stores");


    }
}