package Task_3;

public class Task_3 {
    public static void main(String[] args) {
        IInfo[] instruments = {
                new Violin(),
                new Trombone(),
                new Ukulele()
        };

        for (int i = 0; i < instruments.length; i++) {
            instruments[i].Show();
            instruments[i].Sound();
            instruments[i].Desc();
            instruments[i].History();
            System.out.println();
        }
    }
}