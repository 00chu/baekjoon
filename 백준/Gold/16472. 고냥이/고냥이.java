import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;

public class Main {
    public static int p2 = 0;

    public static int checkLength(HashMap<String, Integer> map, int N, String[] s, int p1) {
        while (p2 < s.length && map.size() <= N) {
            map.put(s[p2], map.getOrDefault(s[p2], 0) + 1);
            p2++;
        }

        if (Objects.equals(s[p2 - 2], s[p2 - 1])) {
            return p2 - p1;
        }
        return p2 - 1 - p1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split("");

        int max = 0;
        int p1 = 0;

        HashMap<String, Integer> map = new HashMap<>();

        while (p1 < s.length - max) {
            if (0 < p1 && Objects.equals(s[p1 - 1], s[p1])) {
                if (map.get(s[p1]) == 1) {
                    map.remove(s[p1]);
                } else {
                    map.put(s[p1], map.get(s[p1]) - 1);
                }
                p1 = p1 + 1;
            }

            max = Math.max(max, checkLength(map, N, s, p1));

            if (map.get(s[p1]) == 1) {
                map.remove(s[p1]);
            } else {
                map.put(s[p1], map.get(s[p1]) - 1);
            }
            p1++;
        }
        System.out.println(max);
    }
}