import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static String[][] graph;
    public static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void dfs(int r, int c, int N) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            if (r + dx[i] < 0 || N <= r + dx[i] || c + dy[i] < 0 || N <= c + dy[i] || visited[r + dx[i]][c + dy[i]]) {
                continue;
            }

            if (Objects.equals(graph[r][c], graph[r + dx[i]][c + dy[i]])) {
                dfs(r + dx[i], c + dy[i], N);
            }
        }
    }


    public static boolean[][] colorVisited;

    public static void colorDfs(int r, int c, int N) {
        colorVisited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            if (r + dx[i] < 0 || N <= r + dx[i] || c + dy[i] < 0 || N <= c + dy[i] || colorVisited[r + dx[i]][c + dy[i]]) {
                continue;
            }

            if (((Objects.equals(graph[r][c], "R") || Objects.equals(graph[r][c], "G"))
                    && (Objects.equals(graph[r + dx[i]][c + dy[i]], "R") || Objects.equals(graph[r + dx[i]][c + dy[i]], "G")))
                    || Objects.equals(graph[r][c], graph[r + dx[i]][c + dy[i]])) {
                colorDfs(r + dx[i], c + dy[i], N);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        graph = new String[N][N];

        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine().split("");
        }

        visited = new boolean[N][N];
        colorVisited = new boolean[N][N];

        int result = 0;
        int colorResult = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, N);

                    result++;
                }

                if (!colorVisited[i][j]) {
                    colorDfs(i, j, N);

                    colorResult++;
                }
            }
        }

        System.out.println(result + " " + colorResult);

        br.close();
    }
}