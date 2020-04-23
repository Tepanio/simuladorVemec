package com.thecure;

import com.thecure.model.*;



public class Simulador {
    public static void main(String[] args) {
        // Los id pre cargados deben de ser de con el formato VEMEC + numero entero
        // Comenzando por 1
        int n = 5; // Cantidad de VeMec
        for (int i = 1; i <= n; i++) {
            VeMec vem = new VeMec("VEMEC" + i);
            //Por cada VeMec simulado se genera un nuevo hilo para sobrecargar la api y probarla
            new PostThread(vem);
        }

    }
}