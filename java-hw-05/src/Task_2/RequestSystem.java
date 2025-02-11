package Task_2;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class RequestSystem {
    private final PriorityQueue<ClientRequest> requests = new PriorityQueue<>();
    private final Queue<ClientRequest> stats = new LinkedList<>();
    private final Scanner scn = new Scanner(System.in);

    public void run() {
        while (true) {
            printMenu();
            int choice = scn.nextInt();
            scn.nextLine();

            switch (choice) {
                case 1 -> addRequest();
                case 2 -> processRequest();
                case 3 -> showStats();
                case 0 -> System.exit(0);
                default -> System.out.println("Невірний вибір!");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n--- Меню ---");
        System.out.println("1. Додати запит");
        System.out.println("2. Обробити запит");
        System.out.println("3. Статистика");
        System.out.println("0. Вийти");
        System.out.print("Виберіть опцію: ");
    }

    private void addRequest() {
        System.out.print("Ім'я клієнта: ");
        String user = scn.nextLine();
        System.out.print("Пріоритет (1-найвищий): ");
        int priority = scn.nextInt();
        requests.add(new ClientRequest(user, priority, LocalTime.now()));
        System.out.println("Запит додано!");
    }

    private void processRequest() {
        if (requests.isEmpty()) {
            System.out.println("Черга порожня!");
            return;
        }
        ClientRequest request = requests.poll();
        stats.add(request);
        System.out.printf("Оброблено: %s (пріоритет %d)%n",
                request.user(), request.priority());
    }

    private void showStats() {
        System.out.println("\n--- Статистика ---");
        for (ClientRequest req : stats) {
            System.out.printf("%s - %s (пріоритет %d)%n",
                    req.time(), req.user(), req.priority());
        }
    }
}
