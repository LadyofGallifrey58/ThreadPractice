package com.example.sabrina.favoritescripture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView resultTxtView = (TextView) findViewById(R.id.ResultTxtView);
        String favScripture = getIntent().getStringExtra("favScripture");
        resultTxtView.setText(favScripture);
    }

}
