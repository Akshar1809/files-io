package com.akshar.Akshar1809_FilesIO;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageViewer extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);

        Intent intent = getIntent();
        String fp = intent.getStringExtra("filePath");
        imageView=findViewById(R.id.imageView);
        imageView.setImageDrawable(Drawable.createFromPath(fp));
    }
}