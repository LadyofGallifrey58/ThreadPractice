package com.example.sabrina.threadpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;


public class MainActivity extends AppCompatActivity {
    File file;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createBtn = (Button) findViewById(R.id.create);
        Button loadBtn = (Button) findViewById(R.id.load);
        Button clearBtn = (Button) findViewById(R.id.clear);

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateNumbers createNumbers = new CreateNumbers();
                createNumbers.execute("numbers.txt");
            }
        });

        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadNumbers loadNumbers = new LoadNumbers();
                loadNumbers.execute(false); //not clear
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadNumbers loadNumbers = new LoadNumbers();
                loadNumbers.execute(true); //clear the screen?
            }
        });

    }


}