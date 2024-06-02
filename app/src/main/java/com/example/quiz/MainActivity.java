package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.badge.BadgeUtils;

public class MainActivity extends AppCompatActivity {

    Button bntStart, btnSettings, btnReset, btnOpenAll, buttonExit;
    ImageView main_logo;
    TextView btnBack, btnClose;
    Dialog dialog;
    LinearLayout startLayout;
    private long backPressedTime;
    private Toast backToast;
    private MediaPlayer pressButtonSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.settings);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);

        btnClose = (TextView) dialog.findViewById(R.id.btnclose);
        btnBack = (Button) dialog.findViewById(R.id.btnBack);
        bntStart = (Button) findViewById(R.id.buttonStart);
        btnSettings = (Button) findViewById(R.id.buttonSettings);
        buttonExit = (Button) findViewById(R.id.buttonExit);
        btnReset = (Button) dialog.findViewById(R.id.btnReset);
        btnOpenAll = (Button) dialog.findViewById(R.id.btnOpenAll);
        main_logo = (ImageView) findViewById(R.id.main_logo);
        startLayout = (LinearLayout) findViewById(R.id.startLayout);
        pressButtonSound = (MediaPlayer) MediaPlayer.create(this, R.raw.button);

        final Animation a = AnimationUtils.loadAnimation(MainActivity.this, R.anim.start_activ_anim);
        final Animation b = AnimationUtils.loadAnimation(MainActivity.this, R.anim.locked_level);
        final Animation start = AnimationUtils.loadAnimation(MainActivity.this, R.anim.logo_anim);
        main_logo.startAnimation(start);
        startLayout.startAnimation(a);

        // Начало
        bntStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    main_logo.startAnimation(b);
                    soundPlay(pressButtonSound);
                    Intent intent = new Intent(MainActivity.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });
        // Открытие насторек
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main_logo.startAnimation(b);
                soundPlay(pressButtonSound);
                dialog.show();
            }
        });
        // Стрелочка закрытия настроек
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    soundPlay(pressButtonSound);
                    dialog.dismiss();
                } catch (Exception e) {

                }
                dialog.dismiss();
            }
        });
        // Кнопка закрытия настроек
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    soundPlay(pressButtonSound);
                    dialog.dismiss();
                } catch (Exception e) {

                }
            }
        });
        // Ресет рогресса
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    soundPlay(pressButtonSound);
                    SharedPreferences.Editor editor = getSharedPreferences("Save", MODE_PRIVATE).edit();
                    editor.putInt("Level", 1);
                    editor.commit();
                    Toast.makeText(getBaseContext(), "Игровой прогресс обнулен", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {

                }
            }
        });
        // Открыть все уровни
        btnOpenAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    soundPlay(pressButtonSound);
                    SharedPreferences.Editor editor = getSharedPreferences("Save", MODE_PRIVATE).edit();
                    editor.putInt("Level", 10);
                    editor.commit();
                    Toast.makeText(getBaseContext(), "Открыты все уровни", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {

                }
            }
        });
        // Выход
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main_logo.startAnimation(b);
                soundPlay(pressButtonSound);
                if (backPressedTime + 2000 > System.currentTimeMillis()) {
                    backToast.cancel();
                    finish();
                } else {
                    backToast = Toast.makeText(getBaseContext(), "Нажмите еще раз, чтобы выйти из Quiz", Toast.LENGTH_SHORT);
                    backToast.show();
                }
                backPressedTime = System.currentTimeMillis();
            }
        });
        // logo
        main_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(pressButtonSound);
            }
        });
    }

    private void soundPlay(MediaPlayer sound) {
        if(sound.isPlaying()){
            sound.stop();
        }
        sound.start();
    }

    @Override
    public void onBackPressed() {
        main_logo.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.locked_level));
        soundPlay(pressButtonSound);
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Нажмите еще раз, чтобы выйти из Quiz", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();

    }
}