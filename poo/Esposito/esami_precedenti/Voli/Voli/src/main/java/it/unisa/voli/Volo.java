package it.unisa.voli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Volo {
	private final String origine, destinazione, ID;
	private Point3D coordinate;
	
	public Volo(String origine, String destinazione, String iD, Point3D coordinate) {
		super();
		this.origine = origine;
		this.destinazione = destinazione;
		ID = iD;
		this.coordinate = coordinate;
	}

	public Point3D getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Point3D coordinate) {
		this.coordinate = coordinate;
	}

	public String getOrigine() {
		return origine;
	}

	public String getDestinazione() {
		return destinazione;
	}

	public String getID() {
		return ID;
	}

	@Override
	public String toString() {
		return "Volo [origine=" + origine + ", destinazione=" + destinazione + ", ID=" + ID + ", coordinate="
				+ coordinate + "]";
	}
	
	public static Volo createVolo(InputStream in) {
		String[] args = new String[3];
		double[] coord = new double[3];
		StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(in)));
		tokenizer.eolIsSignificant(true);

        int token, i = 0, j = 0;

        System.out.println("Indicare info per Volo [origine,destinazione,ID,coordinate]");
        try {
            while( (token = tokenizer.nextToken()) != StreamTokenizer.TT_EOL) {
            	if(token == StreamTokenizer.TT_WORD) {
                    args[i++] = tokenizer.sval;
                } else if(token == StreamTokenizer.TT_NUMBER) {
                	coord[j++] = tokenizer.nval;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        
        return new Volo(args[0], args[1], args[2], new Point3D(coord[0], coord[1], coord[2]));
	}
}
