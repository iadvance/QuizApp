package com.example.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    Button btnBack;
    LinearLayout levels_cont;
    private MediaPlayer pressButtonSound, pressLockedLevel;
    TextView lvl1, lvl2, lvl3, lvl4, lvl5,
            lvl6, lvl7, lvl8, lvl9, lvl10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
        final int level = save.getInt("Level", 1);
        Intent intent = new Intent(GameLevels.this, LevelUniversal.class);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnBack = (Button) findViewById(R.id.btn_back);
        levels_cont = (LinearLayout) findViewById(R.id.cont1);
        pressButtonSound = (MediaPlayer) MediaPlayer.create(this, R.raw.button);
        pressLockedLevel = (MediaPlayer) MediaPlayer.create(this, R.raw.locked_level);

        final Animation a = AnimationUtils.loadAnimation(GameLevels.this, R.anim.start_activ_anim);
        final Animation locked_level = AnimationUtils.loadAnimation(GameLevels.this, R.anim.locked_level);
        levels_cont.startAnimation(a);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    soundPlay(pressButtonSound);
                    Intent i = new Intent(GameLevels.this, MainActivity.class);
                    startActivity(i);
                    finish();
                } catch (Exception e) {

                }
            }
        });
        // уровень 1
        lvl1 = (TextView) findViewById(R.id.textView1);
        lvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 1) {
                        soundPlay(pressButtonSound);
                        intent.putExtra("LevelChoice", "Level1");
                        startActivity(intent);
                        finish();
                    }
                } catch (Exception e) {

                }
            }
        });
        // уровень 2
        lvl2 = (TextView) findViewById(R.id.textView2);
        lvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 2) {
                        soundPlay(pressButtonSound);
                        intent.putExtra("LevelChoice", "Level2");
                        startActivity(intent);
                        finish();
                    } else {
                        lvl2.startAnimation(locked_level);
                        soundPlay(pressLockedLevel);
                    }
                } catch (Exception e) {

                }
            }
        });
        // уровень 3
        lvl3 = (TextView) findViewById(R.id.textView3);
        lvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 3) {
                        soundPlay(pressButtonSound);
                        intent.putExtra("LevelChoice", "Level3");
                        startActivity(intent);
                        finish();
                    } else {
                        lvl3.startAnimation(locked_level);
                        soundPlay(pressLockedLevel);
                    }
                } catch (Exception e) {

                }
            }
        });
        // уровень 4
        lvl4 = (TextView) findViewById(R.id.textView4);
        lvl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 4) {
                        soundPlay(pressButtonSound);
                        intent.putExtra("LevelChoice", "Level4");
                        startActivity(intent);
                        finish();
                    } else {
                        lvl4.startAnimation(locked_level);
                        soundPlay(pressLockedLevel);
                    }
                } catch (Exception e) {

                }
            }
        });
        // уровень 5
        lvl5 = (TextView) findViewById(R.id.textView5);
        lvl5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 5) {
                        soundPlay(pressButtonSound);
                        intent.putExtra("LevelChoice", "Level5");
                        startActivity(intent);
                        finish();
                    } else {
                        lvl5.startAnimation(locked_level);
                        soundPlay(pressLockedLevel);
                    }
                } catch (Exception e) {

                }
            }
        });
        // уровень 6
        lvl6 = (TextView) findViewById(R.id.textView6);
        lvl6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 6) {
                        soundPlay(pressButtonSound);
                        intent.putExtra("LevelChoice", "Level6");
                        startActivity(intent);
                        finish();
                    } else {
                        lvl6.startAnimation(locked_level);
                        soundPlay(pressLockedLevel);
                    }
                } catch (Exception e) {

                }
            }
        });
        // уровень 7
        lvl7 = (TextView) findViewById(R.id.textView7);
        lvl7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 7) {
                        soundPlay(pressButtonSound);
                        intent.putExtra("LevelChoice", "Level7");
                        startActivity(intent);
                        finish();
                    } else {
                        lvl7.startAnimation(locked_level);
                        soundPlay(pressLockedLevel);
                    }
                } catch (Exception e) {

                }
            }
        });
        // уровень 8
        lvl8 = (TextView) findViewById(R.id.textView8);
        lvl8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 8) {
                        soundPlay(pressButtonSound);
                        intent.putExtra("LevelChoice", "Level8");
                        startActivity(intent);
                        finish();
                    } else {
                        lvl8.startAnimation(locked_level);
                        soundPlay(pressLockedLevel);
                    }
                } catch (Exception e) {

                }
            }
        });
        // уровень 9
        lvl9 = (TextView) findViewById(R.id.textView9);
        lvl9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 9) {
                        soundPlay(pressButtonSound);
                        intent.putExtra("LevelChoice", "Level9");
                        startActivity(intent);
                        finish();
                    } else {
                        lvl9.startAnimation(locked_level);
                        soundPlay(pressLockedLevel);
                    }
                } catch (Exception e) {

                }
            }
        });
        // уровень 10
        lvl10 = (TextView) findViewById(R.id.textView10);
        lvl10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 10) {
                        soundPlay(pressButtonSound);
                        intent.putExtra("LevelChoice", "Level10");
                        startActivity(intent);
                        finish();
                    } else {
                        lvl10.startAnimation(locked_level);
                        soundPlay(pressLockedLevel);
                    }
                } catch (Exception e) {

                }
            }
        });

        final int[] levelsArr = {
                R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4, R.id.textView5,
                R.id.textView6, R.id.textView7, R.id.textView8, R.id.textView9, R.id.textView10,
        };

        for (int i = 0; i < level; i++) {
            TextView tv = findViewById(levelsArr[i]);
            tv.setText("" + (i + 1));
        }

    }

    private void soundPlay(MediaPlayer sound) {
        if(sound.isPlaying()){
            sound.stop();
        }
        sound.start();
    }

    @Override
    public void onBackPressed() {
        try {
            Intent i = new Intent(GameLevels.this, MainActivity.class);
            startActivity(i);
            finish();
        } catch (Exception e) {

        }
    }


}