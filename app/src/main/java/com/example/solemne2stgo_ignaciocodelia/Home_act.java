package com.example.solemne2stgo_ignaciocodelia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import Objetos.Insumos;


public class Home_act extends AppCompatActivity {

    private VideoView video;
    private Insumos in = new Insumos(); // Instancia del obj insumos.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        video = findViewById(R.id.vw); // llamo al video

        //obtener la ruta del video

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta); // parseo la ruta

        video.setVideoURI(uri); // le paso mi ruta al videoView

        // Controles para el video

        MediaController media = new MediaController(this);
        video.setMediaController(media);

    }


    // Una tarea o un proceso muy largo
    //public void Task(View view)
    //{
     //   try{
       //     for( int i = 0; i <= 10; i++)
         //   {
           //     Thread.sleep(2000);
           //     Toast.makeText(this,"este es un gran proces", Toast.LENGTH_SHORT).show();
         //   }

       // }catch (InterruptedException e)
        //{
         //   e.printStackTrace();
        //}
    //}

    public void Insumos(View view)
    {
        Intent i = new Intent(this, Insumos_act.class);

        Bundle bun = new Bundle(); //Necesario para enviar arreglos.
        bun.putStringArray("insumos", in.getInsumos()); //relleno el bundle.
        i.putExtras(bun); //le paso mi bundle al intent.

        startActivity(i);
    }

    public void Citas(View view)
    {
        Intent i = new Intent(this, citas_act.class);
        startActivity(i);
    }

}