package Task_1;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task_1 {
    private static boolean isPalindrome(int number) {
        String numStr = String.valueOf(Math.abs(number));
        return numStr.equals(new StringBuilder(numStr).reverse().toString());
    }

    public static void main(String[] args) {
        List<Integer> numbers = IntStream.generate(() -> new Random().nextInt(201) - 100)
                .limit(100)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Набор чисел: " + numbers);

        long positiveCount = numbers.stream()
                .filter(n -> n > 0)
                .count();
        System.out.println("Кількість додатних чисел: " + positiveCount);

        long negativeCount = numbers.stream()
                .filter(n -> n < 0)
                .count();
        System.out.println("Кількість від’ємних чисел: " + negativeCount);

        long twoDigitCount = numbers.stream()
                .filter(n -> (n >= 10 && n <= 99) || (n <= -10 && n >= -99))
                .count();
        System.out.println("Кількість двозначних чисел: " + twoDigitCount);

        long palindromeCount = numbers.stream()
                .filter(Task_1::isPalindrome)
                .count();
        System.out.println("Кількість дзеркальних чисел: " + palindromeCount);
    }
}
