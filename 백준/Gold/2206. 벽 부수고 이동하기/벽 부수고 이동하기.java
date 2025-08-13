import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String[][] map;
    static int[][] visited;
    static boolean[][] checked;

    static int[] rList = {-1, 1, 0, 0};
    static int[] cList = {0, 0, -1, 1};

    public static class Coordinate {
        int r;
        int c;

        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void bfs(int N, int M) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(0, 0));

        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            if (visited[N - 1][M - 1] != 0) {
                return;
            }

            Coordinate temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int r = temp.r + rList[i];
                int c = temp.c + cList[i];

                if (r < 0 || N <= r || c < 0 || M <= c || (visited[r][c] != 0 && !checked[r][c])) {
                    continue;
                }

                if (Objects.equals(map[r][c], "0")) {
                    if (checked[r][c] && !checked[temp.r][temp.c]) {
                        visited[r][c] = visited[temp.r][temp.c] + 1;
                        checked[r][c] = false;
                        queue.offer(new Coordinate(r, c));
                    } else if (visited[r][c] == 0) {
                        visited[r][c] = visited[temp.r][temp.c] + 1;
                        checked[r][c] = checked[temp.r][temp.c];
                        queue.offer(new Coordinate(r, c));
                    }
                } else {
                    if (!checked[temp.r][temp.c] && visited[r][c] == 0) {
                        visited[r][c] = visited[temp.r][temp.c] + 1;
                        checked[r][c] = true;
                        queue.offer(new Coordinate(r, c));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new String[N][M];
        visited = new int[N][M];
        checked = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split("");
        }

        bfs(N, M);

        if (visited[N - 1][M - 1] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(visited[N - 1][M - 1]);
        }
    }
}