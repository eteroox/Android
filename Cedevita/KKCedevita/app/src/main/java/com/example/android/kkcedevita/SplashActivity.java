package com.example.android.kkcedevita;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by denis on 15/02/2017.
 */

public class SplashActivity extends AppCompatActivity {


    private static String TAG = SplashActivity.class.getName();
    private static long SLEEP_TIME = 4;    // Sleep for some time
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);    // Removes title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,     WindowManager.LayoutParams.FLAG_FULLSCREEN);    // Removes notification bar

        mp = MediaPlayer.create(this, R.raw.basket);

        setContentView(R.layout.splash_layout);

        // Start timer and launch main activity
        IntentLauncher launcher = new IntentLauncher();
        launcher.start();
    }

    private class IntentLauncher extends Thread {
        @Override

        public void run() {
            try {
                // Sleeping
                mp.start();
                Thread.sleep(SLEEP_TIME*1000);
                mp.stop();
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }

            // Start main activity
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            SplashActivity.this.startActivity(intent);
            SplashActivity.this.finish();
        }
    }

}
