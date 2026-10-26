public class Sphere extends Shape {

    double radius;

    public Sphere(double r) {
        radius = r;
    }

    public double surface_area() {
        double area = 4 * Math.PI * radius * radius;
        return area;
    }

    public double volume() {
        double vol = (4.0 / 3.0) * Math.PI * radius * radius * radius;
        return vol;
    }

    public String toString() {
        return "sphere\nsurface area: " + surface_area() + "\nvolume: " + volume();
    }
}