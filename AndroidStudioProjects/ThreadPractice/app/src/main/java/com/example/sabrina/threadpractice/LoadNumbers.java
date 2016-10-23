package com.example.sabrina.threadpractice;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadNumbers extends AppCompatActivity implements AsyncTask<Boolean,Integer,Boolean> {
    ArrayAdapter<String> numAdapter;
    ListView listView;
    @Override
    protected Object doInBackground(Boolean...param) {
        boolean clear = param[0];

        listView = (ListView) findViewById(R.id.numDisplay);

        List<String> numbers= new ArrayList<>();
        numAdapter = new ArrayAdapter<>(getApplicationContext(), R.id.numDisplay, numbers);

        while (!clear) { //are we clearing the page?
            try {
                BufferedReader in = new BufferedReader(new FileReader("numbers.txt"));
                String temp;
                int i = 0;
                while ((temp = in.readLine()) != null) {
                    numbers.add(temp);
                    publishProgress(i);
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return param;
        }

        return param; //maybe

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        listView.setAdapter(numAdapter); //show updated list?
    }

    @Override
    protected void onPostExecute(boolean aBoolean) {
        if (aBoolean == true) {
            numAdapter.clear();
        }
    }
}
