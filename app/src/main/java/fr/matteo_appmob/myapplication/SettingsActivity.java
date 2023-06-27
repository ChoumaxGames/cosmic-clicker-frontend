package fr.matteo_appmob.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SettingsActivity extends AppCompatActivity {
    ImageView btnMute;
    ImageView btnUnmute;

    boolean sound = true;

    public void updateSound(){
        if(sound){
            this.btnMute.setImageResource(R.drawable.mute);
            this.btnUnmute.setImageResource(R.drawable.sound_select);
        } else {
            this.btnMute.setImageResource(R.drawable.mute_select);
            this.btnUnmute.setImageResource(R.drawable.sound);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        int UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);

        btnMute = findViewById(R.id.btn_mute_settings);
        btnUnmute = findViewById(R.id.btn_unmute_settings);

        updateSound();

        ImageView btnExit = findViewById(R.id.btn_exit_settings);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

        btnMute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound = false;
                updateSound();
            }
        });

        btnUnmute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound = true;
                updateSound();
            }
        });
    }
}