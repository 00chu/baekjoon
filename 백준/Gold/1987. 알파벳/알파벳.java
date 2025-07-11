import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static HashSet<String> set;
    static String[][] list;
    static int result = 0;

    public static void dfs(int R, int C, int row, int column) {
        if (R == 1 && C == 1){
            set.add(list[row][column]);
            result = Math.max(result, set.size());
            return;
        }
        
        if (set.contains(list[row][column])) {
            result = Math.max(result, set.size());
        } else {
            set.add(list[row][column]);

            if (R != 1) {
                if (0 == row) {
                    dfs(R, C, row + 1, column);
                } else if (row == R - 1) {
                    dfs(R, C, row - 1, column);
                } else {
                    dfs(R, C, row - 1, column);
                    dfs(R, C, row + 1, column);
                }
            }

            if (C != 1) {
                if (0 == column) {
                    dfs(R, C, row, column + 1);
                } else if (column == C - 1) {
                    dfs(R, C, row, column - 1);
                } else {
                    dfs(R, C, row, column - 1);
                    dfs(R, C, row, column + 1);
                }
            }

            set.remove(list[row][column]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        list = new String[R][C];

        for (int i = 0; i < R; i++) {
            list[i] = br.readLine().split("");
        }

        set = new HashSet<>();

        dfs(R, C, 0, 0);

        System.out.println(result);
    }
}