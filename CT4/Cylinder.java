public class Cylinder extends Shape {

    double radius;
    double height;

    public Cylinder(double r, double h) {
        radius = r;
        height = h;
    }

    public double surface_area() {
        double area = 2 * Math.PI * radius * radius + 2 * Math.PI * radius * height;
        return area;
    }

    public double volume() {
        double vol = Math.PI * radius * radius * height;
        return vol;
    }

    public String toString() {
        return "cylinder\nsurface area: " + surface_area() + "\nvolume: " + volume();
    }
}