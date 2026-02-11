import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] list;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    static int sum = 0;

    public static void dfs(int v, int N, int count) {
        if (count == N - 1 && list[v][1] != 0) {
            sum += list[v][1];
            result = Math.min(result, sum);
            sum -= list[v][1];
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && list[v][i] != 0) {
                sum += list[v][i];
                visited[i] = true;
                dfs(i, N, count + 1);
                sum -= list[v][i];
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        list = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        visited = new boolean[N + 1];
        visited[1] = true;

        dfs(1, N, 0);

        System.out.println(result);
    }
}