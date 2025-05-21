import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lines = new int[K];

        long min = 0;
        long max = Integer.MIN_VALUE;

        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lines[i]);
        }

        if (K == 1) {
            System.out.println(lines[0] / N);
            return;
        }

        max++;

        while (min < max) {
            long mid = (min + max) / 2;

            long num = 0;
            for (int i = 0; i < K; i++) {
                num += lines[i] / mid;
            }

            if (num >= N) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        System.out.println(min - 1);
    }
}