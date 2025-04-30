import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word1 = br.readLine();
        String word2 = br.readLine();

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < word2.length(); i++) {
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);
        }

        int count = 0;

        for (int i = 0; i < word1.length(); i++) {
            if (map2.getOrDefault(word1.charAt(i), 0) != 0) {
                int num = map2.get(word1.charAt(i)) - 1;
                if (num != 0) {
                    map2.put(word1.charAt(i), num);
                } else {
                    map2.remove(word1.charAt(i));
                }
            } else {
                count++;
            }
        }
        for (int i = 0; i < word2.length(); i++) {
            if (map1.getOrDefault(word2.charAt(i), 0) != 0) {
                int num = map1.get(word2.charAt(i)) - 1;
                if (num != 0) {
                    map1.put(word2.charAt(i), num);
                } else {
                    map1.remove(word2.charAt(i));
                }
            } else {
                count++;
            }
        }

        System.out.println(count);
    }
}