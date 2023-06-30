package fr.matteo_appmob.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.IOException;

import fr.matteo_appmob.myapplication.backend.api.ApiUser;

public class RankingActivity extends AppCompatActivity {

    private LinearLayout listRanking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        int UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);

        this.listRanking = findViewById(R.id.list_ranking);

        this.listRanking.addView(new RankingView(this, "Matteo", 1, 10000));
        this.listRanking.addView(new RankingView(this, "Mehdi", 2, 9000));
        this.listRanking.addView(new RankingView(this, "Théo", 3, 1000));
        this.listRanking.addView(new RankingView(this, "Toto", 4, 100));
        this.listRanking.addView(new RankingView(this, "Véro", 5, 10));
        this.listRanking.addView(new RankingView(this, "Olivétom", 6, 1));

        ImageView btnExit = findViewById(R.id.btn_exit_ranking);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });
    }
}