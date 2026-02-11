import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Coordinate {
        int r;
        int c;

        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[][] graph;
    static boolean[][] visited;
    static int result = 0;

    public static void bfs(int r, int c, int N, int M) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(r, c));

        visited = new boolean[N][M];
        visited[r][c] = true;

        result++;

        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();

            if (0 < coordinate.r && !visited[coordinate.r - 1][coordinate.c] && !Objects.equals(graph[coordinate.r - 1][coordinate.c], 0)) {
                queue.offer(new Coordinate(coordinate.r - 1, coordinate.c));
                visited[coordinate.r - 1][coordinate.c] = true;
                graph[coordinate.r - 1][coordinate.c] = graph[coordinate.r][coordinate.c] + 1;
            }
            if (0 < coordinate.c && !visited[coordinate.r][coordinate.c - 1] && !Objects.equals(graph[coordinate.r][coordinate.c - 1], 0)) {
                queue.offer(new Coordinate(coordinate.r, coordinate.c - 1));
                visited[coordinate.r][coordinate.c - 1] = true;
                graph[coordinate.r][coordinate.c - 1] = graph[coordinate.r][coordinate.c] + 1;
            }
            if (coordinate.r < N - 1 && !visited[coordinate.r + 1][coordinate.c] && !Objects.equals(graph[coordinate.r + 1][coordinate.c], 0)) {
                queue.offer(new Coordinate(coordinate.r + 1, coordinate.c));
                visited[coordinate.r + 1][coordinate.c] = true;
                graph[coordinate.r + 1][coordinate.c] = graph[coordinate.r][coordinate.c] + 1;
            }
            if (coordinate.c < M - 1 && !visited[coordinate.r][coordinate.c + 1] && !Objects.equals(graph[coordinate.r][coordinate.c + 1], 0)) {
                queue.offer(new Coordinate(coordinate.r, coordinate.c + 1));
                visited[coordinate.r][coordinate.c + 1] = true;
                graph[coordinate.r][coordinate.c + 1] = graph[coordinate.r][coordinate.c] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(temp[j]);
            }
        }

        bfs(0, 0, N, M);

        System.out.println(graph[N - 1][M - 1]);
    }
}