package com.tashi.wearables;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.wearable.activity.WearableActivity;

public class SplashScreen extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent openHome = new Intent( SplashScreen.this, MainActivity.class);
                startActivity(openHome);
                finish();
            }
        },2000);


    }
}
