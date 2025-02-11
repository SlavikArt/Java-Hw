package Task_1;

public class Boat {
    private int arrivalTime;
    private TimeOfDay timeOfDay;
    private boolean isFinalStop;

    public Boat(int arrivalTime, TimeOfDay timeOfDay, boolean isFinalStop) {
        this.arrivalTime = arrivalTime;
        this.timeOfDay = timeOfDay;
        this.isFinalStop = isFinalStop;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public TimeOfDay getTimeOfDay() {
        return timeOfDay;
    }

    public boolean isFinalStop() {
        return isFinalStop;
    }
}
