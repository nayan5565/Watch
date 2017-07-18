package com.example.nayan.timehandler;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int count = 10, sec, min, hour, day;
    private TextView txtSec, txtDay, txtCount;
    private String s, m, h;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        counter();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                for (int i=10;i>=0;i--){
//                    txtCount.setText(i+"");
//                }
//            }
//        },100);

        change();


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
//                if (min==10){
//                    Toast.makeText(MainActivity.this,"holiday",Toast.LENGTH_LONG).show();
//                }
                counter();

            }
        }, 1000);
    }

    private void init() {
        handler = new Handler();
        txtSec = (TextView) findViewById(R.id.txtSec);
        txtDay = (TextView) findViewById(R.id.txtDay);
        txtCount = (TextView) findViewById(R.id.txtCount);
    }

    public void change() {
        count--;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (count == -1) {
                    count=10;

                }
                txtCount.setText(count + "");
                change();
            }
        }, 100);

    }

}
