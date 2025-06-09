package classes;

public class Request {
    private String id;
    private String dest;
    private Cargo c;
    private double dist;
    private boolean ass;

    public Request(String id, String dest, Cargo c, double dist) {
        this.id = id;
        this.dest = dest;
        this.c = c;
        this.dist = dist;
        this.ass = false;
    }

    public String getId() {
        return id;
    }

    public String getDestination() {
        return dest;
    }

    public Cargo getCargo() {
        return c;
    }

    public double getDistance() {
        return dist;
    }

    public boolean isAssigned() {
        return ass;
    }

    public void setAssigned(boolean ass) {
        this.ass = ass;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id='" + id + '\'' +
                ", dest='" + dest + '\'' +
                ", c=" + c +
                ", dist=" + dist +
                ", ass=" + ass +
                '}';
    }
} 