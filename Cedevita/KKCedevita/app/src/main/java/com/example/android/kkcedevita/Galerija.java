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
import android.widget.Toast;

/**
 * Created by denis on 11/02/2017.
 */

public class Galerija extends Fragment {

    View myview;

    GridView androidGridView;

    Integer[] imageIDs = {
            R.mipmap.galerija11,
            R.mipmap.galerija2,
            R.mipmap.galerija3,
            R.mipmap.galerija4,
            R.mipmap.galerija5,
            R.mipmap.galerija6,
            R.mipmap.galerija7,
            R.mipmap.galerija8,
            R.mipmap.galerija9,
            R.mipmap.galerija10,
            R.mipmap.galerija11,
            R.mipmap.galerija12,
            R.mipmap.galerija13,
            R.mipmap.galerija14,
            R.mipmap.galerija21,
            R.mipmap.galerija22,
            R.mipmap.galerija23,
            R.mipmap.galerija24,
            R.mipmap.galerija25,
            R.mipmap.galerija26,
            R.mipmap.galerija27,
            R.mipmap.galerija28,
            R.mipmap.galerija29,
            R.mipmap.galerija30,
            R.mipmap.galerija31,
            R.mipmap.galerija32,
            R.mipmap.galerija33,
            R.mipmap.galerija34,
            R.mipmap.galerija35,
            R.mipmap.galerija36,
            R.mipmap.galerija37,
            R.mipmap.galerija38,
            R.mipmap.galerija39,
            R.mipmap.galerija40

    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.galerija_layout, container, false);

        androidGridView = (GridView) myview.findViewById(R.id.gridview_android_example);
        androidGridView.setAdapter(new ImageAdapterGridView(getActivity()));

        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {
                //Toast.makeText(getActivity(), "Grid Item " + (position + 1) + " Selected", Toast.LENGTH_LONG).show();

                //ImageView imageViewVelike = (ImageView)myview.findViewById(R.id.imageViewVelikaSlika);
                //imageViewVelike.setImageResource(imageIDs[position]);

                GalerijaVelikaSlika galerijaVelikaSlika = new GalerijaVelikaSlika();
                Bundle arguments = new Bundle();
                arguments.putString( "slika" , imageIDs[position].toString());
                galerijaVelikaSlika.setArguments(arguments);

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, galerijaVelikaSlika ); // give your fragment container id in first parameter
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
