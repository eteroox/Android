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
import android.widget.TextView;

public class DisplayFragmentNovosti3 extends Fragment {

    View myview;

    DisplayFragmentNovosti3 newInstance(int position) {
        DisplayFragmentNovosti3 frag=new DisplayFragmentNovosti3();
        return(frag);
    }

    static String getTitle(Context ctxt, int position) {
        return("Cedevita dočekuje Partizan ");
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.novosti_pagger3, container, false);

        TextView textView1 = (TextView)myview.findViewById(R.id.textviewPager);
        textView1.setText("U 22. kolu ABA lige Cedevita će u nedjelju u 19:00h u Domu sportova ugostiti Partizan, a riječ je o iznimno važnoj utakmici jer obje momčadi nadaju se da će uoči doigravanja izboriti drugu poziciju.\n" +
                "\n" +
                "\"Od početka sezone pričam da je svaka utakmica važna. Ovo je liga od 26 kola. Borimo se da bi ostvarili što bolji plasman. Sad nam dolazi Partizan, momčad s kojom se borimo za što bolju poziciju među četiri ekipe koje će izboriti playoff. Cilj nam je odigrati što bolju, čvrstu, utakmicu i idemo na pobjedu\", rekao je u uvodu trener Cedevite Veljko Mršić.\n" +
                "\n" +
                "Cedevita je u Beogradu u 9. kolu svladala Partizan 97:87. Bila je to utakmica u kojoj su Zagrepčani napravili veliki preokret nakon što je glavni trener Zagrepčana bio isključen.\n" +
                "\n" +
                "\"Tamo smo osvojili dva boda, no sada je druga utakmica. Oni su dobra momčad i rezultati koji postižu ove sezone govore o njihovoj kvaliteti. Međutim, i mi imamo kvalitete. Igramo na domaćem terenu i treba misliti samo o toj utakmici, a ne o onom što je bilo ili što će biti poslije.\"\n" +
                "\n" +
                "Za Cedevitu je veliki problem što su ozlijeđeni Luka Babić, Ryan Boatright i Ra'Shad James.\n" +
                "\n" +
                "\"Danas je u odnosu na utakmicu s Unicajom jedan igrač trenirao. Sigurno će jedan od njih trojice biti u momčadi. Vidjet ćemo još u ova dva dana što će biti i hoće li se ova dvojica uspjeti oporaviti.\"\n" +
                "\n" +
                "Mršić o Partizanu ima visoko mišljenje: \"Oni su jedna iskusna momčad, koja ima 14 igrača. Imaju široku momčad, kao što smo vidjeli sad u Solunu. I bez Veličkovića i bez Gordona opet imaju 12 dobrih igrača i rezultati sve govore o njima. Treba odigrati čvrstu utakmicu i odgovoriti na njihovu agresivnost i na fizičku košarku.\"\n" +
                "\n" +
                "\"Sad smo završili Eurokup i imat ćemo dosta više vremena za treninge nego dosad\", izjavio je Marko Arapović, krilni centar Cedevite, koji u zadnje vrijeme igra sve bolje. \"Još ćemo uskladiti neke stvari koje nisu valjale u obrani ili u napadu. Ima par sitnica koje treba korigirati i već smo počeli s tim. Pripremamo se za Partizan. To je meni osobno jedna od dražih utakmica u ligi. Sigurno će to biti jedna dobra utakmica. Oni dolaze iz Grčke s važnom pobjedom u Fibinoj Ligi prvaka. Sigurno su u dobrom ritmu, pobijedili su i Zvezdu i pokazali su da su dobra ekipa, no mi igramo doma i dat ćemo sve od sebe da zaštitimo domaći teren.\"\n" +
                "\n" +
                "Cedeviti treba podrška s tribina…\n" +
                "\n" +
                "\"Nadam se da će doći što više ljudi, da će nas podržati i da će biti jedna dobra košarkaška utakmica s puno dobrih poteza. Naravno, dat ćemo sve od sebe, kao i u prošloj utakmici protiv Unicaje. Mislim da se ljudima svidjelo koliko smo se bacali, borili i trudili. To je nešto po čemu moramo biti poznati, to nam mora biti glavna karakteristika i, ako tako nastavimo, mislim da će biti sve bolje i bolje.\"\n" +
                "\n" +
                "Arapović se osvrnuo i na kvalitetne partije koje pruža u zadnje vrijeme: \"Nakon, nažalost, lošeg početka sezone pokušavam se izvući iz toga. Dajem prije svega sve od sebe u obrani i u tim nekim radnim zadacima, a koševi dolaze. Drago mi je zbog toga i drago mi je što mogu pomoći ekipi. Normalno, svi pokušavamo igrati što bolje i nadam se da će svatko od nas pružati sve bolje predstave do kraja sezone.");

        return myview;
    }
}
