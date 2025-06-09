package classes;

import java.util.*;
import java.util.stream.Collectors;

public class Dispatcher {
    private List<Driver> drvs;
    private List<Vehicle> vhls;
    private List<Request> reqs;
    private List<Trip> trips;
    private Statistics stats;
    private Random rnd;

    public Dispatcher() {
        this.drvs = new ArrayList<>();
        this.vhls = new ArrayList<>();
        this.reqs = new ArrayList<>();
        this.trips = new ArrayList<>();
        this.stats = new Statistics();
        this.rnd = new Random();
    }

    public void addDriver(Driver d) {
        drvs.add(d);
    }

    public void addVehicle(Vehicle v) {
        vhls.add(v);
    }

    public void generateRandomRequest() {
        String[] dests = {"Kyiv", "Lviv", "Kharkiv", "Odesa", "Dnipro"};
        String[] types = {"General", "Fragile", "Hazardous", "Refrigerated"};
        
        String dest = dests[rnd.nextInt(dests.length)];
        String type = types[rnd.nextInt(types.length)];
        double w = 1000 + rnd.nextDouble() * 9000;
        int exp = 1 + rnd.nextInt(5);
        double dist = 100 + rnd.nextDouble() * 900;
        
        Cargo c = new Cargo(type, w, exp);
        Request req = new Request(
            UUID.randomUUID().toString(),
            dest,
            c,
            dist
        );
        
        reqs.add(req);
        System.out.println("New request generated: " + req);
    }

    public void assignRequests() {
        List<Request> unassigned = new ArrayList<>(reqs);
        
        for (Request req : unassigned)
            if (assignRequest(req))
                reqs.remove(req);
    }

    private boolean assignRequest(Request req) {
        List<Driver> suitableDrvs = drvs.stream()
            .filter(d -> d.isAvailable() && d.getExperience() >= req.getCargo().getRequiredExperience())
            .collect(Collectors.toList());
            
        if (suitableDrvs.isEmpty())
            return false;
        
        List<Vehicle> suitableVhls = vhls.stream()
            .filter(v -> v.isAvailable() && v.getMaxLoad() >= req.getCargo().getWeight())
            .collect(Collectors.toList());
            
        if (suitableVhls.isEmpty())
            return false;
        
        Driver drv = suitableDrvs.get(0);
        Vehicle vhl = suitableVhls.stream()
            .min(Comparator.comparingDouble(v -> 
                Math.abs(v.getMaxLoad() - req.getCargo().getWeight())))
            .get();
        
        Trip trip = new Trip(
            UUID.randomUUID().toString(),
            req,
            drv,
            vhl
        );
        
        drv.setAvailable(false);
        vhl.setAvailable(false);
        req.setAssigned(true);
        trips.add(trip);
        
        System.out.println("Assigned trip: " + trip);
        return true;
    }

    public void processTrips() {
        List<Trip> completed = new ArrayList<>();
        
        for (Trip trip : trips) {
            if (rnd.nextDouble() < 0.1) {
                trip.requestRepair();
                System.out.println("Vehicle breakdown reported: " + trip);
            }
            
            if (rnd.nextDouble() < 0.3) {
                double pay = trip.getRequest().getDistance() * 10;
                trip.complete(pay);
                completed.add(trip);
                stats.addTrip(trip);
                System.out.println("Trip completed: " + trip);
            }
        }
        
        trips.removeAll(completed);
    }

    public void printStatus() {
        System.out.println("\n=== System Status ===");
        System.out.println("Pending Requests: " + reqs.size());
        System.out.println("Active Trips: " + trips.size());
        System.out.println("Available Drivers: " + drvs.stream().filter(Driver::isAvailable).count());
        System.out.println("Available Vehicles: " + vhls.stream().filter(Vehicle::isAvailable).count());
        stats.printStatistics();
    }
} 