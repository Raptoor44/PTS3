package com.example.pts3.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pts3.Mes_conteneurs;
import com.example.pts3.R;

import java.util.List;

public class Custom_list_conteneurs extends BaseAdapter {


    private List<Conteneurs> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public Custom_list_conteneurs(Context applicationContext, List<Conteneurs> conteneursList) {
        this.context = applicationContext;
        this.listData = conteneursList;
        layoutInflater = LayoutInflater.from(applicationContext);
    }


    public void Custom_list_conteneurs(Context aContext, List<Conteneurs> list) {
        this.context = aContext;
        this.listData = list;
        layoutInflater = LayoutInflater.from(aContext);

    }


    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Conteneurs getItem(int i) {
        return listData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup viewGroup) {

        convertview = layoutInflater.inflate(R.layout.adaptater_view_conteneurs, null);

        Conteneurs conteneur = getItem(position);

        TextView titre = convertview.findViewById(R.id.id_adaptater_view_conteneurs);


        titre.setText(conteneur.getNom());

        return convertview;
    }
}
