import java.util.Random;

public class Esercizio3 {

    static int sum=0;
    
    public static void main(String[] args) throws InterruptedException{
        int size = 120000000;
        int[] array = new int[size];
        long startTime = System.nanoTime();
        Random r = new Random();
        
        for (int i = 0; i < size; i++) {
            array[i] = r.nextInt(); // Genera un numero intero casuale
        }
        
        /*for (int i = 0; i < size; i++) {
            sum += array[i];
        }*/
        
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<299999; i++)
                    sum+=array[i];
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for(int i=300000; i<599999; i++)
                    sum+=array[i];
            }
        };
        Runnable r3 = new Runnable() {
            @Override
            public void run() {
                for(int i=600000; i<899999; i++)
                    sum+=array[i];
            }
        };
        Runnable r4 = new Runnable() {
            @Override
            public void run() {
                for(int i=900000; i<1199999; i++)
                    sum+=array[i];
            }
        };
        
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        
        System.out.println("Array di " + size + " elementi inizializzato in " + duration + " nanosecondi.\nLa somma è " + sum);
    }
}
