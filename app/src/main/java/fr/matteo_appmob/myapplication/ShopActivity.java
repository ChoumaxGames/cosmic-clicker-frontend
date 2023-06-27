package fr.matteo_appmob.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ShopActivity extends AppCompatActivity {

    ImageView btnMulti1;
    ImageView btnMulti10;
    ImageView btnMulti100;
    TextView price_upgrade1;
    TextView price_upgrade2;

    final int[] selectedMulti = {1};

    public void updateMulti(){
        if(this.selectedMulti[0] != 1) this.btnMulti1.setImageResource(R.drawable.boutton_multi);
        if(this.selectedMulti[0] != 10) this.btnMulti10.setImageResource(R.drawable.boutton_multi);
        if(this.selectedMulti[0] != 100) this.btnMulti100.setImageResource(R.drawable.boutton_multi);
        updatePrice();
    }

    public void updatePrice(){
        if(this.selectedMulti[0] == 1){
            this.price_upgrade1.setText("1000");
            this.price_upgrade2.setText("1000");
        }
        else if(this.selectedMulti[0] == 10){
            this.price_upgrade1.setText("10000");
            this.price_upgrade2.setText("10000");
        }
        else if(this.selectedMulti[0] == 100){
            this.price_upgrade1.setText("100000");
            this.price_upgrade2.setText("100000");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        this.btnMulti1 = findViewById(R.id.btn_multi1);
        this.btnMulti10 = findViewById(R.id.btn_multi10);
        this.btnMulti100 = findViewById(R.id.btn_multi100);
        this.price_upgrade1 = findViewById(R.id.price_upgrade1);
        this.price_upgrade2 = findViewById(R.id.price_upgrade2);
        btnMulti1.setImageResource(R.drawable.boutton_multi_select);

        int UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);

        ImageView btnExit = findViewById(R.id.btn_exit_shop);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

        // select multiplier shop
        this.btnMulti1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedMulti[0] = 1;
                updateMulti();
                btnMulti1.setImageResource(R.drawable.boutton_multi_select);
            }
        });


        this.btnMulti10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedMulti[0] = 10;
                updateMulti();
                btnMulti10.setImageResource(R.drawable.boutton_multi_select);
            }
        });


        this.btnMulti100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedMulti[0] = 100;
                updateMulti();
                btnMulti100.setImageResource(R.drawable.boutton_multi_select);
            }
        });


        // buy upgrades
        ImageView btnUpgrade1 = findViewById(R.id.btn_upgrade1);
        btnUpgrade1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Arboretum amélioré !", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView btnUpgrade2 = findViewById(R.id.btn_upgrade2);
        btnUpgrade2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Fonderie cristaline amélioré !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}