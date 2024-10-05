package poo23;

public class Punto {
    private double x, y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public void setX(int x) { this.x = x; }
    public double getY() { return y; }
    public void setY(int y) { this.y = y; }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
    
}
