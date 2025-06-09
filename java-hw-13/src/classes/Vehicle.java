package classes;

public class Vehicle {
    private String id;
    private String mdl;
    private double maxL;
    private boolean avail;
    private boolean needsR;

    public Vehicle(String id, String mdl, double maxL) {
        this.id = id;
        this.mdl = mdl;
        this.maxL = maxL;
        this.avail = true;
        this.needsR = false;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return mdl;
    }

    public double getMaxLoad() {
        return maxL;
    }

    public boolean isAvailable() {
        return avail;
    }

    public void setAvailable(boolean avail) {
        this.avail = avail;
    }

    public boolean needsRepair() {
        return needsR;
    }

    public void setNeedsRepair(boolean needsR) {
        this.needsR = needsR;
    }

    public void requestRepair() {
        this.needsR = true;
        this.avail = false;
    }

    public void repair() {
        this.needsR = false;
        this.avail = true;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", mdl='" + mdl + '\'' +
                ", maxL=" + maxL +
                ", avail=" + avail +
                ", needsR=" + needsR +
                '}';
    }
} 