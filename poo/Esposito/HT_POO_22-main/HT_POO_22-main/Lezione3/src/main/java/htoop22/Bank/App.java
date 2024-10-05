package htoop22.Bank;


import java.io.*;

public class App {
    public static void main( String[] args ) {
        Bank fiscianoBank;

        // Dichiariamo il file dati
        File f = new File("bank.dat");

        // Controlliamo se il file esiste
        if (f.exists()) {
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
                fiscianoBank = (Bank) in.readObject();
                in.close();
                fiscianoBank.getConti().forEach(System.out::println);
            } catch (IOException e) { // Eccezione controllata
                System.err.println("Impossibile leggere dal file, arresto del programma");
                return;
            } catch (ClassNotFoundException e2) { // Eccezione controllata
                System.err.println("Impossibile trovare la classe Bank, arresto del programma");
                return;
            }
        } else {
            // Se non esiste allora bisogna creare la banca e i relativi clienti
            fiscianoBank = new Bank();

            Cliente c1 = new Cliente("Mario", "Rossi", 1001, 1234);
            Cliente c2 = new Cliente("Giuseppe", "Bianchi", 1002, 1234);

            fiscianoBank.addCostumer(c1);
            fiscianoBank.addCostumer(c2);

            BankAccount b1 = new BankAccount(1000, c1);
            BankAccount b2 = new BankAccount(1000, c2);

            fiscianoBank.addConto(b1);
            fiscianoBank.addConto(b2);
        }

        // Qui si fanno le operazioni di cui si ha bisogno

        // Salvataggio del nuovo stato del programma e chiusura dello
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
            out.writeObject(fiscianoBank);
            out.close();
        } catch (IOException e) {
            System.err.println("Impossibile salvare il file, arresto del programma");
            return;
        }



    }
}
