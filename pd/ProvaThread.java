public class ProvaThread {
    // Metodo statico per stampare un messaggio con il nome del thread corrente
    static void threadMessage(String msg) {
        // Ottiene il nome del thread corrente
        String tn = Thread.currentThread().getName();
        // Stampa il nome del thread e il messaggio formattato
        System.out.format("%s: %s%n", tn, msg);
    }

    // Classe interna statica che implementa l'interfaccia Runnable
    private static class MessageLoop implements Runnable {
        // Metodo run che contiene il codice che verrà eseguito nel thread
        public void run() {
            // Array di stringhe con messaggi da stampare
            String impinf[] = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too"
            };
            try {
                // Ciclo for per iterare attraverso l'array di messaggi
                for (int i = 0; i < impinf.length; i++) {
                    // Fa dormire il thread per 4000 millisecondi (4 secondi)
                    Thread.sleep(4000);
                    // Stampa il messaggio corrente usando il metodo threadMessage
                    threadMessage(impinf[i]);
                } // fine del ciclo for
            } catch (InterruptedException e) {
                // Gestisce l'eccezione InterruptedException
                threadMessage("I wasn’t done!");
            } // fine del blocco catch
        } // fine del metodo run()
    } // fine della classe MessageLoop

    public static void main(String args[])
            throws InterruptedException {
        long patience = 1000 * 60 * 60;
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }
        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();
        threadMessage("Waiting for MessageLoop to finish");
        while (t.isAlive()) {
            threadMessage("Still waiting...");
            t.join(1000);
            if (((System.currentTimeMillis() - startTime) > patience)
                    && t.isAlive()) {
                threadMessage("Tired of waiting!");
                t.interrupt();
                t.join();
            }
        }
        threadMessage("Finally!");
    } // fine del metodo main
} // fine della classe ProvaThread