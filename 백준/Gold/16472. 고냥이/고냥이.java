import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String s = br.readLine();

        int max = 0;
        int count = 0;
        int p1 = 0;
        int p2 = 0;

        int[] alphabet = new int[26];

        while (p1 < s.length() - max) {
            while (p2 < s.length() && count <= N) {
                if (alphabet[s.charAt(p2) - 'a']++ == 0) {
                    count++;
                }
                p2++;
            }

            if (s.charAt(p2 - 2) == s.charAt(p2 - 1)) {
                max = Math.max(max, p2 - p1);
            }
            max = Math.max(max, p2 - 1 - p1);

            alphabet[s.charAt(p1) - 'a']--;
            if (alphabet[s.charAt(p1) - 'a'] == 0) {
                count--;
            }
            p1++;
            if (0 < p1 && Objects.equals(s.charAt(p1 - 1), s.charAt(p1))) {
                alphabet[s.charAt(p1) - 'a']--;
                if (alphabet[s.charAt(p1) - 'a'] == 0) {
                    count--;
                }
                p1++;
            }
        }
        System.out.println(max);
    }
}