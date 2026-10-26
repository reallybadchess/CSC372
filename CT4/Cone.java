public class Cone extends Shape {

    double radius;
    double height;

    public Cone(double r, double h) {
        radius = r;
        height = h;
    }

    public double surface_area() {
        double slant = Math.sqrt(radius * radius + height * height);
        double area = Math.PI * radius * (radius + slant);
        return area;
    }

    public double volume() {
        double vol = (1.0 / 3.0) * Math.PI * radius * radius * height;
        return vol;
    }

    public String toString() {
        return "cone\nsurface area: " + surface_area() + "\nvolume: " + volume();
    }
}