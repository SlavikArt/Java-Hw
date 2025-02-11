package Task_4;

public class TeamLeader implements IWorker {
    @Override
    public void work(House house) {
        report(house);
    }

    @Override
    public void report(House house) {
        System.out.println("\n--- Звіт бригадира ---");
        System.out.println("Фундамент: " + (house.getBasement() != null ? "Готово" : "Відсутній"));
        System.out.println("Стіни: " + countBuiltParts(house.getWalls()) + "/4");
        System.out.println("Двері: " + (house.getDoor() != null ? "Готово" : "Відсутні"));
        System.out.println("Вікна: " + countBuiltParts(house.getWindows()) + "/4");
        System.out.println("Дах: " + (house.getRoof() != null ? "Готово" : "Відсутній"));
    }

    private int countBuiltParts(IPart[] parts) {
        int count = 0;
        for (int i = 0; i < parts.length; i++)
            if (parts[i] != null)
                count++;
        return count;
    }
}
