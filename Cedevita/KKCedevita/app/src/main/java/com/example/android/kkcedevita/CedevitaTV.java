package com.example.android.kkcedevita;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by denis on 20/02/2017.
 */

public class CedevitaTV extends Fragment {

    View myview;
    WebView webView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.cedevita_tv_layout , container, false);

        webView = (WebView)myview.findViewById(R.id.webviewYoutube);
        webView.loadUrl("https://www.youtube.com/watch?v=lfVNY4k-aPI&list=PLcjmBAkhZny44Q5p-3zKcTkr_bsHaj9GK");

        return myview;
    }
}
