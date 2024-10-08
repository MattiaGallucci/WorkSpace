package com.mycompany.esercizio2;

public class Esercizio2 {

    public static void main(String[] args) throws InterruptedException{
        int size = 1200000;
        int[] array = new int[size];
        long startTime = System.nanoTime();
        
        /*for (int i = 0; i < size; i++) {
            array[i] = 42;
        }*/
        
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<size; i++)
                    array[i] = 42;
            }
        };
        
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        Thread t4 = new Thread(r);
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  // Convertire in millisecondi
        
        System.out.println("Array di " + size + " elementi inizializzato in " + duration + " nanosecondi.");
    }
}
