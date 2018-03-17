package com.example.user.weather;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        String time = getIntent().getStringExtra("Time");
        int num = getIntent().getIntExtra("Num", 0);

        Uri uri=Uri.parse("https://raw.githubusercontent.com/chia56028/TEST/master/The%20Sun%20-%20Pyramid%20Hologram%20Technology%20HOLHO.mp4");

        if(time.equals("day")){
            for(int i=1; i<=34; i++){
                if(num == i) uri=Uri.parse("https://raw.githubusercontent.com/chia56028/Weather/master/WEATHER_GIF/day"+i+".mp4");
            }
        }else{
            for(int i=1; i<=34; i++){
                if(num == i) uri=Uri.parse("https://raw.githubusercontent.com/chia56028/Weather/master/WEATHER_GIF/night"+i+".mp4");
            }
        }

        video(uri);
    }

    protected void video(Uri uri) {
        VideoView videoView =(VideoView)findViewById(R.id.videoView);
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent intent = new Intent();
                intent.setClass(Video.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
