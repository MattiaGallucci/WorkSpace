/**
 * 
 */
package oop23;

/**
 * @author bruand
 *
 */
public class Rettangolo extends RettangoloBase implements Comparable<RettangoloBase> {

	/**
	 * @param base
	 * @param altezza
	 */
	public Rettangolo(double base, double altezza) {
		super(base, altezza);
	}

	@Override
	public int compareTo(RettangoloBase o) {
		return (int) (this.area()-o.area());
	}

}
