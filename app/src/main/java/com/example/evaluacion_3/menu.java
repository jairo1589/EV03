package com.example.evaluacion_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import Models.Promociones;

public class menu extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        videoView = (VideoView)findViewById(R.id.videoView);
        videoView.start();

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;

        Uri uri = Uri.parse(ruta);
        videoView.setVideoURI(uri);

        MediaController media = new MediaController(this);
        videoView.setMediaController(media);
    }

    public void Gestion(View view){
        Intent i = new Intent(this, firebase.class);
        startActivity(i);
    }

    public void Promociones(View view){
        Intent i = new Intent(this, promociones.class);
        startActivity(i);
    }
}