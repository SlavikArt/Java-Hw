package Task_10;

import java.util.Random;
import java.util.Scanner;

public class Task_10 {
    public static final Scanner scn = new Scanner(System.in);
    public static final Random rnd = new Random();

    public static void main(String[] args) {
        System.out.print("Enter the size of the array: ");
        int size = scn.nextInt();
        scn.nextLine();

        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = rnd.nextInt(-100, 101);

        int[][] resultArr = separateNumbers(arr);

        System.out.println("Result arrays:");
        System.out.println("Odd numbers:");
        printArray(resultArr[0]);
        System.out.println("Even numbers:");
        printArray(resultArr[1]);
        System.out.println("Negative numbers:");
        printArray(resultArr[2]);
        System.out.println("Positive numbers:");
        printArray(resultArr[3]);

        scn.close();
    }

    public static int[][] separateNumbers(int[] arr) {
        int evenCnt = 0;
        int oddCnt = 0;
        int positiveCnt = 0;
        int negativeCnt = 0;

        for (int num : arr) {
            if (num % 2 == 0)
                evenCnt++;
            else
                oddCnt++;

            if (num > 0)
                positiveCnt++;
            else if (num < 0)
                negativeCnt++;
        }

        int[][] separatedArr = new int[4][];
        separatedArr[0] = new int[evenCnt];
        separatedArr[1] = new int[oddCnt];
        separatedArr[2] = new int[negativeCnt];
        separatedArr[3] = new int[positiveCnt];

        evenCnt = 0;
        oddCnt = 0;
        positiveCnt = 0;
        negativeCnt = 0;

        for (int num : arr) {
            if (num % 2 == 0)
                separatedArr[0][evenCnt++] = num;
            else
                separatedArr[1][oddCnt++] = num;

            if (num > 0)
                separatedArr[3][positiveCnt++] = num;
            else if (num < 0)
                separatedArr[2][negativeCnt++] = num;
        }
        return separatedArr;
    }

    public static void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}
