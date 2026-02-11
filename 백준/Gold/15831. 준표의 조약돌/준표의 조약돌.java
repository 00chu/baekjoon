import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        String s = br.readLine();

        int black = 0;
        int white = 0;

        int p1 = 0;
        int p2 = 0;

        int length = 0;
        int max = 0;

        while (p1 < N - max && p2 < N) {
            if (black <= B) {
                if (s.charAt(p2) == 'B') {
                    black++;
                } else {
                    white++;
                }
                p2++;
                length++;
            } else {
                if (s.charAt(p1) == 'B') {
                    black--;
                } else {
                    white--;
                }
                p1++;
                length--;
            }

            if (black <= B && W <= white) {
                max = Math.max(max, length);
            }
        }

        System.out.println(max);
    }
}