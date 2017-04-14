package com.example.android.kkcedevita;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import static android.R.attr.path;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //dodano da slike ne budu blurry
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap source = BitmapFactory.decodeResource(getResources(), path, options);


        //stavio umjesto naslova
        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        //toolbar.setLogo(R.mipmap.banner2);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //       .setAction("Action", null).show();

                EmailForma emailForma = new EmailForma();

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, emailForma ); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //moj dio za zamjenu
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(R.mipmap.cedevita_logo);

        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });

        toggle.setHomeAsUpIndicator(R.mipmap.cedevita_logo);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // ---------------- micem meni
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        android.app.FragmentManager fragmentManager = getFragmentManager();
        android.support.v4.app.FragmentManager fragmentManagerV4 = getSupportFragmentManager();

        fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        fragmentManagerV4.popBackStackImmediate(null, fragmentManagerV4.POP_BACK_STACK_INCLUSIVE);

        if (id == R.id.news) {
            fragmentManagerV4.beginTransaction()
                    .replace(R.id.content_frame, new Novosti())
                    .commit();
        } else if (id == R.id.galerija) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new Galerija())
                    .commit();

        } else if (id == R.id.lokacija) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new Lokacija())
                    .commit();

        } else if (id == R.id.kontakt) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new Kontakt())
                    .commit();

        } else if (id == R.id.trgovina) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new Trgovina())
                    .commit();

        } else if (id == R.id.igraci) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new Igraci())
                    .commit();

        }

        else if (id == R.id.karte) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new Karte())
                    .commit();

        }

        else if (id == R.id.raspored) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new Raspored())
                    .commit();

        }

        else if (id == R.id.sponzori) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new Sponzori())
                    .commit();

        }

        else if (id == R.id.video) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new CedevitaTV())
                    .commit();

        }

        else if (id == R.id.live) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new Live())
                    .commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    /*

    public void unistiFragmente(){
        //FragmentTransaction transaction = getFragmentManager().beginTransaction();
        //transaction.remove(R.id.pager).commit();
        getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.pager)).commit();
        getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.linearLayoutVelikeSlike)).commit();
        getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.novostiContainer)).commit();
        getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.novostiContainer2)).commit();
        getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.novostiContainer3)).commit();
        getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.content)).commit();
        getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.lokacijaContainer)).commit();
        getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.listSingleContainer)).commit();
        getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.kontaktContainer)).commit();
        getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.igraciContainer)).commit();
        getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.linearLayoutGalerija)).commit();
        getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.igraciContainer)).commit();

    }
    */
}
