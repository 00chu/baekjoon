import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] list = new int[T];
        int[] sum = new int[1001];
        boolean[] result = new boolean[1001];

        int max = 0;

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            list[i] = K;
            max = Math.max(max, list[i]);
        }

        int num = 0;

        for (int j = 1; j < max; j++) {
            sum[j] = j * (j + 1) / 2;

            if (sum[j] >= max) {
                num = j;
                break;
            }
        }

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                for (int k = 1; k <= num; k++) {
                    int temp = sum[i] + sum[j] + sum[k];
                    if (temp <= 1000) {
                        result[temp] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            if (result[list[i]]) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }
}