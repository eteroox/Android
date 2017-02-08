package com.example.android.justjava;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    TextView g1,gn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        g1 = (TextView) findViewById(R.id.textViewGame1);
        gn1 = (TextView) findViewById(R.id.textViewGameN1);

    }

    // reset button
    public void resetButton(View view){
        g1.setText("0");
        gn1.setText("0");
        TextView nadalText = (TextView) findViewById(R.id.textViewScoreNadal);
        TextView novakText = (TextView) findViewById(R.id.textViewScoreNovak);
        nadalText.setText("0");
        novakText.setText("0");
    }

    // on click nadal
    public void nadal(View view){

        TextView nadalText = (TextView) findViewById(R.id.textViewScoreNadal);
        TextView novakText = (TextView) findViewById(R.id.textViewScoreNovak);

        int identifier=1;

        int scoreNadal= Integer.parseInt(nadalText.getText().toString());
        int scoreNovak = Integer.parseInt(novakText.getText().toString());

        int gameNadal = Integer.parseInt(g1.getText().toString());
        int gameNovak = Integer.parseInt(gn1.getText().toString());

        if((gameNadal == 6) && (gameNovak < 5) || (gameNadal==7)){
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("Nadal won the set");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }

        switch(scoreNadal){
            case 0:
                lessThan30(identifier);
                break;
            case 15:
                lessThan30(identifier);
                break;
            case 30:
                goindTo40(identifier);
                break;
            case 40:
                checkScores(scoreNadal,scoreNovak, identifier);
                break;
            case 1:
                nadalAdvantage();
                break;
        }
    }


    //on click novak
    public void novak(View view){

        int identifier=2;

        TextView nadalText = (TextView) findViewById(R.id.textViewScoreNadal);
        TextView novakText = (TextView) findViewById(R.id.textViewScoreNovak);

        int scoreNadal= Integer.parseInt(nadalText.getText().toString());
        int scoreNovak = Integer.parseInt(novakText.getText().toString());

        int gameNadal = Integer.parseInt(g1.getText().toString());
        int gameNovak = Integer.parseInt(gn1.getText().toString());

        if((gameNovak == 6) && (gameNadal < 5) || (gameNovak==7)){
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("Novak won the set");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }

        switch(scoreNovak){
            case 0:
                lessThan30(identifier);
                break;
            case 15:
                lessThan30(identifier);
                break;
            case 30:
                goindTo40(identifier);
                break;
            case 40:
                checkScores(scoreNadal,scoreNovak, identifier);
                break;
            case 1:
                novakAdvantage();
                break;
        }

    }

    // if the score is less than 30
    public void lessThan30(int identifier){
        if(identifier==1){
            TextView rafaelText = (TextView) findViewById(R.id.textViewScoreNadal);
            int score =15;
            score = Integer.parseInt(rafaelText.getText().toString()) + score;
            rafaelText.setText(Integer.toString(score));
        }
        if(identifier==2){
            TextView nadalText = (TextView) findViewById(R.id.textViewScoreNovak);
            int score =15;
            score = Integer.parseInt(nadalText.getText().toString()) + score;
            nadalText.setText(Integer.toString(score));
        }
    }

    // if the score is 30
    public void goindTo40(int identifier){
        if(identifier == 1){
            TextView rafaelText = (TextView) findViewById(R.id.textViewScoreNadal);
            int score =10;
            score = Integer.parseInt(rafaelText.getText().toString()) + score;
            rafaelText.setText(Integer.toString(score));
        }
        if (identifier == 2) {
            TextView nadalText = (TextView) findViewById(R.id.textViewScoreNovak);
            int score = 10;
            score = Integer.parseInt(nadalText.getText().toString()) + score;
            nadalText.setText(Integer.toString(score));
        }
    }

    // check scores at 40
    public void checkScores(int scoreNadal, int scoreNovak, int identifier){
        if((scoreNadal > scoreNovak) && (scoreNadal!=1) && (scoreNovak!=1)){
            int score = Integer.parseInt(g1.getText().toString())+1;
            g1.setText(Integer.toString(score));
            TextView nadalText = (TextView) findViewById(R.id.textViewScoreNadal);
            TextView novakText = (TextView) findViewById(R.id.textViewScoreNovak);
            nadalText.setText("0");
            novakText.setText("0");
        }

        if((scoreNovak > scoreNadal) && (scoreNadal!=1) && (scoreNovak!=1)){
            int score = Integer.parseInt(gn1.getText().toString())+1;
            gn1.setText(Integer.toString(score));
            TextView nadalText = (TextView) findViewById(R.id.textViewScoreNadal);
            TextView novakText = (TextView) findViewById(R.id.textViewScoreNovak);
            nadalText.setText("0");
            novakText.setText("0");
        }

        if((scoreNovak == scoreNadal && identifier == 1) || (scoreNovak == 1 && identifier == 1)){
            TextView nadalText = (TextView) findViewById(R.id.textViewScoreNadal);
            nadalText.setText("1");
            TextView novakText = (TextView) findViewById(R.id.textViewScoreNovak);
            novakText.setText("40");
        }
        if((scoreNovak == scoreNadal && identifier == 2) || (scoreNadal == 1 && identifier == 2)){
            TextView nadalText = (TextView) findViewById(R.id.textViewScoreNadal);
            nadalText.setText("40");
            TextView novakText = (TextView) findViewById(R.id.textViewScoreNovak);
            novakText.setText("1");
        }
    }

    //if nadal scores after advantage
    public void nadalAdvantage(){
        int score = Integer.parseInt(g1.getText().toString())+1;
        g1.setText(Integer.toString(score));
        TextView nadalText = (TextView) findViewById(R.id.textViewScoreNadal);
        TextView novakText = (TextView) findViewById(R.id.textViewScoreNovak);
        nadalText.setText("0");
        novakText.setText("0");
    }

    //if novak scores after advantage
    public void novakAdvantage(){
        int score = Integer.parseInt(gn1.getText().toString())+1;
        gn1.setText(Integer.toString(score));
        TextView nadalText = (TextView) findViewById(R.id.textViewScoreNadal);
        TextView novakText = (TextView) findViewById(R.id.textViewScoreNovak);
        nadalText.setText("0");
        novakText.setText("0");
    }
}