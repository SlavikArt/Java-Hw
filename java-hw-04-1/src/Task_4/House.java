package Task_4;

public class House {
    private Basement basement;
    private Walls[] walls;
    private Door door;
    private Window[] windows;
    private Roof roof;
    private int wallsBuilt;
    private int windowsBuilt;

    public House() {
        this.walls = new Walls[4];
        this.windows = new Window[4];
        this.wallsBuilt = 0;
        this.windowsBuilt = 0;
    }

    public Basement getBasement() {
        return basement;
    }

    public void setBasement(Basement basement) {
        this.basement = basement;
    }

    public Walls[] getWalls() {
        return walls;
    }

    public void addWall(Walls wall) {
        if (wallsBuilt < 4) {
            walls[wallsBuilt] = wall;
            wallsBuilt++;
        }
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public Window[] getWindows() {
        return windows;
    }

    public void addWindow(Window window) {
        if (windowsBuilt < 4) {
            windows[windowsBuilt] = window;
            windowsBuilt++;
        }
    }

    public Roof getRoof() {
        return roof;
    }

    public void setRoof(Roof roof) {
        this.roof = roof;
    }
}
