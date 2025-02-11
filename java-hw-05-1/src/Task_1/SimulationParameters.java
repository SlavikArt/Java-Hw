package Task_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimulationParameters {
    private Map<TimeOfDay, Integer> passengerIntervals;
    private Map<TimeOfDay, Integer> boatIntervals;
    private boolean isFinalStop;
    private int maxPassengersOnDock;

    public SimulationParameters() {
        passengerIntervals = new HashMap<>();
        boatIntervals = new HashMap<>();
    }

    public void inputParameters() {
        Scanner scanner = new Scanner(System.in);

        for (TimeOfDay period : TimeOfDay.values()) {
            System.out.print("Введіть середній час між появою пасажирів для " + period + ": ");
            passengerIntervals.put(period, scanner.nextInt());

            System.out.print("Введіть середній час між появою катерів для " + period + ": ");
            boatIntervals.put(period, scanner.nextInt());
        }

        System.out.print("Чи є зупинка катера кінцевою? (true/false): ");
        isFinalStop = scanner.nextBoolean();

        System.out.print("Максимальна кількість пасажирів на причалі: ");
        maxPassengersOnDock = scanner.nextInt();
    }

    public int getPassengerInterval(TimeOfDay period) {
        return passengerIntervals.get(period);
    }

    public int getBoatInterval(TimeOfDay period) {
        return boatIntervals.get(period);
    }

    public boolean isFinalStop() {
        return isFinalStop;
    }

    public int getMaxPassengersOnDock() {
        return maxPassengersOnDock;
    }
}
