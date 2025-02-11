package Task_4;

public class Worker implements IWorker {
    @Override
    public void work(House house) {
        if (house.getBasement() == null) {
            house.setBasement(new Basement());
            System.out.println("Будівельник заклав фундамент");
        } else if (house.getWalls()[3] == null) {
            for (int i = 0; i < 4; i++) {
                if (house.getWalls()[i] == null) {
                    house.addWall(new Walls());
                    System.out.println("Будівельник збудував стіну " + (i + 1));
                    break;
                }
            }
        } else if (house.getDoor() == null) {
            house.setDoor(new Door());
            System.out.println("Будівельник встановив двері");
        } else if (house.getWindows()[3] == null) {
            for (int i = 0; i < 4; i++) {
                if (house.getWindows()[i] == null) {
                    house.addWindow(new Window());
                    System.out.println("Будівельник вставив вікно " + (i + 1));
                    break;
                }
            }
        } else if (house.getRoof() == null) {
            house.setRoof(new Roof());
            System.out.println("Будівельник поклав дах");
        }
    }

    @Override
    public void report(House house) {}
}
