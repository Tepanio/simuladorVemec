package com.thecure.model;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;

public class VeMec {
    private int id;
    private Collection<VeMecState> estados = new ArrayList<>();

    public VeMec(int id) {
        this.id = id;
    }
    public String getJsonRand(){
        String json;
        this.estados.add((new VeMecState().getRandom()));
        Gson obj = new Gson();
        json = obj.toJson(this.estados);
        return json;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
