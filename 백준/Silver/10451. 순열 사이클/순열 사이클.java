import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] graph;
    static boolean[] visited;

    public static void dfs(int v) {
        visited[v] = true;

        int nextV= graph[v];

        if (!visited[nextV]){
            dfs(nextV);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int result = 0;

            int N = Integer.parseInt(br.readLine());

            graph = new int[N + 1];
            visited = new boolean[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                graph[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= N; j++) {
                if (!visited[j]) {
                    dfs(j);
                    result++;
                }
            }

            sb.append(result);
            if (i != T - 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}