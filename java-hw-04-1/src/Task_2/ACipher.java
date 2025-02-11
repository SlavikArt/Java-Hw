package Task_2;

public class ACipher implements ICipher {
    @Override
    public String encode(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray())
            sb.append((char) (c + 1));
        return sb.toString();
    }

    @Override
    public String decode(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray())
            sb.append((char) (c - 1));
        return sb.toString();
    }
}
