import java.util.*;

public class WordPattern {
    public static boolean wordPattern(String pattern, char delimiter, String s) {
        String[] words = s.split("\\" + delimiter); // Escape special characters in delimiter
        if (pattern.length() != words.length) return false;

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(c) && !charToWord.get(c).equals(word)) {
                return false;
            }
            if (wordToChar.containsKey(word) && wordToChar.get(word) != c) {
                return false;
            }

            charToWord.put(c, word);
            wordToChar.put(word, c);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", '?', "dog?cat?cat?dog")); // true
        System.out.println(wordPattern("abba", '|', "apple|banana|grape|apple")); // false
        System.out.println(wordPattern("aaaa", ',', "dog,cat,cat,dog")); // false
        System.out.println(wordPattern("aaaa", ' ', "ice cream taco day")); // false
        System.out.println(wordPattern("adxp", ' ', "ice cream taco day")); // true
    }
}
