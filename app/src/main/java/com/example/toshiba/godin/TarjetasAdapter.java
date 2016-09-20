package com.example.toshiba.godin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;


/**
 * Created by toshiba on 20/09/16.
 */
public class TarjetasAdapter extends BaseAdapter{
    private List<Tarjeta> tarjetas;
    private LayoutInflater inflater; // crea layouts a partir de xml
    TextView nombre;
    TextView saldo;


    public TarjetasAdapter(Context contexto, List<Tarjeta> tarjetas){
        inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.tarjetas=tarjetas;

    }

    @Override
    public int getCount() {
        return tarjetas.size();
    }

    @Override
    public Object getItem(int position) {
        return tarjetas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Tarjeta tarjeta = tarjetas.get(position);

        //en la primer llamada la vista reciclada es null
        if(convertView == null){
            convertView = inflater.inflate(R.layout.lista_tarjetas,null);
        }

        //obtengo elementos TextView
        nombre = (TextView) convertView.findViewById(R.id.nombreTarjeta);
        saldo = (TextView) convertView.findViewById(R.id.saldo_tarjeta);

        nombre.setText(tarjeta.getNombre());
        saldo.setText(tarjeta.getSaldo().toString());

        return convertView;
    }
}
