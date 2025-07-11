import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] alphabet;
    static String[][] list;
    static int result = 0;

    public static void dfs(int R, int C, int row, int column, int count) {
        if (alphabet[list[row][column].charAt(0) - 65]) {
            result = Math.max(result, count);
        } else {
            alphabet[list[row][column].charAt(0) - 65] = true;

            if (R != 1) {
                if (0 == row) {
                    dfs(R, C, row + 1, column, count + 1);
                } else if (row == R - 1) {
                    dfs(R, C, row - 1, column, count + 1);
                } else {
                    dfs(R, C, row - 1, column, count + 1);
                    dfs(R, C, row + 1, column, count + 1);
                }
            }

            if (C != 1) {
                if (0 == column) {
                    dfs(R, C, row, column + 1, count + 1);
                } else if (column == C - 1) {
                    dfs(R, C, row, column - 1, count + 1);
                } else {
                    dfs(R, C, row, column - 1, count + 1);
                    dfs(R, C, row, column + 1, count + 1);
                }
            }

            alphabet[list[row][column].charAt(0) - 65] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        if (R == 1 && C == 1) {
            System.out.println(1);
            return;
        }

        list = new String[R][C];

        for (int i = 0; i < R; i++) {
            list[i] = br.readLine().split("");
        }

        alphabet = new boolean[26];

        dfs(R, C, 0, 0, 0);

        System.out.println(result);
    }
}