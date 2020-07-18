package com.thecure.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class VeMecState {
    public static int contadorCriticos = 0;

    private String timestamp;
    private int presionMaxima;
    private int presionMinima;
    private int volumenGasAportado;
    private int frecuenciaDeAporte;
    private int porcentajeOxigeno;
    private int humedad;
    private int temperaturaEntrada;
    private int temperaturaSalida;
    private int presionEntrada;
    private int presionSalida;

    private int bpm;
    private boolean usandoBateria;
    private int bateria;
    private String latitud;
    private String longitud;

    public VeMecState() {

    }

    ///Genera estados random para el VeMec
    public VeMecState getRandom() {

        this.humedad = new Random().nextInt(11) + 10;
        this.presionMaxima = new Random().nextInt(30) + 60;
        this.presionMinima = this.presionMaxima - 20 ;
        this.volumenGasAportado = new Random().nextInt(100) + 20;
        this.frecuenciaDeAporte = new Random().nextInt(4) + 1;
        this.porcentajeOxigeno = new Random().nextInt(30) + 20;
        this.temperaturaEntrada = new Random().nextInt(15) + 20;
        this.temperaturaSalida = this.temperaturaEntrada - 5;
        this.presionEntrada = this.presionMaxima - 16;
        this.presionSalida = this.presionMaxima -10;

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        timestamp = formatter.format(date);
        return this;
    }

    public static VeMecState generateRandom(boolean critico) {
        VeMecState state = new VeMecState();

        state.humedad = new Random().nextInt(11) + 10;
        state.presionMaxima = new Random().nextInt(30) + 60;
        state.presionMinima = state.presionMaxima - 20 ;
        state.volumenGasAportado = new Random().nextInt(100) + 20;
        state.frecuenciaDeAporte = new Random().nextInt(4) + 1;
        state.porcentajeOxigeno = new Random().nextInt(30) + 20;
        state.temperaturaEntrada = new Random().nextInt(15) + 20;
        state.temperaturaSalida = state.temperaturaEntrada - 5;
        state.presionEntrada = state.presionMaxima - 16;
        state.presionSalida = state.presionMaxima -10;

        if(critico) {
            state.bpm = 100 +  new Random().nextInt(20);
            contadorCriticos--;
        }
        else {
            state.bpm = 60 +  new Random().nextInt(20);
        }

        state.usandoBateria = false;
        state.bateria = 100;
        state.latitud = "10";
        state.longitud = "10";

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        state.timestamp = formatter.format(date);
        return state;
    }
}

