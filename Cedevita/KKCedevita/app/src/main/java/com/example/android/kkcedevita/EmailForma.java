package com.example.android.kkcedevita;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by denis on 15/02/2017.
 */

public class EmailForma extends Fragment {

    View myview;
    TextView textIme, textEmail, textPredmet, textOpis;
    Button buttonPotvrdi;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.email_form_layout, container, false);

        textIme = (TextView) myview.findViewById(R.id.imeIPrezime);
        textEmail = (TextView) myview.findViewById(R.id.Email);
        textPredmet = (TextView) myview.findViewById(R.id.Predmet);
        textOpis = (TextView) myview.findViewById(R.id.Opis);

        buttonPotvrdi = (Button) myview.findViewById(R.id.potvrdi);

        buttonPotvrdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name      = textIme.getText().toString();
                String email     = textEmail.getText().toString();
                String subject   = textPredmet.getText().toString();
                String message   = textOpis.getText().toString();

                if (TextUtils.isEmpty(name)){
                    textIme.setError("Unestie ime");
                    textIme.requestFocus();
                    return;
                }

                Boolean onError = false;
                if (!isValidEmail(email) || TextUtils.isEmpty(email)) {
                    onError = true;
                    textEmail.setError("Krivi format emaila");
                    return;
                }

                if (TextUtils.isEmpty(subject)){
                    textPredmet.setError("Unesite predmet emaila");
                    textPredmet.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(message)){
                    textOpis.setError("Unesite poruku");
                    textOpis.requestFocus();
                    return;
                }

                Intent sendEmail = new Intent(android.content.Intent.ACTION_SEND);

            /* Fill it with Data */
                sendEmail.setType("plain/text");
                sendEmail.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"eteroox@gmail.com"});
                sendEmail.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
                sendEmail.putExtra(android.content.Intent.EXTRA_TEXT,
                        "Ime:"+name+'\n'+"Email:"+email+'\n'+"Poruka:"+'\n'+message);

            /* Send it off to the Activity-Chooser */
                startActivity(Intent.createChooser(sendEmail, "Send mail..."));


            }
        });


        return myview;
    }


    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
