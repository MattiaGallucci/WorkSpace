package poo23.invert_line;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Nome del file: ");
            String nomeFile = sc.nextLine();

            // Apre il file in modalità lettura e scrittura
            RandomAccessFile file = new RandomAccessFile(nomeFile, "rw");

            // Ottiene la lunghezza del file
            long lunghezza = file.length();

            // Imposta la posizione del puntatore del file alla fine del file
            long posizione = lunghezza - 1;

            // Legge il file riga per riga e lo scrive al contrario
            while (posizione >= 0) {
                // Legge il carattere corrente
                byte carattere = file.readByte();

                // Se il carattere è un carattere di nuova riga, scrive la riga al contrario
                if (carattere == '\n') {
                    file.seek(posizione);
                    file.writeByte('\n');

                    // Legge i caratteri della riga al contrario e li scrive
                    while (posizione >= 0 && file.readByte() != '\n') {
                        file.seek(posizione);
                        file.writeByte(carattere);
                        posizione--;
                        carattere = file.readByte();
                    }
                }

                // Decrementala posizione
                posizione--;
            }

            // Chiude il file
            file.close();
        } catch (FileNotFoundException e) {
            System.err.println("File non trovato");
        } catch (IOException e) {
            System.err.println("Errore di I/O");
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
