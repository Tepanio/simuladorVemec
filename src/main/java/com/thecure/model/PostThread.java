package com.thecure.model;


import java.io.Console;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.methods.HttpPut;

public class PostThread extends Thread {
    private VeMec vem;

    ///Tiempo entre posteo y posteo de un mismo VeMec en milisegundos
    private int delay;

    public PostThread(VeMec veMec) {
        this(veMec, 1000);
    }

    public PostThread(VeMec vemec, int delay)
    {
        super("Creado Thread para VeMec:" + vemec.getId());
        this.vem = vemec;
        this.delay = delay;

        System.out.println(this.getName());
        start();
    }

    public void run()
    {
        try
        {
            ///Determina la cantidad de post que se realizaran
            int cantPost = 20;

            try(CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
                HttpPost request = new HttpPost("http://localhost:8080/api/v1/vemecs/"+ this.vem.getId()+"/estados");
                request.addHeader("content-type", "application/json");

                for (int i=0; i < cantPost;i++)
                {
                    ///Se genera json  y se printea por consola para controlar
                    String json = this.vem.getNewRandomStateJSON();
                    System.out.println( "Datos a postear del Vemec: "+ this.vem.getId()+" \n " + json + "\n");

                    StringEntity params = new StringEntity(json);
                    request.setEntity(params);

                    try(CloseableHttpResponse res = httpClient.execute(request)) {
                        if(res.getStatusLine().getStatusCode() == 200) {
                            System.out.println("Estado ingresado");
                        }
                        else {
                            System.out.println("No se pudo ingresar el estado, status: " + res.getStatusLine().getStatusCode());
                        }
                    }

                    request.reset();

                    Thread.sleep(this.delay);
                }

            } catch (IOException ex) {
                System.out.println("No se puedo cargar el estado");
            }
        }
        catch(InterruptedException e )
        {
            System.out.println("Interrupted");
        }

        System.out.println("Se termino la simulacion de: "+ this.vem.getId());
    }

}

