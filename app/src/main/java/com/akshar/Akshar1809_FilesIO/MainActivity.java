package com.akshar.Akshar1809_FilesIO;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    CardView app;
    CardView audio;
    CardView video;
    CardView photos;
    CardView documents;

    private File storage;
    private String[] storagePaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        app=findViewById(R.id.appcardview);
        audio=findViewById(R.id.audiocardview);
        video=findViewById(R.id.videocardview);
        photos=findViewById(R.id.photoscardview);
        documents=findViewById(R.id.documentcardview);

        app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storagePaths = StorageUtil.getStorageDirectories(MainActivity.this);
                for (String path : storagePaths) {
                    storage = new File(path);
                    ApplicationMethod.load_Directory_Files(storage);
                }
                Intent i=new Intent(MainActivity.this,ApplicationActivity.class);
                startActivity(i);
            }
        });

        photos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storagePaths = StorageUtil.getStorageDirectories(MainActivity.this);
                for (String path : storagePaths) {
                    storage = new File(path);
                    ImageMethod.load_Directory_Files(storage);
                }
                Intent i=new Intent(MainActivity.this,ImageActivity.class);
                startActivity(i);
            }
        });

        audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storagePaths = StorageUtil.getStorageDirectories(MainActivity.this);
                for (String path : storagePaths) {
                    storage = new File(path);
                    AudioMethod.load_Directory_Files(storage);
                }
                Intent i=new Intent(MainActivity.this,AudioActivity.class);
                startActivity(i);
            }
        });

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storagePaths = StorageUtil.getStorageDirectories(MainActivity.this);
                for (String path : storagePaths) {
                    storage = new File(path);
                    VideoMethod.load_Directory_Files(storage);
                }
                Intent i=new Intent(MainActivity.this,VideoActivity.class);
                startActivity(i);
            }
        });

        documents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storagePaths = StorageUtil.getStorageDirectories(MainActivity.this);
                for (String path : storagePaths) {
                    storage = new File(path);
                    DocumentMethod.load_Directory_Files(storage);
                }
                Intent i=new Intent(MainActivity.this,DocumentActivity.class);
                startActivity(i);
            }
        });

    }
}