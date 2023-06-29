package fr.matteo_appmob.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import fr.matteo_appmob.myapplication.backend.clicker.CosmicClicker;
import fr.matteo_appmob.myapplication.backend.clicker.IClicker;
import fr.matteo_appmob.myapplication.backend.planets.XyronPrime;

public class MainActivity extends AppCompatActivity {
    final int[] currentWord = {1};
    private String[] txt_welcome = {};

    public void setTotal(TextView place, long total){
        place.setText(String.valueOf(total));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);


        IClicker cosmicClicker = CosmicClicker.getInstance();
        cosmicClicker.addPlanets(new XyronPrime());
        cosmicClicker.setCurrentPlanet(cosmicClicker.getPlanetById(XyronPrime.PLANET_ID));
        cosmicClicker.getCurrentPlanet().run();


        txt_welcome = getResources().getStringArray(R.array.txt_welcome);

        ImageView imgNotify = findViewById(R.id.notif);

        TextView txtNotify = findViewById(R.id.txt_notif);
        //txtNotify.setText(txt_welcome[0]);

        imgNotify.setVisibility(ImageView.INVISIBLE);
        txtNotify.setText("");
        Thread threadTuto = new Thread(new Runnable() {
            @Override
            public void run() {
                final boolean[] finish = {false};
                while(!finish[0]){
                    try {
                        Thread.sleep(5000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (finish[0]){
                                    imgNotify.setVisibility(ImageView.INVISIBLE);
                                    txtNotify.setText("");
                                    return;
                                }
                                imgNotify.setVisibility(ImageView.VISIBLE);
                                txtNotify.setText(txt_welcome[currentWord[0]]);
                                if(currentWord[0] >= txt_welcome.length - 1){
                                    finish[0] = true;
                                    currentWord[0] = 0;
                                    return;
                                }
                                currentWord[0]++;
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        //threadTuto.start();

        ImageView btnShop = findViewById(R.id.btn_shop);
        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), ShopActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

        ImageView btnSettings = findViewById(R.id.btn_settings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

        ImageView btnRanking = findViewById(R.id.btn_ranking);
        btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), RankingActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

        TextView cristal = findViewById(R.id.txt_cristal);
        TextView sylvan_essence = findViewById(R.id.txt_sylvan_essence);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                setTotal(cristal, CosmicClicker.getInstance().getCurrentPlanet().getCrystals());
                                setTotal(sylvan_essence, CosmicClicker.getInstance().getEssences());
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();

        ImageView btn_clicker_arbre = findViewById(R.id.btn_clicker_arbre);
        btn_clicker_arbre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CosmicClicker.getInstance().getCurrentPlanet().addCrystal(1);
                setTotal(cristal, CosmicClicker.getInstance().getCurrentPlanet().getCrystals());
            }
        });

        ImageView btn_clicker_fonderie = findViewById(R.id.btn_clicker_fonderie);
        btn_clicker_fonderie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CosmicClicker.getInstance().addEssences(1);
                setTotal(sylvan_essence, CosmicClicker.getInstance().getEssences());
            }
        });

    }
}