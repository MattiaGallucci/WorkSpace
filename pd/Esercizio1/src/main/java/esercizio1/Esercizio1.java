/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package esercizio1;

/**
 *
 * @author matti
 */
public class Esercizio1 {

    public static class Contatore {

        private int c;

        public Contatore() {
            this.c = 0;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }

    }

    public static class Incrementatore {

        private Contatore c;
        private int incrementi;

        public Incrementatore(Contatore c, int incrementi) {
            this.c = c;
            this.incrementi = incrementi;
        }

        public void incrementa() {
            for (int j = 0; j < incrementi; j++) {
                c.setC(c.getC() + 1);
                System.out.println(c.getC());
            }
            
        }
    }

    public static void main(String[] args) {
        Contatore c = new Contatore();
        Incrementatore i = new Incrementatore(c, 40000);

        i.incrementa();
        
        new Thread(new Runnable(){
            @Override
            public void run() {
                Incrementatore j = new Incrementatore(c, 10000);
                j.incrementa();
            }
        }).start();
    }
}
