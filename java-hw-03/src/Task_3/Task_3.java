package Task_3;

public class Task_3 {
    public static void main(String[] args) {
        Figure[] figures = {
                new Rectangle(4, 5),
                new Circle(3),
                new RightTriangle(3, 4),
                new Trapezoid(2, 3, 4)
        };

        for (int i = 0; i < figures.length; i++)
            System.out.printf("Площа: %.2f\n", figures[i].calcArea());
    }
}