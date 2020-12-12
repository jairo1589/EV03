package com.example.evaluacion_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.UUID;

import Models.Cliente;

public class firebase extends AppCompatActivity {

    private EditText etnombre, etdestino, etpromocion;
    private Button btn;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        etnombre = (EditText) findViewById(R.id.etnombre);
        etdestino = (EditText) findViewById(R.id.etdestino);
        etpromocion = (EditText) findViewById(R.id.etpromocion);
        btn = (Button) findViewById(R.id.btn);

        InicializarFirebase();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etnombre.equals("")) {
                    Cliente cliente = new Cliente();

                    cliente.setId(UUID.randomUUID().toString());
                    cliente.setNombre(etnombre.getText().toString());
                    cliente.setDestino(etdestino.getText().toString());
                    cliente.setPromocion(etpromocion.getText().toString());

                    databaseReference.child("Clientes").child(cliente.getId()).setValue(cliente);

                    Toast.makeText(getBaseContext(), "Se ha guardado!!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getBaseContext(), "No se ha guardado!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void InicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void Listado(View view){
        Intent i = new Intent(this, listado_clientes.class);
        startActivity(i);
    }
}