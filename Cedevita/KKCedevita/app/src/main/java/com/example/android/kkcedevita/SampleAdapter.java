package com.example.android.kkcedevita;

/**
 * Created by denis on 13/02/2017.
 */

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.TextView;

//adapter za novosti

public class SampleAdapter extends FragmentPagerAdapter {
    Context ctxt=null;
    TextView textFragment;

    public SampleAdapter(Context ctxt, FragmentManager mgr) {
        super(mgr);
        this.ctxt=ctxt;
    }

    @Override
    public int getCount() {
        return(3);
    }

    @Override
    public Fragment getItem(int position) {
        DisplayFragmentNovosti displayFragmentNovosti = new DisplayFragmentNovosti();
        DisplayFragmentNovosti2 displayFragmentNovosti2 = new DisplayFragmentNovosti2();
        DisplayFragmentNovosti3 displayFragmentNovosti3 = new DisplayFragmentNovosti3();
        switch(position) {

            case 0: return displayFragmentNovosti.newInstance(position);
            case 1: return displayFragmentNovosti2.newInstance(position);
            case 2: return displayFragmentNovosti3.newInstance(position);
            default: return displayFragmentNovosti.newInstance(position);
        }
    }

    @Override
    public String getPageTitle(int position) {
        switch(position) {

            case 0: return DisplayFragmentNovosti.getTitle(ctxt, position);
            case 1: return DisplayFragmentNovosti2.getTitle(ctxt, position);
            case 2: return DisplayFragmentNovosti3.getTitle(ctxt, position);
            default: return DisplayFragmentNovosti.getTitle(ctxt, position);
        }
    }
}
