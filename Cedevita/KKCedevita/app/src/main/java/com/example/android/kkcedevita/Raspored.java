package com.example.android.kkcedevita;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by denis on 17/02/2017.
 */

public class Raspored extends Fragment {

    View myview;
    ListView listRaspored;

    static final ArrayList<HashMap<String,String>> list =  new ArrayList<HashMap<String,String>>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myview = inflater.inflate(R.layout.raspored_layout, container, false);

        listRaspored = (ListView)myview.findViewById(R.id.listRaspored);

        SimpleAdapter adapter = new SimpleAdapter(getActivity(), list, R.layout.raspored_adapter, new String[] {"datum", "ekipe", "liga", "kolo"},
                new int[] {R.id.datum, R.id.ekipa, R.id.liga, R.id.kolo});

        populateList();

        listRaspored.setAdapter(adapter);


        return myview;
    }


    private void populateList() {

        if(list.isEmpty()){
            HashMap<String,String> temp = new HashMap<String,String>();
            temp.put("datum","08.03.2017.");
            temp.put("ekipe", "Cedevita - Gorica");
            temp.put("liga", "A1 liga");
            temp.put("kolo", "17.kolo");
            list.add(temp);

            temp = new HashMap<String,String>();
            temp.put("datum","11.03.2017.");
            temp.put("ekipe", "Cedevita - FMP");
            temp.put("liga", "ABA liga");
            temp.put("kolo", "26.kolo");
            list.add(temp);

            temp = new HashMap<String,String>();
            temp.put("datum","13.03.2017.");
            temp.put("ekipe", "Zagreb - Cedevita");
            temp.put("liga", "A1 liga");
            temp.put("kolo", "20.kolo");
            list.add(temp);

            temp = new HashMap<String,String>();
            temp.put("datum","18.03.2017.");
            temp.put("ekipe", "GAME 1 playoffs");
            temp.put("liga", "ABA liga");
            temp.put("kolo", "1/2 finale");
            list.add(temp);

            temp = new HashMap<String,String>();
            temp.put("datum","20.03.2017.");
            temp.put("ekipe", "Cedevita - Jolly JBS");
            temp.put("liga", "A1 liga");
            temp.put("kolo", "21.kolo");
            list.add(temp);

            temp = new HashMap<String,String>();
            temp.put("datum","25.03.2017.");
            temp.put("ekipe", "GAME 2 playoffs");
            temp.put("liga", "ABA liga ");
            temp.put("kolo", "1/2 finale");
            list.add(temp);
        }
    }
}
