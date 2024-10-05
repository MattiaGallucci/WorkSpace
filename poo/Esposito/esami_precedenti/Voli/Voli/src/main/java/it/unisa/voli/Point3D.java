package it.unisa.voli;

public class Point3D {
	private final double x;   // Cartesian
	private final double y;   // coordinates
	private final double z;   // coordinates
	   
	 public Point3D(double x, double y, double z) {
	    this.x = x;
	    this.y = y;
	    this.z = z;
	 }

	 public double distanceTo(Point3D that) {
	    double dx = this.x - that.x;
	    double dy = this.y - that.y;
	    double dz = this.z - that.z;
	    return Math.sqrt(dx*dx + dy*dy + dz*dz);
	 }

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	@Override
	public String toString() {
		return "Point3D [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
}
