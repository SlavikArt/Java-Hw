package Task_3;

public class Task_3 {
    public static void main(String[] args) {
        Animal[] zoo = new Animal[4];
        zoo[0] = new Tiger();
        zoo[1] = new Rabbit();
        zoo[2] = new Wolf();
        zoo[3] = new Kangaroo();

        System.out.print("Тварини в зоопарку: ");
        for (int i = 0; i < zoo.length; i++) {
            System.out.print(zoo[i].getName());
            if (i < zoo.length - 1)
                System.out.print(", ");
        }
        System.out.println();

        int predators = 0;
        double totalFood = 0;
        for (int i = 0; i < zoo.length; i++) {
            if (zoo[i].isPredator())
                predators++;
            totalFood += zoo[i].getFoodAmount();
        }

        System.out.println("Кількість хижаків: " + predators);
        System.out.println("Загальний обсяг корму: " + totalFood);
    }
}
