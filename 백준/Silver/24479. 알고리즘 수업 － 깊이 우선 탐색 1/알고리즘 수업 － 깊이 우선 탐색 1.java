import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static int[] visited;
    public static ArrayList<Integer>[] list;
    public static int count = 1;

    public static void dfs(int s) {
        visited[s] = count++;

        for (int i = 0; i < list[s].size(); i++) {
            if (visited[list[s].get(i)] == 0) {
                dfs(list[s].get(i));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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


        dfs(R);

        for (int i = 1; i < N + 1; i++) {
            System.out.println(visited[i]);
        }
    }
}