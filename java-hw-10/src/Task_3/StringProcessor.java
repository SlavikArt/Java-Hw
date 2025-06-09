package Task_3;

public class StringProcessor implements StringOperation {
    private static final String VOWELS = "aeiouAEIOU";

    @Override
    public boolean isPalindrome(String str) {
        if (str == null)
            throw new IllegalArgumentException("String cannot be null");
        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleanStr.length() - 1;
        
        while (left < right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    @Override
    public int countVowels(String str) {
        if (str == null)
            throw new IllegalArgumentException("String cannot be null");
        int count = 0;
        for (char c : str.toCharArray())
            if (VOWELS.indexOf(c) != -1)
                count++;
        return count;
    }

    @Override
    public int countConsonants(String str) {
        if (str == null)
            throw new IllegalArgumentException("String cannot be null");
        int count = 0;
        for (char c : str.toCharArray())
            if (Character.isLetter(c) && VOWELS.indexOf(c) == -1)
                count++;
        return count;
    }

    @Override
    public int countWordOccurrences(String str, String word) {
        if (str == null || word == null)
            throw new IllegalArgumentException("String and word cannot be null");
        if (word.isEmpty())
            throw new IllegalArgumentException("Word cannot be empty");
        
        int count = 0;
        int index = 0;
        while ((index = str.toLowerCase().indexOf(word.toLowerCase(), index)) != -1) {
            count++;
            index += word.length();
        }
        return count;
    }
}
