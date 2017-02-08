package com.example.android.cardproject;

/**
 * Created by denis on 20/01/2017.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FragmentHowTo tab1 = new FragmentHowTo();
                return tab1;
            case 1:
                FragmentNew tab2 = new FragmentNew();
                return tab2;
            case 2:
                FragmentReport tab3 = new FragmentReport();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
