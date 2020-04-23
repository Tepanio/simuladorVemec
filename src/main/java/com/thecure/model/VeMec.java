package com.thecure.model;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VeMec {
    private String id;
    private Collection<VeMecState> estados = new ArrayList<>();

    public VeMec(String id) {
        this.id = id;
    }

    public String getJsonRand(){
        String json;
        this.estados.add(VeMecState.generateRandom());
        Gson obj = new Gson();
        json = obj.toJson(this.estados);

        return json;
    }

    public String getNewRandomStateJSON() {
        String json;
        VeMecState randomState = VeMecState.generateRandom();
        this.estados.add(randomState);
        Gson gson = new Gson();
        json = gson.toJson(new VeMecState[]{randomState});

        return json;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Collection<VeMecState> getEstados() {
        return estados;
    }
}
