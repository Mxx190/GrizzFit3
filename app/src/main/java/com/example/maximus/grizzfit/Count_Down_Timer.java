package com.example.maximus.grizzfit;

import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by Maximus on 4/9/2018.
 */

public class Count_Down_Timer {

    private long START_TIME_IN_MILLIS;
    private CountDownTimer goalCountDownTimer;
    public boolean TimerRunning = false;
    private long TimeLeftInMillis;
    private TextView goalTimer;

    public Count_Down_Timer(TextView textview){

        goalTimer = textview;

    }




    public void startTimer(){
        goalCountDownTimer = new CountDownTimer(TimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                TimeLeftInMillis = millisUntilFinished;
                updateCountDownText();

            }

            @Override
            public void onFinish() {
                TimerRunning = false;

            }
        }.start();
        TimerRunning = true;


    }

    public void pauseTimer(){
        goalCountDownTimer.cancel();
        TimerRunning = false;


    }

    public void resetTimer(){

        START_TIME_IN_MILLIS = 0;

        TimeLeftInMillis = START_TIME_IN_MILLIS;

        updateCountDownText();


    }

    public void updateCountDownText(){
        int days = (int) (TimeLeftInMillis / (1000*60*60*24));
        int hours   = (int) ((TimeLeftInMillis / (1000*60*60)) % 24);
        int minutes = (int) ((TimeLeftInMillis / (1000*60)) % 60);
        int seconds = (int) (TimeLeftInMillis / 1000) % 60 ;


        String timeLeftFormatted = String .format(Locale.getDefault(),"%02d:%02d:%02d:%02d", days, hours, minutes, seconds);


        goalTimer.setText(timeLeftFormatted);

        System.out.println(timeLeftFormatted);
    }

    public long updateNumberOfDays(long numDays){

        START_TIME_IN_MILLIS = numDays * 86400000;

        TimeLeftInMillis = START_TIME_IN_MILLIS;

        System.out.println("Time left in millis" + TimeLeftInMillis);



        return 0;

    }





}
