package com.example.qthjen.mediaonline;

import  android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btPlay, btVideo;
    ProgressBar pb;
    VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btPlay = (Button) findViewById(R.id.btPlay);
        btVideo = (Button) findViewById(R.id.btVideo);
        pb = (ProgressBar) findViewById(R.id.pb);
        vv = (VideoView) findViewById(R.id.vv);

        pb.setVisibility(View.GONE);
        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "http://khoapham.vn/download/vietnamoi.mp3";
                MediaPlayer media = new MediaPlayer();
                media.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    media.setDataSource(url);
                    media.prepareAsync();
                    pb.setVisibility(View.VISIBLE);
                    media.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            pb.setVisibility(View.GONE);
                            mediaPlayer.start();
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        btVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://khoapham.vn/download/vuoncaovietnam.mp4");
                vv.setVideoURI(uri);
                vv.setMediaController(new MediaController(MainActivity.this));
                vv.start();
            }
        });

    }
}
