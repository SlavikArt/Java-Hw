package Task_3;

public class Task_3 {
    public static int sumIf(int[] numbers, NumberCondition condition) {
        int sum = 0;
        for (int num : numbers)
            if (condition.test(num))
                sum += num;
        return sum;
    }

    public static void main(String[] args) {
        int[] numbers = {3, -5, 7, 7, -2, 0, 4, -8, 10};

        int sumEqual = sumIf(numbers, n -> n == 7);
        System.out.println("Сума чисел, рівних 7: " + sumEqual);

        int sumOutRange = sumIf(numbers, n -> n < -3 || n > 5);
        System.out.println("Сума чисел поза діапазоном [-3, 5]: " + sumOutRange);

        int sumPositive = sumIf(numbers, n -> n > 0);
        System.out.println("Сума додатних чисел: " + sumPositive);

        int sumNegative = sumIf(numbers, n -> n < 0);
        System.out.println("Сума від’ємних чисел: " + sumNegative);
    }
}
