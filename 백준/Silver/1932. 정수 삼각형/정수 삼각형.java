import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] list = new int[n][n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] temp = dp.clone();

            for (int j = 0; j <= i; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());

                if (j == 0) {
                    dp[j] = temp[j] + list[i][j];
                } else if (j == i) {
                    dp[j] = temp[j - 1] + list[i][j];
                } else {
                    dp[j] = Math.max(temp[j - 1] + list[i][j], temp[j] + list[i][j]);
                }
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}