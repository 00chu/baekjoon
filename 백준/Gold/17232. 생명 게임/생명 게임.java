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
        int T = Integer.parseInt(st.nextToken());

        String[][] board = new String[N + 1][M + 1];

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                board[i][j] = temp[j - 1];
            }
        }

        for (int i = 0; i < T; i++) {
            int[][] sum = new int[N + 1][M + 1]; // 배열의 깊은 복사

            for (int y = 1; y <= N; y++) { // 복사한 배열의 구간합
                for (int x = 1; x <= M; x++) {
                    sum[y][x] = sum[y - 1][x] + sum[y][x - 1] - sum[y - 1][x - 1] + (Objects.equals(board[y][x], "*") ? 1 : 0);
                }
            }

            for (int y = 1; y <= N; y++) { // 현 단계의 결과
                for (int x = 1; x <= M; x++) {
                    int r1 = Math.max(y - K, 1);
                    int c1 = Math.max(x - K, 1);
                    int r2 = Math.min(y + K, N);
                    int c2 = Math.min(x + K, M);

                    int num = sum[r2][c2] - sum[r1 - 1][c2] - sum[r2][c1 - 1] + sum[r1 - 1][c1 - 1];

                    if (Objects.equals(board[y][x], "*")) {
                        num--; // 현재 칸의 수를 뺌
                        if (num < a || b < num) { // 고독, 과밀
                            board[y][x] = ".";
                        }
                    } else if (a < num && num <= b) { //탄생
                        board[y][x] = "*";
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}