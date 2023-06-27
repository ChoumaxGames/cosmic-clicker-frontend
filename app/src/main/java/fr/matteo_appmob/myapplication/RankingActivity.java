package fr.matteo_appmob.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class RankingActivity extends AppCompatActivity {

    private LinearLayout listRanking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        int UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);

        this.listRanking = findViewById(R.id.list_ranking);

        listRanking.addView(new RankingView(getApplicationContext(), "Matteo", 1, 1_000_000));
        listRanking.addView(new RankingView(getApplicationContext(), "Mehdi", 2, 900));
        listRanking.addView(new RankingView(getApplicationContext(), "Toto", 3, 500));
        listRanking.addView(new RankingView(getApplicationContext(), "Olimerde", 4, 1));
        listRanking.addView(new RankingView(getApplicationContext(), "Moi", 5, 0));
        listRanking.addView(new RankingView(getApplicationContext(), "Tata", 6, 0));
        listRanking.addView(new RankingView(getApplicationContext(), "Test", 7, 0));

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