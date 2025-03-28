package Task_4;

import java.util.Comparator;
import java.util.List;

public class Task_4 {
    public static void main(String[] args) {
        List<Projector> projectors = List.of(
                new Projector("Проектор A", 2020, 15000, "Виробник X"),
                new Projector("Проектор B", 2021, 18000, "Виробник Y"),
                new Projector("Проектор C", 2019, 12000, "Виробник X"),
                new Projector("Проектор D", 2022, 20000, "Виробник Z")
        );

        printProjectors("Усі проектори:", projectors);

        printProjectors("\nПроектори виробника 'Виробник X':",
                filterByManufacturer(projectors, "Виробник X"));

        printProjectors("\nПроектори 2023 року:",
                filterByYear(projectors, 2023));

        printProjectors("\nПроектори дорожчі за 15000 грн:",
                filterByMinPrice(projectors, 15000));

        printProjectors("\nПроектори за ціною (зростання):",
                sortByPrice(projectors, true));
        printProjectors("\nПроектори за ціною (спадання):",
                sortByPrice(projectors, false));

        printProjectors("\nПроектори за роком (зростання):",
                sortByYear(projectors, true));
        printProjectors("\nПроектори за роком (спадання):",
                sortByYear(projectors, false));
    }

    private static List<Projector> filterByManufacturer(List<Projector> list, String manufacturer) {
        return list.stream().filter(p -> p.getManufacturer().equals(manufacturer)).toList();
    }

    private static List<Projector> filterByYear(List<Projector> list, int year) {
        return list.stream().filter(p -> p.getYear() == year).toList();
    }

    private static List<Projector> filterByMinPrice(List<Projector> list, double minPrice) {
        return list.stream().filter(p -> p.getPrice() > minPrice).toList();
    }

    private static List<Projector> sortByPrice(List<Projector> list, boolean ascending) {
        return ascending
                ? list.stream().sorted(Comparator.comparingDouble(Projector::getPrice)).toList()
                : list.stream().sorted(Comparator.comparingDouble(Projector::getPrice).reversed()).toList();
    }

    private static List<Projector> sortByYear(List<Projector> list, boolean ascending) {
        return ascending
                ? list.stream().sorted(Comparator.comparingInt(Projector::getYear)).toList()
                : list.stream().sorted(Comparator.comparingInt(Projector::getYear).reversed()).toList();
    }

    private static void printProjectors(String title, List<Projector> projectors) {
        System.out.println(title);
        if (projectors.isEmpty())
            System.out.println("(немає проекторів)");
        else
            projectors.forEach(p -> System.out.println(" • " + p));
    }
}
