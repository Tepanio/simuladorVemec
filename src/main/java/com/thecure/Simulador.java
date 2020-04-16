package com.thecure;

import com.thecure.model.*;

public class Simulador {
    public static void main(String[] args) {

        int n = 2; // Cantidad de VeMec/Thread
        for (int i = 0; i < n; i++) {
            VeMec vem = new VeMec(i);
            PostThread object = new PostThread(vem);

        }

    }
}


