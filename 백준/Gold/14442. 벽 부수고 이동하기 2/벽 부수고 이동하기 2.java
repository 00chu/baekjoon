import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String[][] map;
    static boolean[][][] visited;
    static int result = 0;

    static int[] rList = {-1, 1, 0, 0};
    static int[] cList = {0, 0, -1, 1};

    public static class Coordinate {
        int r;
        int c;
        int length;
        int count;

        public Coordinate(int r, int c, int length, int count) {
            this.r = r;
            this.c = c;
            this.length = length;
            this.count = count;
        }
    }

    public static void bfs(int N, int M, int K) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(0, 0, 1, 0));

        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Coordinate temp = queue.poll();

            if (temp.r == N - 1 && temp.c == M - 1) {
                result = temp.length;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int r = temp.r + rList[i];
                int c = temp.c + cList[i];

                if (r < 0 || N <= r || c < 0 || M <= c) {
                    continue;
                }

                if (Objects.equals(map[r][c], "0")&&!visited[r][c][temp.count]) {
                        visited[r][c][temp.count] = true;
                        queue.offer(new Coordinate(r, c, temp.length + 1, temp.count));
                } else if (Objects.equals(map[r][c], "1") && temp.count < K && !visited[r][c][temp.count + 1]) {
                    visited[r][c][temp.count + 1] = true;
                    queue.offer(new Coordinate(r, c, temp.length + 1, temp.count + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new String[N][M];
        visited = new boolean[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split("");
        }

        bfs(N, M, K);

        if (result == 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}