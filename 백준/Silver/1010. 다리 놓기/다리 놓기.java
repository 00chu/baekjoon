import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] dp = new int[M + 1][N + 1];

            for (int j = 1; j <= M; j++) {
                for (int k = 0; k <= N; k++) {
                    if (k == 0 || j == k) {
                        dp[j][k] = 1;
                    } else {
                        dp[j][k] = dp[j - 1][k - 1] + dp[j - 1][k];
                    }
                }
            }

            System.out.println(dp[M][N]);
        }
    }
}