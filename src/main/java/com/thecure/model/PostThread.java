package com.thecure.model;

public class PostThread extends Thread {
    private VeMec vem;
   public PostThread(VeMec vemec)
    {
        super("Creado Thread para VeMec:" + vemec.getId());
        this.vem = vemec;

        System.out.println("my thread created" + this.getName());
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
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println("my thread interrupted");
        }
        System.out.println("Se termino la simulacion del VeMec"+ this.vem.getId());
    }

}

