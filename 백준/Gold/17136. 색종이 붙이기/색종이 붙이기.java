import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] list;
    static int[] paper;
    static int result = Integer.MAX_VALUE;

    public static void dfs(int x, int y, int count) {
        if (x >= 9 && y > 9) {
            result = Math.min(result, count);
            return;
        }
        if (y >= 10) {
            dfs(x + 1, 0, count);
            return;
        }
        if (count >= result) {
            return;
        }

        if (list[x][y]) {
            for (int k = 5; k > 0; k--) {
                boolean flag = true;
                for (int i = x; i < x + k; i++) {   // 종이를 붙일 수 있는지 확인.
                    for (int j = y; j < y + k; j++) {
                        if (x + k > 10 || y + k > 10 || !list[i][j]) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) {
                        break;
                    }
                }

                if (paper[k] < 5 && flag) {
                    for (int i = x; i < x + k; i++) {   // 종이를 크기만큼 붙인다.
                        for (int j = y; j < y + k; j++) {
                            list[i][j] = false;
                        }
                    }
                    paper[k]++;
                    dfs(x, y + 1, count + 1);
                    for (int i = x; i < x + k; i++) {   // 붙였던 종이를 다 뗀다.
                        for (int j = y; j < y + k; j++) {
                            list[i][j] = true;
                        }
                    }
                    paper[k]--;
                }
            }
        } else {
            dfs(x, y + 1, count);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        list = new boolean[10][10];

        int temp = 0;

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                if (Objects.equals(st.nextToken(), "1")) {
                    list[i][j] = true;
                    temp++;
                }
            }
        }

        if (temp == 0) {
            System.out.println(0);
            return;
        }

        paper = new int[5 + 1];

        dfs(0, 0, 0);

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.print(result);
    }
}