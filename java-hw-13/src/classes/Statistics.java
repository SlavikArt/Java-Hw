package classes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Statistics {
    private Map<String, Integer> byDest;
    private Map<Driver, Integer> byDrv;
    private List<Trip> trips;
    private static final String LOG = "trips.log";

    public Statistics() {
        this.byDest = new HashMap<>();
        this.byDrv = new HashMap<>();
        this.trips = new ArrayList<>();
    }

    public void addTrip(Trip t) {
        trips.add(t);
        byDest.merge(t.getRequest().getDestination(), 1, Integer::sum);
        byDrv.merge(t.getDriver(), 1, Integer::sum);
        logTrip(t);
    }

    private void logTrip(Trip t) {
        try (PrintWriter w = new PrintWriter(new FileWriter(LOG, true))) {
            w.println("Trip Log Entry - " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            w.println(t.toString());
            w.println("----------------------------------------");
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    public List<Driver> getTopEarningDrivers(int lim) {
        return trips.stream()
                .map(Trip::getDriver)
                .distinct()
                .sorted(Comparator.comparingDouble(Driver::getTotalEarnings).reversed())
                .limit(lim)
                .collect(Collectors.toList());
    }

    public Map<String, Integer> getCargoByDestination() {
        return new HashMap<>(byDest);
    }

    public Map<Driver, Integer> getCargoByDriver() {
        return new HashMap<>(byDrv);
    }

    public List<Trip> getAllTrips() {
        return new ArrayList<>(trips);
    }

    public void printStatistics() {
        System.out.println("\n=== Statistics Report ===");
        
        System.out.println("\nCargo by Destination:");
        byDest.forEach((dest, cnt) -> 
            System.out.println(dest + ": " + cnt + " cargo items"));
        
        System.out.println("\nCargo by Driver:");
        byDrv.forEach((drv, cnt) -> 
            System.out.println(drv.getName() + ": " + cnt + " cargo items"));
        
        System.out.println("\nTop Earning Drivers:");
        getTopEarningDrivers(5).forEach(drv -> 
            System.out.println(drv.getName() + ": $" + drv.getTotalEarnings()));
    }
} 