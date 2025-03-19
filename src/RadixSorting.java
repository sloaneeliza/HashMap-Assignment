import java.util.*;

public class RadixSorting {
    public static void radixSort(String[] arr) {
        if (arr == null || arr.length == 0) return;

        int maxLength = 0;
        for (String s : arr) {
            maxLength = Math.max(maxLength, s.length());
        }

        for (int pos = maxLength - 1; pos >= 0; pos--) {
            countingSort(arr, pos);
        }
    }

    private static void countingSort(String[] arr, int pos) {
        Map<Character, List<String>> bucketMap = new HashMap<>();

        for (char c = 'A'; c <= 'Z'; c++) bucketMap.put(c, new ArrayList<>());
        for (char c = 'a'; c <= 'z'; c++) bucketMap.put(c, new ArrayList<>());
        bucketMap.put(' ', new ArrayList<>());

        for (String s : arr) {
            char key = pos < s.length() ? s.charAt(pos) : ' ';
            bucketMap.get(key).add(s);
        }

        int index = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            for (String str : bucketMap.get(c)) arr[index++] = str;
        }
        for (char c = 'a'; c <= 'z'; c++) {
            for (String str : bucketMap.get(c)) arr[index++] = str;
        }
        for (String str : bucketMap.get(' ')) {
            arr[index++] = str;
        }
    }

    public static void main(String[] args) {
        String[] arr = {"google", "gojo", "amazingly", "jogo", "luna", "pup", "solas", "solo", "pupperino",
                "amaterasu", "amazon", "puppy", "hydra", "amazonia", "vueltiao"};

        radixSort(arr);
        System.out.println(String.join(", ", arr));
    }
}
