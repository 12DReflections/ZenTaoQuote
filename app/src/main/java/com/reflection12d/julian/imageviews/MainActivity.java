package com.reflection12d.julian.imageviews;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends ActionBarActivity {

    private ImageView enso_image;
    private TextView showTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enso_image = (ImageView) findViewById(R.id.enso);
        showTextView = (TextView) findViewById(R.id.click_answer);

        enso_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTextView.setText(quoteGenerator());
            }
        });

    }

    public String quoteGenerator(){
        String quote = "";

        String quoteArray[] = new String[5];
        quoteArray[0] = "Be serene in everything, and worries vanish by themselves";
        quoteArray[1] = "Two steps forward, one step backward";
        quoteArray[2] = "Mountains are mountains, rivers are rivers";
        quoteArray[3] = "Don't mistake the finger pointing at the moon for the moon itself";
        quoteArray[4] = "A bird flew past the window, as I sit by the computer";

        int quoteNo = RandomTimeSeed(quoteArray.length);
        System.out.println(quoteArray[quoteNo]);
        quote = quoteArray[quoteNo];
        return quote;

    }


    public int RandomTimeSeed(int arraySize){
        Random generator = new Random(System.currentTimeMillis());
        double dSeed = ((generator.nextDouble()) * 100) % arraySize;
        int iSeed = (int)dSeed;

        return iSeed;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
