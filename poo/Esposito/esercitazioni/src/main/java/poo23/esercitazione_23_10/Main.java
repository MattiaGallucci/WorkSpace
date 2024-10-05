package poo23.esercitazione_23_10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int token;
        InputStream in = System.in;
        StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(in)));
        tokenizer.eolIsSignificant(true);

        try{
            while((token = tokenizer.nextToken()) != StreamTokenizer.TT_EOF)
                System.out.println(tokenizer.sval);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        // Salva su file
        System.out.println("Indicare nome del file: ");
        Scanner sc = new Scanner(System.in);
        String scelta = sc.nextLine();
        PrintWriter out = null;

        try{
            out = new PrintWriter(scelta);
            out.println("Ciao");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } finally {
            if (out != null)
                out.close();
        }
        sc.close();


    }
}
