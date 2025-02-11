package Task_2;

import java.util.*;

public class Dictionary {
    private Map<String, List<String>> dict;
    private Map<String, Integer> wordUsage;

    public Dictionary() {
        dict = new HashMap<>();
        wordUsage = new LinkedHashMap<>();
    }

    public void addWord(String word) {
        if (!dict.containsKey(word)) {
            dict.put(word, new ArrayList<>());
            wordUsage.put(word, 0);
            System.out.println("Слово додано: " + word);
        } else
            System.out.println("⚠ Слово вже є в словнику.");
    }

    public void addTranslation(String word, String translation) {
        if (dict.containsKey(word)) {
            dict.get(word).add(translation);
            System.out.println("Додано переклад: " + translation);
        } else
            System.out.println("Слова немає в словнику. Додайте його спочатку.");
    }

    public void displayWord(String word) {
        if (dict.containsKey(word)) {
            wordUsage.put(word, wordUsage.get(word) + 1);
            System.out.println(word + " -> " + dict.get(word));
        } else
            System.out.println("Слова немає в словнику.");
    }

    public void replaceTranslation(String word, String oldTranslation, String newTranslation) {
        if (dict.containsKey(word)) {
            List<String> translations = dict.get(word);
            if (translations.contains(oldTranslation)) {
                translations.set(translations.indexOf(oldTranslation), newTranslation);
                System.out.println("Переклад замінено.");
            } else
                System.out.println("Перекладу немає.");
        } else
            System.out.println("Слова немає в словнику.");
    }

    public void removeTranslation(String word, String translation) {
        if (dict.containsKey(word)) {
            if (dict.get(word).remove(translation)) {
                System.out.println("Переклад видалено.");
            } else
                System.out.println("Перекладу немає.");
        } else
            System.out.println("Слова немає в словнику.");
    }

    public void removeWord(String word) {
        if (dict.remove(word) != null) {
            wordUsage.remove(word);
            System.out.println("Слово видалено.");
        } else
            System.out.println("Слова немає в словнику.");
    }

    public void displayTopPopularWords() {
        dict.entrySet().stream()
                .sorted((a, b) -> Integer.compare(wordUsage.get(b.getKey()),
                        wordUsage.get(a.getKey())))
                .limit(10)
                .forEach(entry -> System.out.println(entry.getKey() + " -> "
                        + wordUsage.get(entry.getKey()) + " переглядів"));
    }

    public void displayTopUnpopularWords() {
        dict.entrySet().stream()
                .sorted(Comparator.comparingInt(a -> wordUsage.get(a.getKey())))
                .limit(10)
                .forEach(entry -> System.out.println(entry.getKey() + " -> "
                        + wordUsage.get(entry.getKey()) + " переглядів"));
    }
}
