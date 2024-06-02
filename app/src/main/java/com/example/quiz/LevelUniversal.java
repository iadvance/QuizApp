package com.example.quiz;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.Random;

public class LevelUniversal extends AppCompatActivity {

    Dialog dialog, dialogEnd;
    public int numLeft, numRight;
    public int cnt = 0;
    int curLevel, nextLevel;
    int[] ImageArr, TextArr;
    TextView btnClose, btnClose2, textLevels;
    Array array = new Array();
    Random random = new Random();
    Random randomFact = new Random();
    Intent nextLevelIntent;

    Button btnOK, btnOK2, btnBack;
    private MediaPlayer pressButtonSound, pressCorrect, pressWrong, winAlert;

    private void soundPlay(MediaPlayer sound) {
        sound.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_universal);

        final ImageView img_left = (ImageView) findViewById(R.id.img_left);
        final ImageView img_right = (ImageView) findViewById(R.id.img_right);
        img_left.setClipToOutline(true);
        img_right.setClipToOutline(true);

        final TextView text_left = findViewById(R.id.text_left);
        final TextView text_right = findViewById(R.id.text_right);
        pressButtonSound = (MediaPlayer) MediaPlayer.create(this, R.raw.button);
        pressCorrect = (MediaPlayer) MediaPlayer.create(this, R.raw.correct);
        pressWrong = (MediaPlayer) MediaPlayer.create(this, R.raw.wrong);
        winAlert = (MediaPlayer) MediaPlayer.create(this, R.raw.win);
        textLevels = (TextView) findViewById(R.id.textLevels);
        final int[] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,
                R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10,
        };
        final Animation a = AnimationUtils.loadAnimation(LevelUniversal.this, R.anim.alpha);
        final Animation c = AnimationUtils.loadAnimation(LevelUniversal.this, R.anim.correct);

        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
        final int level = save.getInt("Level", 1);
        SharedPreferences.Editor editor = save.edit();

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // диалог перед уровнем
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.previewdialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);

        TextView description = (TextView) dialog.findViewById(R.id.textDescribe);

        // диалог после уровня
        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEnd.setContentView(R.layout.dialogend);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false);

        TextView textdescr = (TextView) dialogEnd.findViewById(R.id.textDescribe);

        // Кнопка диалог стрелка назад
        btnClose = (TextView) dialog.findViewById(R.id.btnclose);

        // Кнопка диалог далее
        btnOK = (Button) dialog.findViewById(R.id.btncontinue);

        // Кнопка диалог конец стрелка назад
        btnClose2 = (TextView) dialogEnd.findViewById(R.id.btnclose);

        // Кнопка диалог конец следующий уровень
        btnOK2 = (Button) dialogEnd.findViewById(R.id.btncontinue);

        // кнопка назад уровень
        btnBack = (Button) findViewById(R.id.btnBack);

        // Распеределение по уровням
        String levelChioce = getIntent().getStringExtra("LevelChoice");
        switch (levelChioce) {
            case ("Level1"):
                description.setText(R.string.levelone);
                dialog.show();
                textLevels.setText(R.string.level1);
                textdescr.setText(array.factsArr1[randomFact.nextInt(array.factsArr1.length)]);
                nextLevelIntent = new Intent(LevelUniversal.this, LevelUniversal.class);
                nextLevelIntent.putExtra("LevelChoice", "Level2");
                while (numLeft == numRight) {
                    numRight = random.nextInt(9);
                    numLeft = random.nextInt(9);
                }
                ImageArr = array.img;
                TextArr = array.texts1;

                curLevel = 1;
                nextLevel = 2;
                break;
            case ("Level2"):
                description.setText(R.string.leveltwo);
                dialog.show();
                textLevels.setText(R.string.level2);
                textdescr.setText(array.factsArr2[randomFact.nextInt(array.factsArr2.length)]);
                nextLevelIntent = new Intent(LevelUniversal.this, LevelUniversal.class);
                nextLevelIntent.putExtra("LevelChoice", "Level3");
                while (numLeft == numRight) {
                    numRight = random.nextInt(10);
                    numLeft = random.nextInt(10);
                }
                ImageArr = array.img2;
                TextArr = array.texts2;

                curLevel = 2;
                nextLevel = 3;
                break;
            case ("Level3"):
                description.setText(R.string.levelthree);
                dialog.show();
                textLevels.setText(R.string.level3);
                textdescr.setText(array.factsArr3[randomFact.nextInt(array.factsArr3.length)]);
                nextLevelIntent = new Intent(LevelUniversal.this, LevelUniversal.class);
                nextLevelIntent.putExtra("LevelChoice", "Level4");
                while (numLeft == numRight) {
                    numRight = random.nextInt(10);
                    numLeft = random.nextInt(10);
                }
                ImageArr = array.img3;
                TextArr = array.texts3;

                curLevel = 3;
                nextLevel = 4;
                break;
            case ("Level4"):
                description.setText(R.string.levelfour);
                dialog.show();
                textLevels.setText(R.string.level4);
                text_right.setTextSize(19);
                text_left.setTextSize(19);
                textdescr.setText(array.factsArr4[randomFact.nextInt(array.factsArr4.length)]);
                nextLevelIntent = new Intent(LevelUniversal.this, LevelUniversal.class);
                nextLevelIntent.putExtra("LevelChoice", "Level5");
                while (numLeft == numRight) {
                    numRight = random.nextInt(10);
                    numLeft = random.nextInt(10);
                }
                ImageArr = array.img4;
                TextArr = array.texts4;

                curLevel = 4;
                nextLevel = 5;
                break;
            case ("Level5"):
                description.setText(R.string.levelfive);
                dialog.show();
                textLevels.setText(R.string.level5);
                textdescr.setText(array.factsArr5[randomFact.nextInt(array.factsArr5.length)]);
                nextLevelIntent = new Intent(LevelUniversal.this, LevelUniversal.class);
                nextLevelIntent.putExtra("LevelChoice", "Level6");
                while (numLeft == numRight) {
                    numRight = random.nextInt(10);
                    numLeft = random.nextInt(10);
                }
                ImageArr = array.img5;
                TextArr = array.texts5;

                curLevel = 5;
                nextLevel = 6;
                break;
            case ("Level6"):
                description.setText(R.string.levelsix);
                dialog.show();
                textLevels.setText(R.string.level6);
                text_right.setTextSize(15);
                text_left.setTextSize(15);
                textdescr.setText(array.factsArr6[randomFact.nextInt(array.factsArr6.length)]);
                nextLevelIntent = new Intent(LevelUniversal.this, LevelUniversal.class);
                nextLevelIntent.putExtra("LevelChoice", "Level7");
                while (numLeft == numRight) {
                    numRight = random.nextInt(10);
                    numLeft = random.nextInt(10);
                }
                ImageArr = array.img6;
                TextArr = array.texts6;

                curLevel = 6;
                nextLevel = 7;
                break;
            case ("Level7"):
                description.setText(R.string.levelseven);
                dialog.show();
                textLevels.setText(R.string.level7);
                text_right.setTextSize(17);
                text_left.setTextSize(17);
                textdescr.setText(array.factsArr7[randomFact.nextInt(array.factsArr7.length)]);
                nextLevelIntent = new Intent(LevelUniversal.this, LevelUniversal.class);
                nextLevelIntent.putExtra("LevelChoice", "Level8");
                while (numLeft == numRight) {
                    numRight = random.nextInt(10);
                    numLeft = random.nextInt(10);
                }
                ImageArr = array.img7;
                TextArr = array.texts7;

                curLevel = 7;
                nextLevel = 8;
                break;
            case ("Level8"):
                description.setText(R.string.leveleight);
                dialog.show();
                textLevels.setText(R.string.level8);
                text_right.setTextSize(16);
                text_left.setTextSize(16);
                textdescr.setText(array.factsArr8[randomFact.nextInt(array.factsArr8.length)]);
                nextLevelIntent = new Intent(LevelUniversal.this, LevelUniversal.class);
                nextLevelIntent.putExtra("LevelChoice", "Level9");
                while (numLeft == numRight) {
                    numRight = random.nextInt(10);
                    numLeft = random.nextInt(10);
                }
                ImageArr = array.img8;
                TextArr = array.texts8;

                curLevel = 8;
                nextLevel = 9;
                break;
            case ("Level9"):
                description.setText(R.string.levelnine);
                dialog.show();
                textLevels.setText(R.string.level9);
                text_right.setTextSize(18);
                text_left.setTextSize(18);
                textdescr.setText(array.factsArr9[randomFact.nextInt(array.factsArr9.length)]);
                nextLevelIntent = new Intent(LevelUniversal.this, LevelUniversal.class);
                nextLevelIntent.putExtra("LevelChoice", "Level10");
                while (numLeft == numRight) {
                    numRight = random.nextInt(10);
                    numLeft = random.nextInt(10);
                }
                ImageArr = array.img9;
                TextArr = array.texts9;

                curLevel = 9;
                nextLevel = 10;
                break;
            case ("Level10"):
                textLevels.setText(R.string.level10);
                description.setText(R.string.levelten);
                dialog.show();
                textdescr.setText(array.factsArr10[randomFact.nextInt(array.factsArr10.length)]);
                nextLevelIntent = new Intent(LevelUniversal.this, GameLevels.class);
                while (numLeft == numRight) {
                    numRight = random.nextInt(10);
                    numLeft = random.nextInt(10);
                }
                ImageArr = array.img10;
                TextArr = array.texts10;

                curLevel = 10;
                nextLevel = 10;
                break;
        }

        // Кнопка диалог стрелка назад
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    soundPlay(pressButtonSound);
                    Intent i = new Intent(LevelUniversal.this, GameLevels.class);
                    startActivity(i);
                    finish();
                } catch (Exception e) {

                }
                dialog.dismiss();
            }
        });

        // Кнопка диалог далее
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    soundPlay(pressButtonSound);
                    dialog.dismiss();
                } catch (Exception e) {

                }
            }
        });

        // Кнопка диалог конец стрелка назад
        btnClose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    soundPlay(pressButtonSound);
                    Intent i = new Intent(LevelUniversal.this, GameLevels.class);
                    startActivity(i);
                    finish();
                } catch (Exception e) {

                }
                dialog.dismiss();
            }
        });

        // Кнопка диалог конец переход на следующий уровень
        btnOK2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    soundPlay(pressButtonSound);
                    startActivity(nextLevelIntent);
                    finish();
                } catch (Exception e) {

                }
                dialog.dismiss();
            }
        });
        // замена кон

        // кнопка назад уровень
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    soundPlay(pressButtonSound);
                    Intent i = new Intent(LevelUniversal.this, GameLevels.class);
                    startActivity(i);
                    finish();
                } catch (Exception e) {

                }
                dialog.dismiss();
            }
        });

        while (numLeft == numRight) {
            numRight = random.nextInt(ImageArr.length);
            numLeft = random.nextInt(ImageArr.length);
        }

        img_left.setImageResource(ImageArr[numLeft]);
        text_left.setText(TextArr[numLeft]);

        img_right.setImageResource(ImageArr[numRight]);
        text_right.setText(TextArr[numRight]);

        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    img_right.setEnabled(false);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (numLeft > numRight) {
                        soundPlay(pressCorrect);
                        if (cnt < 10) {
                            cnt += 1;
                        }
                        for (int i = 0; i < 10; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                        for (int i = 0; i < cnt; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                            tv.startAnimation(c);
                        }

                    }
                    else {
                        soundPlay(pressWrong);
                        if (cnt > 0) {
                            if (cnt == 1) {
                                cnt = 0;
                            } else {
                                cnt -= 2;
                            }
                        }
                        // Момент с 9
                        for (int i = 0; i < 10; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < cnt; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                            tv.startAnimation(c);
                        }
                    }
                    if (cnt == 10) {
                        //новый уровень


                        if (level > curLevel) {

                        } else {
                            editor.putInt("Level", nextLevel);
                            editor.commit();
                        }
                        soundPlay(winAlert);
                        dialogEnd.show();
                    } else {
                        numRight = random.nextInt(ImageArr.length);
                        numLeft = random.nextInt(ImageArr.length);
                        while (numLeft == numRight) {
                            numRight = random.nextInt(ImageArr.length);
                            numLeft = random.nextInt(ImageArr.length);
                        }
                        img_left.setImageResource(ImageArr[numLeft]);
                        img_right.setImageResource(ImageArr[numRight]);

                        text_left.setText(TextArr[numLeft]);
                        text_right.setText(TextArr[numRight]);

                        img_left.startAnimation(a);
                        img_right.startAnimation(a);

                        img_right.setEnabled(true);
                    }

                }
                return true;
            }
        });

        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    img_left.setEnabled(false);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (numLeft < numRight) {
                        soundPlay(pressCorrect);
                        if (cnt < 10) {
                            cnt += 1;
                        }
                        for (int i = 0; i < 10; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                        for (int i = 0; i < cnt; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                            tv.startAnimation(c);
                        }

                    } else {
                        soundPlay(pressWrong);
                        if (cnt > 0) {
                            if (cnt == 1) {
                                cnt = 0;
                            } else {
                                cnt -= 2;
                            }
                        }
                        // Момент с 9
                        for (int i = 0; i < 10; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                        for (int i = 0; i < cnt; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                            tv.startAnimation(c);
                        }
                    }
                    if (cnt == 10) {
                        // замена id по id уровня
                        //новый уровень


                        if (level > curLevel) {

                        } else {
                            editor.putInt("Level", nextLevel);
                            editor.commit();
                        }
                        // замена конец
                        soundPlay(winAlert);
                        dialogEnd.show();
                    } else {
                        numRight = random.nextInt(ImageArr.length);
                        numLeft = random.nextInt(ImageArr.length);
                        while (numLeft == numRight) {
                            numRight = random.nextInt(ImageArr.length);
                            numLeft = random.nextInt(ImageArr.length);
                        }
                        img_left.setImageResource(ImageArr[numLeft]);
                        img_right.setImageResource(ImageArr[numRight]);

                        img_left.startAnimation(a);
                        img_right.startAnimation(a);

                        text_left.setText(TextArr[numLeft]);
                        text_right.setText(TextArr[numRight]);

                        img_left.setEnabled(true);
                    }

                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        try {
            Intent i = new Intent(LevelUniversal.this, GameLevels.class);
            startActivity(i);
            finish();
        } catch (Exception e) {

        }
    }
}