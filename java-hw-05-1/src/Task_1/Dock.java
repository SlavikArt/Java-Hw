package Task_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Dock {
    private SimulationParameters parameters;
    private Queue<Passenger> waitingPassengers;
    private Random random;

    public Dock(SimulationParameters parameters) {
        this.parameters = parameters;
        this.waitingPassengers = new LinkedList<>();
        this.random = new Random();
    }

    public void runSimulation() {
        for (TimeOfDay period : TimeOfDay.values()) {
            System.out.println("\nСимуляція для періоду: " + period);
            simulatePeriod(period);
        }
    }

    private void simulatePeriod(TimeOfDay period) {
        int simulationTime = 60;
        int passengerInterval = parameters.getPassengerInterval(period);
        int boatInterval = parameters.getBoatInterval(period);
        int totalWaitingTime = 0;
        int servedPassengers = 0;

        for (int time = 1; time <= simulationTime; time++) {
            if (time % passengerInterval == 0) {
                Passenger passenger = new Passenger(time);
                waitingPassengers.add(passenger);
                System.out.println("Час " + time + ": прибув пасажир.");
            }

            if (time % boatInterval == 0 && !waitingPassengers.isEmpty()) {
                int freeSeats = random.nextInt(10) + 1;
                System.out.println("Час " + time + ": прибув катер з " + freeSeats + " вільними місцями.");

                for (int i = 0; i < freeSeats && !waitingPassengers.isEmpty(); i++) {
                    Passenger boardedPassenger = waitingPassengers.poll();
                    int waitingTime = time - boardedPassenger.getArrivalTime();
                    totalWaitingTime += waitingTime;
                    servedPassengers++;
                    System.out.println("   Пасажир сів у катер, чекав " + waitingTime + " одиниць часу.");
                }
            }

            if (waitingPassengers.size() > parameters.getMaxPassengersOnDock()) {
                System.out.println("   УВАГА! Перевищено ліміт пасажирів на причалі!");
            }
        }

        if (servedPassengers > 0) {
            double averageWaitingTime = (double) totalWaitingTime / servedPassengers;
            System.out.println("\nСередній час очікування пасажира у період "
                    + period + ": " + averageWaitingTime);
        } else
            System.out.println("\nНе було обслуговано жодного пасажира у період " + period);
    }
}
