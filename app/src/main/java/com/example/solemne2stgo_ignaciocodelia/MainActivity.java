package com.example.solemne2stgo_ignaciocodelia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import Objetos.Administrador;
import Objetos.Insumos;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private TextView msj;
    private Button btn;
    private ProgressBar barra;
    private Administrador adm = new Administrador(); //instancia del obj administrador.



    // Ciclo de vida Oncreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.etuser);
        pass = findViewById(R.id.etpass);
        msj = findViewById(R.id.msj);
        btn = findViewById(R.id.btn);
        barra = findViewById(R.id.pb);

        msj.setVisibility(View.INVISIBLE); //Maneja la visibilidad de un elemneto.
        barra.setVisibility(View.INVISIBLE);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Aqui voy a correr mi tarea.
                new Task().execute();

            }
        });


    }
    // Tarea Asincrona.
    class Task extends AsyncTask<String, Void, String>
    {   // es donde puedo dar la configuracion inicial ammi tarea.
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barra.setVisibility(View.VISIBLE); //hago visible mi barra.
        }

        // es el encargado de procesar en segundo plano nuestra tarea pesada.
        @Override
        protected String doInBackground(String... strings) {

            try{
                for(int i = 0; i <= 10; i++)
                {
                    Thread.sleep(500); // Duerme un proceso por 2000milis.
                }
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }

            return null;
        }

        // Es donde finaliza mi tarea asincrona
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            barra.setVisibility(View.INVISIBLE);


            String usuario = user.getText().toString().trim();
            String contrasena = pass.getText().toString().trim();

            String userObj = adm.getUser().trim();
            String passObj = adm.getPass().trim();

            switch(usuario)
            {
                case "Ignacio":
                    if(usuario.equals(userObj) && contrasena.equals(passObj))
                    {
                        //Inicio Sesión
                        msj.setVisibility(View.INVISIBLE);
                        Intent i = new Intent(getBaseContext(), Home_act.class);

                        startActivity(i);
                    }
                    break;
                case "":
                    if(usuario.equals("") && contrasena.equals(""))
                    {
                        //Campos Vacios ...
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Campos vacíos porfavor intente denuevo");
                    }
                    break;
                default:
                    if(!usuario.equals(userObj) && !contrasena.equals(passObj))
                    {
                        // Campos incorrectos
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Campos incorrectos porfavor intente nuevamente");
                    }
            }

        }
    }


    public void Facebook(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); // aacion abrir sitio web
        i.setData(Uri.parse("https://www.facebook.com/")); // le paso la direccion web.
        startActivity(i);
    }
    public void Youtube(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); // aacion abrir sitio web
        i.setData(Uri.parse("https://www.youtube.com/")); // le paso la direccion web.
        startActivity(i);
    }
    public void Twitter(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); // aacion abrir sitio web
        i.setData(Uri.parse("https://www.twitter.com/")); // le paso la direccion web.
        startActivity(i);
    }
    public void Info(View view)
    {
        Intent i = new Intent(this, info_act.class);
        startActivity(i);
    }
    public void cerrar(View view)
    {
        finish();
    }
}