import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] visited;
    public static ArrayList<Integer>[] list;
    public static int count = 1;

    public static void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = count++;

        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int i = 0; i < list[num].size(); i++) {
                if (visited[list[num].get(i)] == 0) {
                    queue.offer(list[num].get(i));
                    visited[list[num].get(i)] = count++;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];
        list = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(list[i]);
        }

        bfs(R);

        for (int i = 1; i < N + 1; i++) {
            System.out.println(visited[i]);
        }
    }
}