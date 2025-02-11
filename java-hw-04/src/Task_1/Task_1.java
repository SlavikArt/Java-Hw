package Task_1;

public class Task_1 {
    public static void main(String[] args) {
        Human[] friends = new Human[3];
        friends[0] = new Builder("Іван", 2, "Цегляник");
        friends[1] = new Sailor("Петро", 1, "Чорна Перлина");
        friends[2] = new Pilot("Марія", 3, "Boeing 747");

        int total = 0;
        for (int i = 0; i < friends.length; i++) {
            total += friends[i].getChildren();
            System.out.println(friends[i].getInfo());
        }
        System.out.println("Сумарна кількість дітей: " + total);
    }
}
