package com.thecure;

import com.thecure.model.*;



public class Simulador {
    public static void main(String[] args) {
        // Los id pre cargados deben de ser de con el formato VEMEC + numero entero
        // Comenzando por 1
        int n = 1; // Cantidad de VeMec/Thread
        for (int i = 0; i < n; i++) {
            VeMec vem = new VeMec("VEMEC" + n);
            //Por cada VeMec simulado se genera un nuevo hilo para sobrecargar la api y probarla
            PostThread object = new PostThread(vem);

        }

    }
}


