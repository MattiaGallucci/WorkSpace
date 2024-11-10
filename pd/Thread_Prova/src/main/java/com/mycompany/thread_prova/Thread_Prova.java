/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.thread_prova;

/**
 *
 * @author matti
 */
public class Thread_Prova {

    public static void main(String[] args) {
        long tempoInizio, tempoFine;
        int inizio, j, numeroThread;
        MioThread threads[];
        
        for(numeroThread=1; numeroThread <= MioThread.MAX_THR; numeroThread++){
            tempoInizio = System.currentTimeMillis();
            inizio = 0;
            threads = new MioThread[numeroThread];
            for(j=0; j<numeroThread; j++){
                threads[j] = new MioThread(inizio, MioThread.SIZE/numeroThread);
                threads[j].start();
                inizio += MioThread.SIZE/numeroThread;
            }
            for(j=0; j<numeroThread; j++){
                try{
                    threads[j].join();
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            tempoFine = System.currentTimeMillis();
            System.out.println(numeroThread + " Thread(s):" + (tempoFine - tempoInizio) + "ms");
        }
    }
}