package fr.matteo_appmob.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final int[] cristalTotal = {0};
    final int[] sylvan_essenceTotal = {0};
    final int[] currentWord = {1};
    private String[] txt_welcome = {};

    public void setTotal(TextView place, int total){
        place.setText(String.valueOf(total));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);

        txt_welcome = getResources().getStringArray(R.array.txt_welcome);

        ImageView imgNotify = findViewById(R.id.notif);

        TextView txtNotify = findViewById(R.id.txt_notif);
        txtNotify.setText(txt_welcome[0]);

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

        threadTuto.start();

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
                                cristalTotal[0] += 2;
                                sylvan_essenceTotal[0] += 1;
                                setTotal(cristal, cristalTotal[0]);
                                setTotal(sylvan_essence, sylvan_essenceTotal[0]);
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
    }
}