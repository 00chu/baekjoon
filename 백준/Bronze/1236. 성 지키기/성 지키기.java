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

        String[][] list = new String[N][M];

        for (int i = 0; i < N; i++) {
            list[i] = br.readLine().split("");
        }

        int row = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Objects.equals(list[i][j], "X")) {
                    break;
                }
                if (j == M - 1) {
                    row++;
                }
            }
        }

        int column = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (Objects.equals(list[j][i], "X")) {
                    break;
                }
                if (j == N - 1) {
                    column++;
                }
            }
        }

        int result = Math.max(row, column);

        System.out.println(result);
    }
}