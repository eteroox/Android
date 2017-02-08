package com.example.android.cardproject;


import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Context;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentNew extends Fragment implements View.OnClickListener {

    Button buttonMoj,buttonShow,buttonFinish;
    ImageView imageViewMoj;
    TextView textViewCestitka;
    EditText editTextCestitka;
    private static int RESULT_LOAD_IMG = 1;
    boolean isImageFitToScreen;

    String msg;
    private android.widget.RelativeLayout.LayoutParams layoutParams;

    public FragmentNew() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_new, container, false);


        buttonMoj = (Button) v.findViewById(R.id.buttonNew);
        buttonMoj.setOnClickListener(this);

        buttonShow = (Button) v.findViewById(R.id.buttonShow);
        buttonShow.setOnClickListener(this);

        buttonFinish = (Button) v.findViewById(R.id.buttonFinish);
        buttonFinish.setOnClickListener(this);

        textViewCestitka = (TextView) v.findViewById(R.id.textViewNew);
        editTextCestitka = (EditText) v.findViewById(R.id.editTextNewEnterText);

        imageViewMoj = (ImageView) v.findViewById(R.id.imageViewNew);


        //sljedeca 3 su za drag i drop funkcionalnosti
        textViewCestitka.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(textViewCestitka);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    v.startDragAndDrop(dragData, myShadow, null, 0);;
                    return true;
                } else {
                    v.startDrag(dragData, myShadow, null, 0);
                    return true;
                }
            }
        });

        v.findViewById(R.id.relative).setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_STARTED");

                        // Do nothing
                        break;

                    case DragEvent.ACTION_DRAG_ENTERED:
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENTERED");
                        int x_cord = (int) event.getX();
                        int y_cord = (int) event.getY();
                        break;

                    case DragEvent.ACTION_DRAG_EXITED:
                        x_cord = (int) event.getX();
                        y_cord = (int) event.getY();
                        layoutParams.leftMargin = x_cord;
                        layoutParams.topMargin = y_cord;
                        v.setLayoutParams(layoutParams);
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_EXITED");
                        break;

                    case DragEvent.ACTION_DRAG_LOCATION:
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_LOCATION");
                        break;

                    case DragEvent.ACTION_DRAG_ENDED:
                        v.setVisibility(View.VISIBLE);
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENDED");
                        // Do nothing
                        break;

                    case DragEvent.ACTION_DROP:
                        x_cord = (int) event.getX();
                        y_cord = (int) event.getY();
                        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        params.setMargins(x_cord,y_cord,0,0);
                        textViewCestitka.setLayoutParams(params);
                        textViewCestitka.setVisibility(View.VISIBLE);
                        Log.d(msg, "ACTION_DROP event");
                        // Do nothing
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        textViewCestitka.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(textViewCestitka);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        textViewCestitka.startDragAndDrop(data, shadowBuilder, textViewCestitka, 0);
                        textViewCestitka.setVisibility(View.INVISIBLE);
                        return true;
                    } else {
                        textViewCestitka.startDrag(data, shadowBuilder, textViewCestitka, 0);
                        textViewCestitka.setVisibility(View.INVISIBLE);
                        return true;
                    }
                } else {
                    return false;
                }
            }
        });

        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonNew:
                /*Intent intent = new Intent();
                // Show only images, no videos or anything else
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                // Always show the chooser (if there are multiple options available)
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);*/

                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                // ******** code for crop image
                i.putExtra("crop", "true");
                i.putExtra("aspectX", 100);
                i.putExtra("aspectY", 100);
                i.putExtra("outputX", 256);
                i.putExtra("outputY", 356);

                try {

                    i.putExtra("return-data", true);
                    startActivityForResult(
                            Intent.createChooser(i, "Select Picture"), 0);
                }catch (ActivityNotFoundException ex){
                    ex.printStackTrace();
                }

                break;
            case R.id.buttonShow:
                textViewCestitka.setText(editTextCestitka.getText().toString());
                break;
            case R.id.buttonFinish:
                editTextCestitka.setVisibility(View.INVISIBLE);
                buttonMoj.setVisibility(View.INVISIBLE);
                buttonShow.setVisibility(View.INVISIBLE);
                buttonFinish.setVisibility(View.INVISIBLE);

                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("image/*");
                File root = Environment.getExternalStorageDirectory();
                share.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(root.getAbsolutePath() + "/DCIM/Camera/image.jpg")));
                startActivity(Intent.createChooser(share,"Share via"));
                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0 && resultCode == Activity.RESULT_OK){
            try {
                Bundle bundle = data.getExtras();
                Bitmap bitmap = bundle.getParcelable("data");
                imageViewMoj.setImageBitmap(bitmap);
                imageViewMoj.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
