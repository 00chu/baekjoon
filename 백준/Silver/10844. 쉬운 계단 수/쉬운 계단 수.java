import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final long num = 1000000000; // 불변 선언 변수

        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                switch (j) {
                    case 0 :
                        dp[i][j] = dp[i - 1][j + 1] % num;
                        break;
                    case 9 :
                        dp[i][j] = dp[i - 1][j - 1] % num;
                        break;
                    default :
                        dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % num;
                }
            }
        }

        long result = 0;

        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
        }

        System.out.println(result % num);
    }
}