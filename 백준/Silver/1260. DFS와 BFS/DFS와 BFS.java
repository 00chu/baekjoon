import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int V; //정점 개수
    public static boolean[] visited;
    public static LinkedList<Integer>[] graph;
    public static StringBuilder sb;

    public static void dfs(int v) { //새로운 매개변수를 추가
        visited[v] = true;
        sb.append(v).append(" ");

        for (int nextV : graph[v]) {
            if (!visited[nextV]) {
                dfs(nextV); //매개변수로 들어갈 수 지정
            }
        }
    }

    public static void bfs(int v) { //새로운 매개변수를 추가
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int num = queue.poll();
            sb.append(num).append(" ");
            for (int nextV : graph[num]) {
                if (!visited[nextV]) {
                    queue.offer(nextV);
                    visited[nextV] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();

        graph = new LinkedList[V + 1];

        for (int i = 1; i < V + 1; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        for (int i = 1; i < V + 1; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[V + 1];
        dfs(s);
        sb.append("\n");

        visited = new boolean[V + 1];
        bfs(s);

        System.out.println(sb);
    }
}