import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] sum = new int[N];

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                sum[i] = Integer.parseInt(br.readLine());
            } else {
                sum[i] = sum[i - 1] + Integer.parseInt(br.readLine());
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int num1 = sum[j] - sum[i];
                int num2 = sum[N - 1] - num1;
                max = Math.max(max, Math.min(num1, num2));
                if (num1 > num2) {
                    break;
                }
            }
        }

        System.out.println(max);
    }
}