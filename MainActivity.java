package com.gametime.acm.gametime;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    //all the button vars
    private Button mStartButton;
    private Button mResetButton;
    private Button mPauseButton;
    private Button mSaveButton;

    //chronometer widget var
    private android.widget.Chronometer mChronometer;

    //keeps track of the last puase
    private long lastPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //importing all the vars from xml buttons etc
        mStartButton = (Button) findViewById(R.id.startButton);
        mPauseButton = (Button) findViewById(R.id.pauseButton);
        mResetButton = (Button) findViewById(R.id.resetButton);
        mSaveButton = (Button) findViewById(R.id.saveButton);
        mChronometer = (Chronometer) findViewById(R.id.chronometer);

        //start button
        mStartButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(lastPause != 0){
                    mChronometer.setBase(mChronometer.getBase()+SystemClock.elapsedRealtime()-lastPause);
                }
                else{
                    mChronometer.setBase(SystemClock.elapsedRealtime());
                }

                mChronometer.start();
                mStartButton.setEnabled(false);
                mPauseButton.setEnabled(true);
            }
        });
        //pause button
        mPauseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                lastPause = SystemClock.elapsedRealtime();
                mChronometer.stop();
                mPauseButton.setEnabled(false);
                mStartButton.setEnabled(true);
            }
        });

        //reset button
        mResetButton.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view){
               mChronometer.stop();
               mChronometer.setBase(SystemClock.elapsedRealtime());
               lastPause = 0;
               mStartButton.setEnabled(true);
               mPauseButton.setEnabled(false);
           }
        });

        //save button
        mSaveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //add code here
                mSaveButton.setEnabled(true);
            }
        });

    }
}
