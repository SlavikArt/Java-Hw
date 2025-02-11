package Task_4;

public class Task_4 {
    public static void main(String[] args) {
        House house = new House();
        Team team = new Team(4);

        for (int i = 0; i < 3; i++)
            team.addWorker(new Worker());
        team.addWorker(new TeamLeader());

        team.buildHouse(house);

        System.out.println("\n--- Будівництво завершено! ---");
        new TeamLeader().report(house);
    }
}
