package com.example.vinove.progressbar;

/*
* //Theory of Progress Bar
*
* Linear
* =======
*
* 4types
*
* 1. Determinate  // percentage
* 2. Indeterminate
* 3. Buffer
* 4. Query Indeterminate and Determinate
*
* Circular
* ========
* 1. Determinate
* 2. Indeterminate
*
* */

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Handler handler;
    Runnable runnable;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressBar = (ProgressBar) findViewById(R.id.progressBar_id);
        progressBar.setVisibility(View.VISIBLE);


        //
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                timer.cancel();
                progressBar.setVisibility(View.GONE);

            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                handler.post(runnable);
            }
        }, 5000, 1000);

        //delay specifies , after this much of delay our task(this run method) start execution

        // period arg means jo run (runnable object  run method )method mai code hai wo every
        // 1sec mai execute hoga
    }
}
