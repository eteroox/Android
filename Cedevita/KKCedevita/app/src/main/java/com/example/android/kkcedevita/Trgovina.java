package com.example.android.kkcedevita;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by denis on 11/02/2017.
 */

public class Trgovina extends Fragment {

    View myview;
    GridView androidGridView;

    Integer[] imageIDs = {
            R.mipmap.cedevita_trgovina,
            R.mipmap.cedevita_trgovina2,
            R.mipmap.cedevita_trgovina3,
            R.mipmap.cedevita_trgovina4,
            R.mipmap.cedevita_trgovina5,
            R.mipmap.cedevita_trgovina6,
            R.mipmap.cedevita_trgovina7
    };

    String[] naslov = {
        "Košarkaška lopta",
        "Sportska torba",
        "Cedevita medo",
            "Cedevita dres",
            "Sportska majica",
            "Sportska kapa",
            "Majica dugih rukava"
    };

    String[] cijena = {
            "150kn",
            "200kn",
            "50kn",
            "100kn",
            "90kn",
            "50kn",
            "90kn"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.trgovina_layout, container, false);

        androidGridView = (GridView) myview.findViewById(R.id.gridview_android_trgovina);
        androidGridView.setAdapter(new ImageAdapterGridView(getActivity()));

        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                TrgovinaOpis trgovinaOpis = new TrgovinaOpis();
                Bundle arguments = new Bundle();
                arguments.putString( "slikeTrgovina" , imageIDs[position].toString());
                arguments.putString("naslovTrgovina" , naslov[position]);
                arguments.putString("cijena" , cijena[position]);
                trgovinaOpis.setArguments(arguments);

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, trgovinaOpis ); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
            }

            });

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
}
