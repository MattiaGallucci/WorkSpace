package it.unisa.parole;

public class StringBufferStrategy implements Strategy {
	private StringBuffer buf;
	
	public StringBufferStrategy() {
		buf = new StringBuffer();
	}
	
	@Override
	public void append(String str) {
		buf.append(str);
	}
	
	public void finalize() {
		System.out.println("StringBuf = "+ buf.toString());
	}
}
