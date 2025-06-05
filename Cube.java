import java.util.Scanner;

public class Cube {
    private int x;
    private double y;

    public Cube(int x, double y) {
        this.x = x;
        this.y = y;
    }

    public void display() {
        System.out.println("x: " + x + " y: " + y);
    }

    public Cube Add(Cube a) {
        return new Cube(this.x + a.x, this.y + a.y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for first Cube
        System.out.println("Enter x1: ");
        int p = sc.nextInt();
        System.out.println("Enter y1: ");
        double q = sc.nextDouble();
        Cube firstCube = new Cube(p, q);

        // Input for second Cube
        System.out.println("Enter x2: ");
        int p2 = sc.nextInt();
        System.out.println("Enter y2: ");
        double q2 = sc.nextDouble();
        Cube secondCube = new Cube(p2, q2);

        // Adding both cubes
        Cube result = firstCube.Add(secondCube);

        // Displaying cubes and result
        System.out.println("First Cube:");
        firstCube.display();
        System.out.println("Second Cube:");
        secondCube.display();
        System.out.println("Sum of Cubes:");
        result.display();

        sc.close();
    }
}
