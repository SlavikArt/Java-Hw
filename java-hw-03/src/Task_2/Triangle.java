package Task_2;

public class Triangle {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setSides(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] calcAngles() {
        double[] angles = new double[3];
        angles[0] = Math.toDegrees(Math.acos((b*b + c*c - a*a)/(2*b*c)));
        angles[1] = Math.toDegrees(Math.acos((a*a + c*c - b*b)/(2*a*c)));
        angles[2] = 180 - angles[0] - angles[1];
        return angles;
    }

    public double calcArea() {
        double p = (a + b + c)/2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double getA() { return a; }
    public double getB() { return b; }
    public double getC() { return c; }
}
