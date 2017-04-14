package com.example.android.kkcedevita;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by denis on 15/02/2017.
 */

public class Karte extends Fragment {

    View myview;
    WebView webView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.karte_layout, container , false);

        webView = (WebView)myview.findViewById(R.id.webviewKarte);
        webView.loadUrl("http://www.eventim.hr/hr/ulaznice/kk-cedevita-zagreb-dom-sportova-410827/event.html?co=hrv&cm=3");

        return myview;
    }
}
