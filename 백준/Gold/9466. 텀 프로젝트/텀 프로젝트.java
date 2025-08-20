import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] graph;
    static boolean[] visited;
    static boolean[] end;

    static int result;

    public static void dfs(int v) {
        visited[v] = true;

        int nextV = graph[v];

        if (!visited[nextV]) {
            dfs(nextV);
        } else {
            if (!end[nextV]) {
                result += 1;
                while (nextV != v) {
                    result++;
                    nextV = graph[nextV];
                }
            }
        }
        end[v] = true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            graph = new int[N + 1];
            visited = new boolean[N + 1];
            end = new boolean[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                graph[j] = Integer.parseInt(st.nextToken());
            }

            result = 0;
            for (int j = 1; j <= N; j++) {
                if (!visited[j]) {
                    dfs(j);
                }
            }

            sb.append(N - result);
            if (i != T - 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}