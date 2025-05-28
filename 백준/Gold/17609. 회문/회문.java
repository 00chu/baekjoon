import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int check(String s, int p1, int p2, int count) {
        if (count >= 2) {
            return 2;
        }
        while (p1 < p2) {
            if (s.charAt(p1) == s.charAt(p2)) {
                p1++;
                p2--;
            }else {
                return Math.min(check(s, p1 + 1, p2, count+1), check(s, p1, p2 - 1, count+1));
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            sb.append(check(s, 0, s.length() - 1, 0)).append("\n");
        }

        System.out.println(sb);
    }
}