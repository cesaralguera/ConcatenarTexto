package com.example.tleng01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tleng01.configuracion.SQLiteConexion;
import com.example.tleng01.configuracion.Transacciones;

public class ActivityIngresar extends AppCompatActivity {

    EditText codigo, nombres, apellidos, edad, correo;

    Button btnAgregar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);

        codigo = (EditText) findViewById(R.id.txtCodigo);
        nombres = (EditText) findViewById(R.id.txtNombres);
        apellidos = (EditText) findViewById(R.id.txtApellidos);
        edad = (EditText) findViewById(R.id.txtEdad);
        correo = (EditText) findViewById(R.id.txtCorreo);
        btnAgregar = (Button) findViewById(R.id.btnIngresar);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgregarPersonas();
            }
        });


    }

    private void AgregarPersonas()
    {
        try {
            SQLiteConexion conexion = new SQLiteConexion(this,
                    Transacciones.NameDatabase,
                    null,
                    1);

            SQLiteDatabase db = conexion.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put(Transacciones.nombres, nombres.getText().toString());
            valores.put(Transacciones.nombres, apellidos.getText().toString());
            valores.put(Transacciones.nombres, edad.getText().toString());
            valores.put(Transacciones.nombres, correo.getText().toString());

            Long resultado = db.insert(Transacciones.tablaperson, Transacciones.id, valores);

            Toast.makeText(this, "Ingresado con exito", Toast.LENGTH_SHORT).show();

            CleanPantalla();
        }
        catch (Exception ex){
            ex.toString();
        }


    }

    private void CleanPantalla() {
        nombres.setText("");
        apellidos.setText("");
        edad.setText("");
        correo.setText("");
    }
}