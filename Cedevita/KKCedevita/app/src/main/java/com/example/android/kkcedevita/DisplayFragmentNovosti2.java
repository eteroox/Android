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

public class DisplayFragmentNovosti2 extends Fragment {

    View myview;
    TextView textView1,textView2;

    DisplayFragmentNovosti2 newInstance(int position) {
        DisplayFragmentNovosti2 frag=new DisplayFragmentNovosti2();
        return(frag);
    }

    static String getTitle(Context ctxt, int position) {
        return("Cedevita odlična protiv Partizana ");
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.novosti_pagger2, container, false);

        textView1 = (TextView)myview.findViewById(R.id.textviewPager2);
        textView1.setText("U 22. kolu ABA lige Cedevita je u ugodno popunjenom Domu sportova svladala Partizan NIS sa 79:67. Zagrepčani su igrali bez Luke Babića. Prvu su četvrtinu završili sa zaostatkom 16:18, a nakon sjajne druge dionice na veliki odmor otišli su s vodstvom 37:30.\n" +
                "\n" +
                "Početkom zadnje četvrtine poslije trice Marka Arapovića Cedevita je otišla i na +20. Gosti su se u 37. minuti spustili na -10, no pobjeda aktualnih prvaka Hrvatske nije došla u pitanje.\n" +
                "\n" +
                "U dresu pobjednika Ryan Boatright upisao je 21 poen, pet skokova i tri asistencije, Miro Bilan ubilježio je 14 poena, 10 skokova i tri asistencije, Marko Arapović ubilježio je 11 poena i četiri skoka, a Karlo Žganec 10 poena i četiri skoka.\n" +
                "\n" +
                "Kod gostiju je Stefan Birčević ubilježio 18 poena i sedam skokova, a Vanja Marinković utakmicu je završio s 12 poena, dva skoka i dvije asistencije.");

        textView2 = (TextView)myview.findViewById(R.id.textviewPager);
        textView1.setText("Izjave nakon utakmice\n" +
                "\n" +
                "Veljko Mršić (trener Cedevite): \"Dominirali smo cijelu utakmicu, osim prve četvrtine jer smo imali malo slabiji ulazak koji je bio uvjetovan time što smo promašili puno otvorenih šuteva. Od druge četvrtine smo preuzeli kontrolu utakmice. Igrali smo stvarno dobru obranu do kraja, s tim da smo u drugom poluvremenu imali malo previše izgubljenih lopti. Ovo nam je druga utakmica zaredom gdje šuterski nismo bili na nivou, a dobili smo takoreći lako protiv ozbiljne ekipe. Podigli smo obranu i sada treba nastaviti na ovom tragu.\"\n" +
                "\n" +
                "Marko Arapović (krilni centar Cedevite): \"Bila je to jedna tvrda i teška utakmica. Mi smo cijelo drugo poluvrijeme bili u dvoznamenkastom vodstvu, no stalno su prijetili. Odigrali smo dobru obranu i primili 67 poena. Igra nam je bila dobra i u jednom i u drugom smjeru. Podižemo agresivnost iz utakmice u utakmicu, za razliku od početka sezone. Radimo puno u obrani. Bilo je lijepo čuti pljesak s tribina kao nagradu za požrtvovnost. Ljudi to vole, a i klubu donosi rezultat.\"\n" +
                "\n" +
                "Aleksandar Džikić (trener Partizana NIS): \"Cedevita je večeras bila bolji protivnik. Nama je nedostajalo žestine u završnici i u samom reketu. Oni su tu moćniji i kvalitetniji i gradili su svoju igru u obrani i napadu na tome i to im je davalo rezultata. Mi smo za ovakav tip utakmice imali previše izgubljenih lopti, ali idemo dalje. Generalno, zadovoljan sam prvom i posljednjom četvrtinom, a treća i četvrta nisu bile dobre.\"\n" +
                "\n" +
                "Tijek utakmice\n" +
                "\n" +
                "1. minuta - Odmah na startu utakmice Birčević i James razmijenili su trice za 3:3.\n" +
                "\n" +
                "5. minuta - Bilan je skočio u napadu i popravio loptu koju je u ulazu na koš uputio Tomas za 7:7.\n" +
                "\n" +
                "6. minuta - Bilan je lijepo asistirao za Žganeca, koji je zabio skok-šut s dva metra.\n" +
                "\n" +
                "7. minuta - Kod rezultata 9:10 ušao je Boatright umjesto Katića, koji je počeo u prvoj petorci Cedevite.\n" +
                "\n" +
                "9. minuta - Poslije trice Boatrighta na jednoj, Luković je položio na drugoj strani za vodstvo Partizana 15:14.\n" +
                "\n" +
                "Kraj prve četvrtine - Partizan poslije 10 minuta igre vodi 18:16. Za domaćine je Žganec dosad ubacio četiri poena, a kod gostiju je pet poena zabio Birčević.\n" +
                "\n" +
                "12. minuta - Boatright je u ulazu u kontaktu položio za izjednačenje 18:18.\n" +
                "\n" +
                "13. minuta - Boatright je preko ruke Hatchera s poludistance zabio za 24:18 vodstvo domaćina.\n" +
                "\n" +
                "14. minuta - Mršić je kod vodstva Cedevite 24:22 pozvao timeout. Maloprije je Begić dobio treću osobnu i umjesto njega u igru je ušao Bilan, koji ima jednu osobnu.\n" +
                "\n" +
                "15. minuta - Tomas je na asistenciju Bilana zabio tricu, a na drugoj strani Marinković nije uspio zabiti u ulazu.\n" +
                "\n" +
                "16. minuta - Sada je s lijevog kuta tricu zabio i Krušlin. Cedevita je povela 30:22, a na 4:35 min. do velikog odmora trener gostiju Aleksandar Džikić pozvao je timeout, poslije kojeg je Hatcher preko ruke Tomasa zabio tricu za -5 Partizana.\n" +
                "\n" +
                "19. minuta - Bilan je poslije promašene trice Shurne skočio u napadu, a onda se okrenuo oko protivničkog igrača i sjajno zakucao za prvo dvoznamenkasto vodstvo Cedevite (36:26).\n" +
                "\n" +
                "Kraj prvog poluvremena - Cedevita vodi 37:30. Zagrepčani su odigrali vrlo dobru drugu četvrtinu, u kojoj je Boatright zabio devet poena. On je trenutno i prvi strijelac domaćina, a za goste je pet poena ubacio Birčević.\n" +
                "\n" +
                "21. minuta - Boatright je tricom iz lijevog kuta Cedeviti ponovno donio dvoznamenkastu prednost (40:30).\n" +
                "\n" +
                "25. minuta - Musa je u kontri položio za vodstvo Cedevite 48:32. Nakon toga je Birčević na drugoj strani zabio tricu za goste i tako prekinuo 11-2 seriju domaćina.\n" +
                "\n" +
                "27. minuta - Kod vodstva Cedevite 50:36 gosti su na 3:43 min. do isteka treće dionice pozvali timeout.\n" +
                "\n" +
                "28. minuta - James je zabio tricu i povećao prednost Cedevite na +19 (55:36).\n" +
                "\n" +
                "Kraj treće četvrtine - Cedevita u zadnjih 10 minuta utakmice ulazi s vodstvom 59:42.\n" +
                "\n" +
                "31. minuta - Arapović je tricom za 62:42 po prvi put na utakmici domaćinima donio +20.\n" +
                "\n" +
                "33. minuta - Gosti su napravili seriju 8-0 i poslije trice Marinkovića, kojom se Partizan približio na 50:62, Mršić je na 7:44 min. do kraja utakmice morao pozvati timeout. Poslije toga je Boatright zabio vrlo važnu tricu za 65:50 prednost Cedevite.\n" +
                "\n" +
                "36. minuta - Hatcher je zabio tricu za 55:68 zaostatak Partizana.\n" +
                "\n" +
                "37. minuta - Marinković je zabio tricu i gosti su došli na -10 (58:68).\n" +
                "\n" +
                "38. minuta - Arapović je na asistenciju Boatrighta zabio s dva metra za 72:58 vodstvo Cedevite, a na 2:34 min. do kraja Luković je potom napravio prekršaj u napadu.\n" +
                "\n" +
                "39. minuta - Arapović je fantastično zakucao na asistenciju Muse za 77:63 u korist prvaka Hrvatske.\n" +
                "\n" +
                "Kraj utakmice - Cedevita je pobijedila 79:67.");
        return myview;
    }
}
