package com.example.pts3.model;

import java.util.ArrayList;

public class Conteneurs {

    private String nom;
    private ArrayList<Aliment> aliments;
    private boolean isvalid;
    private static int id = 0;
    private int uni_id;
    private int static_id_aliment = 0;

    public Conteneurs(String nom) {
        this.aliments = new ArrayList<Aliment>();
        this.nom = nom;
        this.uni_id = id;
        id++;
    }

    public String getNom() {
        return nom;
    }


    public boolean isIsvalid() {
        return isvalid;
    }

    public void setIsvalid(boolean isvalid) {
        this.isvalid = isvalid;
    }

    public int getUni_id() {
        return uni_id;
    }

    public ArrayList<Aliment> getAliments() {
        return aliments;
    }

    public int getStatic_id_aliment() {
        return static_id_aliment;

    }

    public void setStatic_id_aliment(int static_id_aliment) {
        this.static_id_aliment = static_id_aliment;
    }

    public static void setId(int id) {
        Conteneurs.id = id;
    }

    public static int getId() {
        return id;
    }
}
