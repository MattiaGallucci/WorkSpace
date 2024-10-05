package poo23.compilatore_interattivo;

import java.util.Scanner;

public class CompilatoreInterattivo {

    private static void compilaClasse(String stringa) throws Exception {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("javac " + stringa);
        
        final int exitValue = process.waitFor();
        System.out.println(exitValue == 0 ? stringa + " compilato!" : "Impossibile compilare " + stringa);
    }
    
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String stringa = "";
        //! ELIMINA .class IN target E RIPORTA RELATIVE PATH
        System.out.print("Digita il nome di un file java presente nella cartella corrente e batti enter, oppure scrivi \"fine\" per terminare il programma: ");
        
        while (!(stringa = scanner.next()).equals("fine")) {
            System.out.println("Hai digitato " + stringa.toUpperCase() + "!");
            
            try {
                compilaClasse(stringa);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Fine programma!");
        scanner.close();
    }
}