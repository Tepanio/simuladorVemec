package com.thecure.model;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;

public class VeMec {
    private String id;
    private Collection<VeMecState> estados = new ArrayList<>();

    public VeMec(String id) {
        this.id = id;
    }
    public String getJsonRand(){
        String json;
        this.estados.add((new VeMecState().getRandom()));
        Gson obj = new Gson();
        json = obj.toJson(this.estados);
        this.estados.clear();
        return json;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
