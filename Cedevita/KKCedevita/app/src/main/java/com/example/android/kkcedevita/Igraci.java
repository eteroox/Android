package com.example.android.kkcedevita;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by denis on 11/02/2017.
 */

public class Igraci extends Fragment {

    View myview;

    ListView list;
    String[] web = {
            "Brian Scott Hopson",
            "Miro Bilan",
            "Markus Lončar",
            "Karlo Mikšić",
            "Džanan Musa",
            "Filip Krušlin",
            "Karlo Žganec",
            "Ivan Vučić",
            "Mirza Begić",
            "Toni Katić",
            "Marko Arapović",
            "Luka Babić",
            "Ivan Zebić",
            "Darko Bajo",
            "Rashad James",
            "Roko Rogić",
            "Lovro Buljević",
            "Filip Bundović",
            "Marko Ramljak",
            "Marko Tomas",
            "John Shurna",
            "Ryan Boatright",
            "Luka Barišić",
            "Toni Perković",
            "Antonio Jordano"

    } ;

    String[] detalji = {
            "Broj 24 \n Visina: 201 cm \n Pozicija: SF",
            "Broj 15 \n Visina: 213 cm \n Pozicija: C",
            "Broj 55 \n Visina: 195 cm \n Pozicija: PG",
            "Broj 13 \n Visina: 203 cm \n Pozicija: G",
            "Broj 2 \n Visina: 196 cm \n Pozicija: SG",
            "Broj 11 \n Visina: 206 cm \n Pozicija: PF",
            "Broj 2 \n Visina: 196 cm \n Pozicija: SG",
            "Broj 44 \n Visina: 197 cm \n Pozicija: SF",
            "Broj 25 \n Visina: 216 cm \n Pozicija: C",
            "Broj 6 \n Visina: 188 cm \n Pozicija: PG",
            "Broj 35 \n Visina: 207 cm \n Pozicija: PF/C",
            "Broj 9 \n Visina: 201 cm \n Pozicija: SF",
            "Broj 5 \n Visina: 198 cm \n Pozicija: SG",
            "Broj 1 \n Visina: 204 cm \n Pozicija: F",
            "Broj 0 \n Visina: 185 cm \n Pozicija: PG/SG",
            "Broj 32 \n Visina: 185 cm \n Pozicija: PG",
            "Broj 23 \n Visina: 210 cm \n Pozicija: PF",
            "Broj 10 \n Visina: 205 cm \n Pozicija: PF",
            "Broj 46 \n Visina: 201 cm \n Pozicija: SF",
            "Broj 33 \n Visina: 201 cm \n Pozicija: SF",
            "Broj 24 \n Visina: 206 cm \n Pozicija: PF",
            "Broj 3 \n Visina: 188 cm \n Pozicija: PG",
            "Broj 44 \n Visina: 201 cm \n Pozicija: PF",
            "Broj 3 \n Visina: 191 cm \n Pozicija: SG",
            "Broj 4 \n Visina: 188 cm \n Pozicija: PG"
    };

    Integer[] imageId = {
            R.mipmap.hop,
            R.mipmap.bil,
            R.mipmap.mark,
            R.mipmap.miksic,
            R.mipmap.musa,
            R.mipmap.kruslin,
            R.mipmap.zganec,
            R.mipmap.vucic,
            R.mipmap.begic,
            R.mipmap.katic,
            R.mipmap.arapovic,
            R.mipmap.babic,
            R.mipmap.zebic,
            R.mipmap.bajo,
            R.mipmap.james,
            R.mipmap.rogic,
            R.mipmap.buljevic,
            R.mipmap.bundovic,
            R.mipmap.ramljak,
            R.mipmap.tomas,
            R.mipmap.shurna,
            R.mipmap.boatright,
            R.mipmap.noimage,
            R.mipmap.noimage,
            R.mipmap.noimage
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.igraci_layout, container, false);


        CustomList adapter = new
                CustomList(getActivity(), web, imageId);
        list=(ListView)myview.findViewById(R.id.list);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Toast.makeText(getActivity(), "Odabrali ste:  " +web[+ position], Toast.LENGTH_SHORT).show();

                IgraciDetalji igraciDetalji = new IgraciDetalji();
                Bundle arguments = new Bundle();
                arguments.putString( "slike" , imageId[position].toString());
                arguments.putString("naslov" , web[position]);
                arguments.putString("detalji" , detalji[position]);
                igraciDetalji.setArguments(arguments);

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, igraciDetalji ); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();

            }
        });


        return myview;
    }
}

