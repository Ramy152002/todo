package com.ramy.Todoro;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class Pomodoro extends AppCompatActivity {

    private static final long START_TIME_IN_MILLIS = 600000;
    public long lefttime = START_TIME_IN_MILLIS;
    public boolean timeRunning = true;
 private CountDownTimer countdowntimer;
    TextView counter =findViewById(R.id.counter);
   Button Start = findViewById(R.id.start);

   Button Reset = findViewById(R.id.Reset);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pomodoro2);

        counter =findViewById(R.id.counter);
        Start = findViewById(R.id.start);
        Reset = findViewById(R.id.Reset);



        Start.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

           if(timeRunning)PauseTime();
           else StartTime();


         }
     }
        );

      Reset.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              ResetTime();
          }
      });
            updateCountDownText();
    }

    private void StartTime(){
        countdowntimer = new CountDownTimer(lefttime,1000) {
            @Override
            public void onTick(long l) {
                 lefttime = l;
              updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeRunning= false;
                Start.setText(R.string.start);
                Start.setVisibility(View.INVISIBLE);
                Reset.setVisibility(View.VISIBLE);

            }
        }.start();
        timeRunning =true;

         Start.setText(R.string.pause);
         Reset.setVisibility(View.INVISIBLE);

    }
    private void PauseTime(){
        countdowntimer.cancel();
        timeRunning= false;
        Start.setText(R.string.start);
        Reset.setVisibility(View.VISIBLE);
    }
    private void ResetTime(){

        lefttime = START_TIME_IN_MILLIS;
        Reset.setVisibility(View.INVISIBLE);
        Start.setVisibility(View.VISIBLE);
        updateCountDownText();

    }




    private void updateCountDownText(){

        int minutes = (int) (lefttime  /1000)/60;
        int seconds = (int) (lefttime /1000) % 60;

        String lifetimeFormat = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        counter.setText(lifetimeFormat);
    }
}