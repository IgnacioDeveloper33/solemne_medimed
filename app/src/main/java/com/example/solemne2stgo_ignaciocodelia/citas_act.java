package com.example.solemne2stgo_ignaciocodelia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.solemne2stgo_ignaciocodelia.database.AdminSQLiteOpenHelper;

public class citas_act extends AppCompatActivity {

    private EditText code, dia, espe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);

        code = findViewById(R.id.cod);
        dia = findViewById(R.id.dia);
        espe = findViewById(R.id.esp);

    }

    // mETODO PARA GUARdar citas

    public void guardarCitas(View view)
    {
        //obtengo mi database...
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "medimec", null,1);
        SQLiteDatabase db = admin.getWritableDatabase(); // Me permite sobreescribir mi base de datos.

        //Obtengo los valores que escribe el cliente.
        String codigo = code.getText().toString();
        String dias = dia.getText().toString();
        String especialidad = espe.getText().toString();

        if(!codigo.isEmpty() && !dias.isEmpty() && !especialidad.isEmpty())
        {
            //Guardo Datos
            ContentValues cont = new ContentValues(); // Me permite contener Valores
            cont.put("codigo", codigo);
            cont.put("dia", dias);
            cont.put("especialidad", especialidad);

            db.insert("citas", null, cont);
            db.close();

            Clean();
            Toast.makeText(getBaseContext(), "Has guardado una cita", Toast.LENGTH_SHORT).show();


        }else
            {
                Toast.makeText(getBaseContext(), "Los campos no pueden ir vacios",Toast.LENGTH_SHORT).show();
            }

    }

    //Metodo para consultar citas
    public void mostrarCitas(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "medimec", null,1);
        SQLiteDatabase db = admin.getWritableDatabase(); // Me permite sobreescribir mi base de datos.

        //Obtengo los valores que escribe el cliente.
        String codigo = code.getText().toString();
        String dias = dia.getText().toString();
        String especialidad = espe.getText().toString();

        if(!codigo.isEmpty())
        {
            //Mostramos los Campos
            Cursor file = db.rawQuery("SELECT dia, especialidad FROM citas WHERE codigo="+codigo, null);

            if(file.moveToFirst())// comprobar si mi consulta tiene o no tiene valores
            {
                espe.setText(file.getString(0)); // muestro por posicion
                dia.setText(file.getString(1));


            }else
                {
                    Toast.makeText(getBaseContext(), "No hay cita asociada",Toast.LENGTH_SHORT).show();
                }


        }else
            {
                Toast.makeText(getBaseContext(), "El código esta vacío", Toast.LENGTH_SHORT).show();
            }

    }

    //metodo para eliminar citas
    public void eliminarClases(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "medimec", null,1);
        SQLiteDatabase db = admin.getWritableDatabase(); // Me permite sobreescribir mi base de datos.

        String codigo = code.getText().toString();

        if(!codigo.isEmpty())
        {
            //Para eliminar
            db.delete("citas","codigo="+codigo, null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(),"has eliminado la cita: "+codigo, Toast.LENGTH_SHORT).show();

        }else
            {
                Toast.makeText(getBaseContext(), "Ingrese código porfavor", Toast.LENGTH_SHORT).show();
            }

    }

    //metod para actualizar clases
    public void actualizarClases(View view)
    {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "medimec", null,1);
        SQLiteDatabase db = admin.getWritableDatabase(); // Me permite sobreescribir mi base de datos.

        //Obtengo los valores que escribe el cliente.
        String codigo = code.getText().toString();
        String dias = dia.getText().toString();
        String especialidad = espe.getText().toString();

        if(!codigo.isEmpty() && !dias.isEmpty() && !especialidad.isEmpty())
        {
            ContentValues cont = new ContentValues();
            cont.put("dia", dias);
            cont.put("especialidad", especialidad);

            db.update("citas", cont, "codigo="+codigo, null);
            db.close();
            Clean();

            Toast.makeText(getBaseContext(), "Has Actualizado!!", Toast.LENGTH_SHORT).show();

        }
        else
            {
                Toast.makeText(getBaseContext(), "Hay campos vacíos", Toast.LENGTH_SHORT).show();
            }

    }

    //metodo para limpiar campos
    public void Clean()
    {
        code.setText("");
        dia.setText("");
        espe.setText("");
    }

}