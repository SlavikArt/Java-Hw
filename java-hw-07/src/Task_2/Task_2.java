package Task_2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_2 {
    public static void main(String[] args) {
        List<String> products = Arrays.asList(
                "Молоко", "Хліб", "Яблуко", "Молоко",
                "Сир", "Кефір", "Яйця", "Молоко"
        );

        System.out.println("Усі продукти: " + products);

        List<String> shortNameProducts = products.stream()
                .filter(p -> p.length() < 5)
                .collect(Collectors.toList());
        System.out.println("Продукти з назвою менше 5 символів: " + shortNameProducts);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть назву продукту для підрахунку: ");
        String userProduct = scanner.nextLine();
        long count = products.stream()
                .filter(p -> p.equalsIgnoreCase(userProduct))
                .count();
        System.out.println("Кількість входжень '" + userProduct + "': " + count);

        System.out.print("Введіть букву для фільтрації: ");
        String letter = scanner.nextLine().toLowerCase();
        List<String> startsWithLetter = products.stream()
                .filter(p -> p.toLowerCase().startsWith(letter))
                .collect(Collectors.toList());
        System.out.println("Продукти, що починаються на '" + letter + "': " + startsWithLetter);

        List<String> milkProducts = products.stream()
                .filter(p -> p.equals("Молоко"))
                .collect(Collectors.toList());
        System.out.println("Продукти категорії 'Молоко': " + milkProducts);
    }
}
