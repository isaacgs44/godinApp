package com.example.toshiba.godin;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarTarjeta extends AppCompatActivity{
    EditText edtAlias;
    EditText edtSaldo;
    Button btnAgregar;
    Usuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_tarjeta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();

        this.usuario = (Usuario) extras.getSerializable("USER");
        System.out.println("Usuario: " + usuario.getNombre());
        for(Tarjeta t :usuario.getTarjetas()){
            System.out.println("Tarjeta: " + t.getNombre());

        }
        edtAlias = (EditText) findViewById(R.id.edt_alias);
        edtSaldo = (EditText) findViewById(R.id.edt_saldo);
        btnAgregar = (Button) findViewById(R.id.btn_agregarTarjeta);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Nombre: " + edtAlias.getText().toString());
                System.out.println("Saldo: " + Double.parseDouble(edtSaldo.getText().toString()));

                usuario.addTarjeta(edtAlias.getText().toString(),Double.parseDouble(edtSaldo.getText().toString()));
                Toast.makeText(AgregarTarjeta.this, "Tarjeta agregada", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }







}
