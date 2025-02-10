package Task_1;

public class Task_1 {
    public static void main(String[] args) {
        Human[] friends = new Human[3];
        friends[0] = new Builder("Іван", 2);
        friends[1] = new Sailor("Петро", 1);
        friends[2] = new Pilot("Марія", 3);

        for (int i = 0; i < friends.length; i++)
            System.out.println(friends[i].getName() + ": " + friends[i].getChildren());

        int total = 0;
        for (int i = 0; i < friends.length; i++)
            total += friends[i].getChildren();
        System.out.println("Сумарно дітей: " + total);
    }
}
