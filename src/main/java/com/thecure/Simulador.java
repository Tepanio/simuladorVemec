package com.thecure;

import com.thecure.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Simulador {
    public static void main(String[] args) {
        String help = "Uso: simulador <cantidad de vemecs> <cantidad de requests por vemec> <tiempo entre requests en ms> <cant vemecs criticos> <cantidad de estados criticos>";

        if(args.length != 5) {
            System.out.println(help);
            return;
        }

        int cantidadVemecs, cantidadRequests, delay, cantVemecsCriticos, cantEstadosCriticos;

        try {
            cantidadVemecs = Integer.parseInt(args[0]);
            cantidadRequests = Integer.parseInt(args[1]);
            delay = Integer.parseInt(args[2]);
            cantVemecsCriticos = Integer.parseInt(args[3]);
            cantEstadosCriticos = Integer.parseInt(args[4]);
        }
        catch (NumberFormatException e) {
            System.out.println(help);
            return;
        }

        if(cantidadRequests < 1 || cantidadVemecs < 1 || delay < 1 || cantVemecsCriticos < 0 || cantEstadosCriticos < 0) {
            System.out.println("Las cantidades tienen que ser numeros enteros positivos.");
            return;
        }

        if(cantVemecsCriticos > 0 && cantEstadosCriticos == 0) {
            System.out.println("Si define una cantidad de VeMecs criticos mayor a cero, los estados criticos tambien tienen que serlo.");
            return;
        }

        if(cantVemecsCriticos == 0 && cantEstadosCriticos > 0) {
            System.out.println("Si define una cantidad de estados criticos mayor a cero, tiene que definir vemecs criticos.");
            return;
        }

        if(cantEstadosCriticos > cantidadRequests) {
            System.out.println("La cantidad de estados criticos tiene que ser menor o igual a la cantidad de requests.");
            return;
        }

        // Los id pre cargados deben de ser de con el formato VEMEC + numero entero
        // Comenzando por 1
        List<Integer> criticos = new ArrayList<>();
        for(int i = 0; i < cantVemecsCriticos; i++) {
            criticos.add(new Random().nextInt(6) + 1);
        }

        for (int i = 1; i <= cantidadVemecs; i++) {
            VeMec vem;

            if(criticos.contains(i)) {
                vem = new VeMec("VEMEC" + i, true, cantEstadosCriticos);
            }
            else {
                vem = new VeMec("VEMEC" + i, false, 0);
            }

            //Por cada VeMec simulado se genera un nuevo hilo para sobrecargar la api y probarla
            new PostThread(vem, cantidadRequests, delay);
        }
    }
}