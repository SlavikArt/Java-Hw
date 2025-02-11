package Task_3;

public class Task_3 {
    public static void main(String[] args) {
        Animal[] zoo = {
                new Tiger(),
                new Rabbit(),
                new Wolf(),
                new Kangaroo()
        };

        int predators = 0;
        double meatFood = 0;
        double plantFood = 0;

        for (int i = 0; i < zoo.length; i++) {
            System.out.println(zoo[i].getInfo());
            if (zoo[i].isPredator()) {
                predators++;
                meatFood += zoo[i].getFoodAmount();
            } else
                plantFood += zoo[i].getFoodAmount();
        }

        System.out.println("\nКількість хижаків: " + predators);
        System.out.println("Загальний обсяг м'яса: " + meatFood);
        System.out.println("Загальний обсяг рослинної їжі: " + plantFood);
    }
}
