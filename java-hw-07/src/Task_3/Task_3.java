package Task_3;

import java.util.List;

public class Task_3 {
    public static void main(String[] args) {
        List<Device> devices = List.of(
                new Device("Телефон", 2020, 15000, "Чорний", "Мобільний"),
                new Device("Ноутбук", 2019, 25000, "Сірий", "Комп'ютер"),
                new Device("Планшет", 2021, 12000, "Білий", "Мобільний"),
                new Device("Монітор", 2018, 8000, "Чорний", "Комп'ютер")
        );

        printDevices("Усі пристрої:", devices);

        printDevices("\nПристрої кольору 'Чорний':", filterByColor(devices, "Чорний"));

        printDevices("\nПристрої 2020 року:", filterByYear(devices, 2020));

        printDevices("\nПристрої дорожчі за 10000 грн:", filterByMinPrice(devices, 10000));

        printDevices("\nМобільні пристрої:", filterByType(devices, "Мобільний"));

        printDevices("\nПристрої 2019–2021 років:", filterByYearRange(devices, 2019, 2021));
    }

    private static List<Device> filterByColor(List<Device> devices, String color) {
        return devices.stream().filter(d -> d.getColor().equals(color)).toList();
    }

    private static List<Device> filterByYear(List<Device> devices, int year) {
        return devices.stream().filter(d -> d.getYear() == year).toList();
    }

    private static List<Device> filterByMinPrice(List<Device> devices, double minPrice) {
        return devices.stream().filter(d -> d.getPrice() > minPrice).toList();
    }

    private static List<Device> filterByType(List<Device> devices, String type) {
        return devices.stream().filter(d -> d.getType().equals(type)).toList();
    }

    private static List<Device> filterByYearRange(List<Device> devices, int start, int end) {
        return devices.stream().filter(d -> d.getYear() >= start && d.getYear() <= end).toList();
    }

    private static void printDevices(String title, List<Device> devices) {
        System.out.println(title);
        if (devices.isEmpty())
            System.out.println("(немає пристроїв)");
        else
            devices.forEach(device -> System.out.println(" • " + device));
    }
}