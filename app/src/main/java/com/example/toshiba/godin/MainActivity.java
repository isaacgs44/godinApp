package com.example.toshiba.godin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private Usuario usuario;
    ListView listaTarjetas;
    public TarjetasAdapter tarjetasAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Usuario usuario = new Usuario("isaac");

        tarjetasAdapter = new TarjetasAdapter(this,usuario.getTarjetas());

        listaTarjetas = (ListView) findViewById(R.id.ListViewTarjetas);
        listaTarjetas.setAdapter(tarjetasAdapter);

    }


    //Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.mnuAgregarTarjeta) {
            lanzarAgregarTarjeta();
        }

        return super.onOptionsItemSelected(item);
    }

    private void lanzarAgregarTarjeta() {
        Intent i = new Intent(MainActivity.this, AgregarTarjeta.class );
        i.putExtra("USER",this.usuario); // el objeto que se manda debe ser Serializable
        startActivityForResult(i,1);
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data ){
        if(requestCode==1){
            actualizarVista();
        }

    }

    private void actualizarVista() {
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tarjetasAdapter = new TarjetasAdapter(this,usuario.getTarjetas());
        listaTarjetas = (ListView) findViewById(R.id.ListViewTarjetas);
        listaTarjetas.setAdapter(tarjetasAdapter);
    }
}
