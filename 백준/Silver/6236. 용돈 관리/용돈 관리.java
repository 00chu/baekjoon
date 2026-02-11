import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int K = 0;

        int[] moneys = new int[N];

        int min = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            moneys[i] = Integer.parseInt(br.readLine());
            min = Math.max(min, moneys[i]);
            max += moneys[i];
        }

        while (min <= max) {
            int count = 0;
            K = (min + max) / 2;
            int num = K;

            for (int i = 0; i < N; i++) {
                if (num - moneys[i] <= 0) {
                    count++;
                    num = K;
                }
                num -= moneys[i];
            }

            if (count >= M) {
                min = K + 1;
            } else {
                max = K - 1;
            }
        }

        System.out.println(K);
    }
}