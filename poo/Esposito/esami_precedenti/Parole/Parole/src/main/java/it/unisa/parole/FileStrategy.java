package it.unisa.parole;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileStrategy implements Strategy {
	private BufferedWriter writer;
	
	public FileStrategy(String nome) throws FileNotFoundException {
		File file = new File(nome);
		writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
	}

	@Override
	public void append(String str) {
		try {
			writer.write(str + "\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void finalize() {
		if(writer != null) {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
