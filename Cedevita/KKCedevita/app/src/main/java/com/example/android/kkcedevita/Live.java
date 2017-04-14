package com.example.android.kkcedevita;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by denis on 22/02/2017.
 */

public class Live extends Fragment {

    View myview;
    ListView mojlist;
    HttpURLConnection httpURLConnection;
    BufferedReader reader;

    List<String> poruke = new ArrayList<String>();
    static final ArrayList<HashMap<String,String>> list =  new ArrayList<HashMap<String,String>>();

    SwipeRefreshLayout swipeContainer;
    ArrayAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.live_lista, container, false);
        mojlist=(ListView)myview.findViewById(R.id.list_live);


        //new JSONTask().execute("http://velikaljubav.com/php/cedevita.php");
        new JSONTask().execute("http://192.168.1.118/cedevita.php");

        swipeContainer = (SwipeRefreshLayout) myview.findViewById(R.id.swipe_refresh);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //do all refreshing tasks
                swipeContainer.setRefreshing(false);
                adapter.clear();
                //new JSONTask().execute("http://velikaljubav.com/php/cedevita.php");
                new JSONTask().execute("http://192.168.1.118/cedevita.php");

            }
        });


        return myview;

    }

    public class JSONTask extends AsyncTask<String,String, List<String> >{

        @Override
        protected List<String> doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();

                InputStream stream = httpURLConnection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();

                String line="";

                while((line = reader.readLine()) != null){
                    buffer.append(line);
                }

                String finalJSON = buffer.toString();
                JSONObject parentObject = new JSONObject(finalJSON);
                JSONArray parentArray = parentObject.getJSONArray("products");

                StringBuffer finalBuffer = new StringBuffer();
                HashMap<String,String> temp = new HashMap<String,String>();

                for(int i = 0; i<parentArray.length() ; i++ ){
                    JSONObject finalObject = parentArray.getJSONObject(i);

                    String id = finalObject.getString("id");
                    String poruka = finalObject.getString("poruka");
                    finalBuffer.append(poruka);
                    poruke.add(poruka);
                }

                return poruke;
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if(httpURLConnection != null){
                    httpURLConnection.disconnect();
                }
                try{
                    if(reader != null){
                        reader.close();
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<String> s) {
            super.onPostExecute(s);
            //SimpleAdapter adapter = new SimpleAdapter(getActivity(), list, R.layout.list_item, new String[] {"poruka"},
            //        new int[] {R.id.poruke_live});
            adapter = new ArrayAdapter(getActivity(),R.layout.list_item, s);
            mojlist.setAdapter(adapter);
        }
    }
}
