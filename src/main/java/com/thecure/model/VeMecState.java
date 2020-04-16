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

    public VeMecState() {

    }

    public int getPresionMaxima() {
        return presionMaxima;
    }

    public void setPresionMaxima(int presionMaxima) {
        this.presionMaxima = presionMaxima;
    }

    public int getPresionMinima() {
        return presionMinima;
    }

    public void setPresionMinima(int presionMinima) {
        this.presionMinima = presionMinima;
    }

    public int getVolumenGasAportado() {
        return volumenGasAportado;
    }

    public void setVolumenGasAportado(int volumenGasAportado) {
        this.volumenGasAportado = volumenGasAportado;
    }

    public int getFrecuenciaDeAporte() {
        return frecuenciaDeAporte;
    }

    public void setFrecuenciaDeAporte(int frecuenciaDeAporte) {
        this.frecuenciaDeAporte = frecuenciaDeAporte;
    }

    public int getPorcentajeOxigeno() {
        return porcentajeOxigeno;
    }

    public void setPorcentajeOxigeno(int porcentajeOxigeno) {
        this.porcentajeOxigeno = porcentajeOxigeno;
    }

    public int getHumedad() {
        return humedad;
    }

    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }

    public int getTemperaturaEntrada() {
        return temperaturaEntrada;
    }

    public void setTemperaturaEntrada(int temperaturaEntrada) {
        this.temperaturaEntrada = temperaturaEntrada;
    }

    public int getTemperaturaSalida() {
        return temperaturaSalida;
    }

    public void setTemperaturaSalida(int temperaturaSalida) {
        this.temperaturaSalida = temperaturaSalida;
    }

    public int getPresionEntrada() {
        return presionEntrada;
    }

    public void setPresionEntrada(int presionEntrada) {
        this.presionEntrada = presionEntrada;
    }

    public int getPresionSalida() {
        return presionSalida;
    }

    public void setPresionSalida(int presionSalida) {
        this.presionSalida = presionSalida;
    }

    public VeMecState getRandom(){

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
        Timestamp ts=new Timestamp(date.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH.mm.ss.SSS");
        timestamp = formatter.format(ts);
        return this;
    }
}

