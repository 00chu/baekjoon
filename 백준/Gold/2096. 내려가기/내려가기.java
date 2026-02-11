import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] table = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int[][] max = new int[N][3];
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                for (int j = 0; j < 3; j++) {
                    max[i][j] = table[i][j];
                }
            } else {
                for (int j = 0; j < 3; j++) {
                    switch (j) {
                        case 0:
                            max[i][j] = Math.max(max[i - 1][0], max[i - 1][1]) + table[i][j];
                            break;
                        case 1:
                            max[i][j] = Math.max(Math.max(max[i - 1][0], max[i - 1][1]), max[i - 1][2]) + table[i][j];
                            break;
                        default:
                            max[i][j] = Math.max(max[i - 1][1], max[i - 1][2]) + table[i][j];
                            break;
                    }
                }
            }
        }

        int maxResult = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            maxResult = Math.max(maxResult, max[N - 1][i]);
        }

        if (maxResult == 0) {
            int minResult = 0;
            System.out.println(maxResult + " " + minResult);
            return;
        }

        int[][] min = new int[N][3];
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                for (int j = 0; j < 3; j++) {
                    min[i][j] = table[i][j];
                }
            } else {
                for (int j = 0; j < 3; j++) {
                    switch (j) {
                        case 0:
                            min[i][j] = Math.min(min[i - 1][0], min[i - 1][1]) + table[i][j];
                            break;
                        case 1:
                            min[i][j] = Math.min(Math.min(min[i - 1][0], min[i - 1][1]), min[i - 1][2]) + table[i][j];
                            break;
                        default:
                            min[i][j] = Math.min(min[i - 1][1], min[i - 1][2]) + table[i][j];
                            break;
                    }
                }
            }
        }

        int minResult = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            minResult = Math.min(minResult, min[N - 1][i]);
        }

        System.out.println(maxResult + " " + minResult);
    }
}