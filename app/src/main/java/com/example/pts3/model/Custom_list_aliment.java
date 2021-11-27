package com.example.pts3.model;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pts3.R;

import java.util.ArrayList;
import java.util.List;

public class Custom_list_aliment extends BaseAdapter {


    private ArrayList<Aliment> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public Custom_list_aliment(ArrayList<Aliment> listData, LayoutInflater layoutInflater, Context context) {
        this.listData = listData;
        this.layoutInflater = layoutInflater;
        this.context = context;
    }


    public Custom_list_aliment(Context applicationContext, ArrayList<Aliment> listData) {
        this.context = applicationContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(applicationContext);
    }
    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Aliment getItem(int i) {
        return listData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup viewGroup) {

        convertview = layoutInflater.inflate(R.layout.adaptater_view_aliment, null);

        Aliment aliment = getItem(position);

        TextView titre_layout = convertview.findViewById(R.id.id_adaptater_view_aliment_titre_produit);
        TextView date_peremption_layout = convertview.findViewById(R.id.id_adapter_view_aliment_date_peremption);
        TextView quantite_layout = convertview.findViewById(R.id.id_adapter_view_aliment_quantite);


        titre_layout.setText(aliment.getNom());
        date_peremption_layout.setText(aliment.getDate_peremption()+ "");
        quantite_layout.setText(aliment.getQuantité()+ "unite");



     //   Log.e("nom de l'aliment", aliment.getNom());

        return convertview;
    }



}
