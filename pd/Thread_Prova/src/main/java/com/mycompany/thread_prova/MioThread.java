/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thread_prova;

/**
 *
 * @author matti
 */
public class MioThread extends Thread{
    private int inizio;
    private int dimensione;
    public static int[] data;
    public static final int SIZE = 10_000_000;
    public static final int MAX_THR = 8;

    public MioThread(int inizio, int dimensione) {
        data = new int[SIZE];
        this.inizio = inizio;
        this.dimensione = dimensione;
    }
    
    @Override
    public void run(){
        for(int i=0; i<dimensione; i++){
            for(int j=0; j<10_000; j++){
                data[inizio+i] = i; //Scrive 10000 volte il numero sulla stessa cella per ogni cella
            }
        }
    }
    
}
