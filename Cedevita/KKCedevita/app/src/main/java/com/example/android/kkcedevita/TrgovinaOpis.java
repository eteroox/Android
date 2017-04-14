package com.example.android.kkcedevita;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by denis on 14/02/2017.
 */

public class TrgovinaOpis extends Fragment {

    View myview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.trgovina_opis_cijena, container, false);


        Bundle arguments = getArguments();
        String slika_string = arguments.getString("slikeTrgovina");
        String naslov_string = arguments.getString("naslovTrgovina");
        String detalji_string = arguments.getString("cijena");
        ImageView imageviewVelika = (ImageView)myview.findViewById(R.id.slikaTrgovinaOpis);
        TextView textViewNaslov = (TextView)myview.findViewById(R.id.naslovTrgovina);
        TextView textViewDetalji = (TextView)myview.findViewById(R.id.cijenaTrgovina);

        textViewNaslov.setText(naslov_string);
        textViewDetalji.setText(detalji_string);
        imageviewVelika.setImageResource(Integer.parseInt(slika_string));

        return myview;
    }
}
