package it.unisa.parole;

public class VideoStrategy implements Strategy {

	@Override
	public void append(String str) {
		System.out.println(str);
	}

}
