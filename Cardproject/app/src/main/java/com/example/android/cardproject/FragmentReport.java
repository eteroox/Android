package com.example.android.cardproject;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentReport extends Fragment implements View.OnClickListener {

    Button buttonMoj;
    TextView textViewMoj;


    public FragmentReport() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_fragment_report,container,false);

        textViewMoj=(TextView)v.findViewById(R.id.textViewReport);

        Typeface face= Typeface.createFromAsset(getContext().getAssets(), "fonts/athletic.ttf");
        textViewMoj.setTypeface(face);

        buttonMoj = (Button) v.findViewById(R.id.button);
        buttonMoj.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","denis.alibasic22@gmail.com", null));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Error report");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
                break;
        }
    }

    public void reportIssue(){
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, "denis.alibasic22@gmail.com");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
    }

}
