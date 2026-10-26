import java.util.Scanner;

public class ShapeArray {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // for the sphere
        System.out.print("enter the radius of the sphere: ");
        double sphereRadius = input.nextDouble();

        // for the cylinder
        System.out.print("enter the radius of the cylinder: ");
        double cylRadius = input.nextDouble();
        System.out.print("Enter the height of the cylinder: ");
        double cylHeight = input.nextDouble();

        // for the cone
        System.out.print("enter the radius of the cone: ");
        double coneRadius = input.nextDouble();
        System.out.print("enter the height of the cone: ");
        double coneHeight = input.nextDouble();

        input.close();

        Sphere sphere = new Sphere(sphereRadius);
        Cylinder cylinder = new Cylinder(cylRadius, cylHeight);
        Cone cone = new Cone(coneRadius, coneHeight);

        Shape[] shapeArray = new Shape[3];
        shapeArray[0] = sphere;
        shapeArray[1] = cylinder;
        shapeArray[2] = cone;

        System.out.println();

        for (int i = 0; i < shapeArray.length; i++) {
            System.out.println(shapeArray[i].toString());
            System.out.println();
        }
    }
}