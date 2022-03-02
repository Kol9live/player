package com.geektech.audioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public Button play, pause, next;
    public List<Integer> musics = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        next = (Button) findViewById(R.id.btn_next);


        musics.add(R.raw.instrumental);
        musics.add(R.raw.akon);
        musics.add(R.raw.temperature);
        final int[] index = {0};
        final MediaPlayer[] mediaPlayer = {MediaPlayer.create(MainActivity.this, musics.get(index[0]))};

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer[0].isPlaying()) {
                    mediaPlayer[0].start();
                }
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer[0].isPlaying()) {
                    mediaPlayer[0].pause();
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer[0].stop();
                index[0]++;
                if (index[0] > musics.size()-1) {
                    index[0] = 0;
                }
                mediaPlayer[0] = MediaPlayer.create(MainActivity.this, musics.get(index[0]));
                mediaPlayer[0].start();
            }
        });
    }
}