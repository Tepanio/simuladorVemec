package com.thecure;

import com.thecure.model.*;



public class Simulador {
    public static void main(String[] args) {
        String help = "Uso: simulador <cantidad de vemecs> <cantidad de requests por vemec> <tiempo entre requests en ms>";

        if(args.length != 3) {
            System.out.println(help);
            return;
        }

        int cantidadVemecs, cantidadRequests, delay;

        try {
            cantidadVemecs = Integer.parseInt(args[0]);
            cantidadRequests = Integer.parseInt(args[1]);
            delay = Integer.parseInt(args[2]);
        }
        catch (NumberFormatException e) {
            System.out.println(help);
            return;
        }

        if(cantidadRequests < 1 || cantidadVemecs < 1 || delay < 1) {
            System.out.println("Las cantidades tienen que ser numeros enteros positivos.");
            return;
        }

        // Los id pre cargados deben de ser de con el formato VEMEC + numero entero
        // Comenzando por 1
        for (int i = 1; i <= cantidadVemecs; i++) {
            VeMec vem = new VeMec("VEMEC" + i);
            //Por cada VeMec simulado se genera un nuevo hilo para sobrecargar la api y probarla
            new PostThread(vem, cantidadRequests, delay);
        }

    }
}