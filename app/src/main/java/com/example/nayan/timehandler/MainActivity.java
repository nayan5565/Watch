package com.example.nayan.timehandler;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int count = 0, sec, min = 50, hour = 20, day;
    private TextView txtSec, txtDay;
    private String s, m, h;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        counter();


    }

    private void counter() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                sec++;

                if (sec == 60) {
                    sec = 0;
                    min++;
                }
                if (min == 60) {
                    min = 0;
                    hour++;
                }
                if (hour == 24) {
                    hour = 0;
                    day++;
                }
                if (sec <= 9) {
                    s = "0" + sec;
                } else {
                    s = sec + "";
                }


                if (min <= 9) {
                    m = "0" + min;
                } else {
                    m = "" + min;
                }
                if (hour <= 9) {
                    h = "0" + hour;
                } else {
                    h = "" + hour;
                }

                txtSec.setText(s + ":" + m + ":" + h);
                txtDay.setText(day + "");

                counter();

            }
        }, 10);
    }

    private void init() {
        handler = new Handler();
        txtSec = (TextView) findViewById(R.id.txtSec);
        txtDay = (TextView) findViewById(R.id.txtDay);
    }
}
