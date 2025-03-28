package Task_2;

public class Task_2 {
    public static void main(String[] args) {
        FourNumberOperation<Integer> maxOfFour = (a, b, c, d) -> {
            Integer max = a;
            if (b.compareTo(max) > 0) max = b;
            if (c.compareTo(max) > 0) max = c;
            if (d.compareTo(max) > 0) max = d;
            return max;
        };

        FourNumberOperation<Integer> minOfFour = (a, b, c, d) -> {
            Integer min = a;
            if (b.compareTo(min) < 0) min = b;
            if (c.compareTo(min) < 0) min = c;
            if (d.compareTo(min) < 0) min = d;
            return min;
        };

        System.out.println("Максимум з 3, 7, 2, 5: " + maxOfFour.operate(3, 7, 2, 5));
        System.out.println("Мінімум з 3, 7, 2, 5: " + minOfFour.operate(3, 7, 2, 5));
    }
}
