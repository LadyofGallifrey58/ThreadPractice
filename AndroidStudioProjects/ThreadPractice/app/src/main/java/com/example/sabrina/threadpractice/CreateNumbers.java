package com.example.sabrina.threadpractice;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateNumbers extends AppCompatActivity implements AsyncTask<String, Integer, String> {
    @Override
    protected Object doInBackground(String... params) {
        File file = new File(getApplicationContext().getFilesDir(), params[0]);
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            for (int i = 1; i <= 10; i++) {
                try {
                    out.write(i);
                    out.newLine();
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return params[0]; //name of file
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        // no updates...
    }

    @Override
    protected void onPostExecute(String s) {

    }
}