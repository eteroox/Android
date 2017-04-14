package com.example.android.kkcedevita;

/**
 * Created by denis on 13/02/2017.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DisplayFragmentNovosti extends Fragment {

    View myview;

    DisplayFragmentNovosti newInstance(int position) {
        DisplayFragmentNovosti frag=new DisplayFragmentNovosti();
        return(frag);
    }

    static String getTitle(Context ctxt, int position) {
        return("Žalosni zbog incidenta ");
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.novosti_pagger, container, false);
        return myview;
    }
}

