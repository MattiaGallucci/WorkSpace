package esercizio1;

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

        public Incrementatore(Contatore c) {
            this.c = c;
            }

        public synchronized void  incrementa(int i) { //SE LEVI SYNCHRONIZED NON VA BENE
            for (int j = 0; j < i; j++) {
                c.setC(c.getC() + 1);
                System.out.println(c.getC());
            }
            
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Contatore c = new Contatore();
        Incrementatore i = new Incrementatore(c);
        int volte = 40000;

        Runnable r = new Runnable() {
            @Override
            public void run() {
                i.incrementa(volte/4);
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
    }
}
