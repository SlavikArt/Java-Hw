package Task_2;

import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введіть бічну сторону та основу:\n");
        double side = scn.nextDouble();
        double base = scn.nextDouble();

        IsoscelesTriangle tri = new IsoscelesTriangle(side, base);
        System.out.printf("Площа: %.2f\n", tri.calcArea());
        System.out.println("Периметр: " + tri.calcPerimeter());
        scn.close();
    }
}
