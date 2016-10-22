package com.example.sabrina.threadpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

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
                File file = new File(getApplicationContext().getFilesDir(), "numbers.txt");
                BufferedWriter out = new BufferedWriter(new FileWriter(file));
                for (int i = 1; i <= 10; i++) {
                    try {
                        out.write(i);
                        out.newLine();
                        Thread.sleep(250);
                    }
                    catch(IOException ex){
                        ex.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
