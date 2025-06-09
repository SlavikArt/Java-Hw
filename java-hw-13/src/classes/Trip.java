package classes;

import java.time.LocalDateTime;

public class Trip {
    private String id;
    private Request req;
    private Driver drv;
    private Vehicle v;
    private LocalDateTime start;
    private LocalDateTime end;
    private boolean done;
    private double pay;
    private String vStatus;

    public Trip(String id, Request req, Driver drv, Vehicle v) {
        this.id = id;
        this.req = req;
        this.drv = drv;
        this.v = v;
        this.start = LocalDateTime.now();
        this.done = false;
        this.vStatus = "Good";
    }

    public String getId() {
        return id;
    }

    public Request getRequest() {
        return req;
    }

    public Driver getDriver() {
        return drv;
    }

    public Vehicle getVehicle() {
        return v;
    }

    public LocalDateTime getStartTime() {
        return start;
    }

    public LocalDateTime getEndTime() {
        return end;
    }

    public boolean isCompleted() {
        return done;
    }

    public double getPayment() {
        return pay;
    }

    public String getVehicleStatus() {
        return vStatus;
    }

    public void setVehicleStatus(String status) {
        this.vStatus = status;
    }

    public void complete(double pay) {
        this.end = LocalDateTime.now();
        this.done = true;
        this.pay = pay;
        this.drv.addEarnings(pay);
        this.drv.addCompletedTrip(this);
        this.drv.setAvailable(true);
        this.v.setAvailable(true);
    }

    public void requestRepair() {
        this.v.requestRepair();
        this.vStatus = "Needs Repair";
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id='" + id + '\'' +
                ", req=" + req +
                ", drv=" + drv.getName() +
                ", v=" + v.getModel() +
                ", start=" + start +
                ", end=" + end +
                ", done=" + done +
                ", pay=" + pay +
                ", vStatus='" + vStatus + '\'' +
                '}';
    }
} 