package com.eafit.app;

import java.util.concurrent.Semaphore;

public class AltImpl implements Alternador {
    
    private static final int NUM_MAXIMOS_PUENTE = 1;
    private static final int TIEMPO_EN_PUENTE = 2000;

    private static Semaphore puenteB = new Semaphore(NUM_MAXIMOS_PUENTE);
    private static Semaphore puenteC= new Semaphore(NUM_MAXIMOS_PUENTE);
    private static Semaphore puenteD = new Semaphore(NUM_MAXIMOS_PUENTE);
    private static Semaphore mutexA = new Semaphore(1);
    private static Semaphore mutexPuente = new Semaphore(1);
    
    private static int numA = 0;

    private Puente puente;
    
    public AltImpl() {
        this.puente = Puente.B;
    }

    public void entrarA() {
        try{
            mutexA.acquire();
            if(numA == 0){
                mutexPuente.acquire();
            }
            numA++;
            mutexA.release();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void salirA() {
        try{
            mutexA.acquire();
            numA--;
            if(numA == 0){
                mutexPuente.release();
            }
            mutexA.release();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void entrarB() {
        //Solicitar el puente B
        try{
            puenteB.acquire();
            Thread.sleep(TIEMPO_EN_PUENTE);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
    public void salirB() {
        //Salir del puente B
        puenteB.release();
    }

    public void entrarC() {
        //Solicitar el puente C
        try{
            puenteC.acquire();
            Thread.sleep(TIEMPO_EN_PUENTE);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void salirC(){
        //Salir del puente C
        puenteC.release();
    }

    public void entrarD() {
        //Solicitar entrada al puente D
        try{
            puenteD.acquire();
            Thread.sleep(TIEMPO_EN_PUENTE);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void salirD() {
        //Liberar el puente D
        puenteD.release();
    }
    
    public Puente leerPuente() {
        return puente;
    }
    
    public void establecerPuente(Puente puente) {
        try{
            mutexPuente.acquire();
            this.puente = puente;
            mutexPuente.release();
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
	    
    }
}
