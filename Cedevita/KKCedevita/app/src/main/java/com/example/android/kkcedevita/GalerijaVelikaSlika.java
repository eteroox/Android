package com.example.android.kkcedevita;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by denis on 13/02/2017.
 */

public class GalerijaVelikaSlika extends Fragment {

    View myview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.galerija_velika_slika, container, false);

        Bundle arguments = getArguments();
        String desired_string = arguments.getString("slika");
        ImageView imageviewVelika = (ImageView)myview.findViewById(R.id.imageViewVelikaSlika);
        imageviewVelika.setImageResource(Integer.parseInt(desired_string));
        return myview;
    }
}
