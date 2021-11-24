package com.example.solemne2stgo_ignaciocodelia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class info_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    // Intent Implicitos...
    public void Marcar(View view)
    {
        Intent i = new Intent(Intent.ACTION_DIAL); //accion para marcado telefonico
        i.setData(Uri.parse("tel:"+"975141792")); //numero a marcar.
        startActivity(i);
    }

    // Intent Implicitos...
    public void Maps(View view)
    {
        Intent i = new Intent(this, MapsActivity.class);
        startActivity(i);
    }
}