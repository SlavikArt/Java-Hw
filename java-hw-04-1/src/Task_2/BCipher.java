package Task_2;

public class BCipher implements ICipher {
    @Override
    public String encode(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) (base + 25 - (c - base));
            }
            sb.append(c);
        }
        return sb.toString();
    }

    @Override
    public String decode(String input) {
        return encode(input);
    }
}
