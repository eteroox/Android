package com.example.android.kkcedevita;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by denis on 20/02/2017.
 */

public class Sponzori extends Fragment {

    View myview;

    GridView androidGridView;


    Integer[] imageIDs = {
            R.mipmap.cedevita,
            R.mipmap.raif,
            R.mipmap.argeta,
            R.mipmap.croatia_osiguranje,
            R.mipmap.ina,
            R.mipmap.konzum,
            R.mipmap.tcom,
            R.mipmap.montana,
            R.mipmap.smoki,
            R.mipmap.cockta,
            R.mipmap.donatmg,
            R.mipmap.chipsos,
            R.mipmap.kala,
            R.mipmap.medikol,
            R.mipmap.triglav,
            R.mipmap.snt,
            R.mipmap.pwc,
            R.mipmap.zagreb_tourist_info,
            R.mipmap.printgrupa,
            R.mipmap.renault,
            R.mipmap.bauerfeind,
            R.mipmap.erstecard,
            R.mipmap.herbarium,
            R.mipmap.rosal,
            R.mipmap.barcaffe,
            R.mipmap.dietpharm,
            R.mipmap.plidenta,
            R.mipmap.multipower,
            R.mipmap.vecernji_list,
            R.mipmap.otvoreni_radio,
            R.mipmap.fran_pek,
            R.mipmap.poslovna_inteligencija,
            R.mipmap.rehabilitacija_nova,
            R.mipmap.sucafina,
            R.mipmap.zapresicanka,
            R.mipmap.izoforma_paneli,
            R.mipmap.teamplast,
            R.mipmap.paris,
            R.mipmap.volcafe,
            R.mipmap.interomnia,
            R.mipmap.a2b,
            R.mipmap.ald_automotive,
            R.mipmap.samsonite,
            R.mipmap.ricardo

    };

    Integer[] imageOglasivaci = {
            R.mipmap.forma,
            R.mipmap.birodom,
            R.mipmap.elektrowat,
            R.mipmap.cetis,
            R.mipmap.nasa_djeca,
            R.mipmap.molvik,
            R.mipmap.porche,
            R.mipmap.rio,
            R.mipmap.montelektro,
            R.mipmap.mgk_pack,
            R.mipmap.graficar_ludbreg,
            R.mipmap.clean_express,
            R.mipmap.intel_trade,
            R.mipmap.d2d,
            R.mipmap.renato,
            R.mipmap.baotic,
            R.mipmap.reni,
            R.mipmap.securitas,
            R.mipmap.signum,
            R.mipmap.suncana_vura,
            R.mipmap.stratum,
            R.mipmap.lab360,
            R.mipmap.institut_hr
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.sponzori_layout, container, false);

        SponzoriGridView  gridView  = (SponzoriGridView) myview.findViewById(R.id.gridview_sponzori_android_example);
        SponzoriGridView  gridViewOglasivac  = (SponzoriGridView) myview.findViewById(R.id.gridview_oglasivaci_android_example);

        gridView.setAdapter(new Sponzori.ImageAdapterGridView(getActivity()));
        gridViewOglasivac.setAdapter(new Sponzori.ImageAdapterGridViewOglasavac(getActivity()));


        return myview;
    }

    public class ImageAdapterGridView extends BaseAdapter {
        private Context mContext;

        public ImageAdapterGridView(Context c) {
            mContext = c;
        }

        public int getCount() {
            return imageIDs.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView mImageView;

            if (convertView == null) {
                mImageView = new ImageView(mContext);
                mImageView.setLayoutParams(new GridView.LayoutParams(250, 250));
                mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                mImageView.setPadding(16, 16, 16, 16);
            } else {
                mImageView = (ImageView) convertView;
            }
            mImageView.setImageResource(imageIDs[position]);
            return mImageView;
        }
    }


    public class ImageAdapterGridViewOglasavac extends BaseAdapter {
        private Context mContext;

        public ImageAdapterGridViewOglasavac(Context c) {
            mContext = c;
        }

        public int getCount() {
            return imageOglasivaci.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView mImageView;

            if (convertView == null) {
                mImageView = new ImageView(mContext);
                mImageView.setLayoutParams(new GridView.LayoutParams(250, 250));
                mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                mImageView.setPadding(16, 16, 16, 16);
            } else {
                mImageView = (ImageView) convertView;
            }
            mImageView.setImageResource(imageOglasivaci[position]);
            return mImageView;
        }
    }
}
