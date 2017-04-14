package com.example.android.kkcedevita;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by denis on 14/02/2017.
 */

public class IgraciDetalji extends Fragment {

    View myview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.igraci_detalji , container , false);


        Bundle arguments = getArguments();
        String desired_string = arguments.getString("slike");
        String naslov_string = arguments.getString("naslov");
        String detalji_string = arguments.getString("detalji");
        ImageView imageviewVelika = (ImageView)myview.findViewById(R.id.slikaIgraciDetalji);
        TextView textViewNaslov = (TextView)myview.findViewById(R.id.naslovIgraci);
        TextView textViewDetalji = (TextView)myview.findViewById(R.id.detaljiIgraci);

        textViewNaslov.setText(naslov_string);
        textViewDetalji.setText(detalji_string);
        imageviewVelika.setImageResource(Integer.parseInt(desired_string));



        return myview;
    }
}
