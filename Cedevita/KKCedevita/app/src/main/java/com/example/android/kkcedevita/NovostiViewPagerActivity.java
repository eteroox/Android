package com.example.android.kkcedevita;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by denis on 13/02/2017.
 */

public class NovostiViewPagerActivity extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportFragmentManager().findFragmentById(android.R.id.content) == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content,
                            new Novosti()).commit();
        }
    }
}