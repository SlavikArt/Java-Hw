package Task_8;

import java.util.Scanner;

public class Task_8 {
    public static final Scanner scn = new Scanner(System.in);
    
    public static void main(String[] args) {
        String[] menuItems = {"coffee", "tea", "croissant", "tiramisu"};
        double[] menuPrices = {5.0, 3.0, 2.5, 7.0};

        System.out.print("Enter the number of people: ");
        int peopleCnt = scn.nextInt();
        scn.nextLine();

        double[] orders = new double[peopleCnt];

        for (int i = 0; i < peopleCnt; i++) {
            System.out.println("Client #" + (i + 1) + "'s choices:");
            double totalClientOrder = 0;

            while (true) {
                showMenu(menuItems, menuPrices);
                String choice = scn.nextLine().trim();

                if (choice.equalsIgnoreCase("end")) {
                    break;
                } else {
                    int itemIndex = getItemIndex(choice, menuItems);
                    if (itemIndex != -1)
                        totalClientOrder += menuPrices[itemIndex];
                    else
                        System.out.println("Invalid choice, please try again");
                }
            }
            orders[i] = totalClientOrder;
        }

        double totalOrder = 0;
        for (double order : orders)
            totalOrder += order;

        System.out.println("Total order price: " + totalOrder);
    }

    private static void showMenu(String[] menuItems, double[] menuPrices) {
        System.out.println("Menu:");
        for (int i = 0; i < menuItems.length; i++)
            System.out.println((i + 1) + ") "
                    + menuItems[i] + " - " + menuPrices[i] + " UAH");
        System.out.println("To end the order enter 'end'");
        System.out.print("Your choice: ");
    }

    private static int getItemIndex(String choice, String[] menuItems) {
        for (int i = 0; i < menuItems.length; i++)
            if (menuItems[i].equalsIgnoreCase(choice))
                return i;
        return -1;
    }
}
