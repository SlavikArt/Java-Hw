package classes;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    private String id;
    private String nm;
    private int exp;
    private boolean avail;
    private double earn;
    private List<Trip> trips;

    public Driver(String id, String nm, int exp) {
        this.id = id;
        this.nm = nm;
        this.exp = exp;
        this.avail = true;
        this.earn = 0.0;
        this.trips = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return nm;
    }

    public int getExperience() {
        return exp;
    }

    public boolean isAvailable() {
        return avail;
    }

    public void setAvailable(boolean avail) {
        this.avail = avail;
    }

    public double getTotalEarnings() {
        return earn;
    }

    public void addEarnings(double amt) {
        this.earn += amt;
    }

    public void addCompletedTrip(Trip t) {
        trips.add(t);
    }

    public List<Trip> getCompletedTrips() {
        return trips;
    }

    public int getCompletedTripsCount() {
        return trips.size();
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id='" + id + '\'' +
                ", nm='" + nm + '\'' +
                ", exp=" + exp +
                ", avail=" + avail +
                ", earn=" + earn +
                ", trips=" + trips.size() +
                '}';
    }
} 