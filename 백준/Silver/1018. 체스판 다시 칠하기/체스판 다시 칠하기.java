import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static int cut(boolean[][] board, int r, int c) {
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < 2; i++) {
            boolean[][] clone = new boolean[8][8];

            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    clone[j][k] = board[j + r][k + c];
                }
            }

            int temp = 0;

            if (i == 1) {
                clone[0][0] = !clone[0][0];
                temp++;
            }

            for (int j = 0; j < 8; j++) {
                if (j != 0) {
                    if (Objects.equals(clone[j - 1][0], clone[j][0])) {
                        clone[j][0] = !clone[j - 1][0];
                        temp++;
                    }
                }
                for (int k = 1; k < 8; k++) {
                    if (Objects.equals(clone[j][k - 1], clone[j][k])) {
                        clone[j][k] = !clone[j][k - 1];
                        temp++;
                    }
                }
            }
            count = Math.min(count, temp);
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] board = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < temp.length; j++) {
                board[i][j] = Objects.equals(temp[j], "W");
            }
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                result = Math.min(result, cut(board, i, j));
            }
        }

        System.out.println(result);
    }
}