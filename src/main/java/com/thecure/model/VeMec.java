package com.thecure.model;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;

public class VeMec {
    private String id;
    private final Collection<VeMecState> estados = new ArrayList<>();

    private int cantCriticos;
    private boolean critico;

    public VeMec(String id, boolean critico, int cantCriticos) {
        this.id = id;
        this.critico = critico;
        this.cantCriticos = cantCriticos;
    }

//    public String getJsonRand(){
//        String json;
//        this.estados.add(VeMecState.generateRandom());
//        Gson obj = new Gson();
//        json = obj.toJson(this.estados);
//
//        return json;
//    }

    public String getNewRandomStateJSON() {
        String json;
        VeMecState randomState = VeMecState.generateRandom(critico && cantCriticos > 0);
        if(critico && cantCriticos > 0) --cantCriticos;
        this.estados.add(randomState);
        Gson gson = new Gson();
        json = gson.toJson(randomState);

        return json;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCantCriticos(int cantCriticos) {
        this.cantCriticos = cantCriticos;
    }

    public void setCritico(boolean critico) {
        this.critico = critico;
    }

    public Collection<VeMecState> getEstados() {
        return estados;
    }
}
