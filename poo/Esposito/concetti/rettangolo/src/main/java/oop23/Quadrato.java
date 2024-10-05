/**
 * 
 */
package oop23;

/**
 * @author bruand
 *
 */
public class Quadrato extends Rettangolo {

	/**
	 * @param base
	 * @param altezza
	 */
	private Quadrato(double base, double altezza) {
		super(base, altezza);
	}
	
	public Quadrato(double lato) {
		this(lato,lato);
	}

	@Override
	public void setBase(double base) {
		super.setBase(base);
		super.setAltezza(base);
	}

	@Override
	public void setAltezza(double altezza) {
		super.setBase(altezza);
		super.setAltezza(altezza);
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	

}
