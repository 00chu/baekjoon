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

        int[][] list = new int[N + 1][N + 1];
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                list[i][j] = num;

                if (j == 1) {
                    dp[j][1] = list[j][1];
                } else {
                    dp[j][1] = dp[j - 1][1] + list[j][1];
                }

                if (i == 1) {
                    sum += num;
                    dp[i][j] = sum;
                } else {
                    sum += num;
                    dp[i][j] = dp[i - 1][j] + sum;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = 0;

            if (x1 == x2 && y1 == y2) {
                sum = list[x1][y2];
            } else if (x1 == 1 && y1 == 1) {
                sum = dp[x2][y2];
            } else {
                sum = dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1];
            }
            
            System.out.println(sum);
        }
    }
}