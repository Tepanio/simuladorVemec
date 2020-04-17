package com.thecure.model;


import java.io.Console;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
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
   public PostThread(VeMec vemec)
    {
        super("Creado Thread para VeMec:" + vemec.getId());
        this.vem = vemec;

        System.out.println(this.getName());
        start();
    }
    public void run()
    {
        try
        {
            for (int i=0 ;i<3;i++)
            {
                String json = this.vem.getJsonRand();
                System.out.println( "Datos a postear del Vemec:"+ this.vem.getId()+" \n " + json + "\n");



                
                CloseableHttpClient httpClient = HttpClientBuilder.create().build();

                try {
                    HttpPost request = new HttpPost("http://localhost:8080/api/v1/vemecs/"+ this.vem.getId()+"/estados");
                    StringEntity params = new StringEntity(json);
                    request.addHeader("content-type", "application/json");
                    request.setEntity(params);
                    httpClient.execute(request);
                        // handle response here...
                    System.out.println("final del try");
                                
                } catch (IOException ex) {
                    System.out.println("dentro del catch");

                } finally {
                    try {
                        httpClient.close();
                    } catch (IOException ex) {
                        Logger.getLogger(PostThread.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e )
        {
            System.out.println("my thread interrupted");
        }
        System.out.println("Se termino la simulacion de: "+ this.vem.getId());
    }

}

