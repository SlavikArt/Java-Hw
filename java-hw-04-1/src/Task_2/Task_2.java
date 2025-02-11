package Task_2;

public class Task_2 {
    public static void main(String[] args) {
        ICipher aCipher = new ACipher();
        ICipher bCipher = new BCipher();

        String text = "Hello World!";
        String encA = aCipher.encode(text);
        String decA = aCipher.decode(encA);

        String encB = bCipher.encode(text);
        String decB = bCipher.decode(encB);

        System.out.println("ACipher: " + encA + " -> " + decA);
        System.out.println("BCipher: " + encB + " -> " + decB);
    }
}
