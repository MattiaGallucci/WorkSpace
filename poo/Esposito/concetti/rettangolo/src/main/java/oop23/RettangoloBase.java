package oop23;

import static org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA3_512;

import org.apache.commons.codec.digest.DigestUtils;

public class RettangoloBase {
	private double base;
	private double altezza;
	
	public RettangoloBase(double base, double altezza) {
		this.base = base;
		this.altezza = altezza;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltezza() {
		return altezza;
	}

	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}
	
	public double area() {
		return base * altezza;
	}
	
	public double perimetro() {
		return (base*2)+(altezza*2);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof RettangoloBase) {
			RettangoloBase o = (RettangoloBase) obj;
			if (this.base == o.base && this.altezza == o.altezza) {
				return true;
			} else if (this.base == o.altezza && this.altezza == o.base) {
				return true;
			}
			return false;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Sono un rettangolo che copre un area di "+this.area() ;
	}
	
	public String hashClass() {
		String hash = new DigestUtils(SHA3_512).digestAsHex(this.toString().getBytes());
		return hash;
	}
	

}
