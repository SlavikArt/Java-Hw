package Task_3;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringOperationTest {
    private final StringProcessor processor = new StringProcessor();

    @Test
    public void testIsPalindrome() {
        assertTrue(processor.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(processor.isPalindrome("race a car"));
        assertTrue(processor.isPalindrome("Was it a car or a cat I saw?"));
        assertFalse(processor.isPalindrome("hello"));
        assertTrue(processor.isPalindrome(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsPalindromeNull() {
        processor.isPalindrome(null);
    }

    @Test
    public void testCountVowels() {
        assertEquals(2, processor.countVowels("hello"));
        assertEquals(5, processor.countVowels("aeiou"));
        assertEquals(0, processor.countVowels("rhythm"));
        assertEquals(0, processor.countVowels(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCountVowelsNull() {
        processor.countVowels(null);
    }

    @Test
    public void testCountConsonants() {
        assertEquals(3, processor.countConsonants("hello"));
        assertEquals(0, processor.countConsonants("aeiou"));
        assertEquals(6, processor.countConsonants("rhythm"));
        assertEquals(0, processor.countConsonants(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCountConsonantsNull() {
        processor.countConsonants(null);
    }

    @Test
    public void testCountWordOccurrences() {
        assertEquals(2, processor.countWordOccurrences("hello hello world", "hello"));
        assertEquals(1, processor.countWordOccurrences("Hello World", "world"));
        assertEquals(0, processor.countWordOccurrences("hello world", "test"));
        assertEquals(0, processor.countWordOccurrences("", "test"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCountWordOccurrencesNullString() {
        processor.countWordOccurrences(null, "test");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCountWordOccurrencesNullWord() {
        processor.countWordOccurrences("test", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCountWordOccurrencesEmptyWord() {
        processor.countWordOccurrences("test", "");
    }
}
