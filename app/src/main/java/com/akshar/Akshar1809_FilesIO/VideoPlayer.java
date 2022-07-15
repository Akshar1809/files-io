package com.akshar.Akshar1809_FilesIO;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends AppCompatActivity {

    VideoView videoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        Intent intent = getIntent();
        String fp = intent.getStringExtra("filePath");

        videoPlayer = (VideoView) findViewById(R.id.videoPlayer);
        videoPlayer.setVideoPath(fp);
        videoPlayer.setMediaController(new MediaController(this));

        videoPlayer.start();
    }
}