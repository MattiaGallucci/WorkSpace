package poo23.cat_files;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
	public static void main( String[] args ){
        try {
        	FileReader in1 = new FileReader("FILE1.txt");
        	FileReader in2 = new FileReader("FILE2.txt");
        	PrintWriter out = new PrintWriter("FILE3.txt");
        	Scanner sc1 = new Scanner(in1);
        	Scanner sc2 = new Scanner(in2);
        	
        	while(sc1.hasNextLine()) {
        		String line = sc1.nextLine();
        		out.print(line);
        	}
        	while(sc2.hasNextLine()) {
        		String line = sc2.nextLine();
        		out.print(line);
        	}
        out.close();
        sc1.close();
        sc2.close();
        }catch (IOException exception){
        	System.out.println("Error processing file:" + exception);
        	}
    }
}
