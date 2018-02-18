package com.ruatech.sanikamal.activitylifecycleexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String MAIN_ACTIVITY_TAG=MainActivity.class.getSimpleName();

    private void showLog(String text){
        Log.d(MAIN_ACTIVITY_TAG,text);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showLog("Activity Created!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();  //call to restart after onStop
        showLog("Activity Restarted!");
    }

    @Override
    protected void onStart() {
        super.onStart();    //soon be visible
        showLog("Activity Started!");
    }

    @Override
    protected void onResume() {
        super.onResume();   //visible
        showLog("Activity Resumed!");
    }

    @Override
    protected void onPause() {
        super.onPause(); //invisible
        showLog("Activity Paused!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showLog("Activity Stoped!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showLog("Activity Destroyed!");
    }
}
