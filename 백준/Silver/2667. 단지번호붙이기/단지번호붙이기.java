import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static boolean[][] graph;
    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int temp;

    public static void dfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] xy = queue.poll();

            int x = xy[0];
            int y = xy[1];

            for (int k = 0; k < 4; k++) {
                int xt = x + dx[k];
                int yt = y + dy[k];

                if (0 <= xt && xt < N && 0 <= yt && yt < N && graph[xt][yt]&& !visited[xt][yt]) {
                    visited[xt][yt] = true;
                    queue.offer(new int[]{xt, yt});
                    temp++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                if (Objects.equals(s[j], "1")) {
                    graph[i][j] = true;
                }
            }
        }

        visited = new boolean[N][N];

        int count = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] && !visited[i][j]) {
                    count++;
                    temp = 1;
                    dfs(i, j);
                    result.add(temp);
                }
            }
        }

        System.out.println(count);

        Collections.sort(result);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
}